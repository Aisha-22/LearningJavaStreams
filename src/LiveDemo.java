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

        /*
        Building Custom Selenium methods using Streams Mapper
         */
        List<String> price;
        //Scan the name column with getText() -> Beans -> Print the price of the vegetable
        do
            {
                List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
           price = rows.stream().filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList()); /*Creating a custom Method getPriceVeggie() - Method call filter() every
        webElement needs to be iterated, and if you want to apply condition you have to use filter Method
        */
            //Automating Pagination, to search the data using 'do while loop'


            // 'a' represents every item in the list, for every idem in the list do action
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while (price.size() < 1);

        Filter f = new Filter();
        f.setFilter();

        //JavaStreamsExample 1:
        JavaStreamExample1 example1 =new JavaStreamExample1();
        example1.executeElements();

        //This contains a non-terminal operation
        JavaStreamExample2 example2 = new JavaStreamExample2();
        example2.nonTerminalOps();
    }
    private static String getPriceVeggie(WebElement s) {

       String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }

}
