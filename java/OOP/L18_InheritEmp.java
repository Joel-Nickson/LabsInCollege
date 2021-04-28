import java.util.Scanner;

class Employee {
  public String name, addr;
  public int age;
  public long phoneNum;
  public double salary;
  public void setUser(String name, int age, long phoneNum, double salary, String addr) {
    this.name = name;
    this.age = age;
    this.phoneNum = phoneNum;
    this.salary = salary / 1.00;
    this.addr = addr;
  }
  public void printSalary() {
    System.out.println("Salary of " + name + " is " + String.format("%.2f", salary));
  }
  public void getUser() {
    System.out.println("Name : " + name);
    System.out.println("Age : " + age);
    System.out.println("Phone Number : " + phoneNum);
    System.out.print("Address : " + addr + "\n");
  }
}

//officer
class Officer extends Employee {
  String specialization;

  void setSpecialization(String specialization) {
    this.specialization = specialization;
  }
  void getOfficer() {
    super.getUser();
    System.out.println("Specialization : " + specialization);
  }
}

//manager
class Manager extends Employee {
  String department;

  void setdepartment(String department) {
    this.department = department;
  }
  void getManager() {
    super.getUser();
    System.out.println("Department : " + department);
  }
}

public class InheritEmp {
  public static void main(String args[]) {
    String name, addr, specialized, dept, err;
    int age, choice;
    long phoneNum;
    double salary;
    Scanner sc = new Scanner(System. in );
    Officer offc = new Officer();
    Manager mang = new Manager();

      System.out.println("\n***** Get Officer Details *****");

      System.out.print("Name : ");
      name = sc.nextLine();
      System.out.print("Age : ");
      age = sc.nextInt();
      System.out.print("Phone Number : ");
      phoneNum = sc.nextLong();
      System.out.print("Salary : ");
      salary = sc.nextDouble();
      System.out.print("Address : ");
      err = sc.nextLine();
      addr = sc.nextLine();

      offc.setUser(name, age, phoneNum, salary, addr);
      System.out.print("Officer Specialized in : ");
      specialized = sc.nextLine();
      offc.setSpecialization(specialized);



      System.out.println("\n***** Get Manager Details *****");

      System.out.print("Name : ");
      name = sc.nextLine();
      System.out.print("Age : ");
      age = sc.nextInt();
      System.out.print("Phone Number : ");
      phoneNum = sc.nextLong();
      System.out.print("Salary : ");
      salary = sc.nextDouble();
      System.out.print("Address : ");
      err = sc.nextLine();
      addr = sc.nextLine();

      mang.setUser(name, age, phoneNum, salary, addr);
      System.out.print("Manager Department : ");
      dept = sc.nextLine();
      mang.setdepartment(dept);


      System.out.println("\n***** Officer *****");
      offc.getOfficer();
      offc.printSalary();

      System.out.println("\n***** Manager *****");
      mang.getManager();
      mang.printSalary();

  }
}