package kshrd.com.kh;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

abstract class StaffMember {
        Scanner sc = new Scanner(System.in);
        //TODO: FIELDS;
        protected int id;
        protected String name;
        protected String address;
        public static AtomicInteger autoID = new AtomicInteger(4);

        //TODO: CALCULATE PAYMENT;
        public abstract double pay();
        //MODIFY EMPLOYEE BY ID;
        public abstract Object modifyObject(int id);

        //TODO: CONSTRUCTOR: INPUT EMPLOYEE;
        public StaffMember(){
            this.id = autoID.incrementAndGet();
            System.out.println("• Id\t\t\t: "+autoID.get());
            System.out.print("• Name\t\t\t: ");
            this.name = sc.nextLine();
            System.out.print("• Address\t\t: ");
            this.address = sc.nextLine();
        }

        //TODO: CONSTRUCTOR FOR CHANGING EMPLOYEE;
        public StaffMember(int id){
            this.id = id;
            System.out.println("• Id\t\t\t\t: "+id);
            System.out.print("• Input New Name\t: ");
            this.name = sc.nextLine();
            System.out.print("• Input New Address\t: ");
            this.address = sc.nextLine();
        }

        //TODO: CONSTRUCTOR FOR INITIALIZING EMPLOYEE;
        public StaffMember(int id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        //TODO: OUTPUT EMPLOYEE;
        @Override
        public String toString() {
            return  "\n• Id \t: " + id +
                    "\n• Name \t: " + name +
                    "\n• Address \t: " + address;
        }

        //TODO: GETTER AND SETTER;
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
