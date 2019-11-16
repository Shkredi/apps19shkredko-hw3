package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
     private Object[] arr;
     private int size;

     public BaseArray() {
         this.arr = new Object[0];
         this.size = 0;
     }

     public BaseArray(Object[] arr) {
         this.arr = Arrays.copyOf(arr, arr.length);
         this.size = arr.length;
     }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.arr, this.size);
    }

    @Override
    public String operationDescription() {
        return "";
    }

    @Override
    public int size() {
        return this.size;
    }
}
