package NEWPAACKONE;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;

public class NewTest {
	WebDriver driver;
	ExtentReports extentreport;
	ExtentSparkReporter spark;
	ExtentTest extenttest;
	
	
	@BeforeTest
	public void ext() {
		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("//test-output/spark.html");
		
		extentreport.attachReporter(spark);
		
	}
		
	
	

	
  @Test //(retryAnalyzer = listerb.class)
  public void f() {
	  extenttest = extentreport.createTest("test");
	  
	    driver.get("https://www.google.com/");
	  
		System.out.println("page title .." + driver.getTitle());
        
        
        WebElement da= driver.findElement(By.id("APjFqb")) ;
        da.sendKeys("new");
        da.submit();
        Assert.assertEquals(driver.getTitle(),"n" );
        
  }
	@Test 
	  public void j() {
		  WebDriver driver = new ChromeDriver();
		  
		  
			driver.get("https://www.google.com/");
			System.out.println("page title .." + driver.getTitle());
	        
	        
	        WebElement da= driver.findElement(By.id("APjFqb")) ;
	        da.sendKeys("new");
	        da.submit();
	  }
	
	@AfterTest
	public void extg() {
		extentreport.flush();
	}}
	
@AfterMethod 
public void exta() {
	driver.close();
}}

	

