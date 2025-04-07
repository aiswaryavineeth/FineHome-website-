package tests;

import POM.CreateAccountPage;
import tests.CreateAccountTest;
import org.testng.annotations.Test;
import utils.MailinatorAPI;

import java.io.IOException;
import static core.Main.driver;

public class CreateAccountTest {
    @Test(priority = 1)
    public void createAccountTest() throws InterruptedException, IOException {
        core.Main.initializeDriver();
        driver.get("https://app.finehome360.com/");

        CreateAccountPage create = new CreateAccountPage(driver);

        // Generate dynamic email
        String randomEmail = "test" + System.currentTimeMillis() + "@mailinator.com";
        create.closePopup();
        create.clickLoginButton();
        create.clickSignup();
        create.enterEmail(randomEmail);
        create.selectCountry();
        create.enterPhoneNumber("566088345");
        create.enterUsername("nilanisah");
        create.enterFirstName("nila");
        create.enterLastName("nis");
        create.enterPassword("Ddd@1234");
        create.enterConfirmPassword("Ddd@1234");
        create.submitForm();

        // Wait for OTP and fetch from Mailinator
        Thread.sleep(5000);  // Wait for email arrival
        String otp = MailinatorAPI.getOTP(randomEmail);
        create.enterOTP(otp);
        create.submitOTP();

        core.Main.quitDriver();
    }
}
