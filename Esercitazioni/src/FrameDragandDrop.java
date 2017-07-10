import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameDragandDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dcolaprico\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		
		WebElement source=driver.findElement(By.cssSelector("[id=\"draggable\"]"));
		WebElement target=driver.findElement(By.cssSelector("[id=\"droppable\"]"));

		
		Actions a = new Actions(driver);
		
		
		
		//fa andare il frame in diagonale e poi lo fa salire per entrare nel quadrato del drop 
		for (int i=1; i<=160; i++)
		{
		a.dragAndDropBy(source, 1, 2).perform();
		
		}
		for (int y=1; y<=140; y++)
		{
		a.dragAndDropBy(source, 0, -2).perform();
		
		}
		Thread.sleep(1000);
		 
		a.dragAndDropBy(source, -160, -20).perform();
		Thread.sleep(1000);
		
		a.dragAndDrop(source, target).perform();
	}

}
