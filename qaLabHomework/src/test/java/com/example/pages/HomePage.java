package com.example.pages;

import org.openqa.selenium.WebDriver;

/**
 * Home page
 */
public class HomePage extends Page {

    private String url;

    public HomePage(WebDriver webDriver, String url) {
        super(webDriver);
        this.url = url;
  }
    /** open home page */
    public void open() {
        driver.get(url);
  }
}
