package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	 WebDriver driver;	
		
	    ExcelReader  excelReader = new ExcelReader("src\\main\\java\\excelTestData\\excel_TestData.xlsx");
	  
	    //Login Data
	    String userName = excelReader.getCellData("LoginInfo", "userName", 2);
	    String password = excelReader.getCellData("LoginInfo", "password", 2);
	    
		String dashboardHeaderValidationText = excelReader.getCellData("DashboardInfo", "DashboardHeader", 2);
		String alertUserValidationText =  excelReader.getCellData("LoginInfo", " alertUserValidationText", 2);
		String alertpaswordValidationText = excelReader.getCellData("LoginInfo", " alertpaswordValidationText", 2);
		
	 	
	@Test
	 public void validUserShoudBeAbleToLogin()	{
		 
		 driver = BrowserFactory.init();
		 
		 LoginPage loginPage2 = PageFactory.initElements(driver, LoginPage.class);
		 loginPage2.insertUserName(userName);
		 loginPage2.insertPassword(password);
		 loginPage2.clickOnSignInButton();
		 
		 DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		 dashboardPage.validateDashboardPage(dashboardHeaderValidationText);
		 BrowserFactory.tearDown();
	 }
	
	//	@Test
	public void validateLoginAlertMsg() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage2 = PageFactory.initElements(driver, LoginPage.class);
		loginPage2.clickOnSignInButton();
		loginPage2.validateUserAlertMsg(alertUserValidationText);
		
		loginPage2.insertUserName(userName);
		loginPage2.clickOnSignInButton();
		loginPage2.validatePasswordAlertMsg(alertpaswordValidationText);
		BrowserFactory.tearDown();
		 
		
		
	}
	
	
	
	
	
	
	
}
