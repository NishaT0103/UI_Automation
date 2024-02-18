package tests;

import data.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pages.SearchPage;
import pages.sponsoredProducts;
import utils.WebDriverFactory;

public class flipkartSearchTest {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static sponsoredProducts sponsoredProduct;

    @BeforeMethod
//    @Parameters({"browser"})
//    public void setup(String browser) {
//        WebDriverManager.getInstance(browser);
//        searchPage = new SearchPage(driver);
//    }
    @Parameters({"browser"})
    public void setup(String browser) {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
            	System.getProperty("webdriver.chrome.driver", "/UI_Testing/src/test/resources/chromedriver.exe");
               // WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                searchPage = new SearchPage(driver);
                sponsoredProduct = new sponsoredProducts(driver);
                break;
        }
    }
//    @DataProvider(name = "excelDataProvider")
//    public static Iterator<Object[]> provideData(Method method) {
//        return ExcelDataProvider.testData();
//    }
    @Test(dataProvider = "testData", dataProviderClass = data.ExcelDataProvider.class)
    public static void testSearch(String searchQuery, String title) {
    	driver.manage().window().maximize();
    	driver.get("https://www.flipkart.com/");
		try {
			searchPage.searchFor(searchQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Assert search results
        String actualtitle = driver.getTitle();
       // String ActualTitle;
        Assert.assertEquals(actualtitle,title);
        System.out.println("Actual Title: "+title);
    }
    
    @Test(dataProvider = "testData2", dataProviderClass = data.ExcelDataProvider.class)
    public static void addSponsoreditem(String searchproduct)
    {
    	driver.manage().window().maximize();
    	driver.get("https://www.flipkart.com/");
    	searchPage.searchFor(searchproduct);
    	try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	sponsoredProduct.addproduct();
     }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
