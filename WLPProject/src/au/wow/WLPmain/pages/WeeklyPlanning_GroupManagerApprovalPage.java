package au.wow.WLPmain.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import au.wow.WLPmain.objects.WeeklyPlanningStoreObjects;
import au.wow.WLPmain.objects.WeeklyPlanning_GroupManagerApprovalObjects;
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
			
			try {
			boolean checkbox = chkBox.isEnabled();
			boolean button = saveButton.isEnabled();
			boolean comment = commentField.isEnabled();
			System.out.println("The values that are enabled/disabled :" + "   "+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment);
			if(checkbox)
			{
				
				Report_AddStep("testcase","The values that are disabled :"+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are disabled : "+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment +" ;;;Fail");
			}
			
			else {
				Report_AddStep("testcase","The values that are enabled :"+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are enabled : " + "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment +" ;;;Fail");
				
			}
			
		}catch(Exception e) {
			System.out.println("Exception Occured" +e.getMessage());
			Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
			htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
		}
		}
		
public void EditFields(ExtentTest extentTest,WebElement chkBox, WebElement saveButton, WebElement commentField) throws Exception{
			try {
			boolean checkbox = chkBox.isEnabled();
			boolean button = saveButton.isEnabled();
			boolean comment = commentField.isEnabled();
			
			commentField.clear();
			commentField.sendKeys("Test 123");
			//chkBox.click();
			saveButton.click();
			Alert alert = driver1.switchTo().alert();
			
			alert.accept();
			
			System.out.println("The values that amended :" + "   "+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment);
			
			if(checkbox)
			{
				
				Report_AddStep("testcase","The values that are amended :"+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are amended : "+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment +" ;;;Fail");
			}
			
			else {
				Report_AddStep("testcase","The values that are not amended :"+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield"+comment ,"","", "Fail");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are not amended : " + "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment +" ;;;Fail");
				
			}
			
		}catch(Exception e) {
			System.out.println("Exception Occured" +e.getMessage());
			Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
			htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
		}

	}




public List<String> checkApproval(List<List<Object>> list) throws Exception{

	List<String> newList=new ArrayList<String>();
	try {
		
		for(int i=0;i<list.size();i++)
		{
			newList.add((String)list.get(i).get(1));
			
		}
		System.out.println("Value contains:"+newList);
		
		}catch(Exception e) {
		System.out.println("Exception Occured" +e.getMessage());
		Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
		htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
	}
	return newList;
}


public List<String> checkApprovalTwo(List<List<Object>> list) throws Exception{

	List<String> newList=new ArrayList<String>();
	try {
		
		for(int i=0;i<list.size();i++)
		{
			String st=(String)list.get(i).get(1);
			if(st.equals("N"))
			newList.add((String)list.get(i).get(0));
			
		}
		System.out.println("Value contains:"+newList);
		
		}catch(Exception e) {
		System.out.println("Exception Occured" +e.getMessage());
		Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
		htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
	}
	return newList;
}
}


