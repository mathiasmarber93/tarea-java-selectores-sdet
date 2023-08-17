package tarea.pom_swag;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ShippingCart extends BaseTestClass {

    @BeforeClass
    void login() {
        navigateTo("https://www.saucedemo.com/");
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("localStorage.clear();");
        Cookie loginCookie = new Cookie("session-username", "standard_user");
        driver.manage().addCookie(loginCookie);
        ((JavascriptExecutor) driver).executeScript("localStorage.setItem('cart-contents','[4,1,0]')");
        driver.navigate().refresh();
    }

    @Test
    void validateShippingCartItems() {
        navigateTo("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(Integer.valueOf(getShoppingCartText()), 3);
        wait(2);
    }

    @Test
    void validateUserCanCheckOut() {
        navigateTo("https://www.saucedemo.com/checkout-step-one.html");
        register("Mathias", "123456", "2022");
        Assert.assertTrue(getTotalText().contains("60.45"));
        wait(2);
    }

}