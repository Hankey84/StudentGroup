import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static String getStudentsPlural(int count) {
        if (count == 1) {
            return "студент";
        } else if (count >= 2 && count <= 4) {
            return "студента";
        } else {
            return "студентов";
        }
    }

    public static void main(String[] args) {
        StudentGroup group1 = new StudentGroup("МТ-100", "Математика");
        group1.addStudent(new Student("Иванов И.И."));
        group1.addStudent(new Student("Петров А.С."));
        group1.addStudent(new Student("Сидоров С.С."));
        group1.addStudent(new Student("Попова Т.Н."));

        StudentGroup group2 = new StudentGroup("ЛТ-200", "Гуманитарии");
        group2.addStudent(new Student("Цветкова М.С."));
        group2.addStudent(new Student("Захаров Р.В."));
        group2.addStudent(new Student("Шеремет Ю.Н."));
        group2.addStudent(new Student("Хайрулин Э.Ш."));
        group2.addStudent(new Student("Титова М.О."));
        group2.addStudent(new Student("Юнусова У.Р."));

        StudentGroup group3 = new StudentGroup("ФИ-300", "Физика");
        group3.addStudent(new Student("Тулина Т.Ю."));
        group3.addStudent(new Student("Дудник С.К."));
        group3.addStudent(new Student("Перепелица М.А."));
        group3.addStudent(new Student("Волохов Н.И."));
        group3.addStudent(new Student("Юрьева Е.И."));

        Stream stream = new Stream(group1, group2, group3);

        // Пример использования итератора потока
        for (StudentGroup group : stream) {
            int grSize = group.getGroupSize();
            System.out.printf("В группе '" + group.getGroupName() + "' по специализации '"
                    + group.getGroupSpecialization() + "' учатся %d %s: \n", grSize, getStudentsPlural(grSize));
            int count = 0;
            for (Student student : group) {
                System.out.printf("     %d. %s, ID: %d \n", ++count, student.getName(), student.getId());
            }
        }

        TreeSet<StudentGroup> set1 = new TreeSet<>(new StreamComparator());
        set1.add(stream.getStudentGroup("МТ-100"));
        set1.add(stream.getStudentGroup("ЛТ-200"));
        set1.add(stream.getStudentGroup("ФИ-300"));

        System.out.println("Вывод отсортированного множества потоков:");
        System.out.println(set1);

        Iterator<StudentGroup> iterator = stream.iterator();
        while (iterator.hasNext()) {
            StudentGroup stream1 = iterator.next();
            if (stream1.getGroupName().equals("ЛТ-200")) {
                iterator.remove();
            }
        }

        System.out.println("Проверка после удаления потока:");
        for (StudentGroup stream1 : stream) {
            System.out.println(stream1.getGroupName());
        }

    }
}
