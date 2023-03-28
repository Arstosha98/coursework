public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    //Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив)
    public void add (Employee employee){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null){
                employees[i] = employee;
                break;
            }
        }
    }

    //Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве)
    public void remove (long id){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null){
                continue;
            }
            if (employees[i].getId() == id){
                employees[i] = null;
            }
        }
    }

    //Изменить зарплату.
    public void updateSalary(String fullName, double salary){
        for (Employee employee : employees){
            if (employee == null){
                continue;
            }
            if (employee.getFullName().equalsIgnoreCase(fullName)){
                employee.setSalary(salary);
            }
        }
    }

    //Изменить отдел.
    public void updateDepartment (String fullName, int department){
        for (Employee employee : employees){
            if (employee == null){
                continue;
            }
            if (employee.getFullName().equalsIgnoreCase(fullName)){
                employee.setDepartment(department);
            }
        }
    }

    //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников)
    public void printAllByDepartment(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел номер: " + i);
            printAll(i);
        }
    }
    // Напечатать всех сотрудников отдела (все данные, кроме отдела).
    public void printAll (int department){
        boolean hasEmployee = false;
        for (Employee employee: employees){
            if (employee == null){
                continue;
            }
            if (employee.getDepartment() != department){
                continue;
            }
            hasEmployee = true;
            System.out.println("ID адрес: " + employee.getId() + ", " + "Сотрудник: " + employee.getFullName() + " с зарплатой: " + employee.getSalary() + " рублей.");
        }
        if (!hasEmployee){
            System.out.println("Сотрудников нет");
        }
    }

    //Получить список всех сотрудников со всеми имеющимися по ним данными
    public void printAll() {
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
            System.out.println(employee);
        }
    }

    //Посчитать сумму затрат на зарплаты в месяц
    public double calculateSalaryAll() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    //Получить Ф. И. О. всех сотрудников в консоль
    public void printAllFullName() {
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
            System.out.println(employee.getFullName());
        }
    }
    //Найти сотрудника с минимальной зарплатой
    public Employee getEmployeeMinSalary(){
        double minSalary = Double.MAX_VALUE;
        Employee minEmployee = null;
        for (Employee employee : employees){
            if (employee == null){
                continue;
            }
            if (minSalary > employee.getSalary()){
                minSalary = employee.getSalary();
                minEmployee = employee;
            }
        }
        return minEmployee;
    }
    //Найти сотрудника с максимальной зарплатой
    public Employee getEmployeeMaxSalary(){
        double maxSalary = Double.MIN_VALUE;
        Employee maxEmployee = null;
        for (Employee employee : employees){
            if (employee == null){
                continue;
            }
            if (maxSalary < employee.getSalary()){
                maxSalary = employee.getSalary();
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }
    //Подсчитать среднее значение зарплат
    public double getAverageSalary(){
        double average = 0;
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
            average += employee.getSalary()/employees.length;
        }
        return average;
    }
    // Проиндексировать зарплату
    // (вызвать изменение зарплат у всех сотрудников
    // на величину аргумента в %).
    public void increaseByAmount (double amount){
        for (Employee employee: employees){
            if (employee == null){
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * amount);
        }
    }
    // Получить в качестве параметра номер отдела и найти:
    // Сотрудника с минимальной зарплатой.
    public Employee getEmployeeMinSalaryWithDepartment (int department){
        double minSalary = Double.MAX_VALUE;
        Employee minEmployee = null;
        for (Employee employee : employees){
            if (employee == null){
                continue;
            }
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
    public Employee getEmployeeMaxSalaryWithDepartment (int department) {
        double maxSalary = Double.MIN_VALUE;
        Employee maxEmployee = null;
        for (Employee employee: employees) {
            if (employee == null){
                continue;
            }
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
    public double calculateSalaryAllByDepartment(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
            if (employee.getDepartment() != department) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }
    // Среднюю зарплату по отделу
    // (учесть, что количество людей в отделе отличается от employees.length).
    public double getAverageSalary( int department){
        double sum = 0.0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
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
    public void increaseByAmount (double amount, int department){
        for (Employee employee: employees){
            if (employee == null){
                continue;
            }
            if (employee.getDepartment() != department) {
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * amount);
        }
    }

    // Получить в качестве параметра число и найти:
    // Всех сотрудников с зарплатой меньше числа
    // (вывести id, Ф. И. О. и зарплатой в консоль).
    public void printEmployeeWithSalaryLess (double salary){
        boolean HasEmployee = false;
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
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
    public void printEmployeeWithSalaryMore (double salary){
        boolean HasEmployee = false;
        for (Employee employee : employees) {
            if (employee == null){
                continue;
            }
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
