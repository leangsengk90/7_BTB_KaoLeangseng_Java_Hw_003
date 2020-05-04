package kshrd.com.kh;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;
import java.util.Scanner;

public class SalariedEmployee extends StaffMember {
    Scanner sc = new Scanner(System.in);
    //TODO: FIELDS;
    private double salary;
    private double bonus;

    //TODO: CALCULATE PAYMENT IF THOSE ARE >= 0;
    @Override
    public double pay() {
        return getSalary() >= 0 && getBonus() >= 0 ? getSalary() + getBonus() : -1;
    }

    //TODO: MODIFY EMPLOYEE BY RETURN OBJECT;
    @Override
    public Object modifyObject(int id) {
        SalariedEmployee salary = new SalariedEmployee(id);
        return salary;
    }

    //TODO: CONSTRUCTOR: INPUT VALUES;
    public SalariedEmployee() throws Exception {
            System.out.print("• Salary\t\t: ");
            this.salary = sc.nextDouble();
            System.out.print("• Bonus\t\t\t: ");
            this.bonus = sc.nextDouble();
    }

    //TODO: CONSTRUCTOR: CHANGE EMPLOYEE;
    public SalariedEmployee(int id) {
        super(id);
        System.out.print("• Input New Salary\t: ");
        this.salary = sc.nextDouble();
        System.out.print("• Input New Bonus\t: ");
        this.bonus = sc.nextDouble();
    }

    //TODO: CONSTRUCTOR: INITIALIZE EMPLOYEE;
    public SalariedEmployee(int id, String name, String address, double salary, double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }

    //TODO: OUTPUT EMPLOYEE TO TABLE;
    @Override
    public String toString() {
        Table table = new Table(2, BorderStyle.UNICODE_BOX_HEAVY_BORDER);
        table.addCell("SALARIED EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.center),2);
        table.addCell("• Id ");
        table.addCell(id+"");
        table.addCell("• Name ");
        table.addCell(name+"");
        table.addCell("• Address ");
        table.addCell(address+"");
        table.addCell("• Salary ");
        table.addCell(salary+"");
        table.addCell("• Bonus ");
        table.addCell(bonus+"");
        table.addCell("• Payment ");
        table.addCell(pay() == -1 ? "null" : String.format("%.2f",pay()));
        return  table.render();
    }

    //TODO: GETTER AND SETTER;
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
