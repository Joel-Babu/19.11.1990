package au.wow.WLPmain.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeeklyTradingStatementStoreObjects 
{
	@FindBy(xpath= "//span[@id='j_id_jsp_2073548615_0:status.start' and @style='display: none;']")
	public WebElement Spinner;
	
	@FindBy(xpath= "/html/frameset/frame[2]") 
	public WebElement DataFrame;
	
	@FindBy(xpath= "//*[@id='form1:buttonLogoff']")
	public WebElement Logoff;
	
	@FindBy(xpath= "/html/frameset/frame[1]")
	public WebElement TitleFrame;
	
	@FindBy(xpath= "//*[@id='lnktable']/tbody/tr/td/a[1]")
	public WebElement ZoneHyperLink;
	
	@FindBy(xpath= "//*[@id='lnktable']/tbody/tr/td/a[2]")
	public WebElement GroupHyperLink;
		
	public static final String Departments="//td[contains(@id,'form:table1:dynamic:j')][1]";	//department column
	public static final String TotalTitle="//td[contains(@id,'form:table1:dynamic:j')][1]";	//Store Total Text
	public static final String DataTable="//*[@id='form:table1']/tbody/tr";
	
//Sales										
	public static final String ActualSales="//td[contains(@id,'form:table1:dynamic:j')][2]";	//Actual Column
	public static final String PlannedSales="//td[contains(@id,'form:table1:dynamic:j')][3]/span[1]";	//Plan clm
	public static final String PlannedSalesGrwth="//td[contains(@id,'form:table1:dynamic:j')][3]/span[2]"; //�PLAN clm
	public static final String LYSales="//td[contains(@id,'form:table1:dynamic:j')][4]/span[1]"; //LAST YR clm
	public static final String LYSalesGrwth="//td[contains(@id,'form:table1:dynamic:j')][4]/span[2]"; //�%L/YR clm
	public static final String BudgetSales="//td[contains(@id,'form:table1:dynamic:j')][5]/span[1]";	//BUDGET clm
	public static final String BudgetSalesGrwth="//td[contains(@id,'form:table1:dynamic:j')][5]/span[2]";	//�BUD clm
	public static final String AvgBasketSales="//td[contains(@id,'form:table1:dynamic:j')][6]/span[1]";	//AVG BASKET$ clm
	public static final String Mix="//td[contains(@id,'form:table1:dynamic:j')][6]/span[2]";	//MIX clm
	
	public static final String ActualSalesTtl="//td[contains(@id,'form:table1:dynamic:j')][2]";	//Actual Total
	public static final String PlannedSalesTtl="//td[contains(@id,'form:table1:dynamic:j')][3]/span[1]";	//Plan Total
	public static final String PlannedSalesGrwthTtl="//td[contains(@id,'form:table1:dynamic:j')][3]/span[2]";	//�PLAN Total	
	public static final String LYSalesTtl="//td[contains(@id,'form:table1:dynamic:j')][4]/span[1]";	//LAST YR Total
	public static final String LYSalesGrwthTtl="//td[contains(@id,'form:table1:dynamic:j')][4]/span[2]";	//�%L/YR Total
	public static final String BudgetSalesTtl="//td[contains(@id,'form:table1:dynamic:j')][5]/span[1]";	//BUDGET Total
	public static final String BudgetSalesGrwthTtl="//td[contains(@id,'form:table1:dynamic:j')][5]/span[2]";	//�BUD Total
	public static final String AvgBasketSalesTtl="//td[contains(@id,'form:table1:dynamic:j')][6]/span[1]";	//AVG BASKET$ Total
	public static final String MixTtl="//td[contains(@id,'form:table1:dynamic:j')][6]/span[2]";	//MIX Total

//Items and ItemPrice
	public static final String PlannedItem="//td[contains(@id,'form:table1:dynamic:j')][7]/span[1]";	//ITEM PLAN column
	public static final String ActualItem="//td[contains(@id,'form:table1:dynamic:j')][7]/span[2]";	//ITEM ACTUAL clm
	public static final String PlannedItemPrice="//td[contains(@id,'form:table1:dynamic:j')][8]/span[1]";	//ITEM PRICE PLAN clm
	public static final String ActualItemPrice="//td[contains(@id,'form:table1:dynamic:j')][8]/span[2]";	//ITEM PRICE ACTUAL clm

	public static final String PlannedItemTtl="//td[contains(@id,'form:table1:dynamic:j')][7]/span[1]";	//ITEM PLAN total
	public static final String ActualItemTtl="//td[contains(@id,'form:table1:dynamic:j')][7]/span[2]";	//ITEM ACTUAL total
	public static final String PlannedItemPriceTtl="//td[contains(@id,'form:table1:dynamic:j')][8]/span[1]";	//ITEM PRICE PLAN total
	public static final String ActualItemPriceTtl="//td[contains(@id,'form:table1:dynamic:j')][8]/span[2]";	//ITEM PRICE ACTUAL total
	
//Customers
	public static final String ThisYrCustomer="//td[contains(@id,'form:table1:dynamic:j')][9]";
	public static final String PercentageLastCustomer="//td[contains(@id,'form:table1:dynamic:j')][10]/span[1]";
	public static final String DeptPenetrationCustomer="//td[contains(@id,'form:table1:dynamic:j')][10]/span[3]";
	
	public static final String ThisYrCustomerTtl="//td[contains(@id,'form:table1:dynamic:j')][9]";
	public static final String PercentageLastCustomerTtl="//td[contains(@id,'form:table1:dynamic:j')][10]/span[1]";
	public static final String DeptPenetrationCustomerTtl="//td[contains(@id,'form:table1:dynamic:j')][10]/span[3]";
	
//Hours
	public static final String ActualHours="//td[contains(@id,'form:table1:dynamic:j')][11]/span[1]";
	public static final String VarSMSHours="//td[contains(@id,'form:table1:dynamic:j')][11]/span[2]";
	public static final String PlannedHours="//td[contains(@id,'form:table1:dynamic:j')][12]/span[1]";
	public static final String VarPlannedHours="//td[contains(@id,'form:table1:dynamic:j')][12]/span[2]";
	public static final String ActualSMSHours="//td[contains(@id,'form:table1:dynamic:j')][13]/span[1]";
	public static final String ORPercentageHours="//td[contains(@id,'form:table1:dynamic:j')][13]/span[2]";
	
	public static final String ActualHoursTtl="//td[contains(@id,'form:table1:dynamic:j')][11]/span[1]";
	public static final String VarSMSHoursTtl="//td[contains(@id,'form:table1:dynamic:j')][11]/span[2]";
	public static final String PlannedHoursTtl="//td[contains(@id,'form:table1:dynamic:j')][12]/span[1]";
	public static final String VarPlannedHoursTtl="//td[contains(@id,'form:table1:dynamic:j')][12]/span[2]";
	public static final String ActualSMSHoursTtl="//td[contains(@id,'form:table1:dynamic:j')][13]/span[1]";
	public static final String ORPercentageHoursTtl="//td[contains(@id,'form:table1:dynamic:j')][13]/span[2]";
	
	//Wages
		public static final String PlannedCPHWages="//td[contains(@id,'form:table1:dynamic:j')][17]";
		//public static final String PlannedCPHWages="//td[contains(@id,'form:table1:dynamic:j')][16]";
		public static final String ActualWages="//td[contains(@id,'form:table1:dynamic:j')][14]/span[1]";
		public static final String ActualWagesPercentage="//td[contains(@id,'form:table1:dynamic:j')][14]/span[2]";
		public static final String BudgetWages="//td[contains(@id,'form:table1:dynamic:j')][15]/span[1]";
		public static final String BudgetWagesPercentage="//td[contains(@id,'form:table1:dynamic:j')][15]/span[2]";
		public static final String PlannedWages="//td[contains(@id,'form:table1:dynamic:j')][18]/span[1]";
		//public static final String PlannedWages="//td[contains(@id,'form:table1:dynamic:j')][17]/span[1]";
		public static final String PlannedWagesPercentage="//td[contains(@id,'form:table1:dynamic:j')][18]/span[2]";
		//public static final String PlannedWagesPercentage="//td[contains(@id,'form:table1:dynamic:j')][17]/span[2]";
		public static final String AllowedWages="//td[contains(@id,'form:table1:dynamic:j')][16]";
		public static final String CPHWages="//td[contains(@id,'form:table1:dynamic:j')][19]/span[1]";
		//public static final String CPHWages="//td[contains(@id,'form:table1:dynamic:j')][18]/span[1]";
		public static final String VarBudgetWages="//td[contains(@id,'form:table1:dynamic:j')][19]/span[2]";
		//public static final String VarBudgetWages="//td[contains(@id,'form:table1:dynamic:j')][18]/span[2]";
		
		public static final String PlannedCPHWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][17]";
		//public static final String PlannedCPHWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][16]";
		public static final String ActualWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][14]/span[1]";
		public static final String ActualWagesPercentageTtl="//td[contains(@id,'form:table1:dynamic:j')][14]/span[2]";
		public static final String BudgetWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][15]/span[1]";
		public static final String BudgetWagesPercentageTtl="//td[contains(@id,'form:table1:dynamic:j')][15]/span[2]";
	public static final String PlannedWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][18]/span[1]";
		//public static final String PlannedWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][17]/span[1]";
	    public static final String PlannedWagesPercentageTtl="//td[contains(@id,'form:table1:dynamic:j')][18]/span[2]";
		//public static final String PlannedWagesPercentageTtl="//td[contains(@id,'form:table1:dynamic:j')][17]/span[2]";
		public static final String AllowedWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][16]";
		public static final String CPHWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][19]/span[1]";
		//public static final String CPHWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][18]/span[1]";
		public static final String VarBudgetWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][19]/span[2]";
		//public static final String VarBudgetWagesTtl="//td[contains(@id,'form:table1:dynamic:j')][18]/span[2]";
		//Wages Modified
			public static final String PlannedCPHWageswts="//td[contains(@id,'form:table1:dynamic:j')][18]";
			//public static final String PlannedCPHWageswts="//td[contains(@id,'form:table1:dynamic:j')][17]";
			public static final String ActualWageswts="//td[contains(@id,'form:table1:dynamic:j')][14]/span[1]";
			public static final String ActualWagesPercentagewts="//td[contains(@id,'form:table1:dynamic:j')][14]/span[2]";
			public static final String BudgetWageswts="//td[contains(@id,'form:table1:dynamic:j')][16]/span[1]";
			public static final String BudgetWagesPercentagewts="//td[contains(@id,'form:table1:dynamic:j')][16]/span[2]";
			public static final String PlannedWageswts="//td[contains(@id,'form:table1:dynamic:j')][15]/span[1]";
			public static final String PlannedWagesPercentagewts="//td[contains(@id,'form:table1:dynamic:j')][15]/span[2]";
			public static final String AllowedWageswts="//td[contains(@id,'form:table1:dynamic:j')][17]";
			public static final String CPHWageswts="//td[contains(@id,'form:table1:dynamic:j')][19]";
		//public static final String CPHWageswts="//td[contains(@id,'form:table1:dynamic:j')][18]";
			public static final String VarBudgetWageswts="//td[contains(@id,'form:table1:dynamic:j')][19]/span[2]";
			
			public static final String PlannedCPHWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][18]";
			//public static final String PlannedCPHWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][17]";
			public static final String ActualWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][14]/span[1]";
			public static final String ActualWagesPercentageTtlwts="//td[contains(@id,'form:table1:dynamic:j')][14]/span[2]";
			public static final String BudgetWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][16]/span[1]";
			public static final String BudgetWagesPercentageTtlwts="//td[contains(@id,'form:table1:dynamic:j')][16]/span[2]";
			public static final String PlannedWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][15]/span[1]";
			public static final String PlannedWagesPercentageTtlwts="//td[contains(@id,'form:table1:dynamic:j')][15]/span[2]";
			public static final String AllowedWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][17]";
			public static final String CPHWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][19]";
			//public static final String CPHWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][18]";
			public static final String VarBudgetWagesTtlwts="//td[contains(@id,'form:table1:dynamic:j')][19]/span[2]";
	
	//New Table
	public static final String Weeks="//td[contains(@id,'form:table2:dynamic:j')][1]";	//department column
	public static final String MonthTotal="//td[contains(@id,'form:table2:j')][1]";	//Store Total Text
	public static final String Table="//*[@id='form:table2']/tbody/tr";
	
	//Monthly Data Table - Sales
	public static final String ActualSalesNew = "//td[contains(@id,'form:table2:dynamic:j')][5]";
	public static final String ActualSalesTtlNew = "//td[contains(@id,'form:table2:j')][5]";
	public static final String WeeklyPlannedSales = "//td[contains(@id,'form:table2:dynamic:j')][4]";
	public static final String WeeklyPlannedSalesTtl = "//td[contains(@id,'form:table2:j')][4]";
	public static final String MonthlyPlannedSales = "//td[contains(@id,'form:table2:dynamic:j')][3]";
	public static final String MonthlyPlannedSalesTtl = "//td[contains(@id,'form:table2:j')][3]";
	public static final String BudgetSalesNew = "//td[contains(@id,'form:table2:dynamic:j')][2]";
	public static final String BudgetSalesTtlNew = "//td[contains(@id,'form:table2:j')][2]";
	public static final String ForecastSalesNew = "//td[contains(@id,'form:table2:dynamic:j')][2]";
	public static final String ForecastSalesTtlNew="//td[contains(@id,'form:table2:j')][2]";
		
	//Monthly Data Table - Wages
	public static final String ActualWagesNew = "//td[contains(@id,'form:table2:dynamic:j')][9]";
	public static final String ActualWagesTtlNew = "//td[contains(@id,'form:table2:j')][9]";
	public static final String WeeklyPlannedWages = "//td[contains(@id,'form:table2:dynamic:j')][8]";
	public static final String WeeklyPlannedWagesTtl = "//td[contains(@id,'form:table2:j')][8]";
	public static final String MonthlyPlannedWages = "//td[contains(@id,'form:table2:dynamic:j')][7]";
	public static final String MonthlyPlannedWagesTtl = "//td[contains(@id,'form:table2:j')][7]";
	public static final String BudgetWagesNew = "//td[contains(@id,'form:table2:dynamic:j')][6]";
	public static final String BudgetWagesTtlNew = "//td[contains(@id,'form:table2:j')][6]";
	public static final String ForecastWagesNew = "//td[contains(@id,'form:table2:dynamic:j')][6]";
	public static final String ForecastWagesTtlNew = "//td[contains(@id,'form:table2:j')][6]";

	//Monthly Data Table - Wages %
	public static final String ActualWagePerNew = "//td[contains(@id,'form:table2:dynamic:j')][13]";
	public static final String ActualWagePerTtlNew = "//td[contains(@id,'form:table2:j')][13]";
	public static final String WeeklyPlannedWagePer = "//td[contains(@id,'form:table2:dynamic:j')][12]";
	public static final String WeeklyPlannedWagePerTtl = "//td[contains(@id,'form:table2:j')][12]";
	public static final String MonthlyPlannedWagePer = "//td[contains(@id,'form:table2:dynamic:j')][11]";
	public static final String MonthlyPlannedWagePerTtl = "//td[contains(@id,'form:table2:j')][11]";
	public static final String BudgetWagePerNew = "//td[contains(@id,'form:table2:dynamic:j')][10]";
	public static final String BudgetWagePerTtlNew = "//td[contains(@id,'form:table2:j')][10]";
	public static final String ForecastWagePerNew = "//td[contains(@id,'form:table2:dynamic:j')][10]";
	public static final String ForecastWagePerTtlNew = "//td[contains(@id,'form:table2:j')][10]";

	//Monthly Data Table - OR
	public static final String ActualORNew = "//td[contains(@id,'form:table2:dynamic:j')][16]";
	public static final String ActualORTtlNew = "//td[contains(@id,'form:table2:j')][16]";
	public static final String WeeklyPlannedOR = "//td[contains(@id,'form:table2:dynamic:j')][15]";
	public static final String WeeklyPlannedORTtl = "//td[contains(@id,'form:table2:j')][15]";
	public static final String MonthlyPlannedOR = "//td[contains(@id,'form:table2:dynamic:j')][14]";
	public static final String MonthlyPlannedORTtl = "//td[contains(@id,'form:table2:j')][14]";

	//CPH
	public static final String ActualCPHNew = "//td[contains(@id,'form:table2:dynamic:j')][19]";
	public static final String ActualCPHTtlNew = "//td[contains(@id,'form:table2:j')][19]";
	public static final String WeeklyPlannedCPH = "//td[contains(@id,'form:table2:dynamic:j')][18]";
	public static final String WeeklyPlannedCPHTtl = "//td[contains(@id,'form:table2:j')][18]";
	public static final String MonthlyPlannedCPH = "//td[contains(@id,'form:table2:dynamic:j')][17]";
	public static final String MonthlyPlannedCPHTtl = "//td[contains(@id,'form:table2:j')][17]";
	
	
	
	/////////////////////////PST 1073//////////////////////////////////////////////
	
	//public static final String LLTitle="//td[contains(@id,'form:table1:16:j_idt281')]";	//Longlife
	//public static final String SDTitle="//td[contains(@id,'form:table1:0:j_idt281')]";	//Seafood
	//Sales///
	//public static final String ActualSalesLL="//td[contains(@id,'form:table1:16:j_idt286')]";	//Actual salesLonglife
	//public static final String ActualSalesSD="//td[contains(@id,'form:table1:17:j_idt286')]";	//Actual sales Seafood
	
	public static final String PlannedSalesLL="//td[contains(@id,'form:table1:16:j_idt289')]/span[1]";	//Planned sales Longlife
	public static final String PlannedSalesSD="//td[contains(@id,'form:table1:17:j_idt289')]/span[1]";	// Planned sales Seafood
	public static final String PlannedSalesGrwthLL="//td[contains(@id,'form:table1:16:j_idt289')]/span[2]";	//�PLAN Longlife
	public static final String PlannedSalesGrwthSD="//td[contains(@id,'form:table1:17:j_idt289')]/span[2]";	//�PLAN Seafood
	public static final String LYSalesLL="//td[contains(@id,'form:table1:16:j_idt295')]/span[1]";	//LAST YR  Longlife
	public static final String LYSalesSD="//td[contains(@id,'form:table1:17:j_idt295')]/span[1]";	//LAST YR  Seafood
	public static final String LYSalesGrwthLL="//td[contains(@id,'form:table1:16:j_idt295')]/span[2]";	//�%L/YR Longlife
	public static final String LYSalesGrwthSD="//td[contains(@id,'form:table1:17:j_idt295')]/span[2]";	//�%L/YR Seafood
	public static final String BudgetSalesLL="//td[contains(@id,'form:table1:16:j_idt301')]/span[1]";	//BUDGET Longlife
	public static final String BudgetSalesSD="//td[contains(@id,'form:table1:17:j_idt301')]/span[1]";	//BUDGET Seafood
	public static final String BudgetSalesGrwthLL="//td[contains(@id,'form:table1:16:j_idt301')]/span[2]";	//�BUD Longlife
	public static final String BudgetSalesGrwthSD="//td[contains(@id,'form:table1:17:j_idt301')]/span[2]";	//�BUD Seafood
	public static final String AvgBasketSalesLL="//td[contains(@id,'form:table1:16:j_idt305')]/span[1]";	//AVG BASKET$ Longlife
	//public static final String AvgBasketSalesSD="//td[contains(@id,'form:table1:17:j_idt305')]/span[1]";	//AVG BASKET$ Seafood
	public static final String MixLL="//td[contains(@id,'form:table1:16:j_idt305')]/span[2]";	//MIX Longlife
	//public static final String MixSD="//td[contains(@id,'form:table1:17:j_idt305')]/span[2]";	//MIX Seafood
	
	///Items & Item Price/////////////////////////////////////////////////////////////////////////////////////////
	
	public static final String PlannedItemLL="//td[contains(@id,'form:table1:16:j_idt311')]/span[1]";	//ITEM PLAN Longlife
	//public static final String PlannedItemSD="//td[contains(@id,'form:table1:17:j_idt311')]/span[1]";	//ITEM PLAN Seafood
	public static final String ActualItemLL="//td[contains(@id,'form:table1:16:j_idt311')]/span[2]";	//ITEM ACTUAL Longlife
	//public static final String ActualItemSD="//td[contains(@id,'form:table1:17:j_idt311')]/span[2]";	//ITEM ACTUAL Seafood
	public static final String PlannedItemPriceLL="//td[contains(@id,'form:table1:16:j_idt315')]/span[1]";	//ITEM PRICE PLAN Longlife
	//public static final String PlannedItemPriceSD="//td[contains(@id,'form:table1:17:j_idt315')]/span[1]";	//ITEM PRICE PLAN Seafood
	public static final String ActualItemPriceLL="//td[contains(@id,'form:table1:16:j_idt315')]/span[2]";	//ITEM PRICE ACTUAL Longlife
	//public static final String ActualItemPriceSD="//td[contains(@id,'form:table1:17:j_idt315')]/span[2]";	//ITEM PRICE ACTUAL Seafood
	
	////////////////Customers/////////////////////////////////////////////////////////////////////////////////
	
	public static final String ThisYrCustomerLL="//td[contains(@id,'form:table1:16:j_idt319')]"; //This year customer Longlife
	//public static final String ThisYrCustomerSD="//td[contains(@id,'form:table1:17:j_idt319')]"; //This year customer Seafood
	public static final String PercentageLastCustomerLL="//td[contains(@id,'form:table1:16:j_idt321')]/span[1]"; //LYpercustomer Longlife
	//public static final String PercentageLastCustomerSD="//td[contains(@id,'form:table1:17:j_idt321')]/span[1]"; //LYpercustomer Seafood
	public static final String DeptPenetrationCustomerLL="//span[contains(@id,'form:table1:16:text41')]";//DeptPenetration Longlife
	//public static final String DeptPenetrationCustomerSD="//span[contains(@id,'form:table1:17:text41')]";//DeptPenetration Seafood
	
	/////////////////////////Hours///////////////////////////////////////////////////
	public static final String ActualHoursLL="//td[contains(@id,'form:table1:16:j_idt329')]/span[1]";//ActualHours Longlife
	public static final String ActualHoursSD="//td[contains(@id,'form:table1:17:j_idt329')]/span[1]";//ActualHours Seafood
	public static final String VarSMSHoursLL="//td[contains(@id,'form:table1:16:j_idt329')]/span[2]"; //VarSMSHours Longlife
	public static final String VarSMSHoursSD="//td[contains(@id,'form:table1:17:j_idt329')]/span[2]"; //VarSMSHours Seafood
	public static final String PlannedHoursLL="//td[contains(@id,'form:table1:16:j_idt333')]/span[1]"; //PlannedHours Longlife
	public static final String PlannedHoursSD="//td[contains(@id,'form:table1:17:j_idt333')]/span[1]"; //PlannedHours Seafood
	public static final String VarPlannedHoursLL="//td[contains(@id,'form:table1:16:j_idt333')]/span[2]"; //VarPlanned Longlife
	public static final String VarPlannedHoursSD="//td[contains(@id,'form:table1:17:j_idt333')]/span[2]";//VarPlanned Seafood
	public static final String ActualSMSHoursLL="//td[contains(@id,'form:table1:16:j_idt337')]/span[1]"; //ActualSMSHours Longlife
	public static final String ActualSMSHoursSD="//td[contains(@id,'form:table1:17:j_idt337')]/span[1]"; //ActualSMSHours Seafood
	public static final String ORPercentageHoursLL="//td[contains(@id,'form:table1:16:j_idt337')]/span[2]"; //ORPercentageHours Longlife
	public static final String ORPercentageHoursSD="//td[contains(@id,'form:table1:17:j_idt337')]/span[2]"; //ORPercentageHours Seafood
	
	///////////////////////////////Wages/////////////////////////////////////////////////////////////////////////////////
	public static final String ActualWagesLL="//td[contains(@id,'form:table1:16:j_idt344')]/span[1]";
	public static final String ActualWagesSD="//td[contains(@id,'form:table1:17:j_idt344')]/span[1]";
	public static final String ActualWagesPercentageLL="//td[contains(@id,'form:table1:16:j_idt344')]/span[2]";
	public static final String ActualWagesPercentageSD="//td[contains(@id,'form:table1:17:j_idt344')]/span[2]";
	
	
	
	public static final String BudgetWagesLL="//td[contains(@id,'form:table1:16:j_idt356')]/span[1]";
	public static final String BudgetWagesSD="//td[contains(@id,'form:table1:17:j_idt356')]/span[1]";
	public static final String BudgetWagesPercentageLL="//td[contains(@id,'form:table1:16:j_idt356')]/span[2]";
	public static final String BudgetWagesPercentageSD="//td[contains(@id,'form:table1:17:j_idt356')]/span[2]";
	
	public static final String PlannedWagesLL="//td[contains(@id,'form:table1:16:j_idt350')]/span[1]";
	public static final String PlannedWagesSD="//td[contains(@id,'form:table1:17:j_idt350')]/span[1]";	
	public static final String PlannedWagesPercentageLL="//td[contains(@id,'form:table1:16:j_idt350')]/span[2]";
	public static final String PlannedWagesPercentageSD="//td[contains(@id,'form:table1:17:j_idt350')]/span[2]";
	
	
	public static final String AllowedWagesLL="//td[contains(@id,'form:table1:16:j_idt364')]";
	public static final String AllowedWagesSD="//td[contains(@id,'form:table1:17:j_idt364')]";
	
	public static final String PlannedCPHWagesLL="//td[contains(@id,'form:table1:16:j_idt366')]";
	public static final String PlannedCPHWagesSD="//td[contains(@id,'form:table1:17:j_idt366')]";
	
	public static final String CPHWagesLL="//td[contains(@id,'form:table1:16:j_idt382')]";
	public static final String CPHWagesSD="//td[contains(@id,'form:table1:17:j_idt382')]";
	
	public static final String ActualWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt344')]/span[1]";
	public static final String ActualWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt344')]/span[1]";
	public static final String ActualWagesPercentagemtsLL="//td[contains(@id,'form:table1:16:j_idt344')]/span[2]";
	public static final String ActualWagesPercentagemtsSD="//td[contains(@id,'form:table1:17:j_idt344')]/span[2]";
	
	public static final String PlannedWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt368')]/span[1]";
	public static final String PlannedWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt368')]/span[1]";	
	public static final String PlannedWagesPercentagemtsLL="//td[contains(@id,'form:table1:16:j_idt368')]/span[2]";
	public static final String PlannedWagesPercentagemtsSD="//td[contains(@id,'form:table1:17:j_idt368')]/span[2]";
	
	public static final String BudgetWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt356')]/span[1]";
	public static final String BudgetWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt356')]/span[1]";
	public static final String BudgetWagesPercentagemtsLL="//td[contains(@id,'form:table1:16:j_idt356')]/span[2]";
	public static final String BudgetWagesPercentagemtsSD="//td[contains(@id,'form:table1:17:j_idt356')]/span[2]";
	
	
	public static final String AllowedWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt364')]";
	public static final String AllowedWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt364')]";
	
	public static final String PlannedCPHWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt366')]";
	public static final String PlannedCPHWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt366')]";
	
	public static final String CPHWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt374')]/span[1]";
	public static final String CPHWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt374')]/span[1]";
	
	public static final String VarBudgetWagesmtsLL="//td[contains(@id,'form:table1:16:j_idt374')]/span[2]";
	public static final String VarBudgetWagesmtsSD="//td[contains(@id,'form:table1:17:j_idt374')]/span[2]";
	
	
}