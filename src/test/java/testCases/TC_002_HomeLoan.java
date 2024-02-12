package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoan;
import testBase.BaseClass;
import utilities.ExcelUtilities;

public class TC_002_HomeLoan extends BaseClass {

	
	@Test(groups= {"smoke", "regression"})
	public void homeEMICalculator() {
		HomeLoan homeLoan = new HomeLoan(driver);
		logger.info("*** Starting TC_002_homeLoan ***");
		try {
			homeLoan.setLoanAmount();
			logger.info("Setting loan Amount");
			homeLoan.setInteretRate();
			logger.info("Setting interest Rate ");
			homeLoan.setLoanTenure();
			logger.info("Setting Loan Tenure ");
			Assert.assertTrue(true);
		}catch(Exception e) {
			System.out.println(e);
			Assert.fail();
			logger.error("Test Failed");
		}
	}
	
	@Test (dependsOnMethods = "homeEMICalculator", groups= {"regression"})
	public void getYearOYearData() throws IOException {
		HomeLoan homeLoan = new HomeLoan(driver);
		ExcelUtilities excel = new ExcelUtilities();
		List<List<String>> tableData = homeLoan.getTableData();
		logger.info("Storing Table Data in a List");
		excel.tableWriting(tableData);
		logger.info("Writing Table Data into the Excel File");
		logger.info("*** Finished TC_002_homeLoan ***");
		
	}
}
