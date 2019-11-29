package au.wow.WLPmain.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeeklyPlanning_GroupManagerApprovalObjects {

	@FindBy(id="frmDetails:chkCompleted")
	public WebElement ChkBox;
	
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement SaveButton;
	
	
	@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:2:text55']")
	public WebElement CommentField;
	
	
	@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:2:oOrgDescinLink']")
	public WebElement EastGardenStore;
	
	//@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:colOrgDesc' and style='color: red']")
	//public List<WebElement> DeptNameRed;
	
	public static final String Comments="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:commentsId']";
	
	public static final String DeptName="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:colOrgDesc']";
	
	public static final String DeptNameRed="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:colOrgDesc']";
}
