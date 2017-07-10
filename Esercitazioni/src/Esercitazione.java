import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Esercitazione {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dcolaprico\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		
		driver.get("http://www.phptravels.net/");
		driver.manage().window().maximize();
		// clicca sul pulsante "Flights"
		driver.findElement(By.cssSelector("[href=\"#TRAVELPAYOUTS\"]")).click();
		
		// seleziona due date e Milano come meta di partenza
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flights-dates-depart-prepop-e823caac1a24a0172d4ee792e5dad7d9")));
		driver.findElement(By.id("flights-dates-depart-prepop-e823caac1a24a0172d4ee792e5dad7d9")).click();
		driver.findElement(By.id("mewtwo-datepicker-2017-7-19")).click();
		driver.findElement(By.id("flights-dates-return-prepop-e823caac1a24a0172d4ee792e5dad7d9")).click();
		driver.findElement(By.id("mewtwo-datepicker-2017-7-27")).click();
		
		driver.findElement(By.id("flights-origin-prepop-e823caac1a24a0172d4ee792e5dad7d9")).sendKeys("Milano");
		
		Actions a = new Actions(driver);
		// Scrive venezia in stampatello maiuscolo come destinazione
		a.moveToElement(driver.findElement(By.id("flights-destination-prepop-e823caac1a24a0172d4ee792e5dad7d9"))).click().keyDown(Keys.SHIFT).sendKeys("Venezia").build().perform();

		//Preme Enter
		driver.findElement(By.id("flights-destination-prepop-e823caac1a24a0172d4ee792e5dad7d9")).sendKeys(Keys.ENTER);
		
		//posiziona selenium sulla nuova pagina aperta 
				Set<String> idS = driver.getWindowHandles(); 
				Iterator<String> itS = idS.iterator(); 
				String parentPage = itS.next();
				String childPage = itS.next();
				driver.switchTo().window(childPage);
		
		try {
			
			// se trova biglietti mi dà true sennò mi scrive che non ci sono biglietti
			Boolean b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mewtwo-flights-link_to_multi"))).isDisplayed();
			System.out.println(b);
			} 
			catch (Exception e) {
				System.out.println("There aren't tickets available");
			e.printStackTrace();
			
			}
	}

}
