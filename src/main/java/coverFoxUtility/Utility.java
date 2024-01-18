package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {

public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException {
	Reporter.log("Reading data from Excel ",true);
	FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\SeleniumSheet.xlsx");
	Sheet mySheet = WorkbookFactory.create(myFile).getSheet("CoverFoxData");
	String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
	return data;
}

public static void takeScreenshot(WebDriver driver, String TCID) throws IOException {
	String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("E:\\Selenium_Notes\\screenshot\\coverFox"+TCID+"_"+timeStamp+".png");
	Reporter.log("Saved Screenshot at"+dest, true);
	FileHandler.copy(src, dest);
	
}
public static String readDataFromPropertiesFile(String key) throws IOException
{
	Properties prop=new Properties();
	FileInputStream myFile=new FileInputStream("");
	prop.load(myFile);
	String data=prop.getProperty(key);
	return data;
	
}
}
