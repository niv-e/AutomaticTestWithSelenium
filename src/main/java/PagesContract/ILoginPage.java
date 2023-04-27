package PagesContract;

public interface ILoginPage {
    void navigateToLoginForm();
    void enterUserEmail(String email);
    void enterPassword(String pass);
    void clickLogin();
    boolean isLoginSuccessfully();

}
