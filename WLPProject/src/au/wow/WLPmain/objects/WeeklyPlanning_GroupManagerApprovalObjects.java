package au.wow.WLPmain.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeeklyPlanning_GroupManagerApprovalObjects {

	@FindBy(id="frmDetails:chkCompleted")
	public WebElement ChkBox;
	
	
	@FindBy(id="frmDetails:button1")
	public WebElement SaveButton;
	
	
	@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:dynamic:commentsId']/textarea")
	public WebElement CommentField;
	
	
	@FindBy(xpath="//*[@id='frmDetails:ctrStorePlanningDetailsTable:2:oOrgDescinLink']")
	public WebElement EastGardenStore;
	
	
}
