package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ScreenShot;

public class LoanCalculator extends BasePage{
	
	ScreenShot ss = new ScreenShot();
	
	public LoanCalculator(WebDriver driver) {
		super(driver);
	}


//	BaseClass  baseClass = new BaseClass();
	@FindBy(id = "loan-amount-calc")
	WebElement loanAmountCaiculator;
	
	@FindBy(id = "loan-tenure-calc")
	WebElement loanTenureCaiculator;
	
	@FindBy(id = "loanemi")
	WebElement loanEmiTextBox;
	
	@FindBy(xpath = "//*[@id=\"loanemislider\"]/span")
	WebElement loanemiSlider;
	
	
	@FindBy(id = "loanamount")
	WebElement loanAmountTextBox;
	
	@FindBy(partialLinkText = "Loan Calculator")
	WebElement loanCalculatorButton;
	
	@FindBy(xpath = "//*[@id=\"dismiss-button\"]/div/span")
	WebElement adCloseButton;
	
	@FindBy(xpath = "//*[@id=\"loanamountslider\"]/div")
	WebElement loanAmountSlider;
	
	@FindBy(xpath = "//*[@id=\"loanamountslider\"]/span")
	WebElement loanSlider;
	
	@FindBy(id = "emi-calc")
	WebElement emiCaiculator;
	
	@FindBy(id = "loaninterest")
	WebElement loanInterestTextBox;
	
	@FindBy(xpath = "//*[@id=\"loaninterestslider\"]/span")
	WebElement loanInterestSlider;
	
	@FindBy(id = "loanterm")
	WebElement timeInputBox;
	
	@FindBy(xpath = "//*[@id=\"loantermslider\"]/span")
	WebElement tenureSlider;
	
	@FindBy(xpath = "//*[@id=\"loantermsteps\"]/span/span")
	List<WebElement> loanTenureSteps;
	
	@FindBy(id = "loanyears")
	WebElement loanTenureYearButton;
	
	@FindBy(id = "loanmonths")
	WebElement loanTenureMonthButton;
	
	@FindBy(id = "loanfees")
	WebElement fessInputBox;
	
	@FindBy(xpath = "//*[@id=\"loanfeesslider\"]/span")
	WebElement feeSlider;
	
	public void navigateToloanCalculator() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", loanCalculatorButton);
		loanCalculatorButton.click();
	}

	public void handleAdvertisement()  {
		try {
			Thread.sleep(2000);
			driver.switchTo().frame("aswift_9");
			driver.switchTo().frame("ad_iframe");  // switch frame by ID
			adCloseButton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectEMICalculator() {
		emiCaiculator.click();
	}

	public Boolean loanInputBox() {
		return validateInputBox(loanAmountTextBox);
	}
	public Boolean loanEMIInputBox() {
		return validateInputBox(loanEmiTextBox);
	}
	
	public Boolean interestInputBox() {
		return validateInputBox(loanInterestTextBox);
	}

	public Boolean tenureInputBox() {
		return validateInputBox(timeInputBox);
	}

	public Boolean feeInputBox() {
		return validateInputBox(fessInputBox);
	}
	
	
	
	public boolean validateLoanSlider() {
		return validateSlider(loanSlider, loanAmountTextBox, 6);
	}

	public boolean validateInterestSlider() {
		return validateSlider(loanInterestSlider, loanInterestTextBox, 3);
	}

	public boolean validateTenureSlider() {
		return validateSlider(tenureSlider, timeInputBox, 5);
	}

	public boolean validateFeeSlider() {
		return validateSlider(feeSlider, fessInputBox, 5);
	}

	public boolean changeLoanTenure() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if(loanTenureYearButton.isSelected()) {
			int elementNumber = baseClass.getRandom(loanTenureSteps.size());
			String time = loanTenureSteps.get(elementNumber).getText();
			
			ss.takeSS(driver, "LoanTenureYearSliderSS");
			js.executeScript("arguments[0].click();", loanTenureMonthButton);
			ss.takeSS(driver, "LoanTenureMonthSliderSS");

			String time2 = loanTenureSteps.get(elementNumber).getText();
			int t2 = Integer.parseInt(time2) / 12;
			String time3 = String.valueOf(t2);
			return (time.equals(time3));
		}
		else if(loanTenureMonthButton.isSelected()) {
			int elementNumber = baseClass.getRandom(loanTenureSteps.size());
			String time = loanTenureSteps.get(elementNumber).getText();
			ss.takeSS(driver, "LoanTenureMonthSliderSS");

			js.executeScript("arguments[0].click();", loanTenureYearButton);
			ss.takeSS(driver, "LoanTenureYearSliderSS");
			String time2 = loanTenureSteps.get(elementNumber).getText();
			int t2 = Integer.parseInt(time2) * 12;
			String time3 = String.valueOf(t2);
			return (time.equals(time3));
		}

		return false;
	}

	public void selectloanAmountCalculator() {
		loanAmountCaiculator.click();
	}

	public boolean validateLoanEMISlider() {
		return validateSlider(loanemiSlider, loanEmiTextBox, 6);
	}

	// Loan Tenure
	public void selectloanTenureCalculator() {
		loanTenureCaiculator.click();
	}

	
	
	
}
