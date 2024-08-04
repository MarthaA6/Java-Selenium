package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is a test run");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

      WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
      WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
      WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

      usernameField.sendKeys("Admin");
      passwordField.sendKeys("admin123");
      loginButton.click();

      Thread.sleep(15000);

      if(driver.getTitle().equals("Log in OrangeHrmLive")) {
          System.out.println("Test has passed");
      }else {
          System.out.println("Test has failed");
      }

      driver.quit();

    }

}
