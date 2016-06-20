package automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Salesforce_Test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();

		//Open Pardot website with Firefox
		String baseUrl = "https://pi.pardot.com";
		driver.get(baseUrl);
		
		//1. Login credentials		
		driver.findElement(By.id("email_address")).sendKeys("pardot.applicant@pardot.com");
        driver.findElement(By.id("password")).sendKeys("Applicant2012");
        driver.findElement(By.name("commit")).click();
        
        //2. Create a list with random name
        Thread.sleep(2000);
        driver.findElement(By.id("mark-tog")).click();
        driver.findElement(By.cssSelector("#dropmenu-marketing > li:nth-child(11) > a")).click();
        driver.findElement(By.id("listxistx_link_create")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).sendKeys("Random NameC");
        driver.findElement(By.cssSelector("div.input-prepend:nth-child(1) > button:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#ember1201 > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1)")).click();
        driver.findElement(By.id("select-asset")).click();
        driver.findElement(By.id("save_information")).click();
       
        //3. Negative check to ensure same name list will output error message prompt
        Thread.sleep(2000);
        driver.findElement(By.id("mark-tog")).click();
        driver.findElement(By.cssSelector("#dropmenu-marketing > li:nth-child(11) > a")).click();
        driver.findElement(By.id("listxistx_link_create")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("name")).sendKeys("Random NameC");
        driver.findElement(By.cssSelector("div.input-prepend:nth-child(1) > button:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#ember1201 > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1)")).click();
        driver.findElement(By.id("select-asset")).click();
        driver.findElement(By.id("save_information")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#dynamicList-form > div.modal-footer > a")).click();
        
        //4. Rename original list
        Thread.sleep(2000);
        driver.findElement(By.id("mark-tog")).click();
        driver.findElement(By.cssSelector("#dropmenu-marketing > li:nth-child(11) > a")).click();
        driver.findElement(By.cssSelector("#listx_row_a0 > td:nth-child(2) > a")).click();
        driver.findElement(By.cssSelector("#center-stage > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("Test AssessmentC");
        driver.findElement(By.id("save_information")).click();
        
        //5. Create a new list with the original name to ensure system allows the naming convention
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#bread-crumbs > li:nth-child(7) > a")).click();
        driver.findElement(By.id("listxistx_link_create")).click();
        driver.findElement(By.name("name")).sendKeys("Random NameC");
        driver.findElement(By.cssSelector("div.input-prepend:nth-child(1) > button:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#ember1201 > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1)")).click();
        driver.findElement(By.id("select-asset")).click();
        driver.findElement(By.id("save_information")).click();        
        
        //6. Create a new prospect 
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#pro-tog > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#dropmenu-prospects > li:nth-child(1) > a")).click();
        driver.findElement(By.id("pr_link_create")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("default_field_3361")).sendKeys("First");
        driver.findElement(By.id("default_field_3371")).sendKeys("Last");
        driver.findElement(By.id("email")).sendKeys("FirstLastCl@gmail.com");
        driver.findElement(By.id("campaign_id")).click();
        driver.findElement(By.id("campaign_id")).sendKeys("A");
        driver.findElement(By.id("profile_id")).sendKeys("B");
        Thread.sleep(5000);
        driver.switchTo().activeElement();
        driver.findElement(By.cssSelector("input.btn-primary:nth-child(1)")).click();
        
        //7. Adding Prospect to created list
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#center-stage > div.navbar > div > ul > li:nth-child(2) > a")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".chzn-single")).sendKeys("Test AssessmentC");
        driver.findElement(By.cssSelector("input.btn")).click();
        
        //8. Ensure Prospect is added to list
        Thread.sleep(2000);
        driver.findElement(By.id("mark-tog")).click();
        driver.findElement(By.cssSelector("#dropmenu-marketing > li:nth-child(11) > a")).click();
        driver.findElement(By.cssSelector("#listx_table_filter")).sendKeys("Test AssessmentC");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#listx_row_a0 > td:nth-child(2) > a:nth-child(1)")).click();
      
        //9. Send text only email
        Thread.sleep(2000);
        driver.findElement(By.id("mark-tog")).click();
        driver.findElement(By.cssSelector("#dropmenu-marketing > li:nth-child(7) > a")).click();
        driver.findElement(By.cssSelector("#em_module > div.header.clearfix > span > a")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("First");
        driver.findElement(By.cssSelector("#information_form > div:nth-child(3) > div > div > button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ember1201 > div:nth-child(1)")).click(); //Select folder
        driver.findElement(By.id("select-asset")).click();
        driver.findElement(By.cssSelector("#information_form > div.control-group.required.campaign_errors > div > div > button")).click();
        driver.findElement(By.cssSelector("#ember1607 > div:nth-child(1)")).click();      //choose campaign
        driver.findElement(By.id("select-asset")).click();
        driver.findElement(By.id("email_type_text_only")).click();
        driver.findElement(By.cssSelector("#from_template_radio_label > div > label")).click();
        driver.findElement(By.id("save_information")).click();
        Thread.sleep(5000);
        driver.switchTo().activeElement();
        driver.findElement(By.cssSelector("#flow_navigation > li:nth-child(3)")).click();

        //Selecting a list item  (Incomplete)  
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#email-wizard-list-select")).click();
        Thread.sleep(5000);
        driver.switchTo().activeElement();
        //WebElement Lists = driver.findElement(By.cssSelector("#email-wizard-list-select"));
        //Lists.findElement(By.tagName("';l;lo999")).click();

        Thread.sleep(5000);
        driver.findElement(By.name("a_sender[]")).click();
        driver.findElement(By.name("a_sender[]")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.name("a_sender[]")).click();
        
        driver.findElement(By.cssSelector("#subject_a")).sendKeys("Salesforce");
        
        driver.findElement(By.name("a_general_name")).sendKeys("Tester");
        driver.findElement(By.name("a_general_email")).sendKeys("Tester@gmail.com");
        
        driver.findElement(By.cssSelector("a.btn:nth-child(8)")).click();  //Send email

        driver.findElement(By.cssSelector("#flow-footer > div:nth-child(1)")).click();   //save email
         
        //10. Log out of account
        driver.findElement(By.id("acct-tog")).click();
        driver.findElement(By.cssSelector("#dropmenu-account > li:nth-child(8) > a:nth-child(1)")).click();
        
        //close web browser
		driver.close();
		
		//exit the program
		//System.exit(0);
				
					
	}

}

