package NEWPAACKONE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class login {
	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void insetu() throws IOException {
		prop = new Properties();
		
String path = System.getProperty("user.dir") + "//src/test/resources/configfiles/config.properties";
		
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		fin.close();
		
	}
	
@BeforeMethod
public void setup() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}
	
  @Test(dataProvider = "logindata")
  public void f(String user,String password) {
	  
	  driver.get(prop.getProperty("url"));
	  
	  driver.findElement(By.id("username")).sendKeys(user);
	  
	  driver.findElement(By.id("password")).sendKeys(password);
	  
	  driver.findElement(By.className("radius")).click();
	   
	  WebElement da = driver.findElement(By.className("subheader"));
	   
	   Assert.assertEquals(da.getText(), "Welcome to the Secure Area. When you are done click logout below.");
	  
	  
	  
  }
  
  @AfterMethod public void exta() {
		driver.close();
  }




@DataProvider(name = "logindata")
public Object [][] getData(){
	String path = System.getProperty("user.dir") + "//src/test/resources/TESTDATA/Logindata.csv";

	CSVReader read = null;
	try {
		read = new CSVReader(new FileReader(path));
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	String cols[];
	
	ArrayList<Object> datalist = new ArrayList<Object>();
	
	try {
		
		while ((cols = read.readNext()) !=null) {
			Object record[] = {cols[0],cols[1]};
			datalist.add(record);
			
		}
		read.close();
	}catch (CsvValidationException | IOException e) {
		e.printStackTrace();
	}
	return datalist.toArray(new Object[datalist.size()][]);
	
}

	
}