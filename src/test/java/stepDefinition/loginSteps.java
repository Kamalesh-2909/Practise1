package stepDefinition;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	WebDriver driver;
	
	@Before
	public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	@BeforeStep
    public void beforeStep() {
        System.out.println("Executing step...");
	}
	@Given("the user is logged in to the SauceDemo website")
	public void the_user_is_logged_in_to_the_sauce_demo_website() {
		driver.get("https://www.saucedemo.com");
	    
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).click();
	}
	@When("the user adds product to the cart")
	public void the_user_adds_product_to_the_cart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
	}
	@Then("the cart should display number of item")
	public void the_cart_should_display_number_of_item() {
		List<WebElement> removeButtons = driver.findElements(By.xpath("//button[contains(text(),'Remove')]"));
        int expectedCount = removeButtons.size();
        System.out.println("No. of products added: " + expectedCount);

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int actualCartCount = Integer.parseInt(cartBadge.getText());
        Assert.assertEquals(actualCartCount, expectedCount, "Cart item count mismatch!");
	}
	@AfterStep
	public void afterStep() {
		System.out.println("Step executed.");
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
