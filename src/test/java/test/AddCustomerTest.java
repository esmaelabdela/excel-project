package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	
	 WebDriver driver;
	
	  ExcelReader  excelReader = new ExcelReader("src\\main\\java\\excelTestData\\excel_TestData.xlsx");
	  
	    String userName = excelReader.getCellData("LoginInfo", "userName", 2);
	    String password = excelReader.getCellData("LoginInfo", "password", 2);
		String dashboardHeaderValidationText = excelReader.getCellData("DashboardInfo", "DashboardHeader", 2);
		String alertUserValidationText =       excelReader.getCellData("LoginInfo", " alertUserValidationText", 2);
		String alertpaswordValidationText =    excelReader.getCellData("LoginInfo", " alertpaswordValidationText", 2);
		
		String addCustomerValidationText = excelReader.getCellData("AddContactInfo", "AddCustomerValidationText", 2);
		
		String fullName =     excelReader.getCellData("AddContactInfo", "FullName", 2);
		String companyName =  excelReader.getCellData("AddContactInfo", "CompanyName", 2);
		String emailAddress = excelReader.getCellData("AddContactInfo", "EmailAddress", 2);
		String phone =        excelReader.getCellData("AddContactInfo", "PhoneNum", 2);
		String address  =     excelReader.getCellData("AddContactInfo", "Address", 2);
		String city    =      excelReader.getCellData("AddContactInfo", "City", 2);
		String zip    =       excelReader.getCellData("AddContactInfo", "zip", 2);
		String countryName =  excelReader.getCellData("AddContactInfo", "CountryName", 2);
	
	
	@Test
  public void userShouldBeAbleToAddNewCustomer() {
	  
	 driver =  BrowserFactory.init(); 
	  
	 LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	 loginPage.insertUserName(userName);
	 loginPage.insertPassword(password);
	 loginPage.clickOnSignInButton();
	 
	 DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	 dashboardPage.validateDashboardPage(dashboardHeaderValidationText);
	 dashboardPage.clickOnCustomerMenue();
	 dashboardPage.clickOnaddCustomer();
	 
	 AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
	 addCustomerPage.validateAddCustomerPage(addCustomerValidationText);
	 addCustomerPage.insertFullName(fullName);
	 addCustomerPage.insertEmail(emailAddress);
	 addCustomerPage.insertPhone(phone);
	 addCustomerPage.selectCompanyName(companyName);
	 addCustomerPage.insertAddress(address);
	 addCustomerPage.insertCitty(city);
	 addCustomerPage.insertZip(zip);
	 addCustomerPage.selectCountryName(countryName);
//	 addCustomerPage.clickSaveButton();
//	
//	 addCustomerPage.validateInsertedNameAndDelete();
	 
	 
	 
  }
  
	
  
	
}
