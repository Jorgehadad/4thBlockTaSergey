package com.solvd.ta_lab.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.ta_lab.carina.demo.mobile.gui.pages.common.ChartsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

}
