package lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class FacebookLogicService {

    private final static String URL = "https://facebook.com";
    private final static String FIRSTNAME_KEY = "firstname";
    private final static String LASTNAME_KEY = "lastname";
    private final static String EMAIL_KEY = "reg_email__";
    private final static String EMAIL_CONFIRMATION_KEY = "reg_email_confirmation__";
    private final static String PASSWORD_KEY = "reg_passwd__";

    public void signUp(FacebookUser user) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/serhii/IdeaProjects/untitled2/Sources/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        findAndClick(driver, By.xpath(".//*[@rel=\"async\"]"));

        Thread.sleep(1_000);

        sendKeys(driver, FIRSTNAME_KEY, user.getFirstname());
        sendKeys(driver, LASTNAME_KEY, user.getLastname());
        sendKeys(driver,EMAIL_KEY, user.getEmail());
        sendKeys(driver,EMAIL_CONFIRMATION_KEY, user.getEmail());
        sendKeys(driver,PASSWORD_KEY, user.getPassword());

        Select month = getSelect(driver,"month");
        month.selectByIndex(user.getMonth());

        Select day = getSelect(driver,"day");
        day.selectByIndex(user.getDay());

        Select year = getSelect(driver,"year");
        year.selectByIndex(user.getYearIndex());

        findAndClick(driver,By.xpath("//label[text()='" + user.getGender() +"']"));

        findAndClick(driver,By.xpath(".//*[@name=\"websubmit\"]\n"));
    }

    private void findAndClick(WebDriver driver, By xpath) {
       driver.findElement(xpath).click();
    }

    private Select getSelect(WebDriver driver, String xpathExpression) {
        return new Select(driver.findElement(By.xpath(".//*[@id='"+ xpathExpression +"']")));
    }

    private void sendKeys(WebDriver driver, String name, String key) {
        driver.findElement(By.name(name)).sendKeys(key);
    }
}
