package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GSearchAmazon {
    WebDriver driver;
    String url = "https://www.google.co.in";
    public GSearchAmazon(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToBookMyShow() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public boolean searchLink() throws InterruptedException {
        boolean status = false;
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Amazon"+ Keys.ENTER);
        List<WebElement> searchResults = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        for (WebElement result : searchResults) {
            if (result.getText().equals("Amazon.in")) {
                status = true;
                break;
            }
        }
        System.out.println(status);
        return status;
    }
}
