package myprojects.automation.assignment3;

import myprojects.automation.assignment3.tests.CreateCategoryTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * Contains main script actions that may be used in scripts.
 */

public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogueLink = By.cssSelector("#subtab-AdminCatalog");
    private By categoriesLink = By.xpath("//li[@id='subtab-AdminCategories']");
    private By addCategoryButton = By.cssSelector("#page-header-desc-category-new_category");
    private By nameField = By.xpath("//input[@id='name_1']");
    private By saveButton = By.xpath("//button[@id='category_form_submit_btn']");
    private By createMessage = By.xpath("//div[@class='alert alert-success']");
    private By categoryFilterField = By.xpath("//input[@name='categoryFilter_name']");
    private By searchButton = By.xpath("//button [@id='submitFilterButtoncategory']");
    private By tableCellWithTheCategoryName = By.xpath("//tr[1]/td[@class='pointer'][1]");
    private By resetCategoryButton = By.xpath("//button[@name='submitResetcategory']");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
    }

   //Logs in to Admin Panel.

    public void login(String login, String password) {
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement loginInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement loginButton = driver.findElement(By.name("submitLogin"));
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    //Adds new category in Admin Panel.

    public void createCategory(String categoryName){
        wait.until(elementToBeClickable(catalogueLink));
        WebElement catalogueLink = driver.findElement(this.catalogueLink);
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogueLink).build().perform();
        wait.until(elementToBeClickable(categoriesLink));
        actions.click(categoriesLink).build().perform();
        WebElement addCategoryButton = (WebElement) wait.until(elementToBeClickable(this.addCategoryButton));
        addCategoryButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name_1']")));
        WebElement nameField = driver.findElement(this.nameField);
        WebElement saveButton = driver.findElement(this.saveButton);
        nameField.sendKeys(categoryName);
        scrollToTheBottomToThePage();
        saveButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
        WebElement createMessage = driver.findElement(this.createMessage);
        Assert.assertTrue(createMessage.isDisplayed(),"Registration is not successful!!!");
    }

    public void checkNewCategory(String newCategoryName){
        WebElement categoryFilterField = driver.findElement(this.categoryFilterField);
        categoryFilterField.sendKeys(newCategoryName);
        WebElement searchButton = driver.findElement(this.searchButton);
        searchButton.click();
        wait.until(elementToBeClickable(resetCategoryButton));
        WebElement tableCellWithTheCategoryName = driver.findElement(this.tableCellWithTheCategoryName);
        Assert.assertTrue(tableCellWithTheCategoryName.getText().contains(CreateCategoryTest.categoryName),"The created category is not displayed in the table!!!");
    }

    public void scrollToTheBottomToThePage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
