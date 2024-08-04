package Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.Executor;

import BaseClass.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingPopUpsAndTabs {

    public static void handlingAlerts() {
      TestBase testBase = new TestBase();

      testBase.setup();

      testBase.navigateToURL("https://demoqa.com/alerts");

        JavascriptExecutor jsExecutor = ((JavascriptExecutor) testBase.driver);

      jsExecutor.executeScript("arguments[0].scrollIntoView(true);", testBase.driver.findElement(By.id("alertButton")));

      testBase.sleep(5);

      jsExecutor.executeScript("arguments[0].click();", testBase.driver.findElement(By.id("alertButton")));

        testBase.sleep(5);


        //testBase.driver.findElement(By.id("alertButton")).click();

      Alert alert = testBase.driver.switchTo().alert();
      alert.dismiss();

      jsExecutor.executeScript("arguments[0].click();", testBase.driver.findElement(By.id("alertButton")));

      WebDriverWait wait = new WebDriverWait(testBase.driver, Duration.ofSeconds(7));

      wait.until(ExpectedConditions.alertIsPresent());

      Alert alert1 = testBase.driver.switchTo().alert();

      alert1.dismiss();

    }

    public static int addition(int a, int b) {
        return a + b;
    }

}
