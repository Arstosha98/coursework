public class Main {
    private final static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Серебряков Владислав Витальевич", 1, 45_000.0);
        employees[1] = new Employee("Попова Ольга Владимировна", 2, 50_000.0);
        employees[2] = new Employee("Куприн Евгений Михайлович", 3, 55_000.0);
        employees[3] = new Employee("Арсентьева Наталья Эдуардовна", 4, 60_000.0);
        employees[4] = new Employee("Кисляков Дмитрий Александрович", 5, 65_000.0);
        employees[5] = new Employee("Черняков Егор Олегович", 1, 70_000.0);
        employees[6] = new Employee("Федякова Татьяна Сергеевна", 2, 75_000.0);
        employees[7] = new Employee("Сергей Сергеевич Шульгин", 3, 80_000.0);
        employees[8] = new Employee("Терехин Владислав Владимирович", 4, 85_000.0);
        employees[9] = new Employee("Расторгуев Михаил Дмитриевич", 5, 90_000.0);

        printAll();

        System.out.println();

        System.out.println("Затраты на зарплаты в месяц: " + calculateSalaryAll());

        System.out.println();

        System.out.println("Сотрудник с минимальной зарплатой: " + getEmployeeMinSalary().getFullName() + " = " + getEmployeeMinSalary().getSalary());

        System.out.println();

        System.out.println("Сотрудник с максимальной зарплатой: " + getEmployeeMaxSalary().getFullName() + " = " + getEmployeeMaxSalary().getSalary());

        System.out.println();

        System.out.println("Среднее значение зарплат = " + getAverageSalary());

        System.out.println();

        printAllFullName();

    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными
    private static void printAll() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //Посчитать сумму затрат на зарплаты в месяц
    private static double calculateSalaryAll() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    //Получить Ф. И. О. всех сотрудников в консоль
    private static void printAllFullName() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
    //Найти сотрудника с минимальной зарплатой
    private static Employee getEmployeeMinSalary(){
        double minSalary = Double.MAX_VALUE;
        Employee minEmployee = null;
        for (Employee employee : employees){
            if (minSalary > employee.getSalary()){
                minSalary = employee.getSalary();
                minEmployee = employee;
            }
        }
        return minEmployee;
    }
    //Найти сотрудника с максимальной зарплатой
    private static Employee getEmployeeMaxSalary(){
        double maxSalary = Double.MIN_VALUE;
        Employee maxEmployee = null;
        for (Employee employee : employees){
            if (maxSalary < employee.getSalary()){
                maxSalary = employee.getSalary();
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }
    //Подсчитать среднее значение зарплат
    private static double getAverageSalary(){
        double average = 0;
        for (Employee employee : employees) {
            average += employee.getSalary()/employees.length;
        }
        return average;
    }
}