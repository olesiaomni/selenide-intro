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
}
