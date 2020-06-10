package com.omni.selenideintro.trainingfromlessons;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest {
    @Test
    void completesTask() {

        Configuration.timeout = 6000;
        open("http://todomvc.com/examples/emberjs/");


        element("#new-todo").setValue("a").pressEnter();
        element("#new-todo").setValue("b").pressEnter();
        element("#new-todo").setValue("c").pressEnter();


        elements("#todo-list>li").shouldHave(exactTexts("a", "b", "c"));


        elements("#todo-list>li").findBy(exactText("b"))
                .find(".toggle").click();

        elements("#todo-list>li").filterBy(not(cssClass("completed")))
                .shouldHave(exactTexts("a", "c"));
    }
}
