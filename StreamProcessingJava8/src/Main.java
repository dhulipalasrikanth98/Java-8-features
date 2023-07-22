import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

interface Food{

    public void m1();
        }
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Food d = new Food() {
            @Override
            public void m1() {

            }
        };
        Food f = ()-> System.out.print("good");
        Food f1 = ()-> System.out.print("good");
        System.out.println(f+""+f1);

        Runnable runnable = ()->{
                System.out.print("runnable");
            };
        Comparator<String> comparator = (String o1, String o2) ->{
                return o2.compareTo(o1);
            };


       List<String> list = new ArrayList<>();
       list.add("srikanth");
       list.add("valli");
        Collections.sort(list,comparator);

        list.stream().forEach(System.out::println);

        Predicate<String> p1 = s -> s.contains("srikanth");

        System.out.println(p1.test("venkatesa srikanth"));

    }
}