public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private static long idCounter = 0;
    private final long id;

    public Employee() {
        this.id = idCounter++;
    }

    public Employee (String fullName, int department, double salary){
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = idCounter ++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public long getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID адрес: " + id + ", " + "Сотрудник: " + fullName + ", из отдела " + department + ", с зарплатой: " + salary + " рублей.";
    }
}
