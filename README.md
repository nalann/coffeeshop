# coffee assessment

*by Nalan Ekici*

**Note** This documentation is about how to run application easily.

**Prerequsities**

Install java 1.8 [https://www.oracle.com/tr/java/technologies/javase/javase-jdk8-downloads.html](https://www.oracle.com/tr/java/technologies/javase/javase-jdk8-downloads.html)

**How to Run**

**Step 1:** Get JAR file and resources folder from **coffeeshop/target/** folder.

**1.1** Get JAR file which is **CoffeeShopApp-0.0.1-SNAPSHOT.jar** from target folder.

**1.2** Get resources folder which contains **"resources.json"**, **"products.json"**, and **"orders.json"** files.

**NOTE :** Please use **json-resources** for folder name of resources.

**Step 2:** Open the shell to run jar file on your local folder which contains jar file and resources. Run below script;

	java -jar CoffeeShopApp-0.0.1-SNAPSHOT.jar
	
**NOTE-1:** After you run the command, you should see an output.

**NOTE-2:** You can change the resources files based on current data structure to test.

**NOTE-3:** You can find backup of resources under the json-resources folder in the main project structure.