import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FifthTest {

    private WebDriverWait wait;
    private WebDriver webDriver;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tpetkis\\Downloads\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\tpetkis\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://demoqa.com/droppable");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
        wait = new WebDriverWait(webDriver, 20);
    }

    @Test
    public void testDroppable() {
        By draggableLocator = By.id("draggable");
        By droppableLocator = By.id("droppable");

        WebElement draggableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(draggableLocator));
        WebElement droppableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(droppableLocator));

        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(draggableElement, droppableElement).perform();
    }

    @AfterClass
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
