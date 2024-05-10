package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.RegistrationPageObject;
import resources.baseClass;
import resources.constant;

public class VerifyRegistrationTestCases extends baseClass {

	@Test
	public void VerifyRegistrationWithValidData() throws IOException {
	

		RegistrationPageObject rpo = new RegistrationPageObject(driver);// we pass the drievr in object to give scope to
																		// that driver

		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.Enterfirstname().sendKeys(constant.firstname);
		rpo.Enterlastname().sendKeys(constant.lastname);
		rpo.Enteremail().sendKeys(Email);
		rpo.Entertelephone().sendKeys(constant.phone);
		rpo.Enterpassword().sendKeys(constant.password);
		rpo.Enterpasswordconfirm().sendKeys(constant.confirmpassword);

		rpo.clickOnpolicycheck().click();
		rpo.clickOnsubmit().click();

		SoftAssert sa = new SoftAssert();
		String expected = constant.accountcreatetext;
		String actual =rpo.actualtext().getText();
		sa.assertEquals(actual, expected);
		sa.assertAll();
	}

	@Test(priority=1)
	public void VerifyRegistrationWithINValidData() throws IOException {
		
		RegistrationPageObject rpo = new RegistrationPageObject(driver);// we pass the drievr in object to give scope to
																		// that driver

		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.clickOnsubmit().click();

		SoftAssert sa = new SoftAssert();
		String fnexpected = constant.fnexpectedtext;
		String fnactual = rpo.fnactualtext().getText();
		sa.assertEquals(fnactual, fnexpected);
		
		String lnexpected = constant.lnexpectedtext;
		String lnactual = rpo.lnactualtext().getText();
		sa.assertEquals(lnactual, lnexpected);
		
		
		sa.assertAll();
		
	}

}
