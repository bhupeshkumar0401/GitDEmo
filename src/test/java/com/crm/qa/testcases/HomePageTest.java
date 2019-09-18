package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
public HomePageTest(){
		
		super();
		
	}

@BeforeMethod
public void setUp(){
	initalization();
	testutil= new TestUtil();
	contactspage = new ContactsPage(); 
	 loginpage= new LoginPage();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}
@Test(priority=1)
public void homePageTitleTest(){
	String homepagetitle=homepage.verifyHomePageTitle();
	Assert.assertEquals(homepagetitle, "CRMPRO","Home Page title not matched");
	
	
	}
@Test(priority=2)
public void verifyUserNameTest(){
	testutil.switchToFrame();
Assert.assertTrue(homepage.verifyCorrectUserName());
	


}
@Test(priority=3)
public void verifyContactsLink(){
	testutil.switchToFrame();
	contactspage= homepage.clickOnContactsLink();
	
	
	
}







@AfterMethod
public void tearDown()
{
	
	driver.quit();
}
	

}
