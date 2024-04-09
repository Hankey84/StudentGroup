import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class StudentGroup implements Iterable<Student> {
    private List<Student> students;
    private String groupName;
    private String groupSpecialization;
    public Object getGroupName;

    public StudentGroup(String groupName, String groupSpecialization) {
        this.students = new ArrayList<>();
        this.groupName = groupName;
        this.groupSpecialization = groupSpecialization;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupSpecialization() {
        return groupSpecialization;
    }

    public int getGroupSize() {
        return students.size();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator();
    }

    @Override
    public String toString() {

        return getGroupName();
    }

    private class StudentGroupIterator implements Iterator<Student> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.size();
        }

        @Override
        public Student next() {
            return students.get(index++);
        }

        @Override
        public void remove() {
            if (index > 0) {
                students.remove(--index);
            } else {
                throw new IllegalStateException("next должен быть вызван перед remove");
            }
        }
    }
}
