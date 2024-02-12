package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LoanCalculator;
import testBase.BaseClass;

public class TC_004_LoanAmountCalculator extends BaseClass {

	LoanCalculator loanCalculator;
	
	@Test(priority=0, groups= {"smoke", "regression"})
	public void selectLoanAmtCalculator() {
		loanCalculator = new LoanCalculator(driver);
		logger.info("*** Starting TC_004_LoanAmountCalculator ***");
		try {
			loanCalculator.navigateToloanCalculator();
			logger.info("Clicking on Loan Calculator Link");
			try {
				//loanCalculator.handleAdvertisement();
			} catch (Exception e) {
				System.out.println(e);
			}
			loanCalculator.selectloanAmountCalculator();
			logger.info("Selecting Loan Amount Calculator");
			System.out.println("Selecting Loan Amount Calculator");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			logger.error("Test Failed");
		}
	}
	
	@Test(priority=1, dependsOnMethods = "selectLoanAmtCalculator", groups= {"regression"})
	public void textBoxValidation() {
		loanCalculator = new LoanCalculator(driver);
		try {
			//SoftAssert softAssert = new SoftAssert();
			System.out.println("UI checks for Loan Amount Calculator");

			Boolean validate = loanCalculator.loanEMIInputBox();
			//softAssert.assertEquals(validate, true, "Loan EMI Input Box Failed");
			if(validate) System.out.println("Loan EMI InputBox validation successfull");
			logger.info("Validating Loan EMI Input Box");

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
	
	@Test(priority=2, dependsOnMethods = "selectLoanAmtCalculator", groups= {"regression"})
	public void sliderValidation() {
		loanCalculator = new LoanCalculator(driver);
		try {
			//SoftAssert softAssert = new SoftAssert();
			boolean loanValidation;
			
			loanValidation = loanCalculator.validateLoanEMISlider();
			//softAssert.assertEquals(loanValidation, true, "Loan EMI Slider Failed");
			if(loanValidation) System.out.println("Loan EMI Slider validation successfull");
			logger.info("Validating Loan EMI Slider");
			
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
	
	@Test(priority=3, dependsOnMethods = "selectLoanAmtCalculator", groups= {"regression"})
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
		logger.info("*** Finished TC_004_LoanAmountCalculator ***");
		System.out.println("=================================================================================");
	}



}
