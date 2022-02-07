
package com.solvd.ta_lab.carina.demo;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.solvd.ta_lab.carina.demo.gui.pages.localizationSample.WikipediaHomePage;
import com.solvd.ta_lab.carina.demo.gui.pages.localizationSample.WikipediaLocalePage;
import com.zebrunner.agent.core.annotation.TestLabel;

/**
 * This sample shows how create Web Localization test with Resource Bundle.
 *
 * @author qpsdemo
 */

public class WebLocalizationSample implements IAbstractTest {

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = "l10n")
    public void testLanguages() {
        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());

        wikipediaLocalePage.hoverContribElem();
        wikipediaLocalePage.clickDiscussionBtn();

        L10N.assertAll();
    }

    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = "l10n")
    public void testAddNewLanguages() {
        WikipediaHomePage wikipediaHomePage = new WikipediaHomePage(getDriver());
        wikipediaHomePage.open();

        WikipediaLocalePage wikipediaLocalePage = wikipediaHomePage.goToWikipediaLocalePage(getDriver());

        wikipediaLocalePage.hoverWelcomeText();
        wikipediaLocalePage.hoverContribElem();
        wikipediaLocalePage.hoverCreateAccountElem();

        wikipediaLocalePage.hoverHeaders();

        wikipediaLocalePage.clickDiscussionBtn();

        L10N.flush();
        L10N.assertAll();
    }
}