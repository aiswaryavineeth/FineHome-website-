package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Main {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void initializeDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void quitDriver() throws IOException {
        if (driver != null) {
            driver.quit();
        }
        String projectPath = "C:\\Users\\Aiswarya\\IdeaProjects\\FineHome_webiste";
        String command = "cmd /c start cmd.exe /K \"cd /d " + projectPath + " && allure serve allure-results\"";

        // Execute the command
        Runtime.getRuntime().exec(command);

    }
}
