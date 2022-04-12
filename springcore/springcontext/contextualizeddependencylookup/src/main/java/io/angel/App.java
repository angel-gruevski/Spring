package io.angel;

class NumericValue implements Comparable<NumericValue> {

    private byte value;

    NumericValue(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }

    public int compareTo(NumericValue that) {
        return this.value - that.value;
    }
}

class Collections {
    public static <A extends Comparable<A>> A max(Collection<A> xs) {
        Iterator<A> xi = xs.iterator();
        A w = xi.next();
        while (xi.hasNext()) {
            A x = xi.next();
            if (w.compareTo(x) < 0)
                w = x;
        }
        return w;
    }
}

public class App {
    public static void main(String[] args) {
        LinkedList<NumericValue> numberList = new LinkedList<NumericValue>();
        numberList.add(new NumericValue((byte) 0));
        numberList.add(new NumericValue((byte) 1));
        NumericValue y = Collections.max(numberList);
    }
}