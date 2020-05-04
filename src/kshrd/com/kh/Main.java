package kshrd.com.kh;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        //TODO: TURN OFF WARNING MESSAGE FROM LOG4J
        Logger.getRootLogger().setLevel(Level.OFF);
//---------------------------------------------------------//
        Scanner sc = new Scanner(System.in);
        //TODO: INITIALIZE OBJECT;
        StaffMemberController.initStaffMember();

        String option;
        boolean termOption;
        while (true){
            MyTitle.show("MENU");
            System.out.println("1. INSERT EMPLOYEE");
            System.out.println("\n2. MODIFY EMPLOYEE");
            System.out.println("\n3. REMOVE EMPLOYEE");
            System.out.println("\n4. EXIT APPLICATION");
            System.out.print("\n» PLEASE INPUT OPTION: ");
            option = sc.next();
            //TODO: REGEX;
            termOption = Pattern.matches("[1-4]",option);

            if (termOption == true){
                switch (option){
                    case "1":
                        //TODO: INSERT EMPLOYEE;
                        StaffMemberController.insertEmployee();
                        break;
                    case "2":
                        //TODO: MODIFY EMPLOYEE;
                        StaffMemberController.modifyEmployee();
                        break;
                    case "3":
                        //TODO: REMOVE EMPLOYEE;
                        StaffMemberController.removeObject();
                        break;
                    case "4":
                        //TODO: EXIT;
                        System.out.print("(^-^) Application is Exiting!");
                        for (int i=0; i<5; i++){
                            TimeUnit.MILLISECONDS.sleep(500);
                            System.out.print(" ");
                        }
                        System.exit(0);
                        break;
                }
            }else {
                //TODO: ALERT MESSAGE WHEN ERROR;
                StaffMemberController.message("MESSAGE");
            }
        }
    }
}
