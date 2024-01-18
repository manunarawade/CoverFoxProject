package coverFoxPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxAddressDetailsPage {

	@FindBy(xpath = "(//input[@type='number'])[1]") private WebElement pinCodeField;	
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumberField;
	@FindBy(xpath = "//div[text()='Continue']") private WebElement continueButton;
	@FindBy(xpath = "//div[contains(text(),'valid pincode')]") private WebElement pincodeErrorMsg;
	
	public CoverFoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPincode(String pincode) {
		pinCodeField.sendKeys(pincode);
	}
	
	public void enterMobileNumber(String mobNum) {
		mobileNumberField.sendKeys(mobNum);
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	public boolean validatePinErrorMsg() {
		boolean result = pincodeErrorMsg.isDisplayed();
		return result;
	}
}
