class Student implements Comparable<Student>{
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id=id;
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