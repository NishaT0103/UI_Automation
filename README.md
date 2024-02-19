Project Name: UI_Testing
Discription: To test the UI functionlaities of E-commerce website "Flipkart"
Languages: Java, Selenium
Framework: Maven
Folder/File structure: 
                        Src/test/java - data   --> ExcelDataProvider.java
                                      - pages  --> SearchPages.java, sponsoredProduct.java
                                      - tests  --> flipkartSearchTest.java
                                      - utils  --> WebDriverFactory.java
                        Src/main/resources -->  TestData.xlsx, chromedriver.exe
                        pom.xml
                        testng.xml
Details:
1. ExcelDataProvider.java: Class file that reads data from excel file "TestData.xlsx"
2. searchpages.java: Class file that consists of all the page objects and basic methods that are performed on search functionality of flipkart
3. sponsoredProduct.java: Class file that consists of all the page objects and basic methods that performs searching of products and add minimum of 2 sponsored products into the cart
4. flipkartSearhTest.java:  Class file that contains methods to initialize browser and verify assertion results using testNG annotations
5. WebDriverFactory.java: Class file consists of method to create and return the driver instance
6. TestData.xlsx: Consists of multiple test data for eact scenarios
7. pom.xml: XML file that consists of all the necessary maven dependencies
8. testng.xml: consists of setup for multiple threads and crossbrowser execution
