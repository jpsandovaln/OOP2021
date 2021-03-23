import java.util.ArrayList;
import java.util.List;

public class EjemploJava8 {

     public static void main(String []args){
        List<Integer> test = new ArrayList<>();
        test.add(15);
        test.add(1);
        test.add(10);
        test.add(8);
        test.add(4);

        test.stream()
                .forEach(value -> System.out.println(value));
     }
}