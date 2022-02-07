package com.solvd.ta_lab.carina.demo.gui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.ta_lab.carina.demo.gui.components.ModelItem;

public class BrandModelsPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='review-body']//li")
    private List<ModelItem> models;

    public BrandModelsPage(WebDriver driver) {
        super(driver);
    }

    public ModelInfoPage selectModel(String modelName) {
        for (ModelItem model : models) {
            if (model.readModel().equalsIgnoreCase(modelName)) {
                return model.openModelPage();
            }
        }
        throw new RuntimeException("Unable to open model: " + modelName);
    }
}
