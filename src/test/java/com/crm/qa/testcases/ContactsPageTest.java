	package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName="contacts";
	
public ContactsPageTest(){
		
		super();
		
	}

@BeforeMethod
public void setUp(){
	initalization();
	testutil= new TestUtil();
	contactspage = new ContactsPage(); 
	 loginpage= new LoginPage();
	 
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	testutil.switchToFrame();
	contactspage=homepage.clickOnContactsLink();
	
	
}

@Test(priority=1)
public void verifyContactsPageLabel(){
	
	Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts Label is missing on page");
	
}
@Test(priority=2)
public void selectContactsTest(){
	contactspage.selectContactsByName("test test");
	
}

@DataProvider
public Object[][] getCRMTestData(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}


@Test(priority=4, dataProvider="getCRMTestData")
public void validateCreateNewContact(String title, String firstName, String lastName, String company){
	homepage.clickOnNewContactLink();
	//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	contactspage.createNewContact(title, firstName, lastName, company);
	
}


@AfterMethod
public void tearDown()
{
	
	driver.quit();
}


}
