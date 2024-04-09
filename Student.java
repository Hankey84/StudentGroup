
class Student implements Comparable<Student>{
    private static int number;
    private String name;
    private int id;
    
    static {
        Student.number = 100;
   }
    public Student(String name) {
        this.name = name;
        this.id = ++number;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Student o) {
        
        return id - o.getId();
    }
    @Override
    public String toString() {
        return getName();
    }
}