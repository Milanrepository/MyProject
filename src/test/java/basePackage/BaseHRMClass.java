package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	public BaseHRMClass() {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\deep\\eclipse-workspace\\HRMmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
	    prop.load(file);
		}
		catch(FileNotFoundException e) {
		e.printStackTrace();
		}
		
		catch(IOException a) {
			a.printStackTrace();
		}
		
	}
	

	public static void initiation() {
		
	String browsername =prop.getProperty("browser");
	
	if (browsername.equals("Firefox")){
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	else if (browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","chrome.exe");
		driver =new ChromeDriver();
	}
	

	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	}

	public static void screenshots(String Filename) {
		
	
		File file=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(file,new File("C:\\Users\\deep\\eclipse-workspace\\HRMmanagement\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg"));
	}
catch(IOException e) {
	e.printStackTrace();
}

	}
	
}
