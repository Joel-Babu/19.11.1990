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
	List<List<Object>> DBValues, DBValues1, DBValues2, DBValues3, DBValues4, DBValues5, DBTotal, DBTotal1, DBTotal2,
			DBTotal3, DBTotal4, DBTotal5, DBPstive, DBNgtive;
	List<List<Object>> UIValues, UIValues1, UIValues2, UIValues3, UIValues4, UIValues5, UITotal, UITotal1, UITotal2,
			UITotal3, UITotal4, UITotal5;
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
		
		pageWeeklyPlanningPO = new WeeklyPlanning_GroupManagerApprovalPage().createPage(getDriver(), getContext(), log, status, data,
				getReport(), getReportLogger(), WeeklyPlanningStorePage.class);
//		pageMonthlyPlanningGroupPO = new MonthlyPlanningGroupPage().createPage(getDriver(), getContext(), log, status,
//				data, getReport(), getReportLogger(), MonthlyPlanningGroupPage.class);
		TestStatus status = getTestStatus();
		System.out.println("Entering into TestCase");
		pageWeeklyPlanningPO.SelectWeekFromDropdown(objWeeklyPlanningStoreObjects, extentTest,
				getContext().getStringProperty("SelectFiscalWeek"));
		
		pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
				objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
		pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
				objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
		pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
				objWeeklyPlanningStoreObjects.screenToView, "Group");
		
		//check if plan completion checkbox is visible on screen
		if(!this.isDisplayed(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox))
		{
			System.out.println("In Zone screen the Check-box is visible");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.screenToView, "Group");
			//check if the fields are enabled/disabled
			objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
			String GrpMgrCmts = data.getText("GrpMgrCmts");
			DBValues = sql.CLRexecuteQuery(getContext(),
					GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
							.replace("Area", getContext().getStringProperty("Area"))
							.replace("Zone", getContext().getStringProperty("Zone"))
							.replace("FinWeek", getContext().getStringProperty("FinWk"))
							.replace("FinYear", getContext().getStringProperty("Year"))
							.replace("Division", getContext().getStringProperty("Division")));
			System.out.println("DB Value: " + DBValues);

//			String SalesHistoryTotal = data.getText("SalesHistoryTotal");
//			DBTotal = sql.CLRexecuteQuery(getContext(),
//					SalesHistoryTotal.replace("Region", getContext().getStringProperty("Region"))
//							.replace("Area", getContext().getStringProperty("Area"))
//							.replace("Zone", getContext().getStringProperty("Zone")).replace("FinWeek", Week)
//							.replace("FinYear", getContext().getStringProperty("Year"))
//							.replace("Division", getContext().getStringProperty("Division")));
//			System.out.println("DB Total: " + DBTotal);

			UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
					objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
			pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);

