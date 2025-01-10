package pages;

import com.thoughtworks.gauge.Step;
import helper.ClickHelper;
import helper.SendKeysHelper;


public class LoginPage {
    SendKeysHelper sendKeysHelper = new SendKeysHelper();
    ClickHelper clickHelper = new ClickHelper();

    @Step("Kullanici adi <key> alani <text> ile doldurulur")
    public void fillUsername(String jsonKey,String text) {
        sendKeysHelper.sendKeys(jsonKey,text);
    }

    @Step("Sifre <key> alani <text> ile doldurulur")
    public void fillPassword(String jsonKey,String text) {
        sendKeysHelper.sendKeys(jsonKey,text);
    }
    @Step("Login <key> butonuna tiklanir")
    public void clickLogin(String jsonKey) {
        clickHelper.clickElement(jsonKey);
    }

}
