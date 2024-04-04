import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        String t1 = s1.getName() + s1.getId();
        String t2 = s2.getName() + s2.getId();

        return t1.compareTo(t2);
    }
}
