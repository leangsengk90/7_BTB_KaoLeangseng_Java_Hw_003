package kshrd.com.kh;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;
import org.nocrala.tools.texttablefmt.Table;

public class Volunteer extends StaffMember {
    //TODO: CALCULATE PAYMENT;
    @Override
    public double pay() {
        return 0;
    }

    //TODO: MODIFY EMPLOYEE BY RETURN OBJECT;
    @Override
    public Object modifyObject(int id) {
       //TODO: INVOKE CONSTRUCTOR TO INPUT NEW VALUES;
       Volunteer volunteer = new Volunteer(id);
       return volunteer;
    }

    //TODO: CONSTRUCTORS AREA;
    public Volunteer() {
    }
    public Volunteer(int id) {
        super(id);
    }

    public Volunteer(int id, String name, String address) {
        super(id, name, address);
    }

    //TODO: OUTPUT EMPLOYEE IN TABLE;
    @Override
    public String toString() {
        Table table = new Table(2, BorderStyle.UNICODE_BOX_HEAVY_BORDER);
        table.addCell("VOLUNTEER", new CellStyle(HorizontalAlign.center),2);
        table.addCell("• Id ");
        table.addCell(id+"");
        table.addCell("• Name ");
        table.addCell(name+"");
        table.addCell("• Address ");
        table.addCell(address+"");
        table.addCell(" Thanks for your KINDNESS!",2);
        return  table.render();
    }
}
