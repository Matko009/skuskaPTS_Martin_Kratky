package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //definovanie chrome driveru, vytvorenie noveho driveru
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            //prejst na vybranu stranku
            driver.get("https://ais2.ukf.sk/ais/start.do");
            Thread.sleep(3000);

            //ak sa nachadzaju cookies, odklikni ich
            List<WebElement> cookies = driver.findElements(By.xpath("xpath/cesta/buttonu/pre/cookie"));
            if (!cookies.isEmpty()){
                WebElement cookie = cookies.get(0);
                cookie.click();
                Thread.sleep(3000);
            }

            //prilasenie
            WebElement login = driver.findElement(By.id("login"));
            login.sendKeys("meno");
            WebElement heslo = driver.findElement(By.id("heslo"));
            heslo.sendKeys("heslo");
            heslo.submit();
            Thread.sleep(3000);

            //najst xpath video a pustit ho na 7 sekund
            WebElement video = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[3]/app-banner/div/div/section/mat-expansion-panel/div/div/iframe"));
            video.click();
            Thread.sleep(7000);
            video.click();
            Thread.sleep(3000);

            //najst xpathy pre odhlsenie
            WebElement odhlasit = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/a/span"));
            odhlasit.click();
            WebElement odhlasit2 = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a/span"));
            odhlasit2.click();
            Thread.sleep(3000);

            //vypnut driver
            driver.quit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}