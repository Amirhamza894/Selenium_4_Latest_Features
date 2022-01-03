package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Selenium4test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Realtive Locators
		 * when there is no atribute to select selenium have also feature to get the xpath.
		 */
		
		System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\Amir Hamza Haq\\Downloads\\Programs\\edgedriver_win64123\\msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement editab = driver.findElement(By.xpath("//input[@name='name']"));
		WebElement txt = driver.findElement(RelativeLocator.with(By.tagName("label")).above(editab));
		String t = txt.getText();
		System.out.println(t);
		WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		WebElement dobt = driver.findElement(RelativeLocator.with(By.xpath("//input[@class='form-control'] ")).below(dob));
		dobt.sendKeys("03/34/1997");
		WebElement left = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		WebElement chck = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(left));
		chck.click();
		// get me the text of first radio button
		WebElement radio = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		WebElement radiot = driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(radio));
		System.out.println(radiot.getText());
		
	}

}
