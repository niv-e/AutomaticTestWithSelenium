package PagesContract;

public interface IAddToCartPage {
    void navigateToHomePage();
    void addProductToCart();
    void navigateToCartPage();
    boolean verifyThatProductAdded();
}
