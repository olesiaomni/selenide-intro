package com.omni.selenideintro.todomvc.xpathrefactoring;

import com.codeborne.selenide.Configuration;
import com.omni.selenideintro.common.xpathselectors.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class OperationsTest {
    @Test
    void completesTask() {

        Configuration.timeout = 6000;
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']/li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//*[@id='todo-list']/li[.//text()='b']//*" +
                X.filterByCssClass("toggle")))
                .click();
        elements(byXpath("//*[@id='todo-list']/li" +
                X.filterByCssClass("completed")))
                .shouldHave(exactTexts("b"));
        elements(byXpath("//*[@id='todo-list']/li" +
                X.filterByNoCssClass("completed")))
                .shouldHave(exactTexts("a", "c"));
    }
}
