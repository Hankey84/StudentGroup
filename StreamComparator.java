import java.util.Comparator;

public class StreamComparator implements Comparator<StudentGroup> {
    @Override
    public int compare(StudentGroup s1, StudentGroup s2) {
        return Integer.compare(s1.getGroupSize(), s2.getGroupSize());
    }
}
