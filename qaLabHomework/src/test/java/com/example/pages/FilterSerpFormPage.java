package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by daria on 25.05.17.
 */
public class FilterSerpFormPage extends Page {

    private static final String BUY_NOW_RBTN_XPATH = ".//*[@class=\"pnl\"]//a/span[contains(text(), \"Купить сейчас\")]";
    private static final String BUY_NOW_TAB_XPATH = ".//*[@id=\"cbelm\"]//a[@title=\"Купить сейчас\"]";
    private static final String US_ONLY_RBTN_XPATH = ".//*[@class=\"rbx\"]//span[contains(text(), \"США\")]";
    private static final String FREE_SHIPPING_CBX_XPATH = ".//*[@class=\"pnl\"]//a/span[contains(text(), " +
            "\"Бесплатная международная доставка\")]";

    @FindBy(xpath = BUY_NOW_RBTN_XPATH)
    private WebElement buyingFormatsBuyNowRbtn;

    @FindBy(xpath = BUY_NOW_TAB_XPATH)
    private WebElement buyingFormatsBuyNowTab;

    @FindBy(xpath = US_ONLY_RBTN_XPATH)
    private WebElement prefLocationUSOnly;

    @FindBy(xpath = FREE_SHIPPING_CBX_XPATH)
    private WebElement deliveryOptionsFreeShipping;

    public FilterSerpFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    /** click "Buy Now" radiobutton */

    public void clickBuyNowRbtnFilter() {
        buyingFormatsBuyNowRbtn.click();
    }

    /** click "Buy Now" tab */

    public void clickBuyNowTabFilter() {
        buyingFormatsBuyNowTab.click();
    }

    /** click "US only" location filter */

    public void clickLocationUSOnlyFilter() {

        prefLocationUSOnly.click();
    }

    /** click "Free Shipping" filter */

    public void clickFreeShippingFilterCheckBox() {
        deliveryOptionsFreeShipping.click();
    }
}
