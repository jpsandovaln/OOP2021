import java.util.ArrayList;
import java.util.List;

public class EjemploJava7{

     public static void main(String []args){
        List<Integer> test = new ArrayList<>();
        test.add(14);
        test.add(1);
        test.add(10);
        test.add(8);
        test.add(4);

        for (int i=0; i< test.size(); i++){
            System.out.println(test.get(i));
        }
     }
}