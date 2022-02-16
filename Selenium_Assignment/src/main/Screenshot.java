import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/knoldus/IdeaProjects/Selenium_Assignment/Resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        ss("LoginPage");
        driver.quit();
    }

    public static void ss(String filename) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("/home/knoldus/IdeaProjects/Selenium_Assignment/target/Screenshot.png"));
    }
}
