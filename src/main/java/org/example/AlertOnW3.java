package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;


public class AlertOnW3 {
    WebDriver driver;
    String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert";
    public AlertOnW3(WebDriver driver) {
        this.driver =  driver;
    }
    public void navigateToAlertSite() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
    public void handleAlerts(){
        driver.switchTo().frame("iframeResult");
        WebElement tryIt=driver.findElement(By.tagName("button"));
        tryIt.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

    }
}
