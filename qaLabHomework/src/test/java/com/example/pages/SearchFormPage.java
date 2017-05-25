package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by daria on 25.05.17.
 */
public class SearchFormPage extends Page {

    private static final String REQUEST_INPUT_XPATH = ".//*[@id='gh-ac']";
    private static final String SEARCH_BUTTON_XPATH = ".//*[@id='gh-btn']";

    @FindBy(xpath = REQUEST_INPUT_XPATH)
    @CacheLookup
    private WebElement requestInput;

    @FindBy(xpath = SEARCH_BUTTON_XPATH)
    @CacheLookup
    private WebElement searchButton;


    public SearchFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SerpPage searchFor (String request) {
        /** search for given request */
        requestInput.clear();
        requestInput.sendKeys(request);
        searchButton.click();
        return new SerpPage(driver);
    }

}
