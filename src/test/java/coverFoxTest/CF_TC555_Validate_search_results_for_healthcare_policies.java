package coverFoxTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPomPages.CoverFoxAddressDetailsPage;
import coverFoxPomPages.CoverFoxHealthPlanPage;
import coverFoxPomPages.CoverFoxHealthPlanResultsPage;
import coverFoxPomPages.CoverFoxMemberDetails;
import coverFoxPomPages.HomePage;
import coverFoxUtility.Utility;

public class CF_TC555_Validate_search_results_for_healthcare_policies extends Base {
 
	HomePage home;
	CoverFoxHealthPlanPage healthPlan;
	CoverFoxMemberDetails memberDetails;
	CoverFoxAddressDetailsPage addressDetails;
	CoverFoxHealthPlanResultsPage result;
	
	@BeforeClass
	public void  launchBrowser() throws InterruptedException {
		launchCoverFoxBrowser();
		home=new HomePage(driver);
		healthPlan=new CoverFoxHealthPlanPage(driver);
		memberDetails=new CoverFoxMemberDetails(driver);
		addressDetails=new CoverFoxAddressDetailsPage(driver);
		result=new CoverFoxHealthPlanResultsPage(driver);
			
	}
	
	@BeforeMethod
	public void enterMemeberDeatils() throws InterruptedException, EncryptedDocumentException, IOException
	{
	Reporter.log("clicking on gender button ", true);
	home.clickOnMaleButton();
	Thread.sleep(1000);
	Reporter.log("clicking on next button ", true);
	healthPlan.clickOnNextButton();
	Thread.sleep(1000);
	Reporter.log("Handeling age drop down ", true);
	memberDetails.handleAgeDropdown(Utility.readDataFromExcel(1, 0));
	Reporter.log("Clicking on next button ", true);
	memberDetails.clickOnNextButton();
	Thread.sleep(1000);
	Reporter.log("Entering pin code ",true);
	addressDetails.enterPincode(Utility.readDataFromExcel(1, 1));
	Thread.sleep(1000);
	Reporter.log("Entering mobile num ",true);
	addressDetails.enterMobileNumber(Utility.readDataFromExcel(1, 2));
	Thread.sleep(1000);
	Reporter.log("Clicking on continue button ", true);
	addressDetails.clickOnContinueButton();
	Thread.sleep(1000);
	}

	
@Test
public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException
{
Thread.sleep(5000);
Reporter.log("Fetching number of results from text ", true);
int textResult = result.availablePlanNumberFromText();
Thread.sleep(7000);
Reporter.log("Fetching number of results from Banners ", true);
int bannerResult = result.availablePlanNumberFromBanners();
Thread.sleep(1000);
Assert.assertEquals(textResult, bannerResult,"Text results are not matching with Banner results, TC is failed");
Reporter.log("TC is passed ", true);
Utility.takeScreenshot(driver, "CF_TC555");

}

@AfterMethod
public void closeBrowser() throws InterruptedException
{
Thread.sleep(3000);
closeCoverFoxBrowser();
}

}
