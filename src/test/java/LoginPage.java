import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Main{
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Actions
    private By closeButton = By.className("driver-popover-close-btn");
    private By loginButton=By.xpath("//p[normalize-space()='Login']");
    private By Email= By.xpath("//*[@Placeholder='Please enter email or phone number']");
    private By password = By.xpath("//*[@name='password']");
    private By submit=By.xpath("//button[normalize-space()='Login']");
    public void openLoginPage(String url) {
        driver.get(url);
    }
    public void closepopup(){
        driver.findElement(closeButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public  void enterEmail(String em){
        driver.findElement(Email).sendKeys(em);
    }
    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void submit(){
        driver.findElement(submit).click();
    }

}
