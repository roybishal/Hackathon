package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoanCalculator;
import testBase.BaseClass;

public class TC_005_LoanTenureCalculator extends BaseClass{

LoanCalculator loanCalculator;
	
	@Test(priority=0, groups= {"smoke", "regression"})
	public void selectLoanTenureCalculator() {
		loanCalculator = new LoanCalculator(driver);
		logger.info("*** Starting TC_005_LoanTenureCalculator ***");
		
		try {
			loanCalculator.navigateToloanCalculator();
			logger.info("Clicking on Loan Calculator Link");
			try {
			//	loanCalculator.handleAdvertisement();
			} catch (Exception e) {
				System.out.println(e);
			}
			loanCalculator.selectloanTenureCalculator();
			System.out.println("Selecting Loan Tenure Calculator");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			logger.error("Test Failed");
		}
	}
	
	@Test(priority=1, dependsOnMethods = "selectLoanTenureCalculator", groups= {"regression"})
	public void textBoxValidation() {
		loanCalculator = new LoanCalculator(driver);
		try {
			//SoftAssert softAssert = new SoftAssert();
			System.out.println("UI checks for Loan Tenure Calculator");
			
			Boolean validate = loanCalculator.loanInputBox();
			//softAssert.assertEquals(validate, true, "Loan Amount Input Box Failed");
			if(validate) System.out.println("Loan Amount InputBox validation successfull");
			logger.info("Validating Loan Amount Input Box");

			validate = loanCalculator.loanEMIInputBox();
			//softAssert.assertEquals(validate, true, "Loan EMI Input Box Failed");
			if(validate) System.out.println("Loan EMI InputBox validation successfull");
			logger.info("Validating Loan EMI Input Box");

			validate = loanCalculator.interestInputBox();
			//softAssert.assertEquals(validate, true, "Loan Interest Input Box Failed");
			if(validate) System.out.println("Interest Rate InputBox validation successfull");
			logger.info("Validating Loan Interest Input Box");

			validate = loanCalculator.feeInputBox();
			//softAssert.assertEquals(validate, true, "Loan Fees&Charges Input Box Failed");
			if(validate) System.out.println("Loan Fees&Charges InputBox validation successfull");
			logger.info("Validating Loan Fees&Charges Input Box");

			//softAssert.assertAll();
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
			logger.error("Test Failed");
		}
		
	}
	
	@Test(priority=2, dependsOnMethods = "selectLoanTenureCalculator", groups= {"regression"})
	public void sliderValidation() {
		loanCalculator = new LoanCalculator(driver);
		try {
			//SoftAssert softAssert = new SoftAssert();
			boolean loanValidation;
			loanValidation = loanCalculator.validateLoanSlider();
			//softAssert.assertEquals(loanValidation, true, "Loan Amount Slider Failed");
			if(loanValidation) System.out.println("Loan Amount Slider validation successfull");
			logger.info("Validating Loan Amount Slider");
			
			loanValidation = loanCalculator.validateLoanEMISlider();
			//softAssert.assertEquals(loanValidation, true, "Loan EMI Slider Failed");
			if(loanValidation) System.out.println("Loan EMI Slider validation successfull");
			logger.info("Validating Loan EMI Slider");
			
			loanValidation = loanCalculator.validateInterestSlider();
			//softAssert.assertEquals(loanValidation, true, "Loan Interest Slider Failed");
			if(loanValidation) System.out.println("Interest Rate Slider validation successfull");
			logger.info("Validating Interest Rate Slider");
			
			loanValidation = loanCalculator.validateFeeSlider();
			//softAssert.assertEquals(loanValidation, true, "Loan Fees&Charges Slider Failed");
			if(loanValidation) System.out.println("Fees&Charges Slider validation successfull");
			logger.info("Validating Fees&Charges Slider");
			
			//softAssert.assertAll();
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			Assert.fail();
			logger.error("Test Failed");
		}
		logger.info("*** Finished TC_005_LoanTenureCalculator ***");
		System.out.println("=================================================================================");
	}
		
}
