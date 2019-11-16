package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.stream.Stream;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator cmp;

    public SortDecorator(SmartArray sa, MyComparator cmp) {
        super(sa);
        this.cmp = cmp;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        Stream stream = Arrays.stream(arr);
        arr = stream.sorted((o1, o2) -> cmp.compare(o1, o2)).toArray();
        return arr;
    }

    @Override
    public String operationDescription() {
        return "sorted " + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
