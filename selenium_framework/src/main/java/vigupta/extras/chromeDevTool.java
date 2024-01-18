package vigupta.extras;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class chromeDevTool {
    public static void main(String[] args) 
    {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // send command to CDP methods-> CDP (Chrome Dev Tools) Methods will invoke and get access to chrome dev tools.

        // Mobile Emulation

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        devTools.send(Emulation.setDeviceMetricsOverride(412, 915, 55, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        
        driver.findElement(By.cssSelector(".navbar-toggler")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Library")));

        driver.findElement(By.linkText("Library")).click();

        // If custome Selenium code is not available then we can execute CDP methods

       /* driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Map deviceMatrix = new HashMap();
        deviceMatrix.put("width", 412);
        deviceMatrix.put("height", 915);
        deviceMatrix.put("deviceScaleFactor", 55);
        deviceMatrix.put("mobile", true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMatrix);

        

        driver.findElement(By.cssSelector(".navbar-toggler")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Library")));

        driver.findElement(By.linkText("Library")).click();        */ 

    }

}
