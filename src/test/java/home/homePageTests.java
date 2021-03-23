package home;

import base.BaseTest;
import framework.Configuration;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.HomePage;

public class homePageTests extends BaseTest {
    
    private final String expectedUrl = "https://www.amazon.com/s?k=iPhone+12+pro+max+case&ref=nb_sb_noss";
    private final String searchedValue = "iPhone 12 pro max case";
    private final String expectedUrlDropdownMenu = "https://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Dcomputers-intl-ship&field-keywords=";
        
    @After
    public void tearDown() {
        driver.navigate().to(Configuration.userUrl);
    }
    
    @Test
    public void testSearchBox() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.enterValueInSearchBar(searchedValue);
        
        assertEquals("Failure - URL doesn't match!", expectedUrl, driver.getCurrentUrl());
        assertEquals("Failure - search results doesn't match!", "\""+searchedValue+"\"", homePage.getSearchResultsText());
    }
    
    @Test
    public void testSortingOption () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.enterValueInSearchBar(searchedValue);
        homePage.selectAvgCustomerReviewFromSortByDropdown();
        
        assertEquals("Failure - sort by text doesn't match!", "Avg. Customer Review", homePage.getSortByText());
    }
    
    @Test
    public void testSearchDropdownMenu() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.selectCategoryFromSearchDropdownMenu();
        
        System.out.println(driver.getCurrentUrl());
        assertEquals("Failure - URL doesn't match!", expectedUrlDropdownMenu, driver.getCurrentUrl());
    }
    
}
