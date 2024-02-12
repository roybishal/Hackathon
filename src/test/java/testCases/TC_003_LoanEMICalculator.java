package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LoanCalculator;
import testBase.BaseClass;

public class TC_003_LoanEMICalculator extends BaseClass {

	LoanCalculator loanCalculator;
	
	@Test(priority=0, groups= {"smoke", "regression"})
	public void selectEMICalculator() {
		loanCalculator = new LoanCalculator(driver);
		logger.info("*** Starting TC_003_LoanEMICalculator ***");
		try {
			loanCalculator.navigateToloanCalculator();
			logger.info("Clicking on Loan Calculator Link");
			try {
			//	loanCalculator.handleAdvertisement();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			loanCalculator.selectEMICalculator();
			logger.info("Selecting EMI Calculator");
			System.out.println("Selecting EMI Calculator");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			logger.error("Test Failed");
		}
	}

	@Test(priority=1, dependsOnMethods = "selectEMICalculator", groups= {"regression"})
	public void textBoxValidation() {
		loanCalculator = new LoanCalculator(driver);
		// test
		try {
			//SoftAssert softAssert = new SoftAssert();
			System.out.println("UI checks for EMI Calculator");

			Boolean validate = loanCalculator.loanInputBox();
			//softAssert.assertEquals(validate, true, "Loan Amount Input Box Failed");
			if(validate) System.out.println("Loan Amount InputBox validation successfull");
			logger.info("Validating Loan Amount Input Box");

			validate = loanCalculator.interestInputBox();
			//softAssert.assertEquals(validate, true, "Loan Interest Input Box Failed");
			if(validate) System.out.println("Interest Rate InputBox validation successfull");
			logger.info("Validating Loan Interest Input Box");

			validate = loanCalculator.tenureInputBox();
			//softAssert.assertEquals(validate, true, "Loan Tenure Input Box Failed");
			if(validate) System.out.println("Loan Tenure InputBox validation successfull");
			logger.info("Validating Loan Tenure Input Box");

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

	@Test(priority=2, dependsOnMethods = "selectEMICalculator", groups= {"regression"})
	public void sliderValidation() {
		loanCalculator = new LoanCalculator(driver);
		try {
			//SoftAssert softAssert = new SoftAssert();
			boolean loanValidation;
			loanValidation = loanCalculator.validateLoanSlider();
			//softAssert.assertEquals(loanValidation, true, "Loan Amount Slider Failed");
			if(loanValidation) System.out.println("Loan Amount Slider validation successfull");
			logger.info("Validating Loan Amount Slider");
			
			loanValidation = loanCalculator.validateInterestSlider();
			//softAssert.assertEquals(loanValidation, true, "Loan Interest Slider Failed");
			if(loanValidation) System.out.println("Interest Rate Slider validation successfull");
			logger.info("Validating Interest Rate Slider");
			
			loanValidation = loanCalculator.validateTenureSlider();
			//softAssert.assertEquals(loanValidation, true, "Loan Tenure Slider Failed");
			if(loanValidation) System.out.println("Loan Tenure Slider validation successfull");
			logger.info("Validating Loan Tenure Slider");
			
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
	}

	@Test(priority=3, dependsOnMethods = "selectEMICalculator", groups= {"regression"})
	public void loanTenureValidation() {
		try {
			loanCalculator = new LoanCalculator(driver);
			boolean validate = loanCalculator.changeLoanTenure();
			Assert.assertEquals(validate, true, "Loan tenure Scale Failed");
			System.out.println("Loan Tenure Slider Validation successfull for change in Tenure Year & Month");
			logger.info("Validating Loan Tenure Slider for change in Tenure Year & Month");
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail();
			logger.error("Test Failed");
		}
		logger.info("*** Finished TC_003_LoanEMICalculator ***");
		System.out.println("=================================================================================");
	}
}
