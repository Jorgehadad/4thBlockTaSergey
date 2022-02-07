package com.solvd.ta_lab.carina.demo;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qaprosoft.carina.browsermobproxy.ProxyPool;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.ta_lab.carina.demo.gui.pages.HomePage;
import com.solvd.ta_lab.carina.demo.gui.pages.NewsPage;
import com.zebrunner.agent.core.registrar.Artifact;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.proxy.CaptureType;

/**
 * This sample shows how generate har file with proxied Web test content.
 *
 * @author qpsdemo
 */
public class ProxySampleTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    BrowserMobProxy proxy;

    @BeforeMethod(alwaysRun = true)
    public void startProxy()
    {
        R.CONFIG.put("browsermob_proxy", "true");
        getDriver();
        proxy = ProxyPool.getProxy();
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testNewsSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        NewsPage newsPage = homePage.getFooterMenu().openNewsPage();
        Assert.assertTrue(newsPage.isPageOpened(), "News page is not opened!");

        // Saving har to a file...
        String name = "ProxyReport.har";
        File file = new File(name);
        Assert.assertNotNull(proxy.getHar(), "Har is NULL!");

        try {
            proxy.getHar().writeTo(file);
            Artifact.attachToTest(name, file);
        } catch (IOException e) {
            LOGGER.error("Unable to generate har archive!", e);
        }
    }


}
