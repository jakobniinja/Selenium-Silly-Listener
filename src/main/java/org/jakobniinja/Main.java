package org.jakobniinja;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    private static final String URL = "https://www.blueclub.se/2193241/13689448";
    private static final String PLAY_BUTTON = "//button[@title='Play']";
    private static final int LISTEN_TIME = 22_000;
    private static final int AWAIT_PAGE_LOAD_TIME = 4_000;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dansa\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Pass chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");
        options.addArguments("--log-level=3");
        options.addArguments("--disable-logging");
        options.addArguments("--mute-audio");

        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to(URL);
        Thread.sleep(AWAIT_PAGE_LOAD_TIME);

        // Click on the Search button
        driver.findElement(By.xpath(PLAY_BUTTON)).click();

        // Wait for episodes to finish
        Thread.sleep(LISTEN_TIME);

        driver.quit();
        System.exit(0);
    }
}