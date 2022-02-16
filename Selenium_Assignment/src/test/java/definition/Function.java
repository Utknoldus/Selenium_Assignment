package definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Function {
    ReadData excel = new ReadData("/home/knoldus/IdeaProjects/Selenium_Assignment/Data/data.xlsx");
    public WebDriver driver = new FirefoxDriver();

    @Test
    @Given("I am in the login page of the DemoQa site")
    public void i_am_in_the_login_page_of_the_demo_qa_site() throws TimeoutException {

        // open browser
        try {
            System.setProperty("webdriver.chrome.driver", "/home/knoldus/IdeaProjects/Selenium_Assignment/Resources/chromedriver");
        } catch (WebDriverException e) {
            System.out.println("e.getMessage()");
        }

        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        //implicit Timeout
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/login");

    }

    @When("Take data from excel sheet")
    public void take_data_from_excel_sheet() {
        try {
            driver.findElement(By.cssSelector("input#userName")).sendKeys(excel.getData(0, 0, 0));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        driver.findElement(By.cssSelector("input#password")).sendKeys(excel.getData(0, 0, 1));

        try {
            driver.findElement(By.id("login")).click();
        } catch (ElementNotVisibleException e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("Browser close automatically")
    public void browser_close_automatically() {
        try {

            driver.quit();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    @Given("I am in the login page of the DemoQa site for firefox")
    public void i_am_in_the_login_page_of_the_demo_qa_site_for_firefox() {
        System.setProperty("webdriver.gecko.driver", "/home/knoldus/IdeaProjects/Selenium_Assignment/Resources/geckodriver");

        driver = new FirefoxDriver();

        // Maximize browser
        driver.manage().window().maximize();

        //implicit Timeout
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/login");

    }

    @When("Take data from excel sheet for firefox")
    public void take_data_from_excel_sheet_for_firefox() {
        driver.findElement(By.cssSelector("input#userName")).sendKeys(excel.getData(0, 0, 0));
        driver.findElement(By.cssSelector("input#password")).sendKeys(excel.getData(0, 0, 1));
        driver.findElement(By.id("login")).click();

    }


    @Then("Browser close automatically for firefox")
    public void browser_close_automatically_for_firefox() {
        driver.quit();
    }


    // For headless browser
    @Test
    @Given("I am in the login page of the DemoQa site for headless")
    public void i_am_in_the_login_page_of_the_demo_qa_site_for_headless() {
        System.setProperty("webdriver.chrome.driver", "/home/knoldus/IdeaProjects/Selenium_Assignment/Resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        // Maximize browser
        driver.manage().window().maximize();

        //implicit Timeout
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/login");
    }

    @When("Take data from excel sheet for headless for headless")
    public void take_data_from_excel_sheet_for_headless_for_headless() {
        driver.findElement(By.cssSelector("input#userName")).sendKeys(excel.getData(0, 0, 0));
        driver.findElement(By.cssSelector("input#password")).sendKeys(excel.getData(0, 0, 1));
        driver.findElement(By.id("login")).click();
    }

    @Then("Browser close automatically for headless for headless")
    public void browser_close_automatically_for_headless_for_headless() {
        driver.quit();
    }

}
