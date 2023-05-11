package PagesContract;

import java.util.Map;

public interface IPurchasePage extends IAddToCartPage{
    void navigateToPurchasePage();
    void FillPurchaseForm(Map<?,?> purchaseDetails);
    void clickSubmit();
    boolean isPurchasedSuccessfully();

}
