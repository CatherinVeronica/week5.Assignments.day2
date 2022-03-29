package week2.assignments;



import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class EditLead extends ProjectrelatedMethods{
	@BeforeTest
	public void SetData() {
		excelfilepath = ("./TestData/tc004.xlsx");
	}
//	@DataProvider (name= "dataProvider_EditLead")
//	public String[][] TestData() {
//		String[][] data = new String[1][4];
//		data[0][0]="DemoSalesManager";
//		data[0][1]="crmsfa";
//		data[0][2]="99";
//		data[0][3]="TCS";		
//		
//		return data;
//		
//	}
	
@Test(dataProvider="Dynamic_data" )
	public  void tc004(String username,String password,String phoneNumber,String UpdatedCompanyName) throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(UpdatedCompanyName);
		driver.findElement(By.name("submitButton")).click();
		
	}
}
