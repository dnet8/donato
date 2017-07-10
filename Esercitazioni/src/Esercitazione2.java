import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Esercitazione2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dcolaprico\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String password = new String("ciaociao");
		
		driver.get("http://www.phptravels.net/");
		driver.manage().window().maximize();
		
		driver.findElements(By.cssSelector("[data-toggle=\"dropdown\"]")).get(1).click();
		driver.findElement(By.cssSelector("[href=\"http://www.phptravels.net/register\"]")).click();
		
		driver.findElement(By.cssSelector("[placeholder=\"First Name\"]")).sendKeys("Donato");
		driver.findElement(By.cssSelector("[placeholder=\"Last Name\"]")).sendKeys("Colaprico");
		driver.findElement(By.cssSelector("[placeholder=\"Mobile Number\"]")).sendKeys("325626526");
			
		
		driver.findElement(By.cssSelector("[placeholder=\"Email\"]")).sendKeys("ciao@ciao.it");
		
		driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys(password);
		driver.findElement(By.cssSelector("[placeholder=\"Confirm Password\"]")).sendKeys(password);
		driver.findElements(By.cssSelector("[type=\"submit\"]")).get(0).click();
		
	
	}

}
