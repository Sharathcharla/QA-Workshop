package org.example;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrames {
    WebDriver driver;
    String url = "http://the-internet.herokuapp.com/nested_frames";

    public NestedFrames(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToFramesSite() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }

    public boolean printFromFrames() throws InterruptedException {
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        boolean status = false;
        System.out.println(frames.size());
        for (WebElement frame : frames) {
            driver.switchTo().frame(frame);
            
            // if the frame has child frames, iterate over each child frame
            List<WebElement> childFrames = driver.findElements(By.tagName("frame"));
            for (WebElement childFrame : childFrames) {
                driver.switchTo().frame(childFrame);
                WebElement frameText = driver.findElement(By.tagName("body"));
                System.out.println("Text in the frame: " + frameText.getText());
                if(frameText.getText().equals("LEFT")||frameText.getText().equals("MIDDLE")||frameText.getText().equals("RIGHT"))
                    status=true;
                driver.switchTo().parentFrame();
            }

            WebElement frameText = driver.findElement(By.tagName("body"));
            System.out.println("Text in the frame: " + frameText.getText());
            if(frameText.getText().equalsIgnoreCase("bottom"))
                status = true;
            
            driver.switchTo().parentFrame();

    }
        return status;
}
}