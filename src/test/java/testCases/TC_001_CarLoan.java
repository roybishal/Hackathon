package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CarLoan;
import testBase.BaseClass;

public class TC_001_CarLoan extends BaseClass{
	
	@Test(groups= {"smoke", "regression"})
	public void CarEMICalculator() {
		logger.info("*** Starting TC_001_CarLoan ***");
		CarLoan carLoan = new CarLoan(driver);
		try {
			SoftAssert softAssert = new SoftAssert();
			carLoan.setLoanAmount();
			logger.info("Setting Loan Amount Value");
			carLoan.setInteretRate();
			logger.info("Setting Interest Rate");
			carLoan.setLoanTenure();
			logger.info("Setting Loan tenure");
			String actValue = carLoan.getOneMonthEMI();
			softAssert.assertEquals(actValue, "1,31,525");
			
			String febPrincipalAmt = carLoan.get1stMonthPrincipalAmount();
			softAssert.assertEquals(febPrincipalAmt, "1,19,650");
			
			String febInterestAmt = carLoan.get1stMonthInterestAmount();
			softAssert.assertEquals(febInterestAmt, "11,875");
			
			softAssert.assertAll();
			
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail();
			logger.error("Test Failed.");
		}
		logger.info("*** Finished TC_001_CarLoan ***");
		
	}

}
