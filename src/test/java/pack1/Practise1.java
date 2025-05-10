package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Practise1 {
    @Test
    public void register(){
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//min wait time for script to fail if elements don't show up
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Akshay");
        driver.findElement(By.id("input-lastname")).sendKeys("Anand");
        driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("9999999999");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.id("input-confirm")).sendKeys("123456");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter' and @value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        String expectedURL="https://tutorialsninja.com/demo/index.php?route=account/success";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
        String expectedMessage = "Your Account Has Been Created!";
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedMessage));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(),expectedMessage);
        String DetailsExpected1="Congratulations! Your new account has been successfully created!";
        String DetailsExpected2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
        String DetailsExpected3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
        String DetailsExpected4="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
        String DetailsExpected5="contact us";
        String Expected=driver.findElement(By.id("content")).getText();
        Assert.assertTrue(Expected.contains(DetailsExpected1));
        Assert.assertTrue(Expected.contains(DetailsExpected2));
        Assert.assertTrue(Expected.contains(DetailsExpected3));
        Assert.assertTrue(Expected.contains(DetailsExpected4));
        Assert.assertTrue(Expected.contains(DetailsExpected5));
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        String nowExpectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        String actualUrlnow=driver.getCurrentUrl();
        Assert.assertEquals(nowExpectedUrl,actualUrlnow);
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        driver.quit();
    }
    public String generateNewEmail(){
        Date date=new Date();
//        System.out.println(date);
        String dateString=date.toString();
        String nospace=dateString.replaceAll(" ","");
        String res=nospace.replaceAll("\\:","");
        String result=res+"@abc.com";
//        System.out.println(result);
        return result;
    }

}
