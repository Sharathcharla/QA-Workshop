package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;


public class IRCTC {
    WebDriver driver;
    String url = "https://www.irctc.co.in/nget/train-search";
    public IRCTC(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToIRCTC() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public String getFirstStation() throws InterruptedException {
        WebElement fromStation = driver.findElement(By.id("origin"));
        fromStation.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(fromStation, "YE").build().perform();
        List<WebElement> fromStationOptions = driver.findElements(By.xpath("//*[@id=\"pr_id_1_list\"]/li"));
        WebElement firstOption = fromStationOptions.get(1);
        firstOption.click();
        return firstOption.getText();
    }

}
