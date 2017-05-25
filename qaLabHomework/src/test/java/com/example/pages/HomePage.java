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
    public void open() {
        /** open home page */

        driver.get(url);
  }
}
