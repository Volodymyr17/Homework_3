package myprojects.automation.assignment3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class EventHandler implements WebDriverEventListener{


    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeNavigateBack(WebDriver driver) {
    }

    public void afterNavigateBack(WebDriver driver) {
    }

    public void beforeNavigateForward(WebDriver driver) {
    }

    public void afterNavigateForward(WebDriver driver) {
    }

    public void beforeNavigateRefresh(WebDriver driver) {
    }

    public void afterNavigateRefresh(WebDriver driver) {
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Should be " + by);
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Element found ");
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {System.out.println("Should click " + element.getTagName());}

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked successful ");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    }

    public void beforeScript(String script, WebDriver driver) {
    }

    public void afterScript(String script, WebDriver driver) {
    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }


}
