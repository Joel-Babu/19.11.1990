package au.wow.WLPmain.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import au.wow.WLPmain.objects.WeeklyPlanningStoreObjects;
import au.wow.WLPmain.objects.WeeklyPlanning_GroupManagerApprovalObjects;
import au.wow.wlp.utils.CustomException;
import au.wow.wlp.utils.ExtentReportsScreenshotCode;
import au.wow.wlp.utils.SQLWrapper;
import au.wow.wlp.utils.TestBase;
import au.wow.wlp.utils.BasePage;

public class WeeklyPlanning_GroupManagerApprovalPage extends TestBase{

	
		CommonFunctions common = PageFactory.initElements(this.getDriver(),CommonFunctions.class);
		public Logger log = LogManager.getLogger(WeeklyPlanning_GroupManagerApprovalPage.class);
		SQLWrapper sql = new SQLWrapper(log);
		//WeeklyPlanningStoreObjects objWeeklyPlanningStoreObjects;
		WeeklyPlanning_GroupManagerApprovalObjects objWeeklyPlanningGroupMangerApprovalObjects;
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
			boolean checkbox = this.isEnabled(chkBox);
			boolean button = this.isEnabled(saveButton);
			boolean comment = this.isEnabled(commentField);
			System.out.println("The values that are enabled/disabled :" + "   "+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment);
			if(checkbox || button)
			{
				
				Report_AddStep("testcase","The values that are disabled :"+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield"+comment ,"","", "Pass");
				htmlToExtent(cName,mName,extentTest,driver1, "The values that are disabled : "+ "checkbox:"+checkbox+"   " +"savebutton:"+button+"   "+"commentfield:"+comment +" ;;;Pass");
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
		
public void EditFields(ExtentTest extentTest, WebElement chkBox, WebElement saveButton, String commentField,String dept,String Table) throws Exception{

		try {
			 	boolean checkbox = this.isEnabled(chkBox);
			 	boolean button = this.isEnabled(saveButton);
			 	//boolean comment = commentField.isEnabled();
				String Dept,Comment=null;
				int columnsize=2;
				List<List<Object>> Values= new  ArrayList<List<Object>>();
				int RowCount =TradingStatementTableCount(Table);	
				for(int i=1;i<=RowCount-3;i++) //6
				{
					List<Object> row = new ArrayList<>(columnsize);
					System.out.println(i);
					WebElement Department = prepareWebElementWithDynamicXpathWithInt(dept, i);
					WebElement comments = prepareWebElementWithDynamicXpathWithInt(commentField, i);
					comments.sendKeys(" ZZZZ");
//					Dept = getText(Department);
//					Comment = getText(comments);
//					row.add(Dept);
//					row.add(Comment);	
//					Values.add(row);
				}
			
				if(checkbox && button)
				{
					clickElmentUsingJs(saveButton);
					click(chkBox);
					
				}
				else
				{
					clickElmentUsingJs(saveButton);
					
				}
//			Alert alert = driver1.switchTo().alert();
//			alert.accept();
			//return Values;
		}catch(Exception e) {
			System.out.println("Exception Occured" +e.getMessage());
			Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
			htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
			//throw e;
		}
	
	}

public void selectByVisibleText(ExtentTest extentTest,List<String> text, WebElement chkBox,WebElement saveButton, WeeklyPlanning_GroupManagerApprovalObjects objWeeklyPlanningGroupMangerApprovalObjects) throws Exception{
	
	try {
		for(int i=0;i<text.size();i++)
		{
			WebElement element = prepareWebElementWithLinkText(text.get(i));
			this.click(element);
			if(!this.isSelected(chkBox)) {
			this.click(chkBox);
			
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.planningScreens, "Planning Screens");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.weeklyPlanning, "Weekly Planning");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.screenToView, "Group");
		}else {
			
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.planningScreens, "Planning Screens");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.weeklyPlanning, "Weekly Planning");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.screenToView, "Group");
		}
		}
		/*
		 * getLogger().info("The option with text: " + text +
		 * " is selected in the dropdown: " + elementname);
		 */
	} catch(Exception e) {
		System.out.println("Exception Occured" +e.getMessage());
		Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
		htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
	}
}


public void selectByVisibleTextTwo(ExtentTest extentTest,List<Object> text, WebElement chkBox,WebElement saveButton, WeeklyPlanning_GroupManagerApprovalObjects objWeeklyPlanningGroupMangerApprovalObjects) throws Exception{
	
	try {
		for(int i=0;i<text.size();i++)
		{
			WebElement element = prepareWebElementWithLinkText((String)text.get(i));
			this.click(element);
			if(!this.isSelected(chkBox)) {
			this.click(chkBox);
			
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.planningScreens, "Planning Screens");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.weeklyPlanning, "Weekly Planning");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.screenToView, "Zone");
		}else {
			
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.planningScreens, "Planning Screens");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.weeklyPlanning, "Weekly Planning");
			selectPage(extentTest, objWeeklyPlanningGroupMangerApprovalObjects.menuBar,
					objWeeklyPlanningGroupMangerApprovalObjects.screenToView, "Zone");
		}
		}
		/*
		 * getLogger().info("The option with text: " + text +
		 * " is selected in the dropdown: " + elementname);
		 */
	} catch(Exception e) {
		System.out.println("Exception Occured" +e.getMessage());
		Report_AddStep("testcase","Exception Occured" ,"","", "Fail");
		htmlToExtent(cName,mName,extentTest,driver1, "Exception Occured;;;Fail");
	}
}

public void selectPage(ExtentTest extentTest,WebElement PageTitle,String menuBtn,String reportName) throws Exception
{
	String buttonName;
	try
	{
		if((isDisplayed(PageTitle)))
		{
			WebElement element =prepareWebElementWithDynamicXpathWithString(menuBtn,reportName);
			buttonName = getText(element);
			//if (buttonName.equalsIgnoreCase(reportName))
			//{
				click(element);
				//htmlToExtent(cName,mName,extentTest,driver, "Successfully clicked the button: "+reportName+" ;;;Pass");
			//}
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception Occured" +e.getMessage()); 
		//htmlToExtent(cName,mName,extentTest,driver, "Exception Occured - Failed to Select Page from Menu Bar ;;;Fail");
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
			String st=(String)list.get(i).get(0);
			if(!st.isEmpty())
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

public List<Object> checkApprovalThree(List<List<Object>> list) throws Exception{

	List<Object> newList=new ArrayList<Object>();
	try {
		
		for(int i=0;i<list.size();i++)
		{
			Object st=list.get(i).get(0);
			if(st!=null)
			newList.add(list.get(i).get(0));
			
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


