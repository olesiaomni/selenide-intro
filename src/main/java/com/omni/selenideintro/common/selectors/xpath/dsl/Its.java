package com.omni.selenideintro.common.selectors.xpath.dsl;

public class Its {
    public static String cssClass(String value) {
        return by(havingCssClass(value));
    }

    public static String noCssClass(String value) {
        return by(not(havingCssClass(value)));
    }

    public static String id(String value){
        return by("@id='" + value + "'");
    }

    public static String descendantWithText(String value){
        return by(".//text()='" + value + "'");
    }

    public static String by(String predicate) {
        return "[" + predicate + "]";
    }

    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }

    public static String havingCssClass(String value) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value + " '" + ")";
    }
}
