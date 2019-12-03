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

public class WeeklyPlanning_GroupManagerApprovalTest extends TestBase {

	protected Logger log = LogManager.getLogger(WeeklyPlanning_GroupManagerApprovalTest.class);
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
	List<List<Object>> DBValues, DBValues1, DBValues2, DBValues3,DBValues4,DBValues5,DBValues6,DBValues7,DBValues8;
	List<List<Object>> UIValues, UIValues1, UIValues2,UIValues3,UIValues4,UIValues5;
	String Week, Name, Year, YrName, LYYr, OptionToView, Wk, HWk1, HWk2, HWk3, HWk4;
	int LYYear, HistWk;
	String[] WeekName, YearName;

	public WeeklyPlanning_GroupManagerApprovalTest() {
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
		
		//check if plan completion checkbox is visible on zone screen
		if(this.isSelected(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox))
		{
			System.out.println("In Zone screen the plan complete Check-box is visible, so going back to Group for approval");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.screenToView, "Group");
			//check if the fields are enabled/disabled in group screen
			objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
			//get comments of group screen form DB
			String GrpMgrCmts = data.getText("GrpMgrCmts");
			DBValues = sql.CLRexecuteQuery(getContext(),
					GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
							.replace("Area", getContext().getStringProperty("Area"))
							.replace("Zone", getContext().getStringProperty("Zone"))
							.replace("FinWeek", getContext().getStringProperty("FinWk"))
							.replace("FinYear", getContext().getStringProperty("Year"))
							.replace("Division", getContext().getStringProperty("Division")));
			System.out.println("DB Value: " + DBValues);

			//Get comments of group screen from UI
			UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
					objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
			//compare UI and DB comments matching or not in group screen
			pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);

			}
		
		else {
			
			System.out.println("In Zone screen the plan complete Check-box is not visible, going back to group screen for approvals");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.screenToView, "Group");
			//check if checkbox is enabled/disabled in group screen
			if(this.isSelected(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox)) {
				System.out.println("In Group screen the plan complete check-box is Selected");
				//check if the fields are enabled/disabled in group screen
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				//get comment of group screen from DB
				String GrpMgrCmts = data.getText("GrpMgrCmts");
				DBValues2 = sql.CLRexecuteQuery(getContext(),
						GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value: " + DBValues2);
				//get comments of group screen from UI
				UIValues2 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				//Compare UI and DB comments matching or not in group screen
				pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues2, UIValues2);
				
			//toggle checkbox to disable	
			this.click(objWeeklyPlanningGroupMangerApprovalObjects.EastGardenStore);
			
			//check if the checkbox are enabled/disabled in store screen
			if(this.isSelected(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox)) {
				System.out.println("In Store screen the plan complete Check-box is selected");
				
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.screenToView, "Group");
				
				this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
				
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				//edit the fields and save in group screen
				objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.Comments,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName,objMonthlyPlanningStoreObjects.MPTable);
				
				UIValues3 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				
				//get updated DB comment for group screen
				DBValues3 = sql.CLRexecuteQuery(getContext(),
						GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value: " + DBValues3);
				//get updated UI comment for group screen
//				UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
//						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				//Compare DB and UI comments for group screen
				pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues3, UIValues3);
				
			}
				
			}
			
			else {
				System.out.println("In Group screen the plan complete Check-box is unchecked");
				//check if the fields are enabled/disabled in group screen
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				//Check DB comment for group screen
				String StorePlanCompletion = data.getText("StorePlanCompletion");
				DBValues4 = sql.CLRexecuteQuery(getContext(),
						StorePlanCompletion.replace("Region", getContext().getStringProperty("Region"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value: " + DBValues4);
				//check if plan complete for all stores by DB result, if not iterate and do plan completion
				List<String> newDBValues= objWeeklyPlanningGroupMangerApprovalPO.checkApproval(DBValues4);
				List<String> newDBValuesText= objWeeklyPlanningGroupMangerApprovalPO.checkApprovalTwo(DBValues4);
				if(newDBValues.contains("N")){
					//perform plan completion for unplanned stores
					objWeeklyPlanningGroupMangerApprovalPO.selectByVisibleText(extentTest,newDBValuesText,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects);
					
					DBValues5 = sql.CLRexecuteQuery(getContext(),
							StorePlanCompletion.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value: " + DBValues5);
					
					
					//check if the fields are enabled/disabled in group screen		  
					  objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,
					  objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					  objWeeklyPlanningGroupMangerApprovalObjects.SaveButton,
					  objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					//edit  the fields in group screen
					  objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
								objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.Comments,
								objWeeklyPlanningGroupMangerApprovalObjects.DeptName,objMonthlyPlanningStoreObjects.MPTable);
					  
					  
					  UIValues4 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
								objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					  //get DB values for comments of group screen
					  String GrpMgrCmts = data.getText("GrpMgrCmts");
					  DBValues6 =  sql.CLRexecuteQuery(getContext(),
						GrpMgrCmts.replace("Region", getContext().getStringProperty("Region")) 
							  	  .replace("Area",getContext().getStringProperty("Area"))
							  	  .replace("Zone",getContext().getStringProperty("Zone"))
							  	  .replace("FinWeek", getContext().getStringProperty("FinWk")) 
							  	  .replace("FinYear",getContext().getStringProperty("Year")) 
							  	  .replace("Division",getContext().getStringProperty("Division")));
					  System.out.println("DB Value: " + DBValues6);
					  //get comments of UI in group screen
//					  UIValues =
//					  pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable,
//					  extentTest, objWeeklyPlanningGroupMangerApprovalObjects.DeptName,
//					  objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					  pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues6, UIValues4);
					//check if the fields are enabled/disabled in group screen
					  objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,
					  objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					  objWeeklyPlanningGroupMangerApprovalObjects.SaveButton,
					  objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					  
					  }
					 
				
				else {
					System.out.println("Planning is complete for all stores");
					this.click(objWeeklyPlanningGroupMangerApprovalObjects.EastGardenStore);
					//check plan completion is done or not by Db result
					//String StorePlanCompletion = data.getText("StorePlanCompletion");
					DBValues7 = sql.CLRexecuteQuery(getContext(),
							StorePlanCompletion.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value: " + DBValues7);
					
					this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
					
					List<String> newDBValues2= objWeeklyPlanningGroupMangerApprovalPO.checkApproval(DBValues7);
					
					if(newDBValues2.get(1).equals("N"))
					{
						System.out.println("Plan complete checkbox for Eastgarden is unchecked");
						this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
					}
					
					if(newDBValues2.get(1).equals("Y"))
					{
						System.out.println("Plan complete  checkbox for Eastgarden is checked");
					}
					
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.screenToView, "Group");
					//check the fields are enabled/disabled in group screen
					objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					//edit the fields in group screen
					objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.Comments,
							objWeeklyPlanningGroupMangerApprovalObjects.DeptName,objMonthlyPlanningStoreObjects.MPTable);
					
					
					UIValues5 = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
							objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					
					String GrpMgrCmts = data.getText("GrpMgrCmts");
					DBValues8 = sql.CLRexecuteQuery(getContext(),
							GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value: " + DBValues8);
					//list down the comments of UI in group screen 
//					UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
//							objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					//compare UI and DB comments in group screen
					pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues8, UIValues5);
					
				}
		}
		}
			
	}
	
	@Test(priority = 2)
	public void LogoutCLRApplication() throws Exception {
		pageWeeklyPlanningPO = new WeeklyPlanningStorePage().createPage(getDriver(), getContext(), log, status, data,
				getReport(), getReportLogger(), WeeklyPlanningStorePage.class);
		pageWeeklyPlanningPO.LogOFF(objWeeklyPlanningStoreObjects);
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
