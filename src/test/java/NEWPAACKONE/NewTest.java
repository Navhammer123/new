package NEWPAACKONE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  
	  WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("page title .." + driver.getTitle());
        
        
        WebElement da= driver.findElement(By.id("APjFqb")) ;
        da.sendKeys("new");
        da.submit();
  }
}
