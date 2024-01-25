import lombok.Data;

import java.util.Scanner;
@Data
public class Person {
    private String name;
    private int age;
    private String address;
    static Scanner sc = new Scanner(System.in);

    public void nhaphs(){
        System.out.println("Nhập Name: ");
        name = sc.nextLine();
        System.out.println("Nhập age: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập address: ");
        address = sc.nextLine();
    }
    public String output(){
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", address='" + address + '\'' +
                    '}';

    }
}
