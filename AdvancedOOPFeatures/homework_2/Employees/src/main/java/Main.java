import java.time.ZoneId;
import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(findEmployeeWithHighestSalary(staff, 2022));
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Date exception = new Date();
        Employee resultEmployee = staff.stream().filter(employee -> employee.getWorkStart()
                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == year)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(new Employee("Нет такого сотрудника", 0, exception));
        return resultEmployee;
    }
}
