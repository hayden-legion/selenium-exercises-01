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

public class HomePageTest {
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

    @Test(priority = 1)
    public void verifyPopularMake() {
        // Navigate to the home page
        driver.get("https://buggy.justtestit.org/");

        // Find the Popular Make link
        WebElement popularMake = driver.findElement(By.cssSelector("img.img-fluid[src='/img/cars/AR-logo.jpg'][title='Alfa Romeo']"));

        // Navigate to Popular Make page
        popularMake.click();

        // Wait for the  page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Verify that the new page's URL is correct
        String expectedUrl = "https://buggy.justtestit.org/make/c4u1mqnarscc72is00ng";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Unexpected URL");

    }
    @Test(priority = 2)
    public void verifyPopularModel() {
        // Navigate to the home page
        driver.get("https://buggy.justtestit.org/");

        // Find the Popular Model link
        WebElement popularModel = driver.findElement(By.cssSelector("img.img-fluid[src='/img/cars/giulia.png'][title='Guilia Quadrifoglio']"));

        // Navigate to Popular Model page
        popularModel.click();

        // Wait for the new page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Verify that the new page's URL is correct
        String expectedUrl = "https://buggy.justtestit.org/model/c4u1mqnarscc72is00ng%7Cc4u1mqnarscc72is00sg";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Unexpected URL");
    }
    @Test(priority = 3)
    public void verifyOverallRatings() {
        // Navigate to the home page
        driver.get("https://buggy.justtestit.org/");

        // Find the Overall Ratings link
        WebElement overallRatings = driver.findElement(By.cssSelector("img.img-fluid[src='/img/overall.jpg']"));

        // Navigate to Overall Ratings page
        overallRatings.click();

        // Wait for the new page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Verify that the new page's URL is correct
        String expectedUrl = "https://buggy.justtestit.org/model/c4u1mqnarscc72is00ng%7Cc4u1mqnarscc72is00sg";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Unexpected URL");
    }
    @Test(priority = 4)
    public void verifyTwitterLink() {
        // Navigate to the home page
        driver.get("https://buggy.justtestit.org/");

        // Find the Twitter link
        WebElement twitterLink = driver.findElement(By.cssSelector("img.img-fluid[src='/img/twitter.png']"));

        // Navigate to Twitter page
        twitterLink.click();

        // Wait for the new page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Verify that the new page's URL is correct
        String expectedUrl = "https://twitter.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Unexpected URL");
    }
    @Test(priority = 5)
    public void verifyFacebookLink() {
        // Navigate to the home page
        driver.get("https://buggy.justtestit.org/");

        // Find the Facebook link
        WebElement facebookLink = driver.findElement(By.cssSelector("img.img-fluid[src='/img/FB-f-Logo__blue_29.png']"));
        // Navigate to Facebook page
        facebookLink.click();

        // Wait for the new page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Verify that the new page's URL is correct
        String expectedUrl = "https://facebook.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Unexpected URL");
    }
}
