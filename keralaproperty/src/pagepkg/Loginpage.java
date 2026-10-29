
package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Loginpage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//img[contains(translate(@alt,'LOGO','logo'),'logo') or contains(translate(@src,'LOGO','logo'),'logo')]")
    WebElement logo;

    @FindBy(name = "ulogin")
    WebElement user;

    @FindBy(name = "upass")
    WebElement pass;

    @FindBy(id = "sub_logbtn")
    WebElement button;

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void titleverification() {
        String actualtitle = driver.getTitle();

        System.out.println("Actual Title: " + actualtitle);

        Assert.assertTrue(
            actualtitle.toLowerCase().contains("kerala property"),
            "Title verification failed!"
        );

        System.out.println("Title verification passed");
    }

    public void logoverification() {
        wait.until(ExpectedConditions.visibilityOf(logo));

        Assert.assertTrue(logo.isDisplayed(),
            "Logo is not displayed");

        System.out.println("Logo verification passed");
    }

    public void start(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(user));
        user.sendKeys(username);

        wait.until(ExpectedConditions.visibilityOf(pass));
        pass.sendKeys(password);
    }

    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
}
