import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();
        group.addStudent(new Student("Иванов"));
        group.addStudent(new Student("Петров"));
        group.addStudent(new Student("Сидоров"));

        for (Student student : group) {
            System.out.println("Проверка");
            System.out.println(student.getName());
        }

        Iterator<Student> iterator = group.iterator();
        while (iterator.hasNext()){
            System.out.println("Проверка2");

            Student student = iterator.next();
            if (student.getName().equals("Петров")){
                group.removeStudent(student);
            }
        }

        for (Student student : group) {
            System.out.println(student.getName());
        }
    }
}
