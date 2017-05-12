package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by daria on 10.05.17.
 */
public class ItemTitleContainsSnippetTitleTest extends TestNgTestBase{

    private static final String SEARCH_QUERY = "phone case";
    private static final String ID_SEARCH = "gh-ac";
    private static final String ID_SEARCH_BUTTON = "gh-btn";
    private static final String XPATH_BUY_NOW_TAB = "//a[@title=\"Купить сейчас\"]";
    private static final String XPATH_SEARCH_ITEM_TITLE = "//*[@id=\"Results\"]//h3/a";
    private static final String ID_ITEM_TITLE = "itemTitle";


    @Test
    public void testSearchItemTitle() {
        driver.get(baseUrl);
        WebElement gh = driver.findElement(By.id(ID_SEARCH));
        gh.clear();
        gh.sendKeys(SEARCH_QUERY);

        WebElement searchButton = driver.findElement(By.id(ID_SEARCH_BUTTON));
        searchButton.click();

        WebElement buyNowTab = driver.findElement(By.xpath(XPATH_BUY_NOW_TAB));
        buyNowTab.click();

        List<WebElement> searchResults = driver.findElements(By.xpath(XPATH_SEARCH_ITEM_TITLE));
        Map<String, String> resultsTitlesAndURLs = new HashMap<String, String>(searchResults.size());

        for (WebElement result : searchResults) {

            resultsTitlesAndURLs.put(result.getText().replace("...", ""), result.getAttribute("href"));

        }

        for (Map.Entry<String, String> entry : resultsTitlesAndURLs.entrySet()) {

            driver.get(entry.getValue());
            String itemTitle = driver.findElement(By.id(ID_ITEM_TITLE)).getText();

            assertTrue(itemTitle.contains(entry.getKey()));

        }

    }

}
