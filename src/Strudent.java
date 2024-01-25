import lombok.Data;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

@Data
public class Strudent extends Person{
    private String clazz;

    public void nhap(){
        System.out.println("Nhập class: ");
        clazz = sc.nextLine();
    }


    public String xuat(){
        return super.output() + " " + clazz;
    }

    public static void main(String[] args) {
        System.out.println("Nhập số học sinh cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Strudent> stu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Strudent student = new Strudent();
            student.nhaphs();
            stu.add(student);

        }
        for (int i = 0; i < n; i++) {
            System.out.println(stu.get(i).xuat());

        }
        for (int i = 0; i < n; i++) {
            stu.sort((o1, o2) -> o1.getAge() - o2.getAge());
            System.out.println(stu.get(i).xuat());

        }

//        tìm kiếm
        System.out.println("Nhập tên cần tìm kiếm ");
        String name = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (name.equals(stu.get(i).getName())) {
                System.out.println(stu.get(i).xuat());
            }
        }







    }
}
