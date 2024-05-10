package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.LogInPageObject;
import PageObjectModel.RegistrationPageObject;
import resources.baseClass;
import resources.constant;

public class VerifyLoginTestcases extends baseClass {

	@Test
	public void VerifyLogInWithValidData() throws IOException {
		

		LogInPageObject lpo = new LogInPageObject(driver);
		RegistrationPageObject rpo = new RegistrationPageObject(driver);// we pass the drievr in object to give scope to
		// that driver

		rpo.clickOnMyAccount().click();
		lpo.enterlogin().click();

		lpo.enterEmail().sendKeys(Email);
		lpo.enterPassword().sendKeys(constant.password);
		lpo.clickOnsubmitButton().click();

		SoftAssert sa = new SoftAssert();
		String expected = constant.MyAccount;
		String actual = lpo.loginactualtext().getText();
		sa.assertEquals(actual, expected);
		sa.assertAll();
	}

	@Test(priority=1)
	public void VerifyLogInWithINValidData() throws IOException {
		
		LogInPageObject lpo = new LogInPageObject(driver);
		RegistrationPageObject rpo = new RegistrationPageObject(driver);// we pass the drievr in object to give scope to
		// that driver

		rpo.clickOnMyAccount().click();
		lpo.enterlogin().click();


		lpo.clickOnsubmitButton().click();

		SoftAssert sa = new SoftAssert();
		String expected = constant.expectedworning;
		String actual = lpo.actualworningtext().getText();
		sa.assertEquals(actual, expected);
		sa.assertAll();
	}
}
