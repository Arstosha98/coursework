public class Main {
    public static void main (String[] args){
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.add (new Employee("Серебряков Владислав Витальевич", 1, 45_000.0));
        employeeBook.add (new Employee("Попова Ольга Владимировна", 2, 50_000.0));
        employeeBook.add (new Employee("Куприн Евгений Михайлович", 3, 55_000.0));
        employeeBook.add (new Employee("Арсентьева Наталья Эдуардовна", 4, 60_000.0));
        employeeBook.add (new Employee("Кисляков Дмитрий Александрович", 5, 65_000.0));
        employeeBook.add (new Employee("Черняков Егор Олегович", 5, 70_000.0));
        employeeBook.add (new Employee("Федякова Татьяна Сергеевна", 4, 75_000.0));
        employeeBook.add (new Employee("Сергей Сергеевич Шульгин", 3, 80_000.0));
        employeeBook.add (new Employee("Терехин Владислав Владимирович", 2, 85_000.0));
        employeeBook.add (new Employee("Расторгуев Михаил Дмитриевич", 1, 90_000.0));

        employeeBook.add(new Employee("А.С.Пушкин",1,25_000));
        employeeBook.remove(1); employeeBook.remove(9);
        employeeBook.updateSalary("серебряков владислав витальевич",100_000);
        employeeBook.updateDepartment("серебряков владислав витальевич",5);

        employeeBook.printAllByDepartment();
    }
}