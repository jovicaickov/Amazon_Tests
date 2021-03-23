package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private final By searchDropdownMenu = By.id("searchDropdownBox");
    private final By selectCategory = By.xpath("//*/option[7]");
    private final By searchBarLocator = By.id("twotabsearchtextbox");
    private final By searchButtonLocator = By.id("nav-search-submit-text");
    private final By searchResultsTextLocator = By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]");
    private final By sortByLocator = By.className("a-dropdown-prompt");
    private final By avgCustomerReviewLocator = By.id("s-result-sort-select_3");
    private final By sortByTextLocator = By.className("a-dropdown-prompt");
    
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    private void clickOnSearchDropdownMenu() {
        driver.findElement(searchDropdownMenu).click();
    }
    
    private void clickOnCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(selectCategory)).click();
    }
    
    private void setSearchValue (String searchValue) {
        driver.findElement(searchBarLocator).sendKeys(searchValue);
    }
    
    private void clickOnSearchButton() {
        driver.findElement(searchButtonLocator).click();
    }
    
    public String getSearchResultsText() {
        return driver.findElement(searchResultsTextLocator).getText();
    }
    
    public String getSortByText() {
        return driver.findElement(sortByTextLocator).getText();
    }
    
    private void clickOnSortByButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sortByLocator)).click();
    }
    
    private void clickOnAvgCustomerReviewOption() {
        wait.until(ExpectedConditions.elementToBeClickable(avgCustomerReviewLocator)).click();
    }
    
    public void selectCategoryFromSearchDropdownMenu() {
        clickOnSearchDropdownMenu();
        clickOnCategory();
        clickOnSearchButton();
    }
    
    public void enterValueInSearchBar(String searchValue) {
        setSearchValue(searchValue);
        clickOnSearchButton();
    }
    
    public void selectAvgCustomerReviewFromSortByDropdown() {
        clickOnSortByButton();
        clickOnAvgCustomerReviewOption();
    }
    
}