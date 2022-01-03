package InvokeMultipleWindowSelenium4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class InvokeMultipleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Invoking Multiple Windows
		System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\Amir Hamza Haq\\Downloads\\Programs\\edgedriver_win64123\\msedgedriver.exe");
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		driver.switchTo().window(ChildID);
		driver.get("https://rahulshettyacademy.com/#/index");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String CourseName = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		System.out.println(CourseName);
		driver.switchTo().window(ParentID);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement name = driver.findElements(By.xpath("//input[@name='name']")).get(0);
		System.out.println("Pass");
		name.sendKeys(CourseName);

	}

}
