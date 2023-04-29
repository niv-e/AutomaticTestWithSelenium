package NinjaPages;

import PagesContract.IRegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class NinjaRegisterPage extends BasePage implements IRegisterPage {

    private final String successfullyRegisterUrl = NinjaWebConsts.baseUrl + "/index.php?route=account/success";

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement btnMyAccount;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    private WebElement btnNavbarRegister;

    @FindBy(id = "input-firstname")
    private WebElement tfFirstName;
    @FindBy(id = "input-lastname")
    private WebElement tfLastName;
    @FindBy(id = "input-email")
    private WebElement tfEmail;
    @FindBy(id = "input-telephone")
    private WebElement tfTelephone;
    @FindBy(id = "input-password")
    private WebElement tfPassword;
    @FindBy(id = "input-confirm")
    private WebElement tfConfirm;
    @FindBy(name = "agree")
    private WebElement cbAgree;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement btnContinue;

    public NinjaRegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void navigateToRegistrationPage() {
        driver.get(NinjaWebConsts.homeUrl);
        btnMyAccount.click();
        btnNavbarRegister.click();
    }

    @Override
    public void fillRegistrationDetails(Map<?,?> registrationDetails) {
        tfFirstName.sendKeys(
                registrationDetails.get(tfFirstName.getAttribute("id"))
                        .toString());
        tfLastName.sendKeys(
                registrationDetails.get(tfFirstName.getAttribute("id"))
                        .toString());
        tfEmail.sendKeys(
                registrationDetails.get(tfEmail.getAttribute("id"))
                        .toString());
        tfTelephone.sendKeys(
                registrationDetails.get(tfTelephone.getAttribute("id"))
                        .toString());
        tfPassword.sendKeys(
                registrationDetails.get(tfPassword.getAttribute("id"))
                        .toString());
        tfConfirm.sendKeys(
                registrationDetails.get(tfConfirm.getAttribute("id"))
                        .toString());
        cbAgree.click();
    }

    @Override
    public void clickRegister() {
        btnContinue.click();
    }

    @Override
    public boolean isRegisterSuccessfully() {
        return driver.getCurrentUrl().equals(successfullyRegisterUrl);
    }
}
