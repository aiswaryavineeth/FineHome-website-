import org.testng.annotations.Test;

public class createAccount extends Main{
        @Test(priority=1)
        public void createaccounttest() throws InterruptedException {
            createAccountPAge create=new createAccountPAge(driver);
            create.openLoginPage("https://app.finehome360.com/");
            create.closepopup();
            create.clickLoginButton();
            create.clicksignup();
            Thread.sleep(1000);
            create.emailid("nila@gmail.com");
          //  create.ccode();
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



        }
    }


