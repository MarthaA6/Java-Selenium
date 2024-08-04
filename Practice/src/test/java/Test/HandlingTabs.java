package Test;

import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;


public class HandlingTabs {

    public static void main(String[] args) {
        handlingMultipleTabs();
    }

    public static void handlingMultipleTabs() {
        TestBase testBase = new TestBase();

        testBase.setup();
        testBase.navigateToURL("https://dempqa.com/browser-windows");

        JavascriptExecutor jsExecutor = ((JavascriptExecutor) testBase.driver);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", testBase.driver.findElement(By.id("tabButton")));

         testBase.driver.findElement(By.id("tabButton")).click();

        testBase.sleep(5);

        String currentTab = testBase.driver.getWindowHandle();

        System.out.println("The tab handle/id is " + currentTab);

        Set<String> allTabs = testBase.driver.getWindowHandles();

        for(String tab: allTabs) {
            if(!currentTab.equals(tab)){
                testBase.driver.switchTo().window(tab);
            }
        }

        testBase.sleep(5);

        System.out.println("The number of opened tab is " + allTabs.size());

        WebElement sampleText = testBase.driver.findElement(By.id("sampleHeading"));

        Assert.assertEquals(sampleText.getText(), "This is a sample page", "The driver is not the same");

        testBase.tearDown();




    }

}
