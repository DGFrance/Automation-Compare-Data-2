package automation_verification.Bukalapak_test;

import java.awt.AWTException;
import java.awt.desktop.AppEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

public class Test_BL2 {
	public static Test suite() {
		return new TestSuite(AppEvent.class);
	}
//THIS CODE IS DESIGNED FOR INPUT THE DATA TO WEB-UI FOR 'TRANSACRION DATA' AND COMPARE IT WITH THE DATA ON DATABASE
	
	/**
	 * 
	 * 
	 * @throws AWTException
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void testApp() throws AWTException, InterruptedException, ClassNotFoundException, SQLException {

		// selenium method
		WebDriver driver = new FirefoxDriver();
		driver.get(BL_Class.webUrl);

		// get value from id
		driver.findElement(By.id("TRX_ID")).sendKeys(BL_Class.id);
//		WebElement d = driver.findElement(By.id(BL_Class.id));
//		System.out.println("getText() " + d.getText());
//		System.out.println("getAttribute() " + d.getAttribute("value"));
		Thread.sleep(2000);

		// get value from address
		driver.findElement(By.id("ADDRESS_SHIP")).sendKeys(BL_Class.address);
//		WebElement o = driver.findElement(By.id(BL_Class.address));
//		System.out.println("getText() " + o.getText());
//		System.out.println("getAttribute() " + o.getAttribute("value"));
		Thread.sleep(2000);

		// get value from date
		driver.findElement(By.id("DATE_ORDER")).sendKeys(BL_Class.date);
//		WebElement n = driver.findElement(By.id(BL_Class.date));
//		System.out.println("getText() " + n.getText());
//		System.out.println("getAttribute() " + n.getAttribute("value"));
		Thread.sleep(2000);

		// get value from seller
		driver.findElement(By.id("SELLER_NAME")).sendKeys(BL_Class.seller);
//		WebElement p = driver.findElement(By.id(BL_Class.seller));
//		System.out.println("getText() " + p.getText());
//		System.out.println("getAttribute() " + p.getAttribute("value"));
		Thread.sleep(2000);

		// get value from delivery
		driver.findElement(By.id("DELIVERY_SERVICE")).sendKeys(BL_Class.delivery);
//		WebElement aw = driver.findElement(By.id(BL_Class.delivery));
//		System.out.println("getText() " + aw.getText());
//		System.out.println("getAttribute() " + aw.getAttribute("value"));
		Thread.sleep(2000);

		// Database Connection
		Connection con = null;
		Statement stmt = null;
		Class.forName("org.postgresql.Driver");
		System.out.println("Connection to a selected Database");
		con = DriverManager.getConnection(BL_Class.DB_URL, BL_Class.UserName, BL_Class.Password);
		System.out.println("Conected database Successfully....");
		System.out.println("Creating Statement...");
		stmt = con.createStatement();

		// select data form database
		ResultSet rs = stmt.executeQuery(BL_Class.sql);
		while (rs.next()) {

			// Compare the data form UI and Database
			String id = rs.getString("TRX_ID");
			Assert.assertEquals(id, BL_Class.id);
//			String id = rs.getString("TRX_ID");
//			Assert.assertEquals(id, d.getAttribute("value"));
			String address = rs.getString("ADDRESS_SHIP");
			Assert.assertEquals(address, BL_Class.address);
//			String address = rs.getString("ADDRESS_SHIP_UI");
//			Assert.assertEquals(address, o.getAttribute("value"));
			String date = rs.getString("DATE_ORDER");
			Assert.assertEquals(date, BL_Class.date);
//			String date_order = rs.getString("DATE_ORDER");
//			Assert.assertEquals(date_order, n.getAttribute("value"));
			String seller = rs.getString("SELLER_NAME");
			Assert.assertEquals(seller, BL_Class.seller);
//			String seller_name = rs.getString("SELLER_NAME");
//			Assert.assertEquals(seller_name, p.getAttribute("value"));
			String delivery = rs.getString("DELIVERY_SERVICE");
			Assert.assertEquals(delivery, BL_Class.delivery);
//			String delivery = rs.getString("DELIVERY_SERVICE");
//			Assert.assertEquals(delivery, aw.getAttribute("value"));
		}
		rs.close();

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se) {
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException se) {
		}
		System.out.println("All of the list already displayed");

	}
}
