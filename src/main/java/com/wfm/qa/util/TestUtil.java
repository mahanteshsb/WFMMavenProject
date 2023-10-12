package com.wfm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wfm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH = "\"C:\\Users\\GLB-BLR-015\\git\\WFMMavenProject\\src"
			+ "\\main\\java\\com\\wfm\\qa\\testdata\\wfmTestData.xlsx\"";

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	static JavascriptException js;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("//span[text()='SR']");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	//helper class code
	public void waitFor(WebElement ele) {
		// waitForPageToLoad();
		// log("Waiting 60 seconds for element :" + ele + " to be visible");
		try {
			// new WebDriverWait((WebDriver)
			// driver,60).until(ExpectedConditions.visibilityOf(ele));
			// new WebDriverWait((WebDriver)
			// driver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(ele));
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
		}
	}

	public void waitForElementToBeClickable(WebElement ele) {
		// waitForPageToLoad();
		// log("Waiting 60 seconds for element :" + ele + " to be visible");
		try {
			// new WebDriverWait((WebDriver)
			// driver,60).until(ExpectedConditions.elementToBeClickable(ele));
			// new
			// WebDriverWait((WebDriver)driver,Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(ele));
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {

		}

	}

	public void waitFor(WebElement ele, int time) {
		waitForPageToLoad();
		try {
			// new WebDriverWait((WebDriver)
			// driver,time).until(ExpectedConditions.visibilityOf(ele));
			new WebDriverWait((WebDriver) driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
		}
	}

	public void waitForPageToLoad() {
		waitForpage();
		try {
			waitFor(ExpectedConditions
					.invisibilityOfAllElements(getDriver().findElements((SearchContext) By.cssSelector(".preloader"))));
		} catch (Exception e) {
		}
		waitForpage();
	}

	private By getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public void waitFor(ExpectedCondition<Boolean> invisibilityOfAllElements) throws InterruptedException {

		// Thread.sleep(2000);
		Thread.sleep(1500);
	}

	public void waitForpage() {
		try {

			// Thread.sleep(5000);
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}
//end code
	
	
	
	
	
	
	
	
	
	
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static void highlightElement(WebDriver driver, WebElement element)  {
		for (int i = 0; i <3; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 5px solid yellow;");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
		
	}
	
	
}
