package NinjaPages;

import PagesContract.ILoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NinjaLoginPage extends BasePage implements ILoginPage {

    private final String successfullyLoginUrl = NinjaWebConsts.myAccountUrl;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement btnMyAccount;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private WebElement btnNavbarLogin;
    @FindBy(id = "input-email")
    private WebElement tfEmail;
    @FindBy(id = "input-password")
    private WebElement tfPassword;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement btnLogin;

    public NinjaLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigateToLoginForm() {
        driver.get(NinjaWebConsts.homeUrl);
        btnMyAccount.click();
        btnNavbarLogin.click();
    }

    @Override
    public void enterUserEmail(String email) {
        tfEmail.sendKeys(email);
    }

    @Override
    public void enterPassword(String pass) {
        tfPassword.sendKeys(pass);
    }

    @Override
    public void clickLogin() {
        btnLogin.click();
    }

    @Override
    public boolean isLoginSuccessfully() {
        return driver.getCurrentUrl().equals(successfullyLoginUrl);
    }
}
