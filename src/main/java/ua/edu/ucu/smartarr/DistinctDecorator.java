package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    private int size;

    public DistinctDecorator(SmartArray sa) {
        super(sa);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        arr = Arrays.stream(arr).distinct().toArray();
        this.size = arr.length;
        return arr;
    }

    @Override
    public String operationDescription() {
        return "Distingted " + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.size;
    }
}
