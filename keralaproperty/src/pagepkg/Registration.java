	package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Registration {

    WebDriver driver;

    @FindBy(xpath = "//img[contains(translate(@alt,'LOGO','logo'),'logo') or contains(translate(@src,'LOGO','logo'),'logo')]")
    WebElement logo;

    @FindBy(xpath = "//input[@name='name' or @name='fullname' or @placeholder='Name']")
    WebElement name;

    @FindBy(xpath = "//input[@type='email' or @name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@type='password' or @name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit'] | //button[@type='submit']")
    WebElement registerbutton;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void titleverification() {
        String actualtitle = driver.getTitle();

        System.out.println("Actual Title: " + actualtitle);

        Assert.assertTrue(
            actualtitle.toLowerCase().contains("kerala property"),
            "Title verification failed. Actual title: " + actualtitle
        );

        System.out.println("Title verification passed");
    }

    public void logoverification() {
        Assert.assertTrue(
            logo.isDisplayed(),
            "Logo is not displayed"
        );

        System.out.println("Logo verification passed");
    }

    public void registrationdetails(
            String fullname,
            String emailid,
            String pass) {

        name.sendKeys(fullname);
        email.sendKeys(emailid);
        password.sendKeys(pass);
    }

    public void register() {
        registerbutton.click();
    }
}