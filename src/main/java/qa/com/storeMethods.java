package qa.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class storeMethods {


    public String xpathkiller(int number, String letter) {
        return MobileTest.driver.findElement(By.xpath("//li[@data-code='" + number + "' and contains(text(),'" + letter + "')]")).getText();
    }

    public String getPrice(String xpath) {

        return MobileTest.driver.findElement(By.xpath(xpath)).getText().replaceAll(
                "^.*?(-?\\d+(\\.\\d+)?).*$", "$1");
    }

}
