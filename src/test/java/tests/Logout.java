package tests;

import POM.LogoutPage;
import org.testng.annotations.Test;
import static core.Main.driver;
public class Logout {
    @Test(priority = 3)
    public void logoutTest() {
        LogoutPage log = new LogoutPage(driver);
        log.logout();
    }
}
