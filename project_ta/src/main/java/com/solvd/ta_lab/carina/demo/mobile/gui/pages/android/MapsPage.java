package com.solvd.ta_lab.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.ta_lab.carina.demo.mobile.gui.pages.common.MapsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapsPageBase.class)
public class MapsPage extends MapsPageBase {

    public MapsPage(WebDriver driver) {
        super(driver);
    }

}
