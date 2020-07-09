package com.omni.selenideintro.todomvc.dslforxpath;

import com.codeborne.selenide.Configuration;
import com.omni.selenideintro.common.selectors.xpath.dsl.Its;
import com.omni.selenideintro.common.selectors.xpath.dsl.X;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class OperationsTest {
   
    @Test
    void completesTask() {

        Configuration.timeout = 6000;
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath(X
                .any().by(Its.id("new-todo"))
                .x())).setValue("a").pressEnter();
        element(byXpath(X.
                any().by(Its.id("new-todo"))
                .x())).setValue("b").pressEnter();
        element(byXpath(X.
                any().by(Its.id("new-todo"))
                .x())).setValue("c").pressEnter();
        elements(byXpath(X
                .any().by(Its.id("todo-list")).child("li")
                .x())).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath(X
                .any().by(Its.id("todo-list"))
                .child("li").by(Its.descendantText("b"))
                .descendant().by(Its.сssClass("toggle"))
                .x())).click();
        elements(byXpath(X
                .any().by(Its.id("todo-list"))
                .child("li").by(Its.сssClass("completed"))
                .x())).shouldHave(exactTexts("b"));
        elements(byXpath(X
                .any().by(Its.id("todo-list"))
                .child("li").byNot(Its.сssClass("completed"))
                .x())).shouldHave(exactTexts("a", "c"));
    }
}
