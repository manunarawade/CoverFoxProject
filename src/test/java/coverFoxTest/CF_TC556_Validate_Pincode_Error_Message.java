package coverFoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPomPages.CoverFoxAddressDetailsPage;
import coverFoxPomPages.CoverFoxHealthPlanPage;
import coverFoxPomPages.CoverFoxMemberDetails;
import coverFoxPomPages.HomePage;
import coverFoxUtility.Utility;

public class CF_TC556_Validate_Pincode_Error_Message extends Base {
	HomePage home;
	CoverFoxHealthPlanPage  healthPlan;
	CoverFoxMemberDetails  memberDetails;
	CoverFoxAddressDetailsPage addressDetails;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		launchCoverFoxBrowser();
		Thread.sleep(5000);
		home=new HomePage(driver);
		healthPlan=new CoverFoxHealthPlanPage(driver);
		memberDetails=new CoverFoxMemberDetails(driver);
		addressDetails=new CoverFoxAddressDetailsPage(driver);
	}
	
	@BeforeMethod
	public void enterMemberDetails() throws  InterruptedException, EncryptedDocumentException, IOException {
		home.clickOnMaleButton();
		Thread.sleep(1000);

		healthPlan.clickOnNextButton();
		Thread.sleep(1000);

		memberDetails.handleAgeDropdown(Utility.readDataFromExcel(1, 0));
		Thread.sleep(1000);
		
		memberDetails.clickOnNextButton();
		Thread.sleep(1000);

		addressDetails.enterMobileNumber(Utility.readDataFromExcel(1, 2));
		Thread.sleep(1000);
		
		addressDetails.clickOnContinueButton();
		Thread.sleep(1000);
		}
	
	@Test
  public void validatePinCodeErrorMsg() {
		
		boolean res = addressDetails.validatePinErrorMsg();
		Assert.assertTrue(res, "Pincode error message not present, TC is failed");
  }
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
	Thread.sleep(3000);
	closeCoverFoxBrowser();
	}
	
}
