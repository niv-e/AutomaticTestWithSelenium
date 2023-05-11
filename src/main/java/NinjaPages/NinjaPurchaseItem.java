package NinjaPages;

import PagesContract.IPurchasePage;
import PagesContract.IRegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class NinjaPurchaseItem extends NinjaAddToCart implements IPurchasePage {	

    public NinjaPurchaseItem(WebDriver driver) {
		super(driver);
	}

	private final String successfullyPurchasedURL = NinjaWebConsts.baseUrl + "/index.php?route=checkout/success";
	
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a/i")
	private WebElement btnCart;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]")
	private WebElement btnCheckout;
	
	@FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label")
	private WebElement btnChooseAsAGuest;
	
	@FindBy(id = "button-account")
	private WebElement btnContinueCheckout;
	
    @FindBy(id = "input-payment-firstname")
    private WebElement tfFirstName;
    
    @FindBy(id = "input-payment-lastname")
    private WebElement tfLastName;
    
    @FindBy(id = "input-payment-address-1")
    private WebElement tfAddress;
    
    @FindBy(id = "input-payment-city")
    private WebElement tfCity;
    
    @FindBy(id = "input-payment-email")
    private WebElement tfEmail;
    
    @FindBy(id = "input-payment-telephone")
    private WebElement tfTelephone;
	
    @FindBy(id = "input-payment-postcode")
    private WebElement tfPostCode;
	
    @FindBy(id = "input-payment-zone")
    private WebElement tfPaymentZone;
    
    @FindBy(id = "button-guest")
    private WebElement btnDeliverAsGuest;
    
    @FindBy(id = "button-shipping-method")
    private WebElement btnShippingMethod;
    
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
	private WebElement btnTermsAndConditions;
    
	@FindBy(id = "button-payment-method")
	private WebElement btnPaymentMethod;
	
	@FindBy(id = "button-confirm")
	private WebElement btnConfirmOrder;
      


	@Override
	public void navigateToCartPage() {
		this.btnCart.click(); // go to cart click & wait
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void navigateToPurchasePage() {
		try {
			this.btnCheckout.click(); // click on checkout & wait
			Thread.sleep(1000);
			this.btnChooseAsAGuest.click(); // choose checkout as a guest 
			this.btnContinueCheckout.click(); // click on continue
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void FillPurchaseForm(Map<?, ?> purchaseDetails) {
		try {
			tfFirstName.sendKeys(purchaseDetails.get(tfFirstName.getAttribute("id"))
	                .toString());
			tfLastName.sendKeys(purchaseDetails.get(tfLastName.getAttribute("id"))
	                .toString());
			tfAddress.sendKeys(purchaseDetails.get(tfAddress.getAttribute("id"))
					.toString());
			tfCity.sendKeys(purchaseDetails.get(tfAddress.getAttribute("id"))
					.toString());
			tfEmail.sendKeys(purchaseDetails.get(tfEmail.getAttribute("id"))
					.toString());
			tfTelephone.sendKeys(purchaseDetails.get(tfTelephone.getAttribute("id"))
					.toString());
			tfPostCode.sendKeys(purchaseDetails.get(tfTelephone.getAttribute("id"))
					.toString());      
	      
			Thread.sleep(1000);
	        tfPaymentZone.sendKeys(purchaseDetails.get(tfPaymentZone.getAttribute("id")).toString());//
	        Thread.sleep(1500);
	        btnDeliverAsGuest.click(); // click on deliver as a guest
	        Thread.sleep(1500);
	        btnShippingMethod.click(); // click on delivery method
	        Thread.sleep(1500); 
	        btnTermsAndConditions.click(); // click on accept terms and conditions
	        Thread.sleep(1500);
	        btnPaymentMethod.click(); // click on payment method
	        Thread.sleep(1500);
		}
	    catch (InterruptedException e) {
	    	e.printStackTrace();
	    }	
	}

	@Override
	public void clickSubmit() {
		btnConfirmOrder.click(); // click on confirm order		
	}

	@Override
	public boolean isPurchasedSuccessfully() {
	      try {
	          Thread.sleep(1500);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
		return driver.getCurrentUrl().equals(successfullyPurchasedURL);
	}


}
