package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CountFrames {
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/nested_frames";
    public CountFrames(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToFramesSite() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public int countOfFrames() {
        List<WebElement> frameTags = driver.findElements(By.tagName("frame"));
        int countOfFrameTags = frameTags.size();
        System.out.println("The Frames in URL are: "+ countOfFrameTags);
        return countOfFrameTags;
    }
}
