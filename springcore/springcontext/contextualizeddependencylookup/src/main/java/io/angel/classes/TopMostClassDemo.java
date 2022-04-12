package io.angel.classes;

import static java.lang.System.out;

import java.util.function.Consumer;

public class TopMostClassDemo extends AbstractTopMostClassDemo {

    TopMostClassDemo(String fieldO) {
        super(fieldO);
    }

    public static class StaticNestedClassDemo {
        private String fieldOne;

        StaticNestedClassDemo(String fieldOne) {
            this.fieldOne = fieldOne;
        }

        public String getFieldOne() {
            return fieldOne;
        }

        public void setFieldOne(String fieldOne) {
            this.fieldOne = fieldOne;
        }

        @Override
        public String toString() {
            return fieldOne;
        }
    }

    class MemberClassDemo {
        private String fieldOne;

        MemberClassDemo(String fieldOne) {
            this.fieldOne = fieldOne;
        }

        public String getFieldOne() {
            return fieldOne;
        }

        public void setFieldOne(String fieldOne) {
            this.fieldOne = fieldOne;
        }

        @Override
        public String toString() {
            return fieldOne;
        }
    }

    @Override
    public void doSomeStupidShit() {
        out.println("Drive super sport motorcycle!");
    }

    @Override
    public String toString() {
        return getFieldOne();
    }

    public static void main(String[] args) {
        TopMostClassDemo topMostClassDemo = new TopMostClassDemo("Top Most Class");
        out.println(topMostClassDemo);
        
        StaticNestedClassDemo staticNestedClassDemo = new StaticNestedClassDemo("Static Nested Class");
        out.println(staticNestedClassDemo);

        MemberClassDemo memberClassDemo = topMostClassDemo.new MemberClassDemo("Member Class Demo");
        out.println(memberClassDemo);

        Consumer<String> anonymous = new Consumer<String>() {

            @Override
            public void accept(String t) {
            }

            @Override
            public String toString() {
                return "Anonymous Nested Class";
            }
        };
        out.println(anonymous);

        class LocalClassDemo {
            private String fieldOne;

            LocalClassDemo(String field) {
                fieldOne = field;
            }

            @Override
            public String toString() {
                return fieldOne;
            }
        }

        LocalClassDemo localClassDemo = new LocalClassDemo("Local Class");
        out.println(localClassDemo);
    }
}