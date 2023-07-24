package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* Function<Employee,Employee> changeAgePlus2 = (Employee e1)->{
        Employee e2 = new Employee(e1.getAge()+2,e1.getName());
        return e2;

    };
* */
interface Intref {
    public Employee getEmployee(Employee e);
}

public class StreamPractice {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        list = list.stream().filter(i->i%2==0).collect(Collectors.toList());
//        System.out.println(list);
//
//        list = list.stream().map(i->i*2).collect(Collectors.toList());
//        System.out.println(list);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(23,"srikanth"));
        employeeList.add(new Employee(24,"raj"));
//        employeeList.stream().forEach((employee)-> {
//                System.out.print(employee.getName() +"");
//            }
//        );
//
        Function<Employee,Employee> changeAgePlus2 = (Employee e1)->{
            Employee e2 = new Employee(e1.getAge()+2,e1.getName());
            return e2;

        };
        Intref intref = (Employee e)-> {e.setAge(e.getAge()+2); return e;};
   /* Method reference is the alternative of lamda expression
       it is about calling a method from any instance that matches with the function interface arguments of the method
   * */

       employeeList.stream().map(intref::getEmployee).forEach(i->System.out.print(i.getAge()));

//      employeeList.forEach(i-> System.out.println(i.getName()+" : "+i.getAge()));
//
    }
}
class Employee{
  int age;
  String name;

  Employee(int age,String name){
      this.age = age;
      this.name = name;
  }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
