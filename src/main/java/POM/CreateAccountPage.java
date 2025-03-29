package POM;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By closeButton = By.className("driver-popover-close-btn");
    private By loginButton = By.xpath("//p[normalize-space()='Login']");
    private By signup = By.xpath("//*[@href='/signup']");
    private By email = By.xpath("//*[@placeholder='write your email']");
    private By countrycode = By.xpath("//div[@class='styles_country__4NMqj MuiBox-root mui-0']");
    private By countryWidget = By.xpath("//*[@class='MuiDialog-container MuiDialog-scrollPaper mui-ekeie0']");
    private By selectcountry = By.xpath("//div[@class='CountrySelect_countries__6T0DA MuiBox-root mui-0']//div[2]");
    private By phone = By.xpath("//*[@placeholder='444 56789']");
    private By username = By.xpath("//*[@placeholder='Write user name']");
    private By Firstname = By.xpath("//*[@placeholder='Enter first name']");
    private By Lastname = By.xpath("//*[@placeholder='Enter last name']");
    private By password = By.xpath("//*[@placeholder='Enter your password']");
    private By confirmpassword = By.xpath("//*[@placeholder='Confirm Your password']");
    private By submit = By.xpath("//*[@type='submit']");
    private By OTP1 = By.xpath("//*[@aria-label='Digit 1 of OTP']");
    private By OTP2 = By.xpath("//*[@aria-label='Digit 2 of OTP']");
    private By OTP3 = By.xpath("//*[@aria-label='Digit 3 of OTP']");
    private By OTP4 = By.xpath("//*[@aria-label='Digit 4 of OTP']");
    private By OTP5 = By.xpath("//*[@aria-label='Digit 5 of OTP']");
    private By OTP6 = By.xpath("//*[@aria-label='Digit 6 of OTP']");
    private By[] OTPFields = {OTP1, OTP2, OTP3, OTP4, OTP5, OTP6};
    private By subotp = By.xpath("//*[@type='submit']");

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void closepopup() {
        driver.findElement(closeButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clicksignup() {
        driver.findElement(signup).click();
    }

    public void emailid(String emailid) {
        WebElement mailid = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(emailid);
    }

    public void country() {
        driver.findElement(countrycode).click();
        WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(countryWidget));
        WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(selectcountry));
        countryElement.click();
    }

    public void phnumber(String number) {
        driver.findElement(phone).sendKeys(number);
    }

    public void uname(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void firstName(String fname) {
        driver.findElement(Firstname).sendKeys(fname);
    }

    public void lastName(String lname) {
        driver.findElement(Lastname).sendKeys(lname);
    }

    public void pwd(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void conpwd(String conpass) {
        driver.findElement(confirmpassword).sendKeys(conpass);
    }

    public void sub() {
        driver.findElement(submit).click();
    }

    public void otp(String ot) {
        for (int i = 0; i < OTPFields.length; i++) {
            WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(OTPFields[i]));
            otpField.sendKeys(String.valueOf(ot.charAt(i)));
        }
    }

    public void otpsubmit() {
        driver.findElement(subotp).click();
        Allure.step("Created account as successfully");
    }
}
