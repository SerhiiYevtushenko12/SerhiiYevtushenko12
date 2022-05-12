package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

enum Driver {
    CHROME_DRIVER, FIREFOX
}

public class Homework4 {
    public static void main(String[] args) throws InterruptedException {
        enterTitle(Driver.CHROME_DRIVER, true);
//        enterTitle2(Driver.CHROME_DRIVER);
    }

    private static void enterTitle(Driver driver, boolean useMobileOptions) throws InterruptedException {
        if (driver == Driver.CHROME_DRIVER) {
            System.setProperty("webdriver.chrome.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/chromedriver");
        } else if (driver == Driver.FIREFOX) {
            System.setProperty("webdriver.gecko.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/geckodriver");
        }

        Map<String, String> mobileEmulation = new HashMap<>();
        if (useMobileOptions){
            mobileEmulation.put("deviceName", "Nexus 5");
        }

        WebDriver webDriver;
        if (driver == Driver.CHROME_DRIVER) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            webDriver = new ChromeDriver(chromeOptions);
        } else if (driver == Driver.FIREFOX) {
            webDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException();
        }

        webDriver.get("https://www.google.com");
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.xpath(".//*[@name='q']"));
        Thread.sleep(1000);
        element.sendKeys("Selenium");
        element.submit();

        Thread.sleep(1000);
        System.out.println("Page title is: " + webDriver.getTitle());
        webDriver.quit();
    }

    private static void enterTitle2(Driver driver) throws InterruptedException {
        DriverExecutor executor;
        if (driver == Driver.CHROME_DRIVER) {
            executor = new ChromeDriverExecutor();
        } else if (driver == Driver.FIREFOX) {
            executor = new FireFoxDriverExecutor();
        } else {
            return;
        }

        executor.setProperty();
        executor.setOptions();

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");

        WebDriver webDriver = executor.getDriver();

        webDriver.get("https://www.google.com");
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.xpath(".//*[@name='q']"));
        Thread.sleep(1000);
        element.sendKeys("Selenium");
        element.submit();

        Thread.sleep(1000);
        System.out.println("Page title is: " + webDriver.getTitle());
        webDriver.quit();
    }
}

interface DriverExecutor {
    void setProperty();
    void setOptions();
    WebDriver getDriver();
}

class ChromeDriverExecutor implements DriverExecutor {

    private ChromeOptions options;
    @Override
    public void setProperty() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/chromedriver");
    }

    @Override
    public void setOptions() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Nexus 5");
        options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
    }

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver(options);
    }
}

class FireFoxDriverExecutor implements DriverExecutor {

    @Override
    public void setProperty() {
        System.setProperty("webdriver.gecko.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/geckodriver");
    }

    @Override
    public void setOptions() {
        // not needed
    }

    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}

