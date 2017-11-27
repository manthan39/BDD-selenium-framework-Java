package locators;

public interface HomepageLocator{

	public interface IautoLocator  {

		String usernamefield = ".//*[@id='username']";
		String passwordfield = ".//*[@id='password']";
		String username_mandatory=".//*[@id='formly_1_input_username_0']";
		String loginBtn=".btn.btn-danger";
		String LogoutBtn="//a[contains(text(),'Logout')]";
	}
}
	