package myprojects.automation.assignment3;

import myprojects.automation.assignment3.tests.CreateCategoryTest;
import myprojects.automation.assignment3.utils.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;


public abstract class BaseScript {

    public static WebDriver getDriver(String browser) {
        if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", CreateCategoryTest.class.getResource("geckodriver.exe").getPath());
            return new FirefoxDriver();
        } else if ("edge".equals(browser)) {
            System.setProperty("webdriver.edge.driver", CreateCategoryTest.class.getResource("MicrosoftWebDriver.exe").getPath());
            return new EdgeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", CreateCategoryTest.class.getResource("chromedriver.exe").getPath());
            return new ChromeDriver();
        }
    }


    public static WebDriver getConfiguredDriver(String browser){
        EventFiringWebDriver driver = new EventFiringWebDriver (getDriver(browser));
        driver.register(new EventHandler());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        return  driver;
    }






}


