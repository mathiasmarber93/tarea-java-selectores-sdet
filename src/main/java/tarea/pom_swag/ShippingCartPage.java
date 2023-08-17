package tarea.pom_swag;

import org.openqa.selenium.By;

public class ShippingCartPage extends BaseTestClass{

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
