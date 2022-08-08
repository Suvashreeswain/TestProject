package com.demo.pages;


import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.Session;

import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.automation.framework.TestSession;
import com.demo.automation.framework.pagefactory.MobileWebViewPage;
import com.demo.utils.InitData;
import com.demo.utils.PropFileHandler;

public class demoPage extends MobileWebViewPage {

	public static String platformName = InitData.platformName;

	public demoPage(TestSession session) throws Exception {

		super(session, "Applications/demo");

	}

	/**
	 * Verify the Home page is visible
	 * 
	 * @return
	 */
	public boolean isHomePageVisible() {

		WebDriverWait wait = new WebDriverWait(session.driver, 60);
		return wait.until(ExpectedConditions.visibilityOf(element("homePage"))).isDisplayed();

	}

	/**
	 * Verify the Url
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean isUrlCorrect() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("url****" + session.driver.getCurrentUrl());
		return session.driver.getCurrentUrl().contains(PropFileHandler.readProperty("url"));

	}

	/**
	 * Select any category
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void selectCategory() throws InterruptedException {
		String x1 = "//*[text()=' ";
		String x2 = PropFileHandler.readProperty("category");
		String x3 = " ']";
		String xpath = x1 + x2 + x3;
		WebElement category = session.driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) session.driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", category);
		Thread.sleep(2000);
		category.click();
	}

	/**
	 * Select brand
	 * @throws InterruptedException 
	 * 
	 */
	public void selectBrand() throws InterruptedException {
		String x1 = "//*[text()='";
		String x2 = PropFileHandler.readProperty("brand");
		String x3 = "']/parent::a/child::div";
		String xpath = x1 + x2 + x3;
		WebElement brand = session.driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) session.driver;
		js.executeScript("arguments[0].scrollIntoView();",session.driver.findElement(By.xpath(xpath)));	
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", brand);
		Thread.sleep(2000);
		brand.click();

	}

	/**
	 * Verify the options displayed according to the brand
	 * 
	 * @return
	 */
	public boolean areOptionsAccordingToFilterSet() {
		boolean status = false;

		for (int i = 0; i <= elements("optionsDisplayed").size() - 1; i++) {

			if (elements("optionsDisplayed").get(i).getText().contains(PropFileHandler.readProperty("brand"))) {
				System.out.println("Option " + i + " is -->" + elements("optionsDisplayed").get(i).getText());
				status = true;
			} else {
				status = false;
			}
		}
		return status;

	}

	/**
	 * This method is to goto the button url in testleaf website
	 */

	public void gotoButtonURL() {
		session.driver.get("http://www.leafground.com/pages/Button.html");

	}
	/**
	 * This method is to validate if we are at right url
	 * @return
	 */
	public boolean validateurl() {
		String actualTitle = session.driver.getTitle();
		String expectedTitle = "TestLeaf - Interact with Buttons";
		if(actualTitle.equals(expectedTitle))
			return true;
		else 
			return false;
	}
	/**
	 * This method is to click on the home page button
	 */
	public void clickHomePageButton() {
		element("clickOnGotoHomepageButton").click();

	}
	/**
	 * This method to validate if we are redirected back to the home page of the test leaf website
	 * @return
	 */
	public boolean validateRedierction() {
		String actualTitle = session.driver.getTitle();
		//System.out.println("validate redierction:"+actualTitle);
		String expectedTitle = PropFileHandler.readProperty("HomePageTitle");
		if(actualTitle.equals(expectedTitle))
			return true;
		else 
			return false;
	}




	/**
	 * This method is to goto GitHub url
	 */
	public void gotoHomePageURL() {
		session.driver.get("https://www.github.com");

	}

	/**
	 * This method is to Verify the GitHub Home page is visible
	 * @return
	 */
	public boolean HomepageVisible() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("githubHomePage"))).isDisplayed();

	}
	/**
	 * This method is to Verify the GitHub Home page SignIn is visible
	 * @return
	 */
	public boolean signinVisible() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("signinVisible"))).isDisplayed();	

	}
	/**
	 * This method is to click on SignIn button on GitHub home page
	 */
	public void clickOnSignIn() {
		element("clickOnSignIn").click();

	}
	/**
	 * This method is to Verify the actual and expected url's are not same	
	 * @return
	 */

	public boolean validateGitHubUrl() {
		String actualTitle=session.driver.getTitle();
		//String expectedTitle = ("Sign in to GitHub · GitHub");
		String expectedTitle = ("GitHub: Where the world builds software · GitHub");
		//System.out.println("validate github actaul title:" + actualTitle);
		if (actualTitle.equals(expectedTitle))
			return true;
		else 
			return false;

	}
	/**
	 * This method is to send text and verify email field 
	 */

	public void emailField() {
		element("emailField").sendKeys("abc@gmail.com");

	}
	/**
	 * This method is to verify password field 
	 */
	public void passwordField() {
		element("passwordField").sendKeys("abcdefg");

	}
	/**
	 * This method is to click on SignIn button
	 */
	public void clickonSigninButton() {
		element("clickonSigninButton").click();

	}

	//------------Below steps are for Amazon product Add to cart scenario-------------------------//

	/**
	 * This method is to goto Amazon Home page
	 */
	public void goToAmazonHomePage() {
		session.driver.get("https://www.amazon.com/");

	}
	/**
	 * This method is to actual and expected URL both are same
	 * @return
	 */
	public boolean validateAmazonUrl() {
		String ActualT=session.driver.getTitle();
		String ExpectedT=("Amazon.com. Spend less. Smile more.");
		if (ActualT.equals(ExpectedT)) 
			return true;	
		else 
			return false;
	}
	/**
	 * This method is enter data to amazon search box
	 */
	public void enterData() {

		element("serchbox").sendKeys("iphone 13 unlocked");
	}
	/**
	 * This method is to click on search button
	 */
	public void clickOnSearch() {
		element("clickOnSearch").click();

	}
	/**
	 * This method is the options are displaying according to the filter
	 * @return
	 */
	public boolean optionsDisplayed() {

		boolean status=false;
		for (int i = 0; i <= elements("optionsDisplayed").size() - 1; i++) {

			if (elements("optionsDisplayed").get(i).getText().contains(PropFileHandler.readProperty("brand"))) {
				System.out.println("Option " + i + " is -->" + elements("optionsDisplayed").get(i).getText());
				status = true;
			} else {
				status = false;
			}
		}
		return status;
	}
	/**
	 * This method is to scroll down 
	 */
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) session.driver;
		js.executeScript("window.scrollBy(0,400)");

	}
	/**
	 * This method is to click on iPhone
	 */
	public void selectIphone() {
		element("iPhone").click();

	}
	/**
	 * This method is add to cart button displayed
	 * @return
	 */
	public boolean addToCartDisplayed() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("AddToCart"))).isDisplayed();	

	}
	/**
	 * This method is to click on add to cart button
	 */
	public void clickOnAddToCart() {
		element("AddToCart").click();

	}
	/**
	 * This method is to click on No Thanks button
	 */
	public void noThanksButton() {
		element("noThanks").click();

	}
	/**
	 * This method is to verify product in cart
	 * @return
	 */
	public boolean productInCart() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("productInCart"))).isDisplayed();	
	}
	/**
	 * This method is to close the browser
	 */
	public void closeBrowser() {

		//session.driver.close();
	}

	//------------Below steps are for Biskane page validation scenario-------------------------//
	/**
	 * This method is to goto Biskane QA Home page
	 */
	public void biskanePageURL() {

		session.driver.get("https://qa.biskane.com/login");

	}
	/**
	 * This method is enter data into email field box
	 */

	public void loginEmail() {
		element("loginEmailField").sendKeys("pooja@katchintech.com");

	}
	/**
	 * This method is enter data into password field box
	 */
	public void loginPassword() {
		element("loginPasswordField").sendKeys("Cust@123");

	}
	/**
	 * This method is to click on SignIn button
	 */
	public void clickHomepageSignin() {
		element("clickHomepageSignin").click();

	}
	/**
	 * This method is to validate DashBoard page title
	 * @return
	 */
	public boolean validateDashboard() {
		String ActT=session.driver.getTitle();
		String ExpT=("NATIVE AMERICAN AND INDIGENOUS ARTS");
		if (ActT.equals(ExpT)) 
			return true;	
		else 
			return false;

	}
	/**
	 * This method is to click on logout button
	 * @return
	 */
	public void logoutButton() {
		element("logout").click();

	}
	/**
	 * This method is to click on Home button
	 * @return
	 */
	public void clickHome() {
		element("clickHome").click();
	}

	/**
	 * This method is to click on shop now  button
	 * @return
	 */
	public void clickShopNow() {
		element("shopNow").click();

	}
	/**
	 * This method is to validate shop page title
	 * @return
	 */
	public boolean verifyShopPage(){
		String ActShopPage=session.driver.getTitle();
		String ExpShopPage=("NATIVE AMERICAN AND INDIGENOUS ARTS");
		if (ActShopPage.equals(ExpShopPage)) 
			return true;	
		else 
			return false;
	}
	/**
	 * This method is to count number of categories in shop page
	 * @throws InterruptedException 
	 * 
	 */
	public void numberOfElements() throws InterruptedException {

		//	WebDriverWait wait = new WebDriverWait(session.driver, 30);
		//	wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@data-aos='fade-up']"),0));

		Thread.sleep(10000);
		List<WebElement> links =session.driver.findElements(By.xpath("//div[@data-aos='fade-up']"));
		//List<WebElement> links =session.driver.findElements(By.xpath("//*[@class='row']"));
		//Thread.sleep(5000);
		System.out.println("Count number of categories:"+links.size());

		for (WebElement categorieslinksText : links) {

			System.out.println("Number of categories names:"+categorieslinksText.getText());

		}
	}
	/**
	 * This method is to click on switch user
	 */
	public void clickOnSwitchUser() {
		element("switchUser").click();	
	}
	/**
	 * This method is to select Artist from switch user drop down menu.
	 */
	public void selectArtist() {
		element("selectArtist").click();

	}
	/**
	 * This method is to click on yes button.
	 */
	public void clickOnYesButton() {
		element("clickOnYesButton").click();

	}
	/**
	 * This method is to validate artist home page.
	 * @return
	 */
	public boolean validateArtistPage() {
		String ActArtistPage=session.driver.getTitle();
		String ExpArtistPage=("NATIVE AMERICAN AND INDIGENOUS ARTS");
		if (ActArtistPage.equals(ExpArtistPage)) 
			return true;	
		else 
			return false;

	}
	/**
	 * This method is to enter data in to artist password field
	 */
	public void artistPassword() {
		element("loginPasswordField").sendKeys("Artist@123");

	}
	/**
	 * This method is to click on collection
	 */
	public void collection() {
		element("collection").click();

	}
	/**
	 * This method is to 
	 * @throws InterruptedException 
	 */
	public void collectionButton() throws InterruptedException {
		element("collectionButton").click();
		Thread.sleep(5000);
	}
	/**
	 *
	 * This method is to clear the product text box and send text to text box
	 */
	public void editProductTitleBox() {

		element("ProductTitleBox").clear();
		element("ProductTitleBox").sendKeys("Jellyfish");
	}
	/**
	 * This method is to select item from product Category drop down
	 */
	public void productCategory() {
		element("productCategory").click();
		//element("productCategory");
		//Select sel=new Select(element("productCategory"));
		//sel.selectByVisibleText("Home & Life");
		element("productCategoryFoodSov").click();
	}
	/**
	 * This method is to click logout button on Artist page 
	 */
	public void artistPageLogout() {
		element("artistPageLogout").click();

	}
	/**
	 * This method is to click on submit button
	 */
	public void submit() {
		element("submit").click();

	}
	/**
	 * This method is to verify product title is edited and changed
	 * @return
	 */
	public boolean productTitle() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("productTitle"))).isDisplayed();
	}
	/**
	 * This method is to change profile picture
	 * @throws InterruptedException
	 */
	public void ChangeProfilePic() throws InterruptedException {

		element("chooseFile").sendKeys("/Users/sabyasachinayak/Desktop/pinky/candle.jpg");



	}
	/**
	 * This method is to delete collection from collection list
	 * 
	 */
	public void deleteCollection() {
		element("deleteCollection").click();
		element("delete").click();
	}
	/**
	 * This method is to click on art button
	 */
	public void artButton() {
		element("artButton").click();

	}
	/**
	 * This method is to click on dash board
	 */
	public void dashBoard() {
		element("dashBoard").click();
	}
	/**
	 * This method is to verify item is visible in cart
	 * @return
	 */
	public boolean addedToCart() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("addedToCart"))).isDisplayed();
	}	
	/**
	 * This method is to click on buy now button
	 */
	public void buyNowButton() {
		element("buyNowButton").click();

	}
	/**
	 * This method is to Scroll down till Add to cart button is visible 
	 */
	public void addToCartButtonVisible(){
		JavascriptExecutor javase = (JavascriptExecutor)session.driver;
		javase.executeScript("window.scrollBy(0,-400)");
	}
	/**
	 * This method is to click on add to cart button
	 * 
	 */
	public void addedToCartButton() {
		element("addedToCartButton").click();

	}
	/**
	 * This method is to click on order button
	 */
	public void clickOnOrder() {
		element("clickOnOrder").click();

	}
	/**
	 * This method is to click on select button
	 */
	public void clickOnSelect() {
		element("clickOnSelect").click();

	}
	/**
	 * This method is to select shipped from drop down box
	 */

	public void clickSelectType() {
		element("clickSelectType").click();

	}
	/**
	 * This method is to click on ok button
	 */
	public void clickOnOkButton() {
		element("clickOn").click();

	}
	/**
	 * This method is to click on go button
	 */

	public void clickOnGo() {
		element("clickOnGo").click();

	}
	/**
	 * This method is to click on refund button
	 */
	public void ClickRefund() {
		element("ClickRefund").click();

	}
	/**
	 * This method is to verify refund status
	 * @return
	 */
	public boolean refundStatus() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("refundStatus"))).isDisplayed();
	}
	/**
	 * This method is go to next page 
	 */
	public void nextPageButton() {
		element("nextPage").click();

	}
	/**
	 * This method is to send text to comment box
	 * @throws InterruptedException 
	 */
	public void commentBox() throws InterruptedException {
		Thread.sleep(3000);
		element("commentBox").clear();
		element("commentBox").sendKeys("Refund");

	}
	/**
	 * This method is to click on action button
	 * @throws InterruptedException 
	 */
	public void actionButton() throws InterruptedException {
		Thread.sleep(4000);
		element("actionButton").click();

	}
	/**
	 * This method is to select NO.of ITEM to REFUND
	 * @throws InterruptedException 
	 */
	public void clickQTYbutton() throws InterruptedException {
		Thread.sleep(3000);
		element("clickQTYbutton").clear();
		element("clickQTYbutton").sendKeys("1");

	}
	/**
	 * This method is to click on approve button
	 */
	public void clickApprove() {
		element("clickApprove").click();

	}
	/**
	 * This method is to send password to password field 
	 */
	public void storePassword() {
		element("loginPasswordField").sendKeys("Store@123");	

	}
	/**
	 * This method is to click on my shop button
	 */
	public void myShopButton() {

		element("myShopButton").click();
	}
	/**
	 * This method is to verify shop page
	 * @return
	 */
	public boolean shoppage() {
		WebDriverWait wait = new WebDriverWait(session.driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element("shoppage"))).isDisplayed();
	}
	/**
	 * This method is click on collection button
	 */
	public void newCollectionButton() {
		element("newCollectionButton").click();

	}
	/**
	 * This method is to click on add new collection button
	 */
	public void addCollectionButton() {
		element("addCollectionButton").click();

	}
	/**
	 * This method is to click on submit button 
	 * @throws InterruptedException 
	 */
	public void collectionSubmitButton() throws InterruptedException {
		Thread.sleep(5000);
		element("collectionSubmitButton").click();
		Thread.sleep(5000);
	}
	/**
	 * This method is to add product details
	 */

	public void productDetails() {
		element("productImage").sendKeys("/Users/sabyasachinayak/Desktop/pinky/painting.jpg");

	}
	/*
	 * This method is to write product title
	 */
	public void productTit() {
		element("productTitle").sendKeys("Painting");
	}
	/*
	 * This method is to add product description
	 */

	public void productDescription() {
		element("description").sendKeys("Nice Painting");

	}
	/*
	 * This method is to click on price button
	 */
	public void updatePriceButton() {
		element("updatePrice").click();
	

	}
	/*
	 *This method is to select Art from Product Category
	 */
	public void artProductCategory() {
		element("art").click();

	}
	/*
	 * This method is to add cost of the item
	 */
	public void addCostOfItem() throws InterruptedException {
		Thread.sleep(5000);
		element("costOfItem").sendKeys("100");
	}
	/*
	 * This method is to select weight 
	 */
	public void selectWeight() {

		element("weight").clear();
		element("weight").sendKeys("1");
	}
	/*
	 * This method is to select weight type
	 */
	public void weightType() {
		element("weightType").click();

	}
	/*
	 * This method is to add Length and Width and Height of the product 
	 */
	public void productSize() throws InterruptedException {
		Thread.sleep(5000);
		WebElement length=session.driver.findElement(By.xpath("//*[@id=\"artistaddmycoolection\"]/div/div/div/div/div[2]/div/div[7]/div/div[1]/div/div[5]"));
		WebElement Width=session.driver.findElement(By.xpath("//*[@id=\"artistaddmycoolection\"]/div/div/div/div/div[2]/div/div[7]/div/div[2]/div/div[5]"));
		WebElement height=session.driver.findElement(By.xpath("//*[@id=\"artistaddmycoolection\"]/div/div/div/div/div[2]/div/div[7]/div/div[3]/div/div[5]"));
		Actions action= new Actions(session.driver);
		action.dragAndDropBy(length, 60, 1).perform();
		action.dragAndDropBy(Width, 50, 1).perform();
		action.dragAndDropBy(height, 60, 1).perform();
		Thread.sleep(5000);
	}
	/*
	 * This method is to add quantity of the product
	 */
	public void quantity() {
		element("quantity").sendKeys("1");

	}
	/*
	 * This method is to add pre order days 
	 */
	public void PreOrderdays() {
		element("PreOrderdays").sendKeys("10");

	}
	/*
	 * This method is to add Maximum no. of items per parcel
	 */
	public void maxItem() {
		element("maxItem").sendKeys("3");
	}
	/*
	 * This method is to logout shop page
	 */
	public void shopPageLogout() throws InterruptedException {
		Thread.sleep(5000);
		element("shopPageLogout").click();
	}
	/*
	 * This method is to click on art type Radio button
	 */
	public void artTypeRadioButton() {
		element("artTypeRadioButton").click();
	}

	public void imageSubmit() {
		element("imageSubmit").click();
		
	}
}







