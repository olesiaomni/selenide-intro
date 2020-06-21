package com.omni.selenideintro.common.xpathselectors;

public class X {
    public static String filterByCssClass(String value) {
        return filterBy(havingCssClass(value));
    }

    public static String filterByNoCssClass(String value) {
        return filterBy(not(havingCssClass(value)));
    }

    public static String filterBy(String predicate) {
        return "[" + predicate + "]";
    }

    public static String not(String predicate) {
        return "not(" + predicate + ")";
    }

    public static String havingCssClass(String value) {
        return "contains(concat(' ', normalize-space(@class), ' '), ' " + value + " '" +
                ")";
    }
}

