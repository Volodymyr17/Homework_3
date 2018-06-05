package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;


public class CreateCategoryTest extends BaseScript {
    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    public static String categoryName = "MyNewCategory";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getConfiguredDriver("chrome");
        GeneralActions actions = new GeneralActions(driver);
        // login
        actions.login(login, password);
        // create category
        actions.createCategory(categoryName);
        // check that new category appears in Categories table
        actions.checkNewCategory(categoryName);
        // finish script
        driver.quit();
    }
}
