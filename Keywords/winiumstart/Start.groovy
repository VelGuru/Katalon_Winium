package winiumstart

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test

class Start {
	public static Runtime r=Runtime.getRuntime();
	public static Process p=null;
	public static void main(String[] args)
	{
		try {
			
			String s="./Drivers/Winium.Desktop.Driver.exe";
			p=r.exec(s);
			println "Winium Driver Started"
			
			DesktopOptions options= new DesktopOptions();
			options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
			WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
			driver.findElementByClassName("Edit").sendKeys("This is sample test");
			driver.close();
			println "Winium Driver Stopped"
			p.destroy();
		}
		catch(Exception e){
			System.out.println("error==="+e.getMessage());
			e.printStackTrace();
		}
		
	}
}
