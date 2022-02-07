package com.solvd.ta_lab.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.ta_lab.carina.demo.mobile.gui.pages.common.ContactUsPageBase;
import com.solvd.ta_lab.carina.demo.mobile.gui.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//*[@class='t708__icon']")
    private ExtendedWebElement contactUsLink;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactUsPageBase goToContactUsPage() {
        contactUsLink.click();
        return initPage(getDriver(), ContactUsPageBase.class);
    }

}
