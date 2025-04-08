# StoreApp Release Package

This folder contains the pre-packaged JAR file for the `StoreApp` CLI application. This JAR reflects the exact source code committed to the repository for the Java Engineer (with AWS Experience) assessment at CDL.

——

## 1. How to Run

Ensure you have Java 17 or later installed.

### Step-by-step:

1. Start H2 Database, if required.  
   This app uses H2 in file-based mode or as a local instance depending on configuration.  
   If you're running in TCP or file mode, make sure H2 is available before executing the JAR.

2. Run the application using the following command:

Run java -jar storeapp-1.0.0.jar for Dos command (Windows) or bash command (Linux)


### To assist with validation

A SHA256 checksum is included below in case your team wishes to verify the JAR’s integrity of the submitted `storeapp-1.0.0.jar`.

Run Windows CMD: 
CertUtil -hashfile storeapp-1.0.0.jar SHA256

Expected output: 
SHA256 hash of storeapp-1.0.0.jar: 
89cb99f640a21f45e5a43b534d23ac54db1ea1214da4d5b3bfe099f4adc6a6d3
CertUtil: -hashfile command completed successfully.

 

