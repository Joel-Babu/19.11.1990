package au.wow.WLPmain.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import au.wow.WLPmain.objects.WeeklyPlanningStoreObjects;
import au.wow.wlp.utils.ExtentReportsScreenshotCode;
import au.wow.wlp.utils.SQLWrapper;
import au.wow.wlp.utils.TestBase;

public class WeeklyPlanning_GroupManagerApprovalPage extends TestBase{

	
		CommonFunctions common = PageFactory.initElements(this.getDriver(),CommonFunctions.class);
		public Logger log = LogManager.getLogger(WeeklyPlanningStorePage.class);
		SQLWrapper sql = new SQLWrapper(log);
		//WeeklyPlanningStoreObjects objWeeklyPlanningStoreObjects;
		static ExtentReportsScreenshotCode ScreenShotUtil; 
		static WebDriverWait wait;
		String image;
		public WeeklyPlanning_GroupManagerApprovalPage()
		{
			// TODO Auto-generated constructor stub
			super();
		}
	
		
		public void Checklist(ExtentTest extentTest,WebElement chkBox, WebElement saveButton, WebElement commentField) throws Exception{
			
			Boolean checkbox = chkBox.isEnabled();
			Boolean button = saveButton.isEnabled();
			Boolean comment = commentField.isEnabled();
			
			if(checkbox)
			{
				
				Report_AddStep("testcase","The values that are disabled :"+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are disabled : "+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment +" ;;;Fail");
			}
			
			else {
				Report_AddStep("testcase","The values that are enabled :"+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are enabled : " + "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment +" ;;;Fail");
				
			}
			
		}
		
public void EditFields(ExtentTest extentTest,WebElement chkBox, WebElement saveButton, WebElement commentField) throws Exception{
			
			Boolean checkbox = chkBox.isEnabled();
			Boolean button = saveButton.isEnabled();
			Boolean comment = commentField.isEnabled();
			
			System.out.println("The values that are disabled :"+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment);
			
			commentField.sendKeys("Test 123");
			chkBox.click();
			saveButton.click();
			
			if(checkbox)
			{
				
				Report_AddStep("testcase","The values that are amended :"+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are amended : "+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment +" ;;;Fail");
			}
			
			else {
				Report_AddStep("testcase","The values that are not amended :"+ "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are not amended : " + "checkbox:"+checkbox+"/n" +"savebutton:"+button+"/n"+"commentfield"+comment +" ;;;Fail");
				
			}
			
		}
		
}

