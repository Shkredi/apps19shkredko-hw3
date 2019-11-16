package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static javafx.scene.input.KeyCode.M;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new MapDecorator(
                    new SortDecorator(
                        new FilterDecorator(sa, pr),
                    cmp),
                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                    Student[] students) {
        MyPredicate year2 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getYear() == 2;
            }
        };

        MyPredicate GPA4 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getGPA() >= 4;
            }
        };

        MyComparator ordersur = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = ((Student)o1).getSurname();
                String s2 = ((Student)o2).getSurname();
                return s1.compareTo(s2);
            }
        };

        MyFunction sur =  new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student)t).getSurname() + " "
                        + ((Student)t).getName();
            }
        };

        SmartArray sa = new BaseArray(students);

        sa = new DistinctDecorator(
                new MapDecorator(
                        new SortDecorator(
                                new FilterDecorator(
                                        new FilterDecorator(sa, year2),
                                        GPA4),
                                ordersur),
                        sur)
        );

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
