package coverFoxPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemberDetails {

	@FindBy(id = "Age-You")private WebElement ageDropdown;
	@FindBy(className = "next-btn")private WebElement nextButton2;
	
	public  CoverFoxMemberDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void handleAgeDropdown(String age) 
	{
		Select s=new Select(ageDropdown);
		s.selectByValue(age+"y");
	}
	
	public void clickOnNextButton()
	{
		nextButton2.click();
	}
	
	
	
}
