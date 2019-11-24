package com.qa.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Collections;


public class MobileTest {


    // Instance of WebDriver
    public static WebDriver driver;
    public static WebDriverWait wait ;

    /**
     * Set up method
     */
    @Before
    public void setUp() {

        // If you want to disable infobars please use this code

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);
        // Maximize window
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Open Google page, search and quit
     */
    @Test
    public void mobileTest() {
        //Test1
        System.out.println("Starting Tes1");
        // Open Magazine
        driver.get("https://supsystic.com/example/comparison-example/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'ptsCol-2')]//span[contains(@style,'#90c820')]"))));
        String price1 = getPrice("//div[contains(@class,'ptsCol-2')]//span[contains(@style,'#90c820')]");
        System.out.println("Current Prise " + price1 + "$");
        String price2 = getPrice("//div[contains(@class,'ptsCol-2')]//span[contains(@style,'#9d9d9d')]");
        System.out.println("The prise that was before " + price2 + "$");
        System.out.println("Feel the difference " + (Double.parseDouble(price2) - Double.parseDouble(price1)) + "$");
    }

    @Test
    public void letterTest() {
        //Test 2
        System.out.println("Starting Tes2");
        driver.get("https://unicode-table.com/ru/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@data-code='81' and contains(text(),'Q')]"))));

        System.out.println(xpathkiller(81, "Q"));
        System.out.println(xpathkiller(38, "&"));
        System.out.println(xpathkiller(65, "A"));
    }

    /**
     * xpathkiller() Method with unique xpath
     * Please take into consideration that this method location is in the storeMethods class
     *
     * @param number unique number
     * @param letter proper letter
     */

    public String xpathkiller(int number, String letter) {
        return driver.findElement(By.xpath("//li[@data-code='" + number + "' and contains(text(),'" + letter + "')]")).getText();
    }

    /**
     * getPrice() method uses current xpath , gets text from this xpath , replace "$" symbol in order to parse correctly and returns string which contains price.
     * Please take into consideration that this method location is in the storeMethods class
     *
     * @param xpath current xpath
     */
    public String getPrice(String xpath) {

        return driver.findElement(By.xpath(xpath)).getText().replaceAll(
                "^.*?(-?\\d+(\\.\\d+)?).*$", "$1");
    }

    /**
     * After method, quit driver
     */

    @After

    public void tearDown() {

        // Quit from Driver. close() just close window,
        // quit() - close all window an driver
        driver.quit();
    }


}