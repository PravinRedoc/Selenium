package pompckg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class google_pfc {

	@FindBy(id="lst-ib")
	public WebElement googleSearchField;
	
	@FindBy(id="hplogo")
	public WebElement googleLogo;
}
