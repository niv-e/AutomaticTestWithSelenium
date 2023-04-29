package NinjaPages;

import PagesContract.IAddToCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NinjaAddToCart extends BasePage implements IAddToCartPage {

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")
    private WebElement btnAddIphoneToCart;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a/i")
    private WebElement btnMyCart;

    public NinjaAddToCart(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigateToHomePage() {
        driver.get(NinjaWebConsts.homeUrl);
    }

    @Override
    public void addProductToCart() {
        btnAddIphoneToCart.click();
    }

    @Override
    public void navigateToCartPage() {
        btnMyCart.click();
    }

    @Override
    public boolean verifyThatProductAdded() {
        //TODO: add logic to check that the item was added successfully
        return true;
    }
}
