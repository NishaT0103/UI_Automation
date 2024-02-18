package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sponsoredProducts{
	private WebDriver driver;

    public sponsoredProducts(WebDriver driver) {
    	this.driver=driver;
    }
    public void addproduct()
    {
    	 // Identify sponsored products
        List<WebElement> sponsoredProducts = driver.findElements(By.xpath("//span[text()='Sponsored']//ancestor::div[@class='_2B099V']"));

        // Add only 2 sponsored products to cart
        int count = 0;
        for (WebElement product : sponsoredProducts) {
            if (count == 2)
                break;

            // Click on the product
            product.findElement(By.tagName("a")).click();
            String MainWindow=driver.getWindowHandle();	
            // Add to cart
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> i = windows.iterator();
            while(i.hasNext())			
            {		
                String ChildWindow=i.next();		
                		
                if(!MainWindow.equalsIgnoreCase(ChildWindow))			
                {    		
                     
                        // Switching to Child window
                        driver.switchTo().window(ChildWindow);
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
            addToCartButton.click();
                
            // Wait for the cart modal to appear
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
//            @Test(dataProvider="testdatatitle",  dataProviderClass = data.ExcelDataProvider.class)
//            public titleassert(String title)
//            {
//            String Actualtitle = driver.getTitle();
//            Assert.assertEquals(Actualtitle, title);
//            }
             // Close the cart modal
            
//              WebElement closeCartButton = driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']"));
//              closeCartButton.click();
            driver.close();
             driver.switchTo().window(MainWindow);
              
              
                }
            }
            

            count++;
        }
    }

        
}
