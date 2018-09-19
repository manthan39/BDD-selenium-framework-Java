package locators;

/**
 * @author mvbhatiya
 *
 */
public interface HomepageLocator {

	public interface IautoLocator {

		String usernamefield = ".//*[@id='username']";
		String passwordfield = ".//*[@id='password']";
		String username_mandatory = "//div/div/input";
		String loginBtn = "//button";
		String LogoutBtn = "//a[contains(text(),'Logout')]";
		String InvalidMsgTxt = "html/body/div[3]/div/div/div/div[2]";
	}
}
