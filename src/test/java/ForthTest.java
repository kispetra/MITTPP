import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ForthTest {

    private WebDriverWait wait;
    private WebDriver webDriver;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tpetkis\\Downloads\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\tpetkis\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://demoqa.com/login");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
        wait = new WebDriverWait(webDriver, 20);
    }

    @Test (priority = 1)
    public void testLogin() {
        String username = "petrakis1";
        String password = "Petrakis$.1";

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userName\"]")));
        WebElement passwordInput = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        Actions action = new Actions(webDriver);
        action.moveToElement(loginButton).click().build().perform();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("main-header")));
        Assert.assertEquals(successMessage.getText(), "Login");
    }

    @AfterClass
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