//			UITotal = pageMonthlyPlanningGroupPO.WPGetTotal(extentTest, MonthlyPlanningGroupObjects.RowNameTotal,
//					WeeklyPlanningStoreObjects.FirstWeekofMonth);
//			pageMonthlyPlanningPO.CompareValues(extentTest, DBTotal, UITotal);
			}
		
		else {
			
			System.out.println("In Zone screen the Check-box is not visible");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
			pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
					objWeeklyPlanningStoreObjects.screenToView, "Group");
			//check if checkbix is enabled/disabled
			if(this.isEnabled(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox)) {
				System.out.println("In Group screen the Check-box is Enabled");
				//check if the fields are enabled/disabled
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
					objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
				String GrpMgrCmts = data.getText("GrpMgrCmts");
				DBValues = sql.CLRexecuteQuery(getContext(),
						GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value: " + DBValues);
				
				UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);
				
			//toggle checkbox to disable	
			this.click(objWeeklyPlanningGroupMangerApprovalObjects.EastGardenStore);
			
			//check if the checkbox are enabled/disabled
			if(this.isEnabled(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox)) {
				System.out.println("In Store screen the Check-box is Enabled");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
				pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
						objWeeklyPlanningStoreObjects.screenToView, "Group");
				
				//this.click(objWeeklyPlanningGroupMangerApprovalObjects.EastGardenStore);
				//check if the fields are enabled/disabled
				objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
				
				DBValues = sql.CLRexecuteQuery(getContext(),
						GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value: " + DBValues);
				
				UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
						objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
				pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);
				
			}
				
			}
			
			else {
				System.out.println("In Group screen the Check-box is disabled");
				//check if the fields are enabled/disabled
				objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
						objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
				
				String StorePlanCompletion = data.getText("StorePlanCompletion");
				DBValues = sql.CLRexecuteQuery(getContext(),
						StorePlanCompletion.replace("Region", getContext().getStringProperty("Region"))
								.replace("Area", getContext().getStringProperty("Area"))
								.replace("Zone", getContext().getStringProperty("Zone"))
								.replace("FinWeek", getContext().getStringProperty("FinWk"))
								.replace("FinYear", getContext().getStringProperty("Year"))
								.replace("Division", getContext().getStringProperty("Division")));
				System.out.println("DB Value: " + DBValues);
				
				List<String> newDBValues= objWeeklyPlanningGroupMangerApprovalPO.checkApproval(DBValues);
				if(newDBValues.contains("N")){
					List<String> newDBValuesTwo= objWeeklyPlanningGroupMangerApprovalPO.checkApprovalTwo(DBValues);
					int arrSize = newDBValuesTwo.size();
					for(int i =0;i<arrSize;i++)
					{
						String elementOne= newDBValuesTwo.get(i);
						
						String s1= this.getAttribute(objWeeklyPlanningGroupMangerApprovalObjects.DeptName);
						if(elementOne.equals(objWeeklyPlanningGroupMangerApprovalObjects.DeptName))
						{
						this.click(objWeeklyPlanningGroupMangerApprovalObjects.DeptNameRed);
						this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
						this.click(objWeeklyPlanningGroupMangerApprovalObjects.SaveButton);
						
						pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
								objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
						pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
								objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
						pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
								objWeeklyPlanningStoreObjects.screenToView, "Group");
					}
					
					objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
						
					objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					
					String GrpMgrCmts = data.getText("GrpMgrCmts");
					DBValues = sql.CLRexecuteQuery(getContext(),
							GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value: " + DBValues);
					
					UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
							objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);
					
					objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
						
				}
				else {
					this.click(objWeeklyPlanningGroupMangerApprovalObjects.EastGardenStore);
					
					//String StorePlanCompletion = data.getText("StorePlanCompletion");
					DBValues = sql.CLRexecuteQuery(getContext(),
							StorePlanCompletion.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value: " + DBValues);
					
					this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
					
					newDBValues= objWeeklyPlanningGroupMangerApprovalPO.checkApproval(DBValues);
					
					if(newDBValues.get(1).equals("N"))
					{
						System.out.println("Plan complete unchecked");
						this.click(objWeeklyPlanningGroupMangerApprovalObjects.ChkBox);
					}
					
					if(newDBValues.get(1).equals("Y"))
					{
						System.out.println("Plan complete checked");
					}
					
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.planningScreens, "Planning Screens");
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.weeklyPlanning, "Weekly Planning");
					pageWeeklyPlanningPO.selectPage(extentTest, objWeeklyPlanningStoreObjects.menuBar,
							objWeeklyPlanningStoreObjects.screenToView, "Group");
					
					objWeeklyPlanningGroupMangerApprovalPO.Checklist(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					
					objWeeklyPlanningGroupMangerApprovalPO.EditFields(extentTest,objWeeklyPlanningGroupMangerApprovalObjects.ChkBox,
							objWeeklyPlanningGroupMangerApprovalObjects.SaveButton, objWeeklyPlanningGroupMangerApprovalObjects.CommentField);
					
					String GrpMgrCmts = data.getText("GrpMgrCmts");
					DBValues = sql.CLRexecuteQuery(getContext(),
							GrpMgrCmts.replace("Region", getContext().getStringProperty("Region"))
									.replace("Area", getContext().getStringProperty("Area"))
									.replace("Zone", getContext().getStringProperty("Zone"))
									.replace("FinWeek", getContext().getStringProperty("FinWk"))
									.replace("FinYear", getContext().getStringProperty("Year"))
									.replace("Division", getContext().getStringProperty("Division")));
					System.out.println("DB Value: " + DBValues);
					
					UIValues = pageWeeklyPlanningPO.UIResults(objMonthlyPlanningStoreObjects.MPTable, extentTest,
							objWeeklyPlanningGroupMangerApprovalObjects.DeptName, objWeeklyPlanningGroupMangerApprovalObjects.Comments);
					pageWeeklyPlanningPO.CompareValuesText(extentTest, DBValues, UIValues);
					
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
