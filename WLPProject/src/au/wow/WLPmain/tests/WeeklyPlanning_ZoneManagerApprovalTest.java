package au.wow.WLPmain.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import au.wow.WLPmain.WeeklyPlanning.WeeklyPlanningGroup;
import au.wow.WLPmain.objects.MonthlyPlanningGroupObjects;
import au.wow.WLPmain.objects.MonthlyPlanningStoreObjects;
import au.wow.WLPmain.objects.WeeklyPlanningStoreObjects;
import au.wow.WLPmain.objects.WeeklyPlanning_GroupManagerApprovalObjects;
import au.wow.WLPmain.pages.CommonFunctions;
import au.wow.WLPmain.pages.MonthlyPlanningGroupPage;
import au.wow.WLPmain.pages.MonthlyPlanningStorePage;
import au.wow.WLPmain.pages.WeeklyPlanningStorePage;
import au.wow.WLPmain.pages.WeeklyPlanning_GroupManagerApprovalPage;
import au.wow.WLPmain.pages.WoWLoginPage;
import au.wow.wlp.utils.BasePage;
import au.wow.wlp.utils.CommonRepository;
import au.wow.wlp.utils.CustomExtentReports;
import au.wow.wlp.utils.ExtentReportsScreenshotCode;
import au.wow.wlp.utils.SQLWrapper;
import au.wow.wlp.utils.TestBase;
import au.wow.wlp.utils.TestStatus;
import au.wow.wlp.utils.XMLDataReader;
import mx4j.log.Log;

public class WeeklyPlanning_ZoneManagerApprovalTest extends TestBase {

	protected Logger log = LogManager.getLogger(WeeklyPlanning_ZoneManagerApprovalTest.class);
	TestStatus status;
	ExtentReportsScreenshotCode ScreenShotUtil;
	SQLWrapper sql = new SQLWrapper(log);
	WoWLoginPage loginPage;
	CommonRepository CommonFunc;
	WeeklyPlanningStorePage pageWeeklyPlanningPO;
	WeeklyPlanningStoreObjects objWeeklyPlanningStoreObjects;
	MonthlyPlanningStoreObjects objMonthlyPlanningStoreObjects;
	WeeklyPlanning_GroupManagerApprovalObjects objWeeklyPlanningGroupMangerApprovalObjects;
	WeeklyPlanning_GroupManagerApprovalPage objWeeklyPlanningGroupMangerApprovalPO;
	BasePage BaseObj;
	CommonFunctions common;
	StoreProperties storeprop;
	List<List<Object>> DBValues, DBValues1, DBValues2,DBValues3,DBValues4,DBValues5,DBValues6,DBValues7,DBValues9;
	List<List<Object>> UIValues, UIValues1, UIValues2,UIValues3,UIValues4;
	String Week, Name, Year, YrName, LYYr, OptionToView, Wk, HWk1, HWk2, HWk3, HWk4;
	int LYYear, HistWk;
	String[] WeekName, YearName;

	public WeeklyPlanning_ZoneManagerApprovalTest() {
		super.log = log;
	}
	
	@Test(priority = 0)
	public void LogintoCLRApplication() throws Exception {
		loginPage = new WoWLoginPage().createPage(getDriver(), getContext(), log, status, data, report, extentTest,
				WoWLoginPage.class);
		pageWeeklyPlanningPO = loginPage.navToWeeklyPlanningGroupPg(getContext().getStringProperty("store"));
	}

	//Group Manager Approval for plan completion 
	@Test(priority = 1)
	public void GroupManagerApproval() throws Exception {
		
		pageWeeklyPlanningPO = new WeeklyPlanningStorePage().createPage(getDriver(), getContext(), log, status, data,
				getReport(), getReportLogger(), WeeklyPlanningStorePage.class);
		objWeeklyPlanningGroupMangerApprovalPO = new WeeklyPlanning_GroupManagerApprovalPage().createPage(getDriver(), getContext(), log, status,
				data, getReport(), getReportLogger(), WeeklyPlanning_GroupManagerApprovalPage.class);
		TestStatus status = getTestStatus();
		System.out.println("Entering into TestCase");
		pageWeeklyPlanningPO.SelectWeekFromDropdown(objWeeklyPlanningStoreObjects, extentTest,
				getContext().getStringProperty("SelectFiscalWeek"));
		
		pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
				objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
		pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
				objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
		pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
				objWeeklyPlanningStoreObjects.screenToView, "Zone");
		
