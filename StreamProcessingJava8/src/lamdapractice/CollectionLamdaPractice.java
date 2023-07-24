package lamdapractice;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionLamdaPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(3);
        list.add(12);
        list.add(21);

        System.out.println(list);
        Collections.sort(list, (Integer o1, Integer o2)->{
                return o1.compareTo(o2);
            }
        );
        System.out.print(list);

        List<String> list1 = new ArrayList<>();
        list1.add("1=1");
        list1.add("2=2");
        list1.add("3=3");

        Function<List<String>,HashMap<Integer,Integer>> function = (a)->{
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            a.forEach(i->hashMap.put(Integer.parseInt(String.valueOf(i.charAt(0))),Integer.parseInt(String.valueOf(i.charAt(2)))));
            return hashMap;

        };
        HashMap<Integer,Integer> hashMap = function.apply(list1);
        System.out.println(hashMap);


        List<Object> list2 = new ArrayList<>();

        list2.add(null);
        list2.add(1);
        list2.add(2);


        Predicate<Object> checkNullValues = (o)->o==null;

       Function<List<Object>,List<Object>> removeNullValues = (a)->{

           Iterator it = a.listIterator();
           while(it.hasNext()){

               if(checkNullValues.test(it.next())){
                   it.remove();
               }
           }
           return a;
        };


       List<String> stringdata = Stream.of("a","b","c").collect(Collectors.toList());
       //joinign string using streams
       String data = stringdata.stream().collect(Collectors.joining());
        System.out.println(data);
      




    }
}
