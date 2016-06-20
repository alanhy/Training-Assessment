package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
	
		 driver.get("http://google.com");
		 System.out.println(driver.getTitle());
		 driver.close();

	}

}