		//check if plan completion checkbox is checked in state screen
		if(!this.isDisplayed(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox))
		{
			System.out.println("In State screen the plan complete Check-box is checked, so going back to Zone screen");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.screenToView, "Zone");
			// select the required zone
			selectByVisibleText(objWeeklyPlanningGroupMangerApprovalObjects.selectZone, "R04 Z04");
			
			Report_AddStep("testcase","In State screen the planning complete check-box is checked and thus going back to Zone screen : ", "" , "" , "Pass");
			htmlToExtentTwo(cName,mName,extentTest,driver1, "  State screen planning complete check-box is checked and so moving back to Zone screen  ; ; ;Pass");
			
			Report_AddStep("testcase","In Zone screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
			htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
			//check if the fields are enabled/disabled in zone screen
			objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
			//get comments of zone screen form DB
			String ZoneMgrCmts = data.getText("ZoneMgrCmts");
			DBValues = sql.CLRexecuteQuery(getContext(),
					ZoneMgrCmts.replace("Region", getContext().getStringProperty("Region"))
							.replace("Zone", getContext().getStringProperty("Zone"))
							.replace("FinWeek", getContext().getStringProperty("FinWk"))
							.replace("FinYear", getContext().getStringProperty("Year"))
							.replace("Division", getContext().getStringProperty("Division")));
			System.out.println("DB Value for zone manager comments: " + DBValues);


			UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
					objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
			
			Report_AddStep("testcase","In Zone screen comparing UI and DB zone manager comments : ", "", "  " , "Pass");
			htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen comparing UI and DB zone manager comments ; ; ;Pass");
			
			//compare UI and DB comments matching or not in zone screen
			pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);


			}
		
		else {
			
			List<Object> UI = null;
			System.out.println("In State screen the plan complete Check-box is not checked, going back to zone screen for approvals");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.screenToView, "Zone");
			// select the required zone
						selectByVisibleText(objWeeklyPlanningGroupMangerApprovalObjects.selectZone, "R04 Z04");
						
			Report_AddStep("testcase","In State screen the planning complete check-box is unchecked and thus going back to zone screen : ", "", "" , "Pass");
			htmlToExtentTwo(cName,mName,extentTest,driver1, "  State screen planning complete check-box is unchecked and so moving back to zone screen ; ; ;Pass");
			
			//check if checkbox is enabled/disabled in zone screen
			if(this.isSelected(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox)) {
				System.out.println("In Zone screen the plan complete check-box is Selected");
				
				Report_AddStep("testcase","In Zone screen the planning complete check-box is checked : ", "", "  " , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, "  Zone screen planning complete check-box is checked  ; ; ;Pass");
				
				Report_AddStep("testcase","In Zone screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
				//check if the fields are enabled/disabled in zone screen
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				//get comment of zone screen from DB
				String ZoneMgrCmts = data.getText("ZoneMgrCmts");
				DBValues = sql.CLRexecuteQuery(getContext(),
						ZoneMgrCmts.replace("Region", getContext().getStringProperty("Region"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value for zone manager comments: " + DBValues);
				//get comments of zone screen from UI
				UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				
				Report_AddStep("testcase","In Zone screen comparing UI and DB zone manager comments : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen comparing UI and DB zone manager comments ; ; ;Pass");
				
				//Compare UI and DB comments matching or not in zone screen
				pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);
				
			//toggle checkbox to disable	
			this.click(objWeeklyPlanningGroupMangerApprovalObjects.selectGroup);
			
			Report_AddStep("testcase","Click open 419 group : ", "", "" , "Pass");
			htmlToExtentTwo(cName,mName,extentTest,driver1, " Click open 419 group ; ; ;Pass");
			
			//check if the checkbox are enabled/disabled in Group screen
			if(this.isSelected(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox)) {
				System.out.println("In Group screen the plan complete Check-box is checked");
				
				Report_AddStep("testcase"," Inside 419 group the check- box is selected : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " Inside 419 group the check- box is selected and so move back to zone screen; ; ;Pass");
				
//				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
//						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.screenToView, "Zone");
				
				// select the required zone
				selectByVisibleText(objWeeklyPlanningGroupMangerApprovalObjects.selectZone, "R04 Z04");
				
				this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
				
				Report_AddStep("testcase"," In zone screen uncheck planning comeplete check- box : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen uncheck planning comeplete check- box ;Pass");
//				
				Report_AddStep("testcase","In Zone screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
				
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
				Report_AddStep("testcase","In Zone screen edit the comment field : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen edit the comment field ; ; ;Pass");
				
				//edit the fields and save in group screen
				objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.Comments,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName,objMonthlyPlanningStoreObjects.MPTable);
				
				//get updated DB comment for zone screen
				DBValues2 = sql.CLRexecuteQuery(getContext(),
						ZoneMgrCmts.replace("Region", getContext().getStringProperty("Region"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value for zone manager comments: " + DBValues2);
				//get updated UI comment for zone screen
				UIValues2 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				
				Report_AddStep("testcase","In Zone screen comparing UI and DB Zone manager comments : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen comparing UI and DB Zone manager comments ; ; ;Pass");
				
				//Compare DB and UI comments for zone screen
				pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues2, UIValues2);
				
			}
				
			}
			
			else {
				System.out.println("In Zone screen the plan complete Check-box is unchecked");
				
				Report_AddStep("testcase","In Group screen the planning complete check-box is unchecked : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, "  Zone screen planning complete check-box is unchecked  ; ; ;Pass");
				
				Report_AddStep("testcase","In Group screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
				htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
				
				
				UIValues2 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				UI = objWeeklyPlanningGroupMangerApprovalPO.checkApprovalThree(UIValues2);
				//check if the fields are enabled/disabled in zone screen
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				//Check DB comment for zone screen
				String GroupMgrPlanCompletion = data.getText("GroupMgrPlanCompletion");
				DBValues3 = sql.CLRexecuteQuery(getContext(),
						GroupMgrPlanCompletion.replace("Region", getContext().getStringProperty("Region"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value for group plan completion: " + DBValues3);
				
				
				//check if plan complete for all group by DB result, if not iterate and do plan completion
				List<String> newDBValues= objWeeklyPlanningGroupMangerApprovalPO.checkApproval(DBValues3);
				//List<Object> newDBValuesText= objWeeklyPlanningGroupMangerApprovalPO.checkApprovalThree(DBValues3);
				//newDBValuesText.add(UI);
				if(newDBValues.contains("N")){
					
					Report_AddStep("testcase","Perform plan completion for the groups for which planning is not done : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " Perform plan completion for the groups for which planning is not done ; ; ;Pass");
					
					//perform plan completion for unplanned group
					objWeeklyPlanningGroupMangerApprovalPO.selectByVisibleTextTwo(extentTest,UI,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects);
					
					DBValues4 = sql.CLRexecuteQuery(getContext(),
							GroupMgrPlanCompletion.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value for group plan completion after automated plan completion: " + DBValues4);
					
					Report_AddStep("testcase","In Zone screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
					
					//check if the fields are enabled/disabled in zone screen		  
					  objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							  objWeeklyPlanningGroupMangerApprovalObjects.SaveButton,
							  objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					  
					  Report_AddStep("testcase","In Zone screen edit the comment field : ", "", "" , "Pass");
						htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen edit the comment field ; ; ;Pass");
						
					//edit the fields in zone screen
					  objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
								objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.Comments,
								objWeeklyPlanningGroupMangerApprovalObjects.DeptName,objMonthlyPlanningStoreObjects.MPTable);
					  //get DB values for comments of zone screen
					  String ZoneMgrCmts = data.getText("ZoneMgrCmts");
					  DBValues5 =  sql.CLRexecuteQuery(getContext(),
							  ZoneMgrCmts.replace("Region", getContext().getStringProperty("Region")) 
							  	  .replace("Zone",getContext().getStringProperty("Zone"))
							  	  .replace("FinWeek", getContext().getStringProperty("FinWk")) 
							  	  .replace("FinYear",getContext().getStringProperty("Year")) 
							  	  .replace("Division",getContext().getStringProperty("Division")));
					  System.out.println("DB Value for zone manager comments: " + DBValues5);
					  //get comments of UI in zone screen
					  UIValues3 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable,
					  		extentTest, objWeeklyPlanningGroupMangerApprovalObjects.DeptName,
					  		objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					  
					  Report_AddStep("testcase","In Zone screen comparing UI and DB zone manager comments : ", "", "" , "Pass");
						htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen comparing UI and DB zone manager comments ; ; ;Pass");
					  
					  pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues5, UIValues3);
					  
					  Report_AddStep("testcase","In Zone screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
						htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
						
					//check if the fields are enabled/disabled in group screen
					  objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							  objWeeklyPlanningGroupMangerApprovalObjects.SaveButton,
							  objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					  
					  }
					 
				
				else {
					System.out.println("Planning is complete for all group");
					Report_AddStep("testcase","In Zone screen all store planning completion is done : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen all store planning completion is done ; ; ;Pass");
					
					this.click(objWeeklyPlanningGroupMangerApprovalObjects.selectGroup);
					Report_AddStep("testcase"," Click open 419 group : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " Click open 419 group ; ; ;Pass");
					
					//check plan completion is done or not in group by Db result
					String StorePlanCompletion = data.getText("StorePlanCompletion");
					DBValues6 = sql.CLRexecuteQuery(getContext(),
							StorePlanCompletion.replace("Region", getContext().getStringProperty("Region"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value for store plan completion: " + DBValues6);
					
					this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
					Report_AddStep("testcase","  Uncheck plan completion for 419 group : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " Uncheck plan completion for 419 group ; ; ;Pass");
					
					String GroupMgrPlanCompletion2 = data.getText("GroupMgrPlanCompletion");
					DBValues9 = sql.CLRexecuteQuery(getContext(),
							GroupMgrPlanCompletion.replace("Region", getContext().getStringProperty("Region"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value group plan completion: " + DBValues9);
					
					newDBValues= objWeeklyPlanningGroupMangerApprovalPO.checkApproval(DBValues9);
					
					if(newDBValues.get(2).equals("N"))
					{
						System.out.println("Plan complete checkbox for selected Group is unchecked");
						this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
						Report_AddStep("testcase","  check plan completion for the group : ", "", "" , "Pass");
						htmlToExtentTwo(cName,mName,extentTest,driver1, " check plan completion check-box for the group and go back to zone screen ; ; ;Pass");
					}
					
					if(newDBValues.get(2).equals("Y"))
					{
						System.out.println("Plan complete  checkbox for selected Group is checked");
						Report_AddStep("testcase","  Check plan completion for the group : ", "", "" , "Pass");
						htmlToExtentTwo(cName,mName,extentTest,driver1, " Check plan completion check-box for the group and go back to zone screen ; ; ;Pass");
					}
					
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.screenToView, "Zone");
					
					// select the required zone
					selectByVisibleText(objWeeklyPlanningGroupMangerApprovalObjects.selectZone, "R04 Z04");
					
					Report_AddStep("testcase","In Zone screen checking for the fields that are enabled and disabled : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen checking for the fields that are enabled and disabled ; ; ;Pass");
					
					//check the fields are enabled/disabled in zone screen
					objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					
					Report_AddStep("testcase","In Zone screen edit the comment field : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen edit the comment field ; ; ;Pass");
					
					//edit the fields in group screen
					objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.Comments,
							objWeeklyPlanningGroupMangerApprovalObjects.DeptName,objMonthlyPlanningStoreObjects.MPTable);
					
					String ZoneMgrCmts = data.getText("ZoneMgrCmts");
					DBValues7 = sql.CLRexecuteQuery(getContext(),
							ZoneMgrCmts.replace("Region", getContext().getStringProperty("Region"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value for zone manager comments: " + DBValues7);
					//list down the comments of UI in zone screen 
					UIValues4 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
							objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					Report_AddStep("testcase","In Zone screen comparing UI and DB zone manager comments : ", "", "" , "Pass");
					htmlToExtentTwo(cName,mName,extentTest,driver1, " In Zone screen comparing UI and DB zone manager comments ; ; ;Pass");
					
					//compare UI and DB comments in zone screen
					pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues7, UIValues4);
					
				}
		}
		}
			
	}
	
	@Test(priority = 2)
	public void LogoutCLRApplication() throws Exception {
		pageWeeklyPlanningPO = new WeeklyPlanningStorePage().createPage(getDriver(), getContext(), log, status, data,
				getReport(), getReportLogger(), WeeklyPlanningStorePage.class);
		pageWeeklyPlanningPO.LogOFF(objWeeklyPlanningStoreObjects);
		driver1.close();
	}
	
	
	@BeforeMethod
	public void setUpItemPrice(Method m, ITestContext testcontext) throws IOException {
		System.out.println("test1 - beforemethod");
		mName = m.getName().toString().trim();
		System.out.println(m.getName().toString().trim());
		if (!methodList.contains(m.getName().toString().trim())) {
			methodList.add(m.getName().toString().trim());
			extentTest = report.startTest(m.getName().toString().trim());
		}
		System.out.println(methodList.size());
		// initializeTestcontext();

		System.out.println("test1 - beforemethod");
		log.info("Loading Testdata for the test case: " + m.getName().toString());
		data.getTCNameFromChildren(m.getName().toString().trim());
		testcontext.setAttribute("WebDriver", getDriver());
		testcontext.setAttribute("Customreports", this.customreport);
		customreport.startTest(m.getName().toString());
		initializeTestStatus();
		reportPath = new File(getContext().getStringProperty("reportPath"));
		moduledesc = m.getName().toString().trim();
		dtmoduledesc = m.getAnnotation(Test.class).description();
		testcasesttime = new Date();
		pageWeeklyPlanningPO = PageFactory.initElements(this.getDriver(), WeeklyPlanningStorePage.class);
		objMonthlyPlanningStoreObjects = PageFactory.initElements(this.getDriver(), MonthlyPlanningStoreObjects.class);
		BaseObj = PageFactory.initElements(this.getDriver(), BasePage.class);
		common = PageFactory.initElements(this.getDriver(), CommonFunctions.class);
		storeprop = PageFactory.initElements(this.getDriver(), StoreProperties.class);
		objWeeklyPlanningStoreObjects = PageFactory.initElements(this.getDriver(), WeeklyPlanningStoreObjects.class);
		objWeeklyPlanningGroupMangerApprovalObjects = PageFactory.initElements(this.getDriver(), WeeklyPlanning_GroupManagerApprovalObjects.class);
		objWeeklyPlanningGroupMangerApprovalPO = PageFactory.initElements(this.getDriver(), WeeklyPlanning_GroupManagerApprovalPage.class);
		ScreenShotUtil = PageFactory.initElements(this.getDriver(), ExtentReportsScreenshotCode.class);
		System.out.println(System.getProperty("user.dir"));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy_hmmss");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate1 = dateFormat.format(date);
		System.out.println(formattedDate1); // 12/01/2011 4:48:16 PM
		String dat = formattedDate1;
		Report_Header("testcase", reportPath, moduledesc, dat);

	}

	@BeforeClass
	public void loadXMLFile() {
		try {
			cName = this.getClass().getSimpleName();
			reportPath = new File(getContext().getStringProperty("reportPath"));
			report = new ExtentReports(
					getContext().getStringProperty("reportPath") + "\\" + this.getClass().getSimpleName() + ".html");
			classList.add(this.getClass().getSimpleName());
			initializeTestcontext();
			sql.CLRConnectDB(context);
			System.out.println("test1 - Beforeclass");
			data = new XMLDataReader(log);
			customreport = new CustomExtentReports();
			createDriver(getContext().getStringProperty("WLPUrl"), getContext().getStringProperty("browser"), cName,
					mName, extentTest, driver1);
			log.info("Loading data for the class: ");
			data.loadTestDataXML(System.getProperty("user.dir") + "\\TestData\\WLP\\WeeklyPlanningGroup.xml");
			customreport.createExtentReport();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
