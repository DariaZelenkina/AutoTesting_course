package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;


/**
 * Created by daria on 25.05.17.
 */
public class ConstraintCaptionContainerPage extends Page{

    private static final String REMOVE_FREE_SHIPPING_FILTER_BTN_XPATH = ".//span[@id=\"smuys\"]" +
            "//span[contains(text(), \"Бесплатная международная доставка\")]/parent::b" +
            "/following-sibling::a";
    private static final String REMOVE_US_ONLY_FILTER_BTN_XPATH = ".//span[@id=\"smuys\"]" +
            "//span[contains(text(), \"US Only\")]/parent::b/following-sibling::a";

    @FindBy(xpath = REMOVE_FREE_SHIPPING_FILTER_BTN_XPATH)
    private WebElement constraintContainerRemoveFreeShippingFilterBtn;

    @FindBy(xpath = REMOVE_US_ONLY_FILTER_BTN_XPATH)
    private WebElement constraintContainerRemoveUSOnlyFilterBtn;

    public ConstraintCaptionContainerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /** check if Free Shipping filter is present
     * in the Constraint Caption Container
     * @return true if the filter is present
     */
    public boolean isFreeShippingConstraintCaptionPresent() {
        if(driver.findElements(By.xpath(REMOVE_FREE_SHIPPING_FILTER_BTN_XPATH)).size() > 0)
            return true;
        else
            return false;
    }

    /** check if US Only filter is present
     * in the Constraint Caption Container
     * @return true if the filter is present
     */
    public boolean isUSOnlyConstraintCaptionPresent() {
        if(driver.findElements(By.xpath(REMOVE_US_ONLY_FILTER_BTN_XPATH)).size() > 0)
            return true;
        else
            return false;
    }

    /** click to remove US Only filter from
     * Constraint Caption container
     */
    public void clickRemoveUSOnlyFilterBtn() {
        constraintContainerRemoveUSOnlyFilterBtn.click();
    }

    /** click to remove Free Shipping filter from
     * Constraint Caption container
     */
    public void clickRemoveFreeShippingFilter() {
        constraintContainerRemoveFreeShippingFilterBtn.click();
    }
}
