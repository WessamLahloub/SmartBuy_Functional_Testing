import static org.testng.Assert.assertEquals;

import java.awt.print.Printable;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.Console;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.text.NumberFormat;
public class Practice_TestNG_SmartBuy {

	public WebDriver driver;

	@BeforeTest

	public void Intialize_and_Login() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://smartbuy-me.com/smartbuystore/");

		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[2]/a")).click();
		// To Switch the language to English
	}

	@Test
	//To test that the software will stop adding items to the cart if there were no
	// enough items in the inventory
	public void testing_Total_Amount_In_Cart() {

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		int amount_of_DELLG15_In_Inventory = 4;
		int number_Of_Times_To_Add = 4;

		if (number_Of_Times_To_Add <= amount_of_DELLG15_In_Inventory ) {

		for (int i = 0; i < number_Of_Times_To_Add; i++) {
				driver.findElement(By.xpath(
					"//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[3]/div[1]/div/div/form[1]/div[1]/button"))
					.click();
				driver.findElement(By.xpath("//*[@id=\"addToCartLayer\"]/a[2]")).click();
			// to check for the number of items and then add it to cart if sufficient
		}
		} else {
		System.out.println("No sufficient amount In Inventory");
		// if the number of "number_Of_Times_To_Add" Was more than the
			// "amount_of_DELLG15_In_Inventory, this will be printed

	}

	}

	@Test

	public void testing_price_after_discount() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String discountMessage = ((WebElement) driver.findElements(By.className("productDiscountMassage"))).getText();
		int updatedDiscountMessage = Integer.parseInt(discountMessage);
		for (int  i=0 ; i==discountMessage.length() ; i++ ) {
			
		
		System.out.println(discountMessage);

		// Converting the prices from string to integer
		String priceAfterDiscount = driver.findElement(By.xpath("//*[@id=\"newtab-Featured\"]/div/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div/div/span[3]")).getText();
		
		String[] splittedPriceAfterDiscount = priceAfterDiscount.split("JOD");
		
		
		double  updatedSplittedPriceAfterDiscount = Double.parseDouble("splittedPriceAfterDiscount"); 
       
		if (discountMessage.contains("- You save")) {

			Assert.assertEquals(updatedSplittedPriceAfterDiscount, 369*27.1/100);

		} else {

			System.out.println("There Are No Discounted Prices");
		}
		}
	}
}
