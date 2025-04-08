package com.storeapp.cli;

import com.storeapp.cli.model.CartItem;
import com.storeapp.cli.model.Product;
import com.storeapp.cli.model.SpecialOffer;
import com.storeapp.cli.service.ProductService;
import com.storeapp.cli.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.*;

@SpringBootApplication
@EnableJpaRepositories("com.storeapp.cli.repository")
@EntityScan("com.storeapp.cli.model")
@ComponentScan("com.storeapp.cli")
public class CheckoutCLI implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private SpecialOfferService specialOfferService;

    private final Map<String, CartItem> cart = new HashMap<>();
    private final Map<String, Product> skuProductMap = new HashMap<>();
    private final Map<Long, SpecialOffer> offerMap = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(CheckoutCLI.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = productService.getAllProducts();
        List<SpecialOffer> offers = specialOfferService.getAllSpecialOffers();

        for (Product p : products) {
            skuProductMap.put(p.getSku().toUpperCase(), p);
        }
        for (SpecialOffer o : offers) {
            offerMap.put(o.getProduct().getId(), o);
        }

        System.out.println("=== Available Products ===");
        for (Product p : products) {
            SpecialOffer offer = offerMap.get(p.getId());
            String offerText = (offer != null && offer.getSpecDescription() != null)
                    ? " | Promo: " + offer.getSpecDescription()
                    : "";
            System.out.printf("SKU: %-4s | Name: %-12s | Price: £%.2f%s%n",
                    p.getSku(), p.getName(), p.getPrice(), offerText);
        }

        System.out.println("\nEnter SKUs to scan items (letters only, type 'total' to finish):");

        while (true) {
            System.out.print("Scan SKU: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("TOTAL")) {
                break;
            }

            if (!input.matches("^[A-Z]+$")) {
                System.out.println("Invalid input. Only letters (A-Z) are allowed.");
                continue;
            }

            Product product = skuProductMap.get(input);
            if (product == null) {
                System.out.println("Invalid SKU. Please try again.");
                continue;
            }

            CartItem item = cart.getOrDefault(input, new CartItem(product, 0));
            item.setQuantity(item.getQuantity() + 1);
            cart.put(input, item);

            SpecialOffer offer = offerMap.get(product.getId());
            int qty = item.getQuantity();

            if (offer != null && qty % offer.getQuantity() == 0) {
                String desc = offer.getSpecDescription() != null
                        ? offer.getSpecDescription()
                        : "Special offer met!";
                System.out.println("** Promotion triggered: " + desc + " **");
            }

            double subtotal = calculateSubtotal();
            System.out.printf("Added %s. Subtotal: £%.2f%n", product.getName(), subtotal);
        }

        double finalTotal = calculateSubtotal();
        System.out.printf("\n=== Final Total: £%.2f ===%n", finalTotal);
        System.out.println("Thank you for shopping!");
    }

    private double calculateSubtotal() {
        double total = 0.0;
        for (CartItem item : cart.values()) {
            Product product = item.getProduct();
            int qty = item.getQuantity();
            double unitPrice = product.getPrice();

            SpecialOffer offer = offerMap.get(product.getId());
            if (offer != null && qty >= offer.getQuantity()) {
                int groupQty = offer.getQuantity();
                double specialPrice = offer.getSpecPrice();
                int eligibleGroups = qty / groupQty;
                int remainder = qty % groupQty;
                total += eligibleGroups * specialPrice + remainder * unitPrice;
            } else {
                total += qty * unitPrice;
            }
        }
        return total;
    }
}