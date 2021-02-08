import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    public static void main(String[] args) {

        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aisha Hlatshwayo\\Desktop\\chromedriver.exe");

        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Capture all webelements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]")); //we can store in one list

        //capture text of all webelements into new (original) list
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //we'll apply sort on the original list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //Compare original list with sorted list
        Assert.assertTrue(originalList.equals(sortedList));
    }
}
