package kshrd.com.kh;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;
import java.util.Scanner;

public class HourlyEmployee extends StaffMember {
    Scanner sc = new Scanner(System.in);
    //TODO: FIELDS;
    private int hoursWorked;
    private double rate;

    //TODO: CALCULATE PAYMENT IF THOSE ARE >= 0;
    @Override
    public double pay() {
        return getHoursWorked() >= 0 && getRate() >= 0 ? getHoursWorked() * getRate() : -1;
    }

    //TODO: MODIFY EMPLOYEE BY RETURN OBJECT;
    @Override
    public Object modifyObject(int id) {
        //TODO: INVOKE CONSTRUCTOR TO INPUT NEW VALUES;
        HourlyEmployee hour = new HourlyEmployee(id);
        return hour;
    }

    //TODO: CONSTRUCTOR: INPUT VALUES;
    public HourlyEmployee(){
        System.out.print("• HoursWorked\t: ");
        this.hoursWorked = sc.nextInt();
        System.out.print("• Rate\t\t\t: ");
        this.rate = sc.nextDouble();
    }

    //TODO: CONSTRUCTOR: CHANGE EMPLOYEE;
    public HourlyEmployee(int id) {
        super(id);
        System.out.print("• Input New HoursWorked\t: ");
        this.hoursWorked = sc.nextInt();
        System.out.print("• Input New Rate\t\t: ");
        this.rate = sc.nextDouble();
    }

    //TODO: CONSTRUCTOR FOR INITIALIZING EMPLOYEE;
    public HourlyEmployee(int id, String name, String address, int hoursWorked, double rate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    //TODO: OUTPUT EMPLOYEE TO TABLE;
    @Override
    public String toString() {
        Table table = new Table(2, BorderStyle.UNICODE_BOX_HEAVY_BORDER);
        table.addCell("HOURLY EMPLOYEE", new CellStyle(CellStyle.HorizontalAlign.center),2);
        table.addCell("• Id ");
        table.addCell(id+"");
        table.addCell("• Name ");
        table.addCell(name+"");
        table.addCell("• Address ");
        table.addCell(address+"");
        table.addCell("• Hours Worked ");
        table.addCell(hoursWorked+"");
        table.addCell("• Rate ");
        table.addCell(rate+"");
        table.addCell("• Payment ");
        table.addCell(pay() == -1 ? "null" : String.format("%.2f",pay()));
        return  table.render();
    }

    //TODO: GETTER AND SETTER;
    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
