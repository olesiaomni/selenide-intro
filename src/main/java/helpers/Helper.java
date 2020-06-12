package helpers;

public class Helper {
    public String hasCssClass(String className) {
       return "contains(concat(' ', normalize-space(@class), ' '), ' " + className;
    }
}

