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

    // Locators
    private By closeButton = By.className("driver-popover-close-btn");
    private By loginButton = By.xpath("//p[normalize-space()='Login']");
    private By signup = By.xpath("//*[@href='/signup']");
    private By emailField = By.xpath("//*[@placeholder='write your email']");
    private By countryDropdown = By.xpath("//div[@class='styles_country__4NMqj MuiBox-root mui-0']");
    private By countryWidget = By.xpath("//*[@class='MuiDialog-container MuiDialog-scrollPaper mui-ekeie0']");
    private By selectCountry = By.xpath("//div[@class='CountrySelect_countries__6T0DA MuiBox-root mui-0']//div[2]");
    private By phoneField = By.xpath("//*[@placeholder='444 56789']");
    private By usernameField = By.xpath("//*[@placeholder='Write user name']");
    private By firstNameField = By.xpath("//*[@placeholder='Enter first name']");
    private By lastNameField = By.xpath("//*[@placeholder='Enter last name']");
    private By passwordField = By.xpath("//*[@placeholder='Enter your password']");
    private By confirmPasswordField = By.xpath("//*[@placeholder='Confirm Your password']");
    private By submitButton = By.xpath("//*[@type='submit']");
    private By otpFields = By.xpath("//*[@aria-label='Digit']"); // Adjust based on actual structure
    private By otpSubmitButton = By.xpath("//*[@type='submit']");

    // Methods
    public void closePopup() {
        driver.findElement(closeButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickSignup() {
        driver.findElement(signup).click();
    }

    public void enterEmail(String email) {
        WebElement mailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        mailInput.sendKeys(email);
    }

    public void selectCountry() {
        driver.findElement(countryDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryWidget));
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(selectCountry));
        country.click();
    }

    public void enterPhoneNumber(String number) {
        driver.findElement(phoneField).sendKeys(number);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public void enterOTP(String otp) {
        WebElement[] otpElements = driver.findElements(otpFields).toArray(new WebElement[0]);
        for (int i = 0; i < otp.length(); i++) {
            otpElements[i].sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

    public void submitOTP() {
        driver.findElement(otpSubmitButton).click();
        Allure.step("Account created successfully.");
    }
}
