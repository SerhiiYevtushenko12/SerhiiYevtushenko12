package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Search {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        String url = "https://rozetka.com.ua/ua/mobile-phones/c80003/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> finds = driver.findElements(By.xpath("//*[@class='goods-tile__label promo-label promo-label_type_action ng-star-inserted']"));

        List<String> names = new ArrayList<>();
        for (WebElement webElements : finds) {
            WebElement element = webElements.findElement(By.xpath("//parent::*/*[@class='goods-tile__inner']"));
            names.add(element.getText());

            System.out.println(names);
            driver.quit();

        }
    }
}