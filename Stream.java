import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentGroup> {

    private List<StudentGroup> streams;

    public Stream(StudentGroup... groups){
        this.streams = new ArrayList<>();
        for (StudentGroup group : groups) {
            streams.add(group);
        }
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return streams.iterator();
    }

    public void addStream(StudentGroup stream) {
        streams.add(stream);
    }

    public StudentGroup getStudentGroup(String name) {
        for (StudentGroup stream : streams) {
            if (stream.getGroupName().equals(name)) {
                return stream;
            }
        }
        return null;
    }
}
