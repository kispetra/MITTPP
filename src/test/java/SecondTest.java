import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SecondTest {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tpetkis\\Downloads\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/text-box");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
    }


    @Test
    public void testTextBoxInput() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement textBox = webDriver.findElement(By.xpath("//*[@id=\"userName\"]"));
        textBox.sendKeys("Petra Kiš");
        Assert.assertEquals(textBox.getAttribute("value"), "Petra Kiš", "Incorrect text input");
    }


    @Test
    public void testSubmitButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submit']")));
        WebElement outputMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userForm")));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(submitButton).click().perform();

        wait.until(ExpectedConditions.visibilityOf(outputMessage));
    }


    @AfterClass
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
