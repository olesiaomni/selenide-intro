package com.omni.selenideintro.common.selectors.xpath.dsl;

public class Its {

    public static String id(String value){
        return "@id='" + value + "'";
    }

    public static String descendantText(String value){
        return ".//text()='" + value + "'";
    }

    public static String сssClass(String value) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value + " '" + ")";
    }
}
