import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class createAccountPAge extends Main {

    public createAccountPAge(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By closeButton = By.className("driver-popover-close-btn");
    private By loginButton = By.xpath("//p[normalize-space()='Login']");
    private By signup = By.xpath("//*[@href='/signup']");
    private By email = By.xpath("//*[@placeholder='write your email']");
    private By countrycode = By.xpath("//div[@class='styles_country__4NMqj MuiBox-root mui-0']");
    private By countryWidget = By.xpath("//*[@class='MuiDialog-container MuiDialog-scrollPaper mui-ekeie0']");

    private By selectcountry = By.xpath("//p[normalize-space()='Pakistan']");
    private By phone = By.xpath("//*[@placeholder='444 56789']");
    private By username = By.xpath("//*[@placeholder='Write user name']");

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
    public void emailid(String emailid){
        driver.findElement(email).sendKeys(emailid);
    }
    public void ccode()
    {

        driver.findElement(countrycode).click();
    }
    public void country(){
        WebElement widget = wait.until(ExpectedConditions.visibilityOfElementLocated(countryWidget));
        driver.findElement(selectcountry).click();
    }
    public void phnumber(String number){
        driver.findElement(phone).sendKeys(number);
    }
    public void uname(String name){
        driver.findElement(username).sendKeys(name);
    }
}