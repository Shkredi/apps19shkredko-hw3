package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction func;

    public MapDecorator(SmartArray sa, MyFunction func) {
        super(sa);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = this.smartArray.toArray();
        return Arrays.stream(arr).map(ob -> func.apply(ob)).toArray();
    }

    @Override
    public String operationDescription() {
        return "Maped " + this.smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
