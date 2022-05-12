package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
        public static void main(String[] args) throws InterruptedException {
                System.setProperty("webdriver.gecko.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/geckodriver");

                WebDriver driver = new FirefoxDriver();

                driver.get("https://www.google.com");

                WebElement etSearchField = driver.findElement(By.xpath(".//*[@name='q']"));

                etSearchField.sendKeys("Selenium");

                etSearchField.submit();

                Thread.sleep(20_000);

                System.out.println("Page title is: " + driver.getTitle());

                driver.quit();
        }
}
