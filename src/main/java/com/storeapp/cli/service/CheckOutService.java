package com.storeapp.cli.service;

import com.storeapp.cli.model.Product;
import com.storeapp.cli.model.SpecialOffer;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CheckOutService {

    public double calculateTotal(List<Product> cart, List<SpecialOffer> offers) {
        Map<String, Integer> itemCount = new HashMap<>();
        for (Product p : cart) {
            itemCount.put(p.getSku(), itemCount.getOrDefault(p.getSku(), 0) + 1);
        }

        double total = 0.0;

        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            String sku = entry.getKey();
            int qty = entry.getValue();

            Optional<SpecialOffer> offer = offers.stream()
                    .filter(o -> o.getSku().equalsIgnoreCase(sku))
                    .findFirst();

            double unitPrice = cart.stream()
                    .filter(p -> p.getSku().equalsIgnoreCase(sku))
                    .findFirst()
                    .map(Product::getPrice)
                    .orElse(0.0);

            if (offer.isPresent()) {
                int offerQty = offer.get().getQuantity();
                double offerPrice = offer.get().getSpecPrice();
                total += (qty / offerQty) * offerPrice + (qty % offerQty) * unitPrice;
            } else {
                total += qty * unitPrice;
            }
        }

        return total;
    }
}