package qa.com;

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
import java.util.concurrent.TimeUnit;

public class MobileTest extends storeMethods {


    // Instance of WebDriver
    public static WebDriver driver;

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

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();

    }

    /**
     * Open Google page, search and quit
     */
    @Test
    public void mobileTest() {
        // Open Magazine

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Test1
        System.out.println("Starting Tes1");
        driver.get("https://supsystic.com/example/comparison-example/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy S6')]/ancestor::div//span[contains(text(),'959')]"))));
        /**
         * getPrice() method uses current xpath , gets text from this xpath , replace "$" symbol in order to parse correctly and returns string which contains price.
         * Please take into consideration that this method location is in the storeMethods class
         *
         * @param xpath current xpath
         */
        String price1 = getPrice("//span[contains(text(),'Samsung Galaxy S6')]/ancestor::div//span[contains(text(),'959')]");
        System.out.println("Current Prise " + price1 + "$");
        String price2 = getPrice("//span[contains(text(),'Samsung Galaxy S6')]/ancestor::div//span[contains(text(),'2699')]");
        System.out.println("The prise that was before " + price2 + "$");
        System.out.println("Feel the difference " + (Double.parseDouble(price2) - Double.parseDouble(price1)) + "$");

        //Test 2
        System.out.println("Starting Tes2");
        openLinkinNewtab("https://unicode-table.com/ru/");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[@data-code='81' and contains(text(),'Q')]"))));

        /**
         * xpathkiller() Method with unique xpath
         * Please take into consideration that this method location is in the storeMethods class
         *
         * @param number unique number
         * @param letter proper letter
         * */
        System.out.println(xpathkiller(81, "Q"));
        System.out.println(xpathkiller(38, "&"));
        System.out.println(xpathkiller(65, "A"));

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