import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SixthTest {

    private WebDriverWait wait;
    private WebDriver webDriver;

    @BeforeClass
    public void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\tpetkis\\Downloads\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\tpetkis\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
        webDriver.get("https://demoqa.com/automation-practice-form");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]")))).click();
        wait = new WebDriverWait(webDriver, 20);
        webDriver.manage().window().setSize(new Dimension(1280, 595));

    }

    @Test
    public void testPracticeForm() {
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        firstNameInput.sendKeys("Petra");

        WebElement lastNameInput = webDriver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Kis");

        WebElement emailInput = webDriver.findElement(By.id("userEmail"));
        emailInput.sendKeys("petra@kis.com");

        WebElement genderRadio = webDriver.findElement(By.id("gender-radio-2"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", genderRadio);

        WebElement mobileNumberInput = webDriver.findElement(By.id("userNumber"));
        mobileNumberInput.sendKeys("1234567890");

        WebElement element = webDriver.findElement(By.id("dateOfBirthInput"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        WebElement monthDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByVisibleText("January");

        WebElement yearDropdown = webDriver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByVisibleText("2002");

        WebElement dayToSelect = webDriver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[text()='12']"));
        dayToSelect.click();

        WebElement submitButton = webDriver.findElement(By.id("submit"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(submitButton);
        actions.perform();
        element.click();
    }

    @AfterClass
    public void closeBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
