import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) myNumberList.add(i);

        
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Mth1: Iterator Value::" + i);
        }

        
        class Myconsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Mth2: Consumer impl Value::" + t);
            }
        }
        Myconsumer action = new Myconsumer();
        myNumberList.forEach(action);

        
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class value:" + t);
            }
        });

        
        Consumer<Integer> myListAction = n -> {
            System.out.println("Mth4: forEach Lambda impl value::" + n);
        };
        myNumberList.forEach(myListAction);

        
        myNumberList.forEach(n -> {
            System.out.println("Mth5: forEach Lambda impl value::" + n);
        });

        
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n -> {
            System.out.println("Mth6: forEach Lambda double value::" +
                    toDoubleFunction.apply(n));
        });

        
        Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 == 0;
        myNumberList.forEach(n -> {
            System.out.println("Mth7: forEach value of:" + n +
                    "check for Even:" + isEvenFunction.test(n));
        });
    }
}
