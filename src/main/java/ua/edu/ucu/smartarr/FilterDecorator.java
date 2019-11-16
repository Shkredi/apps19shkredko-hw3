package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate pr;
    private int size;

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
        this.pr = pr;
        this.size = this.toArray().length;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        arr = Arrays.stream(arr).filter(ob -> pr.test(ob)).toArray();
        this.size = arr.length;
        return arr;
    }

    @Override
    public String operationDescription() {
        return "Filtered " + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.size;
    }
}
