package com.omni.selenideintro.common.selectors.xpath.dsl;

public class X {

    public static X any() {
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

    public X child(){
        return child("*");
    }

    public X descendant(String value){
        this.selector += "//" + value;
        return this;
    }

    public X descendant() {
        return descendant("*");
    }

    public X by(String predicate){
        this.selector += "[" + predicate + "]";
        return this;
    }

    public X byNot(String predicate){
        return by(Its.not(predicate));
    }

       public String x() {
        return this.selector;
    }
}
