package Selenium4ElementScreenShot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class ElementScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// To check the ScreenShot code see the last lines of this program
		
		System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\hp\\Downloads\\edgedriver_win64123\\msedgedriver.exe");
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
		name.sendKeys(CourseName);
		// Taking ScreenShot from that specific element.
		File Scrnshot = name.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(Scrnshot, new File("C:\\Users\\hp\\eclipse-workspace\\Selenium4Project\\src\\test\\java\\Selenium4ElementScreenShot\\element.png"));
		System.out.println("Pass");
		

	}

}
