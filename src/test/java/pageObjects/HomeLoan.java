package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtilities;
import utilities.ScreenShot;

public class HomeLoan extends BasePage {

	List<List<String>> tableData = new ArrayList<>();
	ExcelUtilities excel = new ExcelUtilities();
	ScreenShot ss = new ScreenShot();

	public HomeLoan(WebDriver driver) {
		super(driver);
	}

	Actions action = new Actions(driver);
	JavascriptExecutor js;

	@FindBy(id = "home-loan")
	WebElement homeLoanTab;

	@FindBy(id = "loanamount")
	WebElement loanAmount;

	@FindBy(id = "loaninterest")
	WebElement interestRate;

	@FindBy(id = "loanterm")
	WebElement loanTenure;

	@FindBy(css = "label[for='loanterm']")
	WebElement loanTenureText;

	@FindBy(xpath = "//div[@id=\"emiamount\"]//span")
	WebElement oneMonthEMI;

	@FindBy(id = "emipaymenttable")
	WebElement emiTable;
	
	@FindBy(id = "yearheader")
	WebElement yearHeader;
	
	@FindBy(id = "principalheader")
	WebElement principalHeader;
	
	@FindBy(id = "interestheader")
	WebElement interestHeader;
	
	@FindBy(id = "totalheader")
	WebElement totalHeader;
	
	@FindBy(id = "balanceheader" )
	WebElement balanceHeader;
	
	@FindBy(id = "paidtodateheader")
	WebElement paidtodateHeader;

	@FindAll(@FindBy(xpath = "//*[@id=\"emipaymenttable\"]//tr[@class=\"row no-margin yearlypaymentdetails\"]"))
	List<WebElement> rowData;

	public void setLoanAmount() throws IOException {
		String loanAmt = excel.getCellData("HomeLoan", 1, 0);
		homeLoanTab.click();
		loanAmount.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys(loanAmount, loanAmt).sendKeys(Keys.ENTER).build().perform();

	}

	public void setInteretRate() throws IOException {
		String interest_rate = excel.getCellData("HomeLoan", 1, 1);
		interestRate.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys(interestRate, interest_rate).sendKeys(Keys.ENTER).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setLoanTenure() throws IOException {
		String loan_tenure = excel.getCellData("HomeLoan", 1, 2);
		loanTenure.clear();
		loanTenure.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE)
				.sendKeys(loanTenure, loan_tenure).sendKeys(Keys.ENTER).build().perform();
		loanTenureText.click();
	}

	public List<List<String>> getTableData() throws IOException {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", emiTable);
		ss.takeSS(driver, "HomeLoanEMITable");
		
		tableData.add(addHeader());
		for (WebElement row : rowData) {
			List<String> cellDataText = new ArrayList<String>();
			List<WebElement> cellElement = row.findElements(By.tagName("td"));
			for (WebElement cell : cellElement) {
				String data = cell.getText();
				cellDataText.add(data);
			}
			tableData.add(cellDataText);
		}
		
		System.out.println("Year Principal(A) Interest(B) Total Payment(A+B) Balance Loan Paid To Date");
		for(int i=1;i<tableData.size();i++) {
			System.out.println(tableData.get(i));
		}
		System.out.println("=================================================================================");
		
		return tableData;
	}
	
	public List<String> addHeader(){
		List<String> header = new ArrayList<>();
		header.add(yearHeader.getText());
		header.add(principalHeader.getText());
		header.add(interestHeader.getText());
		header.add(totalHeader.getText());
		header.add(balanceHeader.getText());
		header.add(paidtodateHeader.getText());
		return header;
	}
}
