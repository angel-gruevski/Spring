package io.angel.classes;

public abstract class AbstractTopMostClassDemo {
    private String fieldOne;

    AbstractTopMostClassDemo(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public abstract void doSomeStupidShit();

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }
}