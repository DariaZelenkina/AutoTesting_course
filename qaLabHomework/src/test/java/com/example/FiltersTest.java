package com.example;

import com.example.pages.HomePage;
import com.example.pages.SearchFormPage;
import com.example.pages.SerpPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    /** initialize Home Page and Search Form before Test */

    @BeforeMethod
    public void initPageObjects() {
         homePage = new HomePage(driver, baseUrl);
         searchFormPage = new SearchFormPage(driver);
    }

    /** applying Buy Now tab filter
     * expected result: no "Time Left" field in the snippets
     */
    @Test
    public void testBuyNowTabFilter() {
        homePage.open();
        assertFalse(searchFormPage.searchFor(REQUEST).applyBuyNowTabFilter().isTimeLeftFieldPresent());
    }

    /** applying Buy Now radiobutton
     * Expected result: no "Time Left" field in the snippets
     */
    @Test
    public void testBuyNowRbtnFilter() {
        homePage.open();
        assertFalse(searchFormPage.searchFor(REQUEST).applyBuyNowRbtnFilter().isTimeLeftFieldPresent());
    }

    /** applying Free Shipping filter
     * Expected result: "Free Shipping" text field is present
     * in the snippets
     */
    @Test
    public void testFreeShippingFilter() {
        homePage.open();
        assertTrue(searchFormPage.searchFor(REQUEST).applyFreeShippingFilter().isFreeShippingFieldPresent());
    }

    /** applying US Only filter
     * Expected result: "Country" text field in the
     * snippets is "CША"
     */
    @Test
    public void testUSOnlyLocationFilter() {
        homePage.open();
        assertTrue(searchFormPage.searchFor(REQUEST).applyLocationUSOnlyFilter().isCountryUSOnly());
    }

    /** applying Free Shipping and US only filters together
     * Expected result: "Country" text field in the
     * snippets is "CША", "Free Shipping" text field is present
     * in the snippets
     */
    @Test
    public void testMultipleFilters() {
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyFreeShippingFilter()
                .applyLocationUSOnlyFilter();
        assertTrue(serpPage.isFreeShippingFieldPresent()
                    && serpPage.isCountryUSOnly());
    }

    /** apply Free Shipping filter,
     * check if relevant constraint caption appeared
     * Expected result: caption is present
     */
    @Test
    public void testConstraintCaptionIsPresent() {
        homePage.open();
        assertTrue(searchFormPage.searchFor(REQUEST).applyFreeShippingFilter().isFreeShippingCaptionPresent());
    }

    /** apply Free Shipping and US Only filters,
     * check if relevant constraint captions appeared,
     * Expected result: "Free Shipping" and "US Only" captions are present
     * deselect "Free Shipping" checkbox,
     * check if relevant caption was removed
     * Expected result: "Free Shipping" caption is not present
     */
    @Test
    public void testConstraintCaptionNotPresentWhenFilterRemoved() {
        homePage.open();
        SerpPage serpPage = searchFormPage.searchFor(REQUEST).applyFreeShippingFilter().applyLocationUSOnlyFilter();
        softAssert.assertTrue(serpPage.isFreeShippingCaptionPresent());
        softAssert.assertTrue(serpPage.isUSOnlyCaptionPresent());
        serpPage.applyFreeShippingFilter();
        softAssert.assertFalse(serpPage.isFreeShippingCaptionPresent());
        softAssert.assertAll();
    }
}
