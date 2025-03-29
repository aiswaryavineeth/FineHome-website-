package POM;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By profile = By.xpath("//img[@alt='User']");
    private By logoutButton = By.xpath("//div[normalize-space()='Log out']");

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(profile));
        driver.findElement(profile).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
        Allure.step("Logout successfully");
    }
}
