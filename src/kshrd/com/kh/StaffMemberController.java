package kshrd.com.kh;

import java.util.*;
import java.util.regex.Pattern;

public class StaffMemberController {
    private static ArrayList<StaffMember> staffList = new ArrayList();

    //TODO: MESSAGE TO NOTIFICATION
    public static void message() throws Exception{
        System.out.print("\nPress \"Enter\" key to continue...");
        System.in.read();
    }
    public static void message(String sms) throws Exception{
        System.out.print("@"+sms+": PLEASE INPUT VALID NUMBER!\n");
        System.out.print("\nPress \"Enter\" key to continue...");
        System.in.read();
    }
    public static void message(String sms, String description) throws Exception{
        System.out.print("@"+sms+": "+description+"\n");
        System.out.print("\nPress \"Enter\" key to continue...");
        System.in.read();
    }

    //TODO: FIRST INITIALIZE EMPLOYEE TO VIEW;
    public static void initStaffMember() throws Exception{
        //TODO: INITIALIZATION BY CONSTRUCTORS;
        StaffMember vol = new Volunteer(1, "Kao Leangseng","Phnom Penh");
        StaffMember sal = new SalariedEmployee(2,"Tep Nakeo","Siem Reap",-550,120);
        StaffMember hou = new HourlyEmployee(3,"Chan Bori","Kampong Cham",12,-8);
        StaffMember vol2 = new Volunteer(4, "kat Leangseng","Phnom Penh");

        //TODO: ADD OBJECTS TO LIST;
        staffList.add(vol);
        staffList.add(sal);
        staffList.add(hou);
        staffList.add(vol2);

        showEmployee();
    }

    //TODO: SHOW ALL EMPLOYEES;
    public static void showEmployee() throws Exception{
        MyTitle.show("EMPLOYEE LIST");
        //TODO: SORT STAFF MEMBER LIST BY ASCENDING;
//        Comparator<StaffMember> staffName = new Comparator<StaffMember>() {
//            @Override
//            public int compare(StaffMember st1, StaffMember st2) {
//                return st1.getName().toUpperCase().compareTo(st2.getName().toUpperCase());
//            }
//        };
        //TODO: COMPARE OBJECTS AND SORT;
        Comparator<StaffMember> staffName = Comparator.comparing(st -> st.getName().toUpperCase());
        Collections.sort(staffList, staffName);

        for (Object obj : staffList){
            System.out.println(obj);
        }

        if(staffList.isEmpty()) System.out.println("@MESSAGE: EMPLOYEE LIST IS EMPTY!");
    }

    //TODO: INSERT EMPLOYEE BY TYPE;
    public static void insertEmployee() throws Exception{
        Scanner sc = new Scanner(System.in);

        String option;
        boolean termOption , event = true;
        while (event){
            MyTitle.show("INSERT EMPLOYEE");
            System.out.println("1. VOLUNTEER");
            System.out.println("\n2. SALARIED EMPLOYEE");
            System.out.println("\n3. HOURLY EMPLOYEE");
            System.out.println("\n4. BACK");
            System.out.print("\n» PLEASE INPUT OPTION: ");
            option = sc.next();
            termOption = Pattern.matches("[1-4]",option);

            if (termOption == true){
                switch (option){
                    case "1":
                        //TODO: VOLUNTEER;
                        MyTitle.show("VOLUNTEER");
                        StaffMember vol = new Volunteer();
                        staffList.add(vol);
                        System.out.println(" VOLUNTEER IS ADDED!");
                        showEmployee();
                        message();
                        break;
                    case "2":
                        //TODO: SALARIED EMPLOYEE;
                        MyTitle.show("SALARIED EMPLOYEE");
                        StaffMember sal;
                        try {
                            sal = new SalariedEmployee();
                        }catch (Exception ex){
                            message("ERROR","INVALID INPUT!");
                            break;
                        }
                        staffList.add(sal);
                        System.out.println(" SALARIED EMPLOYEE IS ADDED!");
                        showEmployee();
                        message();
                        break;
                    case "3":
                        //TODO: HOURLY EMPLOYEE;
                        MyTitle.show("HOURLY EMPLOYEE");
                        StaffMember hou;
                        try {
                             hou = new HourlyEmployee();
                        }catch (Exception ex){
                            message("ERROR","INVALID INPUT!");
                            break;
                        }
                        staffList.add(hou);
                        System.out.println(" HOURLY EMPLOYEE IS ADDED!");
                        showEmployee();
                        message();
                        break;
                    case "4":
                        //TODO: BACK TO MENU;
                        event = false;
                        break;
                }
            }else {
               message("MESSAGE");
            }
        }
    }

