package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import PageObjectModel.RegistrationPageObject;

public class baseClass {

	public  WebDriver driver;
	public static String Email= genrateRandomEmailID();
	public Properties prop;
	
	//Browser code--
	public void driverInitilization() throws IOException
    {
	     //Reading Data.properties file
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
	
       //want to access the data from properties file
	    prop=new Properties();//proerties is class of java 
    
	    prop.load(fis);//load file 
	    String BrowserName=prop.getProperty("browser");//it will give the value is chrome stored in data properties
	    
	    //this nothing but cross browser testing
	    if(BrowserName.equalsIgnoreCase("chrome"))
	    {
	    	 driver=new ChromeDriver();
	    }
	    else  if(BrowserName.equalsIgnoreCase("firefox"))
	    {
	    	 driver=new FirefoxDriver();
	    }
	    else  if(BrowserName.equalsIgnoreCase("edge"))
	    {
	    	 driver=new EdgeDriver();
	    }
	    else
	    {
	    	System.out.println("Please choose proper driver value");
	    }
    
    }
	   //this will generate new email.id  everytime
	public static String genrateRandomEmailID() {
	
		return "abc" + System.currentTimeMillis() +"@gmail.com";
	}
	    
	    @BeforeMethod
  public void LaunchBrowser() throws IOException
  {
	    	driverInitilization();
	    	
	    	driver.get(prop.getProperty("url"));

			
  }
	    
	
}
