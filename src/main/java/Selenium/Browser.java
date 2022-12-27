package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class Browser {
    @Test
    public void createBrowserInstance() throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\ProjectWork\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = driver.getTitle();
        Assert.assertEquals("Google", title);
        String handle = driver.getWindowHandle();
        System.out.println(handle + "handle");
        Thread.sleep(5000);
        Set<String> windowHandles= driver.getWindowHandles();
        Iterator it= windowHandles.iterator();
        System.out.println(" windowHandles.size();"+ windowHandles.size());
       int i = 0;
        while (it.hasNext()) {
            String str = it.next().toString();
            System.out.println("Handle:" + str);
            i++;
        }
//       String alertText= driver.switchTo().alert().getText();
//        System.out.println(alertText+ "alertText");
        // Thread.sleep(5000);
//    JavascriptExecutor js = (JavascriptExecutor)driver;
        //  WebElement element=
        //  driver.findElement(By.xpath("//a[@aria-label='Sign in']")).sendKeys(Keys.ENTER);
//    js.executeScript("arguments[0].click();", element);
//   < System.out.println("clicked on alert");
        //  Assert
//;
        // String text=driver.switchTo().frame(0);
//        Set<String> logset = driver.manage().logs().getAvailableLogTypes();
//        Iterator it = logset.iterator();
//
//        int i = 0;
//        while (it.hasNext()) {
//            String str = it.next().toString();
//            System.out.println("log1:" + str);
//            i++;
//        }
        Actions act=new Actions(driver);
       // act.moveToElement() ;
        driver.quit();
    }


}
