package PagesContract;

import java.util.Map;

public interface IRegisterPage {
    void navigateToRegistrationPage();
    void fillRegistrationDetails(Map<?,?> registrationDetails);
    void clickRegister();
    boolean isRegisterSuccessfully();


}
