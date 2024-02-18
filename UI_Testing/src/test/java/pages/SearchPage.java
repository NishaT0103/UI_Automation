package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String text) {
    	WebElement search = driver.findElement(By.xpath("//*[@type='text']"));
    	search.sendKeys(text);
    	search.sendKeys(Keys.ENTER);
    	//search.sendKeys(null)
    	//Actions action = new Actions(driver);
    	//action.sendKeys(Keys.RETURN);
       // driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
      //WebElement searchbutton =  driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/button"));
     // action.moveToElement(searchbutton).click().build().perform();
    	//action.sendKeys(search, null)
    }
    
   }
