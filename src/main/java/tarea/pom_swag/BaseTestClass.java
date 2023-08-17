package tarea.pom_swag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import tarea.base.BrowserType;
import tarea.base.DriverFactory;

public class BaseTestClass {

    public WebDriver driver;
    protected String demoSiteUrl = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String username = "admin";
    String password = "G3-ySzY%";

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        driver = DriverFactory.getInstance().getDriver();
    }

    @AfterTest
    public void turnDown() {
        DriverFactory.getInstance().removeDriver();
    }

    void wait(int seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
    }

    private final By firstname = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By spnShoppingCart = By.className("shopping_cart_badge");
    private final By dvTotal = By.xpath("(//div[contains(text(),'Total')])[2]");

    protected String getTotalText(){
        return driver.findElement(dvTotal).getText();
    }

    protected String getShoppingCartText(){
        return driver.findElement(spnShoppingCart).getText();
    }

    private void typeUsername(String username){
        driver.findElement(firstname).sendKeys(username);
    }

    private void typePassword(String password){
        driver.findElement(lastName).sendKeys(password);
    }

    private void typePostalCode(String postal){
        driver.findElement(postalCode).sendKeys(postal);
    }

    private void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public void register(String username, String password, String postal){
        typeUsername(username);
        typePassword(password);
        typePostalCode(postal);
        clickContinue();
    }

}
