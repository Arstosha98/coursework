public class Main {
    private final static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Серебряков Владислав Витальевич", 1, 45_000.0);
        employees[1] = new Employee("Попова Ольга Владимировна", 2, 50_000.0);
        employees[2] = new Employee("Куприн Евгений Михайлович", 3, 55_000.0);
        employees[3] = new Employee("Арсентьева Наталья Эдуардовна", 4, 60_000.0);
        employees[4] = new Employee("Кисляков Дмитрий Александрович", 5, 65_000.0);
        employees[5] = new Employee("Черняков Егор Олегович", 5, 70_000.0);
        employees[6] = new Employee("Федякова Татьяна Сергеевна", 4, 75_000.0);
        employees[7] = new Employee("Сергей Сергеевич Шульгин", 3, 80_000.0);
        employees[8] = new Employee("Терехин Владислав Владимирович", 2, 85_000.0);
        employees[9] = new Employee("Расторгуев Михаил Дмитриевич", 1, 90_000.0);

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

        System.out.println();

        System.out.println("Повышенная сложность: ");
        // Проиндексировать зарплату у всех сотрудников
        System.out.println("Проиндексировать зарплату у всех сотрудников: ");
        // на величину аргумента в %
        increaseByAmount(0.10);
        printAll();
        System.out.println();

        // Получить в качестве параметра номер отдела и найти:
        // Сотрудника с минимальной зарплатой.
        System.out.println("Сотрудник с минимальной зарплатой: ");
        System.out.println(getEmployeeMinSalaryWithDepartment(3));
        // Сотрудника с максимальной зарплатой.
        System.out.println("Сотрудник с максимальной зарплатой: ");
        System.out.println(getEmployeeMaxSalaryWithDepartment(3));

        System.out.println("Сумму затрат на зарплату по отделу: ");
        // Сумму затрат на зарплату по отделу.
        System.out.println(calculateSalaryAllByDepartment(3));

        System.out.println("Среднюю зарплату по отделу: ");
        // Среднюю зарплату по отделу.
        System.out.println(getAverageSalary(3));

        System.out.println("Проиндексировать зарплату всех сотрудников конкретного отдела на процент: ");
        // Проиндексировать зарплату всех сотрудников отдела на процент.
        increaseByAmount(0.25,1);
        printAll();
        System.out.println();

        System.out.println("Напечатать всех сотрудников конкретного отдела (все данные, кроме отдела): ");
        // Напечатать всех сотрудников отдела (все данные, кроме отдела).
        printAll(5);
        System.out.println();

        System.out.println("Всех сотрудников с зарплатой меньше числа ... : ");
        // Получить в качестве параметра число и найти:
        // (вывести id, Ф. И. О. и зарплатой в консоль).
        // Всех сотрудников с зарплатой меньше числа
        printEmployeeWithSalaryLess(50_000.0);
        System.out.println();

        System.out.println("Всех сотрудников с зарплатой больше (или равно) числа ... : ");
        // Получить в качестве параметра число и найти:
        // (вывести id, Ф. И. О. и зарплатой в консоль).
        // Всех сотрудников с зарплатой больше (или равно) числа
        printEmployeeWithSalaryMore(88_000.0);

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
    // Проиндексировать зарплату
    // (вызвать изменение зарплат у всех сотрудников
    // на величину аргумента в %).
    private static void increaseByAmount (double amount){
        for (Employee employee: employees){
            employee.setSalary(employee.getSalary() + employee.getSalary() * amount);
        }
    }
    // Получить в качестве параметра номер отдела и найти:
    // Сотрудника с минимальной зарплатой.
    private static Employee getEmployeeMinSalaryWithDepartment (int department){
        double minSalary = Double.MAX_VALUE;
        Employee minEmployee = null;
        for (Employee employee : employees){
            if (employee.getDepartment() != department){
                continue;
            }
            if (minSalary > employee.getSalary()){
                minSalary = employee.getSalary();
                minEmployee = employee;
            }
        }
        return minEmployee;
    }
    // Сотрудника с максимальной зарплатой.
    private static Employee getEmployeeMaxSalaryWithDepartment (int department) {
        double maxSalary = Double.MIN_VALUE;
        Employee maxEmployee = null;
        for (Employee employee: employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }
    // Сумму затрат на зарплату по отделу.
    private static double calculateSalaryAllByDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }
    // Среднюю зарплату по отделу
    // (учесть, что количество людей в отделе отличается от employees.length).
    private static double getAverageSalary( int department){
        double sum = 0.0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() != department) {
                continue;
            }
            sum += employee.getSalary();
            count++;
        }
        if (count == 0){
            System.out.println("нет сотрудников в отделе" + department);
        }
        return sum / count;
    }
    // Проиндексировать зарплату всех сотрудников отдела на процент,
    // который приходит в качестве параметра.
    private static void increaseByAmount (double amount, int department){
        for (Employee employee: employees){
            if (employee.getDepartment() != department) {
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * amount);
        }
    }
    // Напечатать всех сотрудников отдела (все данные, кроме отдела).
    private static void printAll (int department){
        for (Employee employee: employees){
            if (employee.getDepartment() != department){
                continue;
            }
            System.out.println("ID адрес: " + employee.getId() + ", " + "Сотрудник: " + employee.getFullName() + " с зарплатой: " + employee.getSalary() + " рублей.");
        }
    }
    // Получить в качестве параметра число и найти:
    // Всех сотрудников с зарплатой меньше числа
    // (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printEmployeeWithSalaryLess (double salary){
        boolean HasEmployee = false;
        for (Employee employee : employees) {
            if (employee.getSalary() < salary){
                System.out.println("ID адрес: " + employee.getId() + ", " + "Сотрудник: " + employee.getFullName() + " с зарплатой: " + employee.getSalary() + " рублей.");
            HasEmployee = true;
            }
        }
        if (!HasEmployee){
            System.out.println("Нет сотрудника с ЗП меньшей " + salary);
        }
    }
    // Получить в качестве параметра число и найти:
    // Всех сотрудников с зарплатой больше (или равно) числа
    // (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printEmployeeWithSalaryMore (double salary){
        boolean HasEmployee = false;
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary){
                System.out.println("ID адрес: " + employee.getId() + ", " + "Сотрудник: " + employee.getFullName() + " с зарплатой: " + employee.getSalary() + " рублей.");
            HasEmployee = true;
            }
        }
        if (!HasEmployee) {
                    System.out.println("Нет сотрудника с ЗП большей " + salary);
        }
    }
}