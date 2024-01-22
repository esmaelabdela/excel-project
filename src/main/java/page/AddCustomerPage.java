package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {

	
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElements/Attributes
	
	@FindBy(how = How.XPATH,using = "//strong[contains(text(),'New Customer')]" ) WebElement addCustomerHeaderElement;
	@FindBy(how = How.XPATH,using = "//input[@name='name']") WebElement fullNameElement;
	@FindBy(how = How.XPATH,using = "//select[@name='company_name']") WebElement companyNameElement;
	@FindBy(how = How.XPATH,using = "//input[@name='email']") WebElement emailElement;
	@FindBy(how = How.XPATH,using = "//input[@id='phone']") WebElement phoneElement;
	@FindBy(how = How.XPATH,using = "//input[@name='address']") WebElement addressElement;
	@FindBy(how = How.XPATH,using = "//input[@name='city']") WebElement cityElement;
	@FindBy(how = How.XPATH,using = "//select[@name='country']") WebElement countryElement;
	@FindBy(how = How.XPATH,using = "//select[@name='country']") WebElement zipElement;
	@FindBy(how = How.XPATH,using = "//select[@id='customer_group']") WebElement groupNameElement;
	@FindBy(how = How.XPATH,using = "//button[@id='save_btn']") WebElement saveElement;
	
	
public void validateAddCustomerPage( String addCustomerHeaderText) {

     validateElement(addCustomerHeaderElement.getText(), addCustomerHeaderText ,"Add customer is not available");
 }


    String insertedName;
	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);
	}
	public void selectCompanyName(String companyName) {
		selectFromdropDown(companyNameElement, companyName);
	}
	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNum(999) + email);
	}
	public void insertPhone(String phone) {
		phoneElement.sendKeys(phone + generateRandomNum(999));
	}
	
	public void insertAddress(String address) {
		addressElement.sendKeys(address);
	}
	public void insertCitty(String city) {
		cityElement.sendKeys(city);
	}
	public void insertZip(String zip) {
		zipElement.sendKeys(zip);
	}
	public void selectCountryName(String countryName) {
		selectFromdropDown(countryElement, countryName);
	}
	
	public void seletGroupName(String groupName) {
		selectFromdropDown(groupNameElement,groupName);
	}
	public void clickSaveButton() {
		saveElement.click();
	}

  // DYNAMIC WEB TABLE XPATH
	//tbody/tr[1]/td[2]/a
	//tbody/tr[2]/td[2]/a
	//tbody/tr[3]/td[2]/a
	//tbody/tr[1]/td[9]/button
	
	
	String  beforeXpath = "//tbody/tr[";
	String  afterXpath = "]/td[2]/a";
	
	String  afterXpathDelete = "]/td[9]/button";
	
	
	public void validateInsertedNameAndDelete() {
		
	for(int i = 1; i<=5; i++) {
		String actualName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
		System.out.println(actualName);
		
	if(actualName. contains(insertedName)) {
	    System.out.println("Name Exist");
		driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click();
		driver.findElement(By.xpath("//a[@id='yesBtn']")).click();	
		  }
		break;
	 }
	
  }
	
	
	
	
	
}
