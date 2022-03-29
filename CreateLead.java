package week2.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class CreateLead extends ProjectrelatedMethods {
	@BeforeTest
	public void SetData() {
		excelfilepath = ("./TestData/tc001.xlsx");
	}
	
	@Test(dataProvider="Dynamic_data")
	public void tc001(String username, String password, String companyname, String firstname, String lastname) {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
		driver.findElement(By.name("submitButton")).click();

	}
}
