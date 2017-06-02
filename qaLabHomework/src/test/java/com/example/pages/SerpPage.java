package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by daria on 24.05.17.
 */
public class SerpPage extends Page {


    private static final String ITEM_COUNTRY_FIELD_XPATH = "//li[contains(text(), \"Страна\")]";
    private static final String ITEM_FREE_SHIPPING_FIELD_XPATH = "//*[@id=\"Results\"]//span[contains(text()," +
            " \"Бесплатная международная доставка\")]";
    private static final String ITEM_TIME_LEFT_FIELD_XPATH = "//li[@class=\"timeleft\"]";
    private static final String SNIPPETS_XPATH = ".//*[@id=\"ListViewInner\"]/li";

    @FindAll(@FindBy(xpath = SNIPPETS_XPATH))
    private List<WebElement> snippets;

    @FindBy(xpath = ITEM_COUNTRY_FIELD_XPATH)
    private List<WebElement> countryFields;

    @FindBy(xpath = ITEM_TIME_LEFT_FIELD_XPATH)
    private List<WebElement> timeLeftFields;

    @FindBy(xpath = ITEM_FREE_SHIPPING_FIELD_XPATH)
    private List<WebElement> freeShippingFields;

    FilterSerpFormPage filterSerpForm = new FilterSerpFormPage(driver);
    ConstraintCaptionContainerPage constraintCaptionContainer = new ConstraintCaptionContainerPage(driver);


    public SerpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** get all snippets from serp
     * @return list of snippets */

    public List<WebElement> getSnippets() {
        return snippets;
    }

    /** apply Buy Now filter by radiobutton
     * @return new SerpPage object */

    public SerpPage applyBuyNowRbtnFilter() {
        filterSerpForm.clickBuyNowRbtnFilter();
        return new SerpPage(driver);
    }

    /** apply Buy Now filter by tab
     * @return new SerpPage object */

    public SerpPage applyBuyNowTabFilter() {
        filterSerpForm.clickBuyNowTabFilter();
        return new SerpPage(driver);
    }

    /** apply US Only location filter
     * @return new SerpPage object */

    public SerpPage applyLocationUSOnlyFilter() {
        filterSerpForm.clickLocationUSOnlyFilter();
        return new SerpPage(driver);
    }

    /** apply Free Shipping filter
     * @return new SerpPage oject */

    public SerpPage applyFreeShippingFilter() {
        filterSerpForm.clickFreeShippingFilterCheckBox();
        return new SerpPage(driver);
    }

    /** check if location of the items is the US
     * @return true if all snippets have location US */

    public boolean isCountryUSOnly() {
        for (WebElement countryField : countryFields) {
            if(!countryField.getText().contains("США"))
                return false;
        }
        return true;
    }

    /** check if Free Shipping field is present in the snippets
     * @return true if all snippets have "Free Shipping" field */

    public boolean isFreeShippingFieldPresent() {
        if(freeShippingFields.size() == snippets.size())
            return true;
        else
            return false;
    }

    /** check if Time Left field present in the snippets
     * @return true if at least one snippet has "Time Left" field */

    public boolean isTimeLeftFieldPresent() {
        if(timeLeftFields.size() > 0)
            return true;
        else
            return false;

    }

    /** check if Free Shipping constraint caption is
     * present in container
     * @return true if the caption is present
     */
    public boolean isFreeShippingCaptionPresent() {
        return constraintCaptionContainer.isFreeShippingConstraintCaptionPresent();
    }

    /** check if US Only constraint caption is
     * present in container
     * @return true if the caption is present
     */
    public boolean isUSOnlyCaptionPresent() {
        return constraintCaptionContainer.isUSOnlyConstraintCaptionPresent();
    }

    /** remove US Only filter from
     * constraint caption container
     * @return new SerpPage object
     */
    public SerpPage removeUSOnlyFilterFromConstraintContainer() {
        constraintCaptionContainer.clickRemoveUSOnlyFilterBtn();
        return new SerpPage(driver);
    }

    /** remove Free Shipping filter from
     * constraint caption container
     * @return new SerpPage object
     */
    public SerpPage removeFreeShippingFilterFromConstraintContainer() {
        constraintCaptionContainer.clickRemoveFreeShippingFilter();
        return new SerpPage(driver);
    }
}
