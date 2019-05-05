import java.io.IOException;
import java.net.URL;

import org.junit.AfterClass
import org.junit.BeforeClass
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test

public class Start {
	public static Runtime r=Runtime.getRuntime();
	public static Process p=null;
	@BeforeClass
	public static void start_service() {
		try{
			String s="./Drivers/Winium.Desktop.Driver.exe";
			p=r.exec(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void start_notepad() {
		try {
			String s="./Drivers/Winium.Desktop.Driver.exe";
			p=r.exec(s);
			DesktopOptions options= new DesktopOptions();
			options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
			WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
			driver.findElementByClassName("Edit").sendKeys("This is sample test");
			driver.close();
		}
		catch(Exception e){
			System.out.println("error==="+e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void teardown() {
		try {
			p.destroy();
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
}
