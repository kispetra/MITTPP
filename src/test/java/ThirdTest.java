import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.concurrent.TimeUnit;


import java.time.Duration;

public class ThirdTest {
    private WebDriver webDriver;
    private WebDriverWait wait;

    /*@BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tpetkis\\Downloads\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/books");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
        wait = new WebDriverWait(webDriver, 10);
    }*/
    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tpetkis\\Downloads\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\tpetkis\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://demoqa.com/books");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
        wait = new WebDriverWait(webDriver, 10);
    }

    @Test
    public void testSearchByNonExistingTitle() {
        setImplicitWait(2);

        String searchTitle = "Git Pocket Guide22" + "\n";
        performSearch(searchTitle);

        boolean exist = isBookVisible("Git Pocket Guide");
        Assert.assertFalse(exist);

        clearSearchBox();
    }

    @Test(dependsOnMethods = "testSearchByNonExistingTitle")
    public void testSearchByTitle() {
        String searchTitle = "Git Pocket Guide";
        performSearch(searchTitle);

        assertBookVisible(searchTitle);

        clearSearchBox();
        clickOnBook(searchTitle);
    }

    @AfterClass
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private void setImplicitWait(int seconds) {
        webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    private void performSearch(String searchTitle) {
        WebElement searchBox = webDriver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
        searchBox.clear();
        searchBox.sendKeys(searchTitle);
    }

    private boolean isBookVisible(String title) {
        By bookLocator = By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a");
        return !webDriver.findElements(bookLocator).isEmpty();
    }

    private void assertBookVisible(String title) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        By bookLocator = By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a");
        WebElement book = wait.until(ExpectedConditions.visibilityOfElementLocated(bookLocator));
        Assert.assertTrue(book.isDisplayed(), "Book with title '" + title + "' should be visible");
    }

    private void clearSearchBox() {
        WebElement searchBox = webDriver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
        searchBox.clear();
    }

    private void clickOnBook(String title) {
        By bookLocator = By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a");
        WebElement book = wait.until(ExpectedConditions.elementToBeClickable(bookLocator));
        Actions actions = new Actions(webDriver);

        actions.moveToElement(book).click().perform();
    }
}
