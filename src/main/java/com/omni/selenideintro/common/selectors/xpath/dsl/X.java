package com.omni.selenideintro.common.selectors.xpath.dsl;

public class X {

    public static X all() {
        return new X("//*");
    }

    private String selector;

    public X(String selectorStart) {
        this.selector = selectorStart;
    }

    public X child(String type) {
        this.selector += "/" + type;
        return this;
    }

    public X by(String value){
        this.selector += value;
        return this;
    }

    public X descendant() {
        this.selector += "//*";
        return this;
    }

       public String x() {
        return this.selector;
    }

    public static class Its {
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
}
