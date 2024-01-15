import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MySeleniumTestNGProject01 {

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

        // Click the Submit button by XPath
        WebElement submitButtonViaXpath = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/form/button"));
        submitButtonViaXpath.click();

        /**
         * HANDS-ON EXERCISES
         * TO DO:
         * - Complete the form using Selenium JUNIT Test Automation
         * - Payment should be Debit Card
         * - After the Submit button, it should return no errors and return to the initial state
         * - Redundant/Duplicated Steps can be removed
         */

        // Optional: Add a sleep statement for demonstration purposes
        // Note: Using Thread.sleep in tests is generally discouraged due to its static nature
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         Checkpoint to ensure no elements with 'invalid-feedback' class are present and the exercise is correct
         DO NOT UPDATE THIS PART
         **/
        List<WebElement> invalidFeedbackElements = driver.findElements(By.className("invalid-feedback"));
        boolean isVisible = false;
        for (WebElement element : invalidFeedbackElements) {
            if (element.isDisplayed()) {
                isVisible = true;
                break;
            }
        }
        if (!isVisible) {
            System.out.println("Checkpoint Passed: No visible 'invalid-feedback' elements found on the page.");
        } else {
            System.out.println("Checkpoint Failed: Visible 'invalid-feedback' elements found on the page.");
        }
        assertFalse(isVisible);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
