package com.omni.selenideintro.trainingfromlessons;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.Wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class GoogleTest {
    @Test
    void shouldSearch (){
        open("https://google.com/ncr");

        element(byName("q")).setValue("selenide").pressEnter();

        ElementsCollection results = elements("#search .g");
        results.shouldHave(sizeGreaterThanOrEqual(10))
                .first().shouldHave(text("Selenide: concise UI tests in Java"));

        results.first().find(".r>a").click();
        Wait().until(titleIs("Selenide: concise UI tests in Java"));
    }
}
