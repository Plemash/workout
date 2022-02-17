import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        for (Employee employee : employees) {
            hire(employee);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees);
        Collections.reverse(employees);
        if (count > employees.size()) {
            count = employees.size();
        }
        return employees.subList(0, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employees);
        if (count > employees.size()) {
            count = employees.size();
        }
        return employees.subList(0, count);
    }


    public int getIncome() {
        int income = 0;
        for (Employee employee : employees){
            if (employee instanceof Manager){
                income += ((Manager) employee).getSales();
            }
        }
        return income;
    }

}
