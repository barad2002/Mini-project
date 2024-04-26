package SeleniumProject;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws HeadlessException, InterruptedException, AWTException, IOException 
    {
        AlertHandling miniProject = new AlertHandling();
//	Invoking the methods from AlertHandling Class
        miniProject.createDriver();
        miniProject.signIn();
        miniProject.checkAlert("Please enter a valid user name");
        miniProject.forgotPassword();
        miniProject.checkAlert("Please enter your email ID");
        miniProject.navigateBack();
        miniProject.privacyPolicy();
        miniProject.checkNewTab();
        miniProject.changeNewTab();
        miniProject.closeBrowser();
    }

}
