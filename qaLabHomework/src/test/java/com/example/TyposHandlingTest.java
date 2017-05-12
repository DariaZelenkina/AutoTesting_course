package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by daria on 09.05.17.
 */
public class TyposHandlingTest extends TestNgTestBase {

    private static final String ID_SEARCH = "gh-ac";
    private static final String ID_SEARCH_BUTTON = "gh-btn";
    private static final String XPATH_SEARCH_ITEM_TITLE = "//*[@id=\"Results\"]//h3/a";


    @DataProvider(name = "dataProvider")
    public Object[][] createTestData() {
        return new Object[][] {
                {"iphoen", "iphone"},
                {"чхол", "чехол"},
                {"rollex", "rolex"}
        };
    }

    @Test (dataProvider = "dataProvider")
    public void checkTypoHandling(String typoRequest, String correctRequest) {

        driver.get(baseUrl);
        WebElement gh = driver.findElement(By.id(ID_SEARCH));
        gh.clear();
        gh.sendKeys(typoRequest);

        WebElement searchButton = driver.findElement(By.id(ID_SEARCH_BUTTON));
        searchButton.click();

        List<WebElement> searchItemTitles;
        searchItemTitles = driver.findElements(By.xpath(XPATH_SEARCH_ITEM_TITLE));

        for (WebElement title : searchItemTitles) {

            Boolean checkIfContains = title.getAttribute("title").toLowerCase()
                    .contains(correctRequest.toLowerCase());

            assertTrue(checkIfContains);
        }

    }

}
