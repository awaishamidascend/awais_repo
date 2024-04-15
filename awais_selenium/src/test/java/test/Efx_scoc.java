package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Efx_scoc {

    public static void main(String[] args) {
        System.out.println("Starting the WebDriver setup...");
        WebDriverManager.chromedriver().setup();
        System.out.println("WebDriver setup complete. Launching ChromeDriver...");

        WebDriver driver = new ChromeDriver();
        System.out.println("ChromeDriver launched successfully.");

        driver.manage().window().maximize(); // Maximizing the browser window

        System.out.println("Setting up timeouts...");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("Timeouts set.");

        System.out.println("Navigating to the login page...");
        driver.get("https://efficax-ssr.kakashi.app/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Waiting for email input element...");
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Email']")));
        System.out.println("Email input element found. Entering email...");

        emailInput.sendKeys("awais.hamid@ascend.com.sa");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Waiting for password input element...");
        WebElement passwordInput = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
        System.out.println("Password input element found. Entering password...");

        passwordInput.sendKeys("eod777");

        System.out.println("Clicking the login button...");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Waiting for indicator element...");
        WebElement indicatorElement = driver.findElement(By.cssSelector(".select__indicator.select__dropdown-indicator.css-tlfecz-indicatorContainer"));
        System.out.println("Indicator element found. Clicking on the indicator...");

        indicatorElement.click();

        System.out.println("Script execution completed.");
    }
}
