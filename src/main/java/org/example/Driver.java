package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().timeout(10).setup();
        return new ChromeDriver(chromeOptions);
    }

    public static boolean bookMyShow(WebDriver driver) throws InterruptedException {
        boolean status;
        BMS loadPage = new BMS(driver);
        loadPage.navigateToBookMyShow();
        status = loadPage.countOfLinks() >= 300;
        return status;
    }
    public static boolean gSearchAmazon(WebDriver driver) throws InterruptedException {
        boolean status;
        GSearchAmazon loadPage = new GSearchAmazon(driver);
        loadPage.navigateToBookMyShow();
        status = loadPage.searchLink();
        return status;
    }
    public static boolean getFirstStationfromIRCTC(WebDriver driver) throws InterruptedException {
        boolean status;
        IRCTC loadPage = new IRCTC(driver);
        loadPage.navigateToIRCTC();
        status = loadPage.getFirstStation().contains("YESVANTPUR");
        return status;
    }
    public static boolean getNumberOfFrames(WebDriver driver) {
        boolean status;
        CountFrames loadPage = new CountFrames(driver);
        loadPage.navigateToFramesSite();
        status = loadPage.countOfFrames()>=2;
        return status;
    }
    public static boolean getTextFromFrames(WebDriver driver) throws InterruptedException {
        boolean status;
        NestedFrames loadPage = new NestedFrames(driver);
        loadPage.navigateToFramesSite();
        status = loadPage.printFromFrames();
        return status;
    }
    public static void performLinkedIN(WebDriver driver) {
        LinkedIn loadPage = new LinkedIn(driver);
        loadPage.navigateToLinkedIn();
        loadPage.postOnLinkedIn();
    }
    public static void getIMDB(WebDriver driver) throws InterruptedException {
        IMDBTop loadPage = new IMDBTop(driver);
        loadPage.navigateToIMDBsSite();
        loadPage.PrintTopRatedMovies();
    }
    public static void handleAlert(WebDriver driver) {
        AlertOnW3 loadPage = new AlertOnW3(driver);
        loadPage.navigateToAlertSite();
        loadPage.handleAlerts();
    }
    public static void handleWindow(WebDriver driver) {
        WindowOnW3 loadPage = new WindowOnW3(driver);
        loadPage.navigateToWindowSite();
        loadPage.handleWindows();
    }



    public static void main(String[] args) throws InterruptedException {
        int totalTests = 0;
        int passedTests = 0;
        boolean status;
        WebDriver driver = createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            totalTests += 1;
            status = bookMyShow(driver);
            if (status) {
                passedTests += 1;
            }
            System.out.println("\n");

            totalTests += 1;
            status = gSearchAmazon(driver);
            if (status) {
                passedTests += 1;
            }
            System.out.println("\n");
            totalTests += 1;
            status = getFirstStationfromIRCTC(driver);
            if (status) {
                passedTests += 1;
            }
            System.out.println("\n");

            totalTests += 1;
            status = getNumberOfFrames(driver);
            if (status) {
            passedTests += 1;
            }
            System.out.println("\n");
            totalTests += 1;
            status = getTextFromFrames(driver);
            if (status) {
                passedTests += 1;
            }
            System.out.println("\n");

            totalTests += 1;
            getIMDB(driver);
            passedTests += 1;
            totalTests += 1;
            performLinkedIN(driver);
            passedTests+=1;
            handleWindow(driver);
            totalTests +=1;
            handleAlert(driver);
            passedTests+=1;

    } finally {
            driver.quit();

            System.out.printf("%s out of %s test cases Passed ", passedTests,
                    totalTests);
        }
    }
}