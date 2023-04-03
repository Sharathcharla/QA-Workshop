package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BMS {
    WebDriver driver;
    String url = "https://in.bookmyshow.com/explore/home/hyderabad";
    public BMS(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToBookMyShow() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public int countOfLinks()throws InterruptedException{
        List<WebElement> anchorTags = driver.findElements(By.tagName("a"));
        int countOfAnchorTags = anchorTags.size();
        System.out.println("The Links in URL are: "+countOfAnchorTags);
        return countOfAnchorTags;
    }
}
