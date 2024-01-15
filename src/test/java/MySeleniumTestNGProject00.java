import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MySeleniumTestNGProject00 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Create WebDriver instance
        driver = new ChromeDriver();
    }

    @Test
    public void testFormFilling() {
        // Navigate to the specified web page
        driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");

        // Perform actions: Fill in the form
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");

        // Assert the title of the page (adjust as needed)
        assertEquals("Checkout example · Bootstrap v5.3", driver.getTitle());

        // You can add more assertions or actions as required for your test

        // Optional: Add a sleep statement for demonstration purposes
        // Note: Using Thread.sleep in tests is generally discouraged due to its static nature
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
