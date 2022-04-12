package io.angel;

public class Summation {
    private static <T> boolean compareArrays(T[] x, T[] y) {
        if(x.length != y.length)
            return false;
        
        for(int i = 0; i < x.length; i++) {
            if(!x[i].equals(y[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer x[] = {1, 2, 3, 4, 5};
        Integer y[] = {1, 2, 3, 4, 5};
        Integer z[] = {1, 2, 4, 5, 2};

        if(compareArrays(x, y)){
            System.out.println("Equal");
        }

        if(compareArrays(x, z)){
            System.out.println("Equal");
        }
    }
}