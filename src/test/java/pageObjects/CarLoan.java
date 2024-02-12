package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelUtilities;
import utilities.ScreenShot;

public class CarLoan extends BasePage {

	Actions action = new Actions( driver);
	ExcelUtilities excel = new ExcelUtilities();
	ScreenShot ss = new ScreenShot();
	
	public CarLoan(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js;
	
	@FindBy(id = "car-loan")
	WebElement carLoan;
	
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
	
	@FindBy(id="year2024")
	WebElement tableCell2024Btn_Loc;
	
	@FindBy(xpath="//tr[@id=\"monthyear2024\"]//tr[1]/td[2]")
	WebElement firstmonthPrincipalAmt_Loc;
	
	@FindBy(xpath="//tr[@id=\"monthyear2024\"]//tr[1]/td[3]")
	WebElement firstmonthInterest_Loc;	
	
			
	
	public void setLoanAmount() throws IOException {
		String loanAmt = excel.getCellData("CarLoan", 1, 0);
		highlightElement(carLoan);
		carLoan.click();
		highlightElement(loanAmount);
		loanAmount.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(loanAmount , loanAmt).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void setInteretRate() throws IOException {
		String Interest_rate = excel.getCellData("CarLoan", 1, 1);
		highlightElement(interestRate);
		interestRate.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(interestRate , Interest_rate).sendKeys(Keys.ENTER).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setLoanTenure() throws IOException {
		String loan_tenure = excel.getCellData("CarLoan", 1, 2);
		highlightElement(loanTenure);
		loanTenure.clear();
		loanTenure.click();
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(loanTenure , loan_tenure).sendKeys(Keys.ENTER).build().perform();
		loanTenureText.click();		
	}
	
	public String getOneMonthEMI() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", oneMonthEMI);
		String expValue = oneMonthEMI.getText();
		highlightElement(oneMonthEMI);
		ss.takeSS(driver, "MonthlyEMI");
		System.out.println("One Month EMI : " + expValue);
		return expValue;
	}
	
	public String get1stMonthPrincipalAmount() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tableCell2024Btn_Loc);
		tableCell2024Btn_Loc.click();
		String principal =  firstmonthPrincipalAmt_Loc.getText();
		System.out.println("Principal Amount for 1st Month : "+principal);
		return principal.substring(2);
	}
	
	public String get1stMonthInterestAmount() throws IOException {
		String interest =  firstmonthInterest_Loc.getText();
		System.out.println("Interest for 1st Month : "+interest);
		ss.takeSS(driver, "firstMonthPripcipal&Interest");
		System.out.println("=================================================================================");
		return interest.substring(2);
	}
}
