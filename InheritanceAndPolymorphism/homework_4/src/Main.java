import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        for (int i = 0; i < 180; i++){
            company.hire(new Operator());
        }

        List<Employee> merchants = new ArrayList<>();
        for (int i = 0; i < 80; i++){
            merchants.add(new Manager());
            if (i % 8 == 0){
                merchants.add(new TopManager(company));
            }
        }
        company.hireAll(merchants);
        System.out.println(company.getIncome());


        printEmployees(company);
        System.out.println("Количество сотрудников в компании: " + company.getEmployees().size());
        List<Employee> employees = company.getEmployees();

        for (int i = 0; i < employees.size(); i++){
            if (i % 2 == 0){
                company.fire(employees.get(i));
            }
        }
        System.out.println("Количество сотрудников в компании после увольнения: " + company.getEmployees().size());

    }

    private static void printEmployees(Company company) {
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        System.out.println("Список 15 наибольших зарплат в компании: ");
        for (Employee employee : topSalaryStaff){
            System.out.println(employee.getMonthSalary());
        }

        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
        System.out.println("Список 30 наименьших зарплат в компании: ");
        for (Employee employee : lowestSalaryStaff){
            System.out.println(employee.getMonthSalary());
        }
    }

}
