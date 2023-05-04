package org.mmp.patientmodule.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterPatient_PAT001 {
	
	
	@Test(description="Register Patient using valid credentials")
	public void TC_009_registerPatient_valid() throws Exception {
		MMPLibrary mmplib = new MMPLibrary();
		mmplib.launchBrowser("chrome", "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		
		
		String actualTab1 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText().trim();
		String expectedTab1 = "Home";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTab1, expectedTab1, "Home tab is not not displayed");
		String actualTab2 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]")).getText().trim();
		String expecteTab2 = "Patient Login";
		sa.assertEquals(actualTab2, expecteTab2, "Patient Login tab is not displayed");
		String actualTab3 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'Office Login')]")).getText().trim();
		String expecteTab3 = "Office Login";
		sa.assertEquals(actualTab3, expecteTab3, "Office Login tab is not displayed");
		String actualTab4 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).getText().trim();
		String expecteTab4 = "About Us";
		sa.assertEquals(actualTab4, expecteTab4, "About Us tab is not displayed");
		String actualTab5 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).getText().trim();
		String expecteTab5 = "Contact Us";
		sa.assertEquals(actualTab5, expecteTab5, "Contact Us tab is not displayed");
		
		mmplib.driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]")).click();
		String actualTab6 = mmplib.driver.findElement(By.xpath("//h1[contains(text(),'Now it is')]")).getText().trim();
		String expectedTab6 = "Now it is really simple to Claim your Insurance";
		sa.assertEquals(actualTab6, expectedTab6, "Text is not displayed as expected");
		String actualTab7 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'Login') and @class='button button-alt']")).getText().trim();
		String expectedTab7 = "Login";
		sa.assertEquals(actualTab7, expectedTab7, "Login tab is not displayed");
		String actualTab8 = mmplib.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).getText().trim();
		String expectedTab8 = "Register";
		sa.assertEquals(actualTab8, expectedTab8, "Register tab is not displayed");
		Thread.sleep(3000);
		boolean actualTab9 = mmplib.driver.findElement(By.xpath("//a[@class='smooth-scroll']")).isDisplayed();
		sa.assertTrue(actualTab9, "False");
		Thread.sleep(3000);
		
		mmplib.driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		boolean actualTab10 = mmplib.driver.findElement(By.id("firstname")).isDisplayed();
		boolean expectedTab10 = true;
		sa.assertEquals(actualTab10, expectedTab10, "First name Tab is not displayed");
		
		Random data = new Random();
		int val = data.nextInt(99);
		//int UppCaseVal = 65+data.nextInt(26);
		//char UppCaseChar = (char) UppCaseVal;
		int lowCaseVal = 97+data.nextInt(26);
		char lowCaseChar = (char) lowCaseVal;
		//int spCharVal = 33+data.nextInt(14);
		//char spChar = (char) spCharVal;
		String fname = "A"+lowCaseChar+lowCaseChar;
		mmplib.driver.findElement(By.id("firstname")).sendKeys(fname);
		String lname = "P"+lowCaseChar+lowCaseChar;
		mmplib.driver.findElement(By.id("lastname")).sendKeys(lname);
		mmplib.driver.findElement(By.id("datepicker")).sendKeys("01/01/1975");
		String licenseVal = "2"+val+val+val+"0";
		mmplib.driver.findElement(By.id("license")).sendKeys(licenseVal);
		String ssnVal = "1"+val+val+val+val;
		mmplib.driver.findElement(By.id("ssn")).sendKeys(ssnVal);
		mmplib.driver.findElement(By.id("state")).sendKeys("Georgia");
		mmplib.driver.findElement(By.id("city")).sendKeys("Alpharetta");
		mmplib.driver.findElement(By.id("address")).sendKeys("10 Rice ln");
		mmplib.driver.findElement(By.id("address")).sendKeys("10 Rice ln");
		mmplib.driver.findElement(By.id("zipcode")).sendKeys("12345");
		mmplib.driver.findElement(By.id("age")).sendKeys("65");
		mmplib.driver.findElement(By.id("height")).sendKeys("160");
		mmplib.driver.findElement(By.id("weight")).sendKeys("70");
		mmplib.driver.findElement(By.id("pharmacy")).sendKeys("cvs");
		mmplib.driver.findElement(By.id("pharma_adress")).sendKeys("20 Rico ln, Fresno, GA");
		mmplib.driver.findElement(By.id("email")).sendKeys("");
		Random obj = new Random();
		int ucv = (char) 65+obj.nextInt(26);
		int lcv = (char) 97+obj.nextInt(26);
		String Randomemail = "iitworkforce"+ucv+lcv+"@gamil.com";
		mmplib.driver.findElement(By.id("email")).sendKeys(Randomemail);
		
		int ucv1 = (char) 65+obj.nextInt(26);
		int lcv1 = (char) 97+obj.nextInt(26);
		int num = obj.nextInt(99);
		String Randomusername = "R"+ucv1+lcv1+num;
		mmplib.driver.findElement(By.id("username")).sendKeys(Randomusername);

		Select secQ = new Select(mmplib.driver.findElement(By.id("security")));
		secQ.selectByVisibleText("what is your pet name");
		
		int ucv2 = (char) 65+obj.nextInt(26);
		int lcv2 = (char) 97+obj.nextInt(26);
		int num1 = obj.nextInt(99);
		String password = "Password"+ucv2+lcv2+num1;
		mmplib.driver.findElement(By.id("password")).sendKeys(password);
		mmplib.driver.findElement(By.id("confirmpassword")).sendKeys(password);
		mmplib.driver.findElement(By.id("answer")).sendKeys("Daizy");
		mmplib.driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		String actualAlertTxt = mmplib.driver.switchTo().alert().getText().trim();
		String expectedAlertTxt = "Thank you for registering with MMP.";
		sa.assertEquals(actualAlertTxt, expectedAlertTxt, "Actual alert text does not match expected");
		mmplib.driver.switchTo().alert().accept();
		String actualHomePage = mmplib.driver.findElement(By.xpath("//span[contains(text(),'North America')]")).getText().trim();
		String expectedHomePage = "North American Medical Tech Group";
		sa.assertEquals(actualHomePage, expectedHomePage, "Actual does not match expected");
		sa.assertAll();
		
		
	}

}
