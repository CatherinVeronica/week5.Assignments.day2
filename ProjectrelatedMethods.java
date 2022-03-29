package week2.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.classroom.ReadExcel;

public class ProjectrelatedMethods {
	 public String excelfilepath;	
public RemoteWebDriver driver;
@Parameters({"URL","Browser_Name"})
	@BeforeMethod
	public void BeforeMethod(String url, String browserName) {
	if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}else if (browserName.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
		
		

	}
	@AfterMethod
	public void AfterMethod() {
		driver.close();
}
	@DataProvider(name = "Dynamic_data")
	public  String[][] Testdata() throws IOException {
		String[][] data = ReadExcel.getData(excelfilepath);
				return data;
		
	}

	}

