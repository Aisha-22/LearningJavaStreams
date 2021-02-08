import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public void setFilter() {
        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aisha Hlatshwayo\\Desktop\\chromedriver.exe");

        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));//You captured all veggies
        //Iterate - > get the text
        //Results 5
        List<WebElement> filterList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice")).collect(Collectors.toList()); /*Checking if 'Rice' is
        present
        */
        //Result 1 - Put the condition
        Assert.assertEquals(veggies.size(), filterList.size()); //If both size matches then the test will pass
    }
}
