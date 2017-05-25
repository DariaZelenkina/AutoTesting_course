package com.example;

import com.example.pages.HomePage;
import com.example.pages.SearchFormPage;
import com.example.pages.SerpPage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import static com.example.pages.SerpPage.isCountryUS;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by daria on 25.05.17.
 */
public class FiltersTest extends TestNgTestBase {

    private static final String REQUEST = "phone case";
    private HomePage homePage;
    private SearchFormPage searchFormPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void initPageObjects() {
         homePage = new HomePage(driver, baseUrl);
         searchFormPage = new SearchFormPage(driver);
    }

    @Test
    public void testBuyNowTabFilter() {
        /** applying Buy Now tab filter
         * expected result: no Time Left field in the snippets
         */
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyBuyNowTabFilter();
        List<WebElement> snippets = serpPage.getSnippets();
        for(WebElement snippet : snippets) {
            assertFalse(serpPage.isTimeLeftFieldPresent(snippet));
        }
    }

    @Test
    public void testBuyNowRbtnFilter() {
        /** applying Buy Now radiobutton
         * Expected result: no Time Left field in the snippets
         */
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyBuyNowRbtnFilter();
        List<WebElement> snippets = serpPage.getSnippets();
        for(WebElement snippet : snippets) {
            assertFalse(serpPage.isTimeLeftFieldPresent(snippet));
        }
    }

    @Test
    public void testFreeShippingFilter() {
        /** applying Free Shipping filter
         * Expected result: Free Shipping text field is present
         * in the snippets
         */
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyFreeShippingFilter();
        List<WebElement> snippets = serpPage.getSnippets();
        for(WebElement snippet : snippets) {
            assertTrue(serpPage.isFreeShippingFieldPresent(snippet));
        }
    }

    @Test
    public void testUSOnlyLocationFilter() {
        /** applying US Only filter
         * Expected result: Country text field in the
         * snippets is "CША"
         */
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyLocationUSOnlyFilter();
        List<WebElement> snippets = serpPage.getSnippets();
        for(WebElement snippet : snippets) {
            assertTrue(serpPage.isCountryUS(snippet));
        }
    }

    @Test
    public void testMultipleFilters() {
        /** applying Free Shipping and US only filters together
         * Expected result: Country text field in the
         * snippets is "CША", Free Shipping text field is present
         * in the snippets
         */
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyFreeShippingFilter()
                .applyLocationUSOnlyFilter();

        List<WebElement> snippets = serpPage.getSnippets();
        for(WebElement snippet : snippets) {
            assertTrue(serpPage.isFreeShippingFieldPresent(snippet)
                    && serpPage.isCountryUS(snippet));
        }
    }

    @Test
    public void testConstraintCaptionIsPresent() {
        /** apply Free Shipping filter,
         * check if relevant constraint caption appeared
         * Expected result: caption is present
         */
        homePage.open();
        assertTrue(searchFormPage.searchFor(REQUEST).applyFreeShippingFilter().isFreeShippingCaptionPresent());

    }

    @Test
    public void testConstraintCaptionNotPresentWhenFilterRemoved() {
        /** apply Free Shipping and US Only filters,
         * check if relevant constraint captions appeared,
         * Expected result: Free Shipping and US Only captions are present
         * deselect Free Shipping checkbox,
         * check if relevant caption was removed
         * Expected result: Free Shipping caption is not present
         */
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyFreeShippingFilter().applyLocationUSOnlyFilter();
        softAssert.assertTrue(serpPage.isFreeShippingCaptionPresent());
        softAssert.assertTrue(serpPage.isUSOnlyCaptionPresent());
        serpPage.applyFreeShippingFilter();
        softAssert.assertFalse(serpPage.isFreeShippingCaptionPresent());
        softAssert.assertAll();
    }

}