    //TODO: MODIFY EMPLOYEE BY ID;
    public static void modifyEmployee() throws Exception{
        Scanner sc = new Scanner(System.in);
        MyTitle.show("MODIFY EMPLOYEE");
        System.out.print("• Input Id\t\t: ");
        int id,index = -1;
        Object getObj = null;
        boolean isEmpty = true;
        try {
            id = sc.nextInt();
            Iterator<StaffMember> temp = staffList.iterator();
            while (temp.hasNext()){
                Object obj = temp.next();
                //TODO: CHECK IF EQUAL ID;
                if (((StaffMember) obj).getId() == id){
                    //TODO: SHOW EMPLOYEE BEFORE CHANGE;
                    index = staffList.indexOf(obj);
                    //System.out.println(staffList.indexOf(obj));
                    System.out.println(obj);
                    //TODO: REMOVE EMPLOYEE;
                    //temp.remove();
                    //TODO: ASSIGN OBJECT ONCE CHANGE VALUES;
                    getObj = ((StaffMember) obj).modifyObject(id);
                    isEmpty = false;
                }
            }

            //TODO: CHECK IF LIST IS EMPTY;
            if (isEmpty){
                message("MESSAGE","Employee is not FOUND!");
            }else {
                //TODO: ADD EMPLOYEE TO LIST;
                //staffList.add((StaffMember) getObj);
                staffList.set(index,(StaffMember) getObj);
                System.out.println(" UPDATE SUCCESSFUL!");
                showEmployee();
                message();
            }
        }catch (Exception ex){
            message("ERROR","INVALID INPUT!");
        }
    }

    //TODO: REMOVE EMPLOYEE BY ID;
    public static void removeObject() throws Exception{
        Scanner sc = new Scanner(System.in);
        MyTitle.show("REMOVE EMPLOYEE");
        System.out.print("• Input Id\t\t: ");
        int id;
        boolean isEmpty = true;
        try {
            id = sc.nextInt();
            Iterator<StaffMember> temp = staffList.iterator();
            while (temp.hasNext()){
                Object obj = temp.next();
                //TODO: CHECK IF EQUAL ID;
                if (((StaffMember) obj).getId() == id){
                    //TODO: SHOW EMPLOYEE BEFORE CHANGE;
                    System.out.println(obj);
                    isEmpty = false;
                    //TODO: CONFIRM TO DELETE EMPLOYEE;
                    System.out.print(" DO YOU WANT TO DELETE THIS EMPLOYEE? (Y/N): ");
                    String confirm = sc.next().toUpperCase();
                    switch (confirm){
                        case "Y":
                            temp.remove();
                            message("MESSAGE","EMPLOYEE IS DELETED SUCCESSFUL!");
                            break;
                        default:
                            message("MESSAGE","ACTION IS CANCELED!");
                            break;
                    }
                }
            }

            //TODO: CHECK IF LIST IS EMPTY;
            if (isEmpty){
                message("MESSAGE","Employee is NOT found!");
            }else {
                showEmployee();
                message();
            }
        }catch (Exception ex){
            message("ERROR","INVALID INPUT!");
        }
    }


}
