package com.omni.selenideintro.todomvc.dslforxpath;

import com.codeborne.selenide.Configuration;
import com.omni.selenideintro.common.xpathdsl.XPath;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class OperationsTest {
   // Selector list
    String newTodoList = XPath.all().filterById("new-todo").path(),
           todoList = XPath.all().filterById("todo-list").child("li").path(),
           toggleTaskBInTodoList = XPath.all().filterById("todo-list")
                    .child("li").filterByDescendantWithText("b")
                    .descendant().filterByCssClass("toggle").path(),
           completedTasks = XPath.all().filterById("todo-list")
                   .child("li").filterByCssClass("completed").path(),
           notCompletedTasks = XPath.all().filterById("todo-list")
                   .child("li").filterByNoCssClass("completed").path();

    @Test
    void completesTask() {

        Configuration.timeout = 6000;
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath(newTodoList)).setValue("a").pressEnter();
        element(byXpath(newTodoList)).setValue("b").pressEnter();
        element(byXpath(newTodoList)).setValue("c").pressEnter();
        elements(byXpath(todoList)).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath(toggleTaskBInTodoList)).click();
        elements(byXpath(completedTasks)).shouldHave(exactTexts("b"));
        elements(byXpath(notCompletedTasks)).shouldHave(exactTexts("a", "c"));
    }
}
