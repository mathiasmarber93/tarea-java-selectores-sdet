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

    public static WebDriver driver;

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



}
