package qa.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class storeMethods {


    public String xpathkiller(int number, String letter) {
        return MobileTest.driver.findElement(By.xpath("//li[@data-code='" + number + "' and contains(text(),'" + letter + "')]")).getText();
    }

    public String getPrice(String xpath) {

        return MobileTest.driver.findElement(By.xpath(xpath)).getText().replaceAll(
                "^.*?(-?\\d+(\\.\\d+)?).*$", "$1");
    }

    public void openLinkinNewtab (String link){
    ((JavascriptExecutor)MobileTest.driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<String>(MobileTest.driver.getWindowHandles());
    MobileTest.driver.switchTo().window(tabs.get(1));
    MobileTest.driver.get(link);
    }

}
