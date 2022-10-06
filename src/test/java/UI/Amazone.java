package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazone {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon_db", "root", "password");

		Statement stmt = con.createStatement();

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[1]/div[1]/div/section/div/div/div[1]/div[2]/div/ol/li[1]/a/div[1]/img"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/ol/li[1]/div/div[1]/a/img"))
				.click();
		String brand = driver
				.findElement(By.xpath(
						"/html/body/div[2]/div[2]/div[5]/div[4]/div[4]/div[43]/div/table/tbody/tr[1]/td[2]/span"))
				.getText();
		String model = driver
				.findElement(By.xpath(
						"/html/body/div[2]/div[2]/div[5]/div[4]/div[4]/div[43]/div/table/tbody/tr[2]/td[2]/span"))
				.getText();
		String amount = driver
				.findElement(By.xpath(
						"/html/body/div[2]/div[2]/div[5]/div[4]/div[4]/div[10]/div[3]/div[1]/span[2]/span[2]/span[2]"))
				.getText();

		String sql = "insert into product_details" + "( brand, model, amount)" + "values('" + brand + "','" + model
				+ "','" + amount + "')";
		stmt.executeUpdate(sql);

		driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
		driver.findElement(By.xpath("//*[@id=\"acs-product-block-0\"]/div[1]/a/img")).click();
		String brand1 = driver
				.findElement(By.xpath("//*[@id=\"productOverview_feature_div\"]/div/table/tbody/tr[1]/td[2]/span"))
				.getText();
		String model1 = driver
				.findElement(By.xpath("//*[@id=\"productOverview_feature_div\"]/div/table/tbody/tr[2]/td[2]/span"))
				.getText();
		String amount1 = driver
				.findElement(By.xpath("//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr[2]/td[2]/span[1]/span[2]"))
				.getText();

		/*
		 * System.out.println(brand1); System.out.println(model1);
		 * System.out.println(amount1);
		 */

		String sql1 = "insert into product_details" + "( brand, model, amount)" + "values('" + brand1 + "','" + model1
				+ "','" + amount1 + "')";
		stmt.executeUpdate(sql1);

	}

}
