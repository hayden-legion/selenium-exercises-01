package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        // Navigate to the login page
        driver.get("https://buggy.justtestit.org/");

        // Find the username and password fields
        WebElement usernameField = driver.findElement(By.name("login"));
        WebElement passwordField = driver.findElement(By.name("password"));
        //WebElement usernameField = driver.findElement(By.id("login"));
        //WebElement passwordField = driver.findElement(By.id("password"));

        // Enter the username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the login button
        //WebElement loginButton = driver.findElement(By.id("submit"));
        //WebElement loginButton = driver.findElement(By.className("btn btn-success"));
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        // Verify that the user has logged in successfully
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'You have logged in!')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Invalid username/password");
    }

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
                {"hayden_user1", "Hayden_user1"}
                //{"testuser2", "testpassword2"},
                //{"testuser3", "testpassword3"}
        };
    }
}