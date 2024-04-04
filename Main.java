import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();

        group.addStudent(new Student("Иванов", 101));
        group.addStudent(new Student("Петров", 112));
        group.addStudent(new Student("Сидоров", 103));

        for (Student student : group) {
            System.out.println(student.getName());
        }

        System.out.println(group.getStudent("Иванов").compareTo(group.getStudent("Петров")));

        TreeSet<Student> set = new TreeSet<>(new StudentComparator());
            set.add(group.getStudent("Иванов"));
            set.add(group.getStudent("Петров"));
            set.add(group.getStudent("Сидоров"));

        System.out.println(set);

        Iterator<Student> iterator = group.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals("Петров")) {
                iterator.remove();
            }
        }

        System.out.println("Проверка после удаления:");
        for (Student student : group) {
            System.out.println(student.getName());
        }
    }
}
