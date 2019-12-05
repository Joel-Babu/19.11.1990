package au.wow.WLPmain.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeeklyPlanning_GroupManagerApprovalObjects {

	@FindBy(xpath="//input[@id='frmDetails:chkCompleted' and @type='checkbox']")
	public WebElement ChkBox;
	
	
	@FindBy(xpath="//input[@value='Save Comments' and @name='frmDetails:button1']")
	public WebElement SaveButton;
	
	
	@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:2:text55']")
	public WebElement CommentField;
	
	@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:2:oOrgDescinLink']")
	public WebElement EastGardenStore;
	
	@FindBy(xpath= "//*[@id='main-menu']")
	public WebElement menuBar;
	
	@FindBy(xpath= "//*[@id='frmDetails:ctrStorePlanningDetailsTable:3:oOrgDescinLink']")
	public WebElement selectGroup;
	
	
	
	@FindBy(xpath= "//*[@id='frmDetails:ctrStorePlanningDetailsTable:cboLocation']")
	public WebElement selectZone;
	
	
	public final String planningScreens="//a[contains(text(),'Planning Screens')]";
	
	public final String weeklyPlanning="//a[contains(text(),'Weekly Planning')]";
	
	public final String screenToView="//li[a[contains(text(),'Weekly Planning')]]/ul/li[a[contains(text(),'dynamic')]]";
	
	public static final String Comments="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:text55']";
	
	public static final String DeptName="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:colOrgDesc']";
	
	public static final String DeptNameRed="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:colOrgDesc']";
}
