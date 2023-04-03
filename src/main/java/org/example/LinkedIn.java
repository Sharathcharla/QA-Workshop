package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedIn {
    WebDriver driver;
    String url = "https://www.linkedin.com/home";
    public LinkedIn(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToLinkedIn() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public void postOnLinkedIn(){
        /*
        Login Code has to be written in
                        these lines
                        */
        WebElement postTextArea = driver.findElement(By.xpath("//div[@class=\"ql-editor ql-blank\"]"));
        postTextArea.sendKeys("Here's my new post!");
        WebElement privacyDropdown = driver.findElement(By.xpath("//button[@aria-label='Post visibility options. Current setting: Anyone.']"));
        privacyDropdown.click();
        WebElement connectionsOption = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']"));
        connectionsOption.click();
        WebElement saveButton = driver.findElement(By.xpath("//button[@id='ember449']"));
        saveButton.click();
        WebElement picture = driver.findElement(By.xpath("//button[@aria-describedby='artdeco-hoverable-artdeco-gen-64']"));
        picture.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);", picture, "C:\\Users\\username\\Documents\\sample.jpg");
        WebElement done = driver.findElement(By.xpath("//button[@id='ember533']"));
        done.click();
        WebElement postButton = driver.findElement(By.xpath("//button[@id='ember479']"));
        postButton.click();
    }
}