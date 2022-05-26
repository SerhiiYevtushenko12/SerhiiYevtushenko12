package Lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DataProvTest {
    WebDriver driver;

    @DataProvider(name = "dp", parallel = true)
    public Object[][] parseData() {
        return new Object[][] {
                {"https://www.bing.com"},
                {"https://duckduckgo.com"},
                {"https://duckduckgo.com"},
                {"https://duckduckgo.com"},
                {"https://duckduckgo.com"},
                {"https://duckduckgo.com"},
                {"https://duckduckgo.com"},
                {"https://duckduckgo.com"}
        };
    }

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "dp")
    public void test(String searchUrl) throws InterruptedException, MalformedURLException {
        WebDriver driver;
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("se:name", "My Custom Name " + searchUrl);
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        driver.get(searchUrl);
        WebElement element = driver.findElement(By.xpath(".//*[@name='q']"));
        element.sendKeys("git merge vs rebase");
        element.submit();
        Thread.sleep(6000);
        System.out.println("Page title is: " + driver.getTitle());
        Thread.sleep(5000);
        {
            driver.quit();
        }

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
