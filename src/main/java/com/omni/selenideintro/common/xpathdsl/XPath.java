package com.omni.selenideintro.common.xpathdsl;

public class XPath {

    public static XPath all() {
        return new XPath("//*");
    }

    private String selector;

    public XPath(String selector_start) {
        selector = selector_start;
    }

    public XPath filterById(String id) {
        this.selector += "[@id='" + id + "']";
        return this;
    }

    public XPath child(String childType) {
        this.selector += "/" + childType + "";
        return this;
    }

    public XPath filterByDescendantWithText(String text) {
        this.selector += "[.//text()='" + text + "']";
        return this;
    }

    public XPath descendant() {
        this.selector += "//*";
        return this;
    }

    public XPath filterByCssClass(String value) {
        this.selector += "[contains(concat(' ', normalize-space(@class), ' '), ' " + value + " ')]";
        return this;
    }

    public XPath filterByNoCssClass(String value) {
        this.selector += "[not(contains(concat(' ', normalize-space(@class), ' '), ' " + value + " '))]";
        return this;
    }

    public String path() {
        return selector;
    }
}
