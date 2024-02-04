import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FirstTest {
    private WebDriver webdriver;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tpetkis\\Downloads\\chromedriver\\chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.get("https://demoqa.com/");
        new WebDriverWait(webdriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
    }

    @Test
    public void testPageTitle() {

        String expectedTitle = "DEMOQA";
        WebDriverWait wait = new WebDriverWait(webdriver, 10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = webdriver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title is not as expected");
    }

    @Test
    public void testExistingElementVisibility() {

        WebDriverWait wait = new WebDriverWait(webdriver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-body")));

        Assert.assertTrue(element.isDisplayed(), "Element is not visible");
    }

    @Test
    public void testNonExistingElementVisibility() {

        WebDriverWait wait = new WebDriverWait(webdriver, 10);
         boolean exist = webdriver.findElements(By.className("non-card-body")).isEmpty();

        Assert.assertTrue(exist);
    }

    @AfterClass
    public void closeBrowser() {
        if (webdriver != null) {
            webdriver.quit();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        FirstTest object = new FirstTest();
        object.setupBrowser();
        object.testPageTitle();
        object.testExistingElementVisibility();
        object.testNonExistingElementVisibility();
        object.closeBrowser();
    }
}
