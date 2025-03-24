import org.testng.annotations.Test;

public class Login  extends Main {
    @Test(priority = 1)
    public void logintest() throws InterruptedException{
      LoginPage loginPage=new LoginPage(driver);
      loginPage.openLoginPage("https://app.finehome360.com/");
      loginPage.closepopup();
      loginPage.clickLoginButton();
      loginPage.enterEmail("nish2000@gmail.com");
      loginPage.enterPassword("Nish@2025");
      loginPage.submit();

    }
}
