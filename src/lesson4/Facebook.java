package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Facebook {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://facebook.com");
        driver.findElement(By.xpath(".//*[@rel=\"async\"]")).click();
        Thread.sleep(1_000);
        driver.findElement(By.name("firstname")).sendKeys("Tony");
        driver.findElement(By.name("lastname")).sendKeys("Hawk");
        driver.findElement(By.name("reg_email__")).sendKeys("TonyHawk@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("TonyHawk@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("TonyHawk98");

        Select month = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
        month.selectByIndex(4);

        Select day = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
        day.selectByIndex(16);

        Select year = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
        year.selectByIndex(30);

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.xpath(".//*[@name=\"websubmit\"]\n")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}





