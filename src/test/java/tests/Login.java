package tests;

import POM.LoginPage;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static core.Main.driver;
import static core.Main.initializeDriver;

public class Login {

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver
        initializeDriver();
    }

    @Test(priority = 2)
    public void logintest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver); // Passing initialized driver to LoginPage
        loginPage.openLoginPage("https://app.finehome360.com/");
        loginPage.closepopup();
        loginPage.clickLoginButton();
        loginPage.enterEmail("nish2000@gmail.com");
        loginPage.enterPassword("Nish@2025");
        loginPage.submit();

    }
}
