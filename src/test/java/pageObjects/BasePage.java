package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;


public class BasePage {

	WebDriver driver;
	String textBoxValue1;
	String textBoxValue2;
	BaseClass  baseClass = new BaseClass();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSlider(WebElement sliderElement,WebElement textBoxElement, int n) {
		Actions action = new Actions(driver);
		textBoxValue1 = textBoxElement.getAttribute("value");
		int xLocation = sliderElement.getLocation().getX();
		action.dragAndDropBy(sliderElement,-(xLocation-130) , 0).perform();
		action.dragAndDropBy(sliderElement,(int) (n * baseClass.randomNumber() ), 0).perform();
		textBoxValue2 = textBoxElement.getAttribute("value");
		//System.out.println(textBoxValue1);
		//System.out.println(textBoxValue2);
		
		if(textBoxValue1 != textBoxValue2) {
			return true;
		}
		return false; 
	}

	public Boolean validateInputBox(WebElement element) {
		if(	element.isEnabled() || element.isDisplayed() || element.getAttribute("value") != null ) {
//			System.out.println("True Validation");
			return true;
			
		}
		return false;
	}
	
	public void highlightElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;')", element);
		} catch (Exception e) {}
	}
}
