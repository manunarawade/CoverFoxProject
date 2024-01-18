package coverFoxPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//div[text()='Male']")private WebElement maleButton;
	
		public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMaleButton() {
		maleButton.click();
	}
	
}
