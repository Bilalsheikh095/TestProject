import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by VD on 28/12/2017.
 */
public class firstclass {

    @Test
    public void myfirstclass () {


        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe" );
        ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.navigate().to("http://www.practiceselenium.com/practice-form.html");


        driver.findElement(By.name("firstname")).sendKeys("test");
        driver.findElement(By.name("lastname")).sendKeys("user");

        if ( !driver.findElement(By.id("sex-1")).isSelected() )
        {
            driver.findElement(By.id("sex-1")).click();
        }

        driver.findElement(By.id("exp-5")).click();
        driver.findElement(By.id("datepicker")).sendKeys("NA");

        if ( !driver.findElement(By.id("tea3")).isSelected() )
        {
            driver.findElement(By.id("tea3")).click();
        }

        if ( !driver.findElement(By.id("tool-0")).isSelected() )
        {
            driver.findElement(By.id("tool-0")).click();
        }

        Select dropdown= new Select(driver.findElement(By.id("continents")));
        dropdown.selectByVisibleText("Asia");

        Select dropdown1= new Select(driver.findElement(By.id("selenium_commands")));
        dropdown1.selectByVisibleText("Switch Commands");

        driver.findElement(By.id("submit")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://www.practiceselenium.com/welcome.html?firstname=test&lastname=user&sex=Female&exp=6&oolongtea=oolong+tea&tool=Break&continents=Asia&selenium_commands=Switch+Commands&submit=" );

        Boolean isPresent= driver.findElement(By.linkText("seleniumframework.com")).isDisplayed();
        Assert.assertTrue("Link not present" , isPresent);

        driver.findElement(By.linkText("Menu")).click();
        driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451955160")).click();



    }
}
