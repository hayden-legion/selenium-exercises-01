package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SingleLoginTest {
    private WebDriver driver;


    @BeforeMethod
    public void setUp() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }

    @Test
    public void testLogin() {
        // Navigate to the home page
        driver.get("https://buggy.justtestit.org/");

        // Find the username and password fields
        WebElement usernameField = driver.findElement(By.name("login"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the username and password
        usernameField.sendKeys("hayden_user1");
        passwordField.sendKeys("Qwerty123.");

        // Click the login button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Verify that the user has logged in successfully
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement profileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/profile]']")));
        Assert.assertTrue(profileLink.isDisplayed());

    }
}
