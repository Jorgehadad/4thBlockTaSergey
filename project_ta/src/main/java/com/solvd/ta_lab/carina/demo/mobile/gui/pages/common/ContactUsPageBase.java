package com.solvd.ta_lab.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ContactUsPageBase extends AbstractPage {

    public ContactUsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typeEmail(String email);

    public abstract void typeQuestion(String question);

    public abstract void submit();

    public abstract boolean isErrorMessagePresent();

    public abstract boolean isRecaptchaPresent();

}
