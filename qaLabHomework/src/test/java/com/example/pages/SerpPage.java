package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by daria on 24.05.17.
 */
public class SerpPage extends Page {


    private static final String ITEM_COUNTRY_FIELD_XPATH = "//li[contains(text(), \"Страна\")]";
    private static final String ITEM_FREE_SHIPPING_FIELD_XPATH = "//span[contains(text(), \"Бесплатная международная доставка\")]";
    private static final String ITEM_TIME_LEFT_FIELD_XPATH = "//li[@class=\"timeleft\"]";
    private static final String SNIPPETS_XPATH = ".//*[@id=\"ListViewInner\"]";

    @FindBy(xpath = SNIPPETS_XPATH)
    private List<WebElement> snippets;

    FilterSerpFormPage filterSerpForm = PageFactory.initElements(driver, FilterSerpFormPage.class);
    ConstraintCaptionContainerPage constraintCaptionContainer = PageFactory.initElements(driver, ConstraintCaptionContainerPage.class);


    public SerpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public List<WebElement> getSnippets() {
        /** get all snippets from serp */
        return snippets;
    }

    public SerpPage applyBuyNowRbtnFilter() {
        /** apply Buy Now filter by radiobutton */
        filterSerpForm.clickBuyNowRbtnFilter();
        return new SerpPage(driver);
    }

    public SerpPage applyBuyNowTabFilter() {
        /** apply Buy Now filter by tab */

        filterSerpForm.clickBuyNowTabFilter();
        return new SerpPage(driver);
    }

    public SerpPage applyLocationUSOnlyFilter() {
        /** apply US Only location filter */
        filterSerpForm.clickLocationUSOnlyFilter();
        return new SerpPage(driver);
    }

    public SerpPage applyFreeShippingFilter() {
        /** apply Free Shipping filter */
        filterSerpForm.clickFreeShippingFilterCheckBox();
        return new SerpPage(driver);
    }

    public static boolean isCountryUS(WebElement element) {
        /** check if location of the item is the US */
        try {
            element.findElement(By.xpath(ITEM_COUNTRY_FIELD_XPATH));
            if(element.getText().contains("США"))
                return true;
            else
                return false;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isFreeShippingFieldPresent(WebElement element) {
        /** check if Free Shipping field is present in the snippet */
        if(element.findElements(By.xpath(ITEM_FREE_SHIPPING_FIELD_XPATH)).size() > 0)
            return true;
        else
            return false;
    }

    public boolean isTimeLeftFieldPresent(WebElement element) {
        /** check if Time Left field present in the snippet */
        if(element.findElements(By.xpath(ITEM_TIME_LEFT_FIELD_XPATH)).size() > 0)
            return true;
        else
            return false;

    }

    public boolean isFreeShippingCaptionPresent() {
        /** check if Free Shipping constraint caption is
         * present in container
         */
        return constraintCaptionContainer.isFreeShippingConstraintCaptionPresent();
    }

    public boolean isUSOnlyCaptionPresent() {
        /** check if US Only constraint caption is
         * present in container
         */
        return constraintCaptionContainer.isUSOnlyConstraintCaptionPresent();
    }

    public SerpPage removeUSOnlyFilterFromConstraintContainer() {
        /** remove US Only filter from
         * constraint caption container
         */
        constraintCaptionContainer.clickRemoveUSOnlyFilterBtn();
        return new SerpPage(driver);
    }

    public SerpPage removeFreeShippingFilterFromConstraintContainer() {
        /** remove Free Shipping filter from
         * constraint caption container
         */
        constraintCaptionContainer.clickRemoveFreeShippingFilter();
        return new SerpPage(driver);
    }
}
