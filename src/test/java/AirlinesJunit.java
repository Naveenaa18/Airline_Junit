import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirlinesJunit extends BaseClass{
	
	public static WebDriver driver;

	
	@BeforeClass
	public static void beforeClass()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naveenaa\\eclipse-workspace\\Airlines\\Webdriver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.get("https://alsieexpress.dk/en/");
		driver.manage().window().maximize();
	}
	
	@Before	
	public void before()
	{
		Date d = new Date();
		System.out.println(d);
	}
	
	@Test
	
	public void testClass() throws Throwable
	{
			
			Robot r = new Robot();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
			driver.findElement(By.xpath("//label[@for='traveltype-one-way']")).click();
			
			//CHOOSING SOURCE
			WebElement origin = driver.findElement(By.id("origin"));
			origin.click();
			Thread.sleep(1000);
			WebElement src = driver.findElement(By.xpath("//li[@item='1220']"));
			src.click();
			String checkOrigin = origin.getAttribute("value");
			Boolean b = checkOrigin.contains("CPH");
			Assert.assertTrue("check origin", b);
			Thread.sleep(1000);
			
			//CHOOSING DESTINATION
					
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			WebElement dest = driver.findElement(By.id("destination"));
			Thread.sleep(1000);
			String dest_check = dest.getAttribute("value");
			Boolean c = dest_check.contains("SGD");
			Assert.assertTrue("check destination", c);
			
			//CALENDER
			
			WebElement rows = driver.findElement(By.xpath("//table/tbody/tr[4]"));
					
			List<WebElement> tDate = rows.findElements(By.tagName("td"));
			
			for(int j=0;j<tDate.size();j++)
		{
				WebElement date = tDate.get(j);
				String text = date.getText();
				if(text.equals("26"))
				{
					date.findElement(By.linkText("26")).click();
					break;
				}
			}
		
			Thread.sleep(1000);
			WebElement dateBox = driver.findElement(By.id("departdate"));
			String value = dateBox.getAttribute("value");
			Assert.assertEquals("check date","26/01/2020" ,value);
			
	//SEARCH_BUTTON
			
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(2000);
			
			
			//////PAGE-2//////// FLIGHT SELECTION
			
			driver.findElement(By.xpath("//a[@class='v-button v-accept']")).click();
			
			WebElement cl = driver.findElement(By.xpath("//label[@for='from-6I124_0126_CPH_SGDpremium']")); //CLASS_SELECTION
			js.executeScript("arguments[0].click()", cl);
			
			
			
			WebElement cntn_btn = driver.findElement(By.id("continue"));
			js.executeScript("arguments[0].click()", cntn_btn);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();//sign-in pop-up close
			
			
			//SELECTING TITLE
			WebElement e = driver.findElement(By.id("passenger_title_0"));
			SVT(e,"Ms.");			
			String txt_title = e.getAttribute("value");
			Assert.assertEquals("check title box", "Ms.",txt_title );
			
			//FIRSTNAME
			WebElement fName = driver.findElement(By.id("passenger_firstname_0"));
			fName.sendKeys(excelData(1,0));
			String x = fName.getAttribute("value");
			Assert.assertEquals("check first name", "Naveenaa", x);
			
			//LAST NAME
			WebElement lName = driver.findElement(By.id("passenger_lastname_0"));
			lName.sendKeys(excelData(1,1));
			String y = lName.getAttribute("value");
			Assert.assertEquals("check last name", "Srikanth", y);
			
			//MOBILE
			WebElement mobile = driver.findElement(By.id("passenger_mobile_0"));
			mobile.sendKeys(excelData(1,2));
			String z = mobile.getAttribute("value");
			Assert.assertEquals("check mobile", "9566720446", z);
			
			//GO_BTN
			
			WebElement go_btn = driver.findElement(By.id("btnCopyFrom"));
			js.executeScript("arguments[0].click()", go_btn);
			
			//EMAIL
			
			WebElement email = driver.findElement(By.id("contact_email"));
			email.sendKeys(excelData(1,3));
			String p = email.getAttribute("value");
			Assert.assertEquals("check email", "naveenaa907@gmail.com", p);
			
			//CONFIRM EMAIL
			
			WebElement cnfrmEmail = driver.findElement(By.id("confirmation_contact_email"));
			cnfrmEmail.sendKeys(excelData(1,3));
			String q = cnfrmEmail.getAttribute("value");
			Assert.assertEquals("check email", "naveenaa907@gmail.com", q);
			
			//COUNTRY
			WebElement con = driver.findElement(By.id("contact_country_id"));
			SVT1(con,"India");
		//	String text = con.getAttribute("value");
		//	Assert.assertEquals("check country", "India",text);
			
			//UNCHECK CHECK BOX
			
			WebElement check = driver.findElement(By.xpath("//label[@for='create_account']"));
			js.executeScript("arguments[0].click()", check);
			
			
			//CHECKOUT
			
			WebElement checkOut = driver.findElement(By.id("continue-checkout"));
			js.executeScript("arguments[0].click()", checkOut);
			
			//FINAL PAGE
			
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			
			Thread.sleep(1500);
			
			WebElement agr = driver.findElement(By.xpath("//input[@name='agreement[1]']"));
			js.executeScript("arguments[0].click()", agr);
			
			//CHECKOUT BUTTON CLICK
			WebElement order = driver.findElement(By.id("checkout-btn"));
			js.executeScript("arguments[0].click()", order);		
			
	}
	
	@After
	
	public void after()
	
	{
		Date d = new Date();
		System.out.println(d);
	}
	
	@AfterClass
	
	public static void afterClass() throws Exception
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
