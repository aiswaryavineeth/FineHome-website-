package tests;

import POM.CreateAccountPage;
import org.testng.annotations.Test;
import static core.Main.driver;

public class createAccount {
    @Test(priority = 1)
    public void createAccountTest() throws InterruptedException {
        core.Main.initializeDriver();
        driver.get("https://app.finehome360.com/");

        CreateAccountPage create = new CreateAccountPage(driver);

        create.closepopup();
        create.clickLoginButton();
        create.clicksignup();
        create.emailid("nila@gmail.com");
        create.country();
        create.phnumber("566088345");
        create.uname("nilanisah");
        create.firstName("nila");
        create.lastName("nis");
        create.pwd("Ddd@1234");
        create.conpwd("Ddd@1234");
        create.sub();
        create.otp("123456");
        create.otpsubmit();

        core.Main.quitDriver();
    }
}
