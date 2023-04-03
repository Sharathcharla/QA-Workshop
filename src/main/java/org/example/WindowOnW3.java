package org.example;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowOnW3 {
        WebDriver driver;
        String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open";
        public WindowOnW3(WebDriver driver) {
            this.driver =  driver;
        }
        public void navigateToWindowSite() {
            if (!driver.getCurrentUrl().equals(this.url)) {
                driver.get(this.url);
            }
        }
        public void handleWindows(){
            driver.switchTo().frame("iframeResult");
            WebElement tryIt=driver.findElement(By.tagName("button"));
            tryIt.click();

            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals("W3Schools Online Web Tutorials")) {
                    break;
                }
            }
            System.out.println("Title of the new window: " + driver.getTitle());

            // Switch back to the original window
            for (String handle : windowHandles) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals("Tryit Editor v3.7")) {
                    break;
                }
            }

        }
}