


//imported Chilled Class InputMismatchException of parent Class Runtime Exception

import java.util.InputMismatchException;
import java.util.Scanner;
// Abstract class representing a user
abstract class User {
    protected String name, email, password, confirmPass, cnic, rollNo;
    protected   int empid;
    public User(String name, String email, String password, String confirmPass, String cnic, String rollNo)
     {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.cnic = cnic;
        this.rollNo = rollNo;
    }
    public User(String name, String email, String password, String confirmPass, String cnic,int empid)
     {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
        this.cnic = cnic;
        this.empid=empid;
    }
//abstract Method
    public abstract void displayUserInfo();
}

// Class representing a student, extending User
class Student extends User {
    public Student(String name, String email, String password, String confirmPass, String cnic, String rollNo) {
        super(name, email, password, confirmPass, cnic, rollNo);
    }
    //defination of abstract method
    @Override
    public void displayUserInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("CNIC: " + cnic);
        System.out.println("Roll No: " + rollNo);
    }
}
class Employe extends User{
     public Employe(String name, String email, String password, String confirmPass, String cnic, int eId) 
     {
        super(name, email, password, confirmPass, cnic, eId);
    }
    //defination of abstract method
    @Override
    public void displayUserInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("CNIC: " + cnic);
            System.out.println("ID-no:  " + empid);
    }
}
// Interface for user authentication actions
interface UserAuthentication {
    void signin();
    void signup();
}

// Interface for user interface actions
interface UserInterface {

    void Student_displayMenu();
    void Employe_displayMenu();
    void handleUserStud();
    void handleUserEmp();
}

// IubEportal class implementing interfaces 
 class IubEportal implements UserInterface, UserAuthentication
  {
    private static Scanner in = new Scanner(System.in);//created object (in) of Scanner class 
    //reference variable of Class Student "UserStud" and UserEmp of Employe
    private Student UserStud;
    private Employe UserEmp;
    private int choiceT;
     int userType;
    int userChoice;
   
    public void OuterInterface()
     {
        System.out.println("  _____________________________________________ ");
        System.out.println("           Islamia University Bahawalpur \n               Console Based(App)     ");
        System.out.println("  _____________________________________________\n ");
          System.out.println(" Account type \n Student (1) \n Employee (2)    " );
            try{
          userType=in.nextInt();
          if (userType==1 || userType==2){
        System.out.println(" --> sign_in (press 1) \n --> sign_up (press 2) ");
           userChoice = in.nextInt();}
           else
           {
            System.out.println("Invalid input, try again!!");
            OuterInterface();
           }

        }
        // end of try block
        
         //catch Block to handel InputMismatch Exception on UserChoice
      catch(InputMismatchException e)
        {
            System.out.println("* Invalid input! Please enter a number ");
           in.nextLine();//clear the invalid input
            OuterInterface(); 
          }
    
        if (userChoice == 1) 
        {
            signin();
                // Open Main Menu
                // emp cond
                if( userType==1){
            Student_displayMenu();}
            else{
            Employe_displayMenu();}
           } 
         else if (userChoice == 2) 
         {
            signup();
                // Open Main Menu
                if(userType==1){
           Student_displayMenu();}
           else{
           Employe_displayMenu();}
        }  
          else 
          {
            System.out.println("Invalid Choice!\n try again");
            OuterInterface();
        } 
    }
    @Override
    public void signin()
     {
        String rollNo;
        int empid;
        System.out.println("'_");
        System.out.println("        Sign_In");
        System.out.println("_");
        // empl condition
       if(userType==1){
        System.out.println("Enter Roll no :");
         rollNo = in.next();
         System.out.println("Enter Password :");
         String password = in.next();
         UserStud= new Student("", "", password, "", "",rollNo);}
     else{
              System.out.println("Enter Employee ID :");
              try{
              empid=in.nextInt();
            
              System.out.println("Enter Password :");
              String password = in.next();
              UserEmp = new Employe("", "", password, "", "", empid);
              }
              catch(InputMismatchException obj)
              {
                System.out.println("Invalid input! ,try again ");
                in.nextLine();
                signin();
              }
        }
    }
    
    @Override
    public void signup()
     {
          int empid;
          String rollNo;
        System.out.println("'_");
        System.out.println("        Sign_Up");
        System.out.println("'_");
        System.out.println("Enter your Name :");
        String name = in.next();
        System.out.println("Enter Your Email :");
        String email = in.next();
        String cnic = "";
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter Your Cnic no(without dashes) :");
            cnic = in.next();
            if (cnic.length() == 13) {
                break;
            } else {
                System.out.println("Enter 13 Digits!, try again");
            }
        }
        String password = "";
        String confirmPass = "";
        for (int i = 0; i < 4; i++) {
            System.out.println("Create your Password :");
            password = in.next();
            System.out.println("Re-enter your password :");
            confirmPass = in.next();
            if (password.equals(confirmPass)) {
                break;
            } else {
                System.out.println("Passwords do not match, try again!");
            }
        }//end of for loop
        if(userType==1)
        {
        System.out.println("Enter Roll no :");
         rollNo = in.next();
        UserStud = new Student(name, email, password, confirmPass, cnic, rollNo);
        }
        else
        {    
               

        System.out.println("Enter Emp ID :");
            try{
         empid = in.nextInt();
        UserEmp = new Employe(name, email, password, confirmPass, cnic, empid);    
        }    
        catch(InputMismatchException obj)
        {
          System.out.println("Invalid input! ,try again ");
          in.nextLine();
          signup();
        }
        }
        }   //end of signup
    
   @Override
    public void Employe_displayMenu()
    {
         System.out.println("  _______________________ ");
         System.out.println("       IUB_EPORTAL");
         System.out.println("  -----------------------\n");
         System.out.print("[1] View Work Schedule \t ");
         System.out.print("[2] Work Plan\t");
         System.out.print("[3] Active Projects \n");
         System.out.print("[4] Attendance Record  \t");
         System.out.print("[5] Salary Statement  \t");
         System.out.print("[6] Employee ID Card \n");
         System.out.print("[7] Employee Benefits \t");
         System.out.print("[8] Performance Review\t");
         System.out.print("[9] Logout \t");
         System.out.println("\n");
         System.out.println("_");
         System.out.println("          Please enter your Choice ");
         System.out.println("_");
        try{
             choiceT = in.nextInt();
        }
        catch(InputMismatchException object)
        {   
         System.out.println("Invalid Input! , Please enter a number * ");
         in.nextLine();
        Employe_displayMenu();
        }
              handleUserEmp();
    }
    @Override
    public void handleUserEmp()
    {
        switch (choiceT) {
            case 1:
            ViewWorkSchedule();
                break;
            case 2:
            WorkPlan();
                break;
            case 3:
            ActiveProjects();
                break;
            case 4:
            AttendanceRecord ();
                break;
            case 5:
            SalaryStatement();
                break;
            case 6:
            EmployeeIDCard ();
                break;
            case 7:
            EmployeeBenefits();
                break;
            case 8:
            PerformanceReview();
                break;
            case 9:
                LogOut();
                break;
            default:
                System.out.println("Invalid choice, try again");
                Employe_displayMenu();
        }
    }
           
void ViewWorkSchedule() {
    System.out.println("_________________________ ");
    System.out.println("    Work Schedule");
    System.out.println("_________________________ ");
    System.out.println(" Monday \t 2 meetings (10am-12pm) \n Tuesday \t 3 meetings (9am-12pm) \n Wednesday \t 2 meetings (2pm-4pm) \n Thursday  \t 1 meeting (3pm-4pm)");
    Employe_displayMenu();
}

void WorkPlan() {
    System.out.println("_");
    System.out.println("    Work Plan\n ");
    System.out.println("    Project A: Research and Development ");
    System.out.println("_");
    System.out.println("  Task 1: Research on new technology \t Due Date: 12th June");
    System.out.println("  Task 2: Develop prototype \t Due Date: 20th June");
    System.out.println("  Task 3: Prepare presentation \t Due Date: 25th June");
    Employe_displayMenu();
}

void ActiveProjects() {
    System.out.println("_________________________ ");
    System.out.println("    Active Projects\n ");
    System.out.println("_________________________ ");
    System.out.println("  Project Code: P103 \t Project Title: AI Development \t Deadline: 30th June");
    System.out.println("  Project Code: P104 \t Project Title: Database Optimization \t Deadline: 20th July");
    Employe_displayMenu();
}

void AttendanceRecord() {
    System.out.println("_________________________ ");
    System.out.println("    Attendance Record");
    System.out.println("_________________________ ");
    System.out.println(" January: 20 days present, 2 days absent");
    System.out.println(" February: 18 days present, 4 days absent");
    System.out.println(" March: 22 days present, 0 days absent");
    Employe_displayMenu();
}

void SalaryStatement() {
    System.out.println("_________________________ ");
    System.out.println("    Salary Statement");
    System.out.println("_________________________ ");
    System.out.println(" Employee Name: " + UserEmp.name);
    System.out.println(" Employee ID: " + UserEmp.empid);
    System.out.println(" Basic Salary: PKR 50,000");
    System.out.println(" Allowances: PKR 10,000");
    System.out.println(" Deductions: PKR 5,000");
    System.out.println(" Net Salary: PKR 55,000");
    Employe_displayMenu();
}

void EmployeeIDCard() {
    System.out.println("_________________________ ");
    System.out.println("        Employee Card");
    System.out.println("_________________________ ");
    UserEmp.displayUserInfo();
    System.out.println(" Position: Software Engineer");
    Employe_displayMenu();
}

void EmployeeBenefits() {
    System.out.println("_________________________ ");
    System.out.println("        Employee Benefits");
    System.out.println("_________________________ ");
    System.out.println(" Available Benefits:");
    System.out.println("[1] Health Insurance");
    System.out.println("[2] Retirement Plan");
    System.out.println("[3] Paid Time Off");
    Employe_displayMenu();
}

void PerformanceReview() {
    System.out.println("_________________________ ");
    System.out.println("    Performance Evaluation");
    System.out.println("_________________________ ");
    System.out.println(" Employee Name: " + UserEmp.name);
    System.out.println(" Employee ID: " + UserEmp.empid);
    System.out.println(" Evaluation Period: Jan - Mar 2024");
    System.out.println(" Performance Rating: Excellent");
    System.out.println(" Comments: Outstanding performance in AI Development project.");
    Employe_displayMenu();
}
// Method to logout
void LogOut() {
    System.out.println("Logging out...");
    OuterInterface();
}





    @Override
    //OuterInterface ke try block ka displayMenu per koi impact nhn pare ga Q ke hm ne try just user input per kia he 
    public void Student_displayMenu() 
    {
        System.out.println("  _______________________ ");
        System.out.println("       IUB_EPORTAL");
        System.out.println("  -----------------------\n");
        System.out.print("[1] Timetable \t ");
        System.out.print("[2] Plan of study\t");
        System.out.print("[3] Current Enroll \n");
        System.out.print("[4] Course repeat \t");
        System.out.print("[5] Fee Voucher ");
        System.out.print("[6] My card\n");
        System.out.print("[7] Scholarships \t");
        System.out.print("[8] Transcript\t");
        System.out.print("[9] Logout \t");
        System.out.println("\n");
        System.out.println("_");
        System.out.println("          Please enter your Choice ");
        System.out.println("_");
       try{
            choiceT = in.nextInt();
       }
       catch(InputMismatchException object)
       {   
        System.out.println("Invalid Input! , Please enter a number * ");
        in.nextLine();
       Student_displayMenu();
       }
             handleUserStud();
        }
       
    @Override
    public void handleUserStud() {
        switch (choiceT) {
            case 1:
                Timetable();
                break;
            case 2:
                StudyPlan();
                break;
            case 3:
                CurrentE();
                break;
            case 4:
                CourseRepeat();
                break;
            case 5:
                feevouch();
                break;
            case 6:
                Mycard();
                break;
            case 7:
                Scholarships();
                break;
            case 8:
                Transcript();
                break;
            case 9:
                Logout();
                break;
            default:
                System.out.println("Invalid choice, try again");
                Student_displayMenu();
        }
    }

    void Timetable() {
        System.out.println("_________________________ ");
        System.out.println("    TimeTable");
        System.out.println("_________________________ ");
        System.out.println(" Monday \t 2 lectures (4pm-6pm) \n Tuesday \t 2 lectures(4pm-6pm) \n Wednesday \t 3 lectures (3pm-6pm) \n Thursday  \t 2 lectures(3pm-6pm)");
       Student_displayMenu();
       
    }

    void StudyPlan() {
        System.out.println("_");
        System.out.println("    Plan of Study\n ");
        System.out.println("    Semester 2 ");
        System.out.println("_");
        System.out.println("  C.code: CS103 \t Course Title: Database systems \t CH :2 \t C.Type:CS103");
        System.out.println("  C.code: CS104 \t Course Title: OOPs \t                 CH :3 \t C.Type:CS103");
        System.out.println("  C.code: CS105 \t Course Title: DLD \t                 CH :3 \t C.Type:CS103");
        System.out.println("  C.code: CS106 \t Course Title: Multivar Calculus \t CH :2 \t C.Type:CS103");
        System.out.println("  C.code: CS107 \t Course Title: Linear Algebra \t         CH :3 \t C.Type:CS103");
          Student_displayMenu();
    }
    void CurrentE() {
        System.out.println("_________________________ ");
        System.out.println("    Current Enrollments\n ");
        System.out.println("    Semester 2 ");
        System.out.println("_________________________ ");
        System.out.println("  C.code: CS103 \t Course Title: Database systems \t CH :2 \t C.Type:CS103");
        System.out.println("  C.code: CS104 \t Course Title: OOPs \t                 CH :3 \t C.Type:CS103");
        System.out.println("  C.code: CS105 \t Course Title: DLD \t                 CH :3 \t C.Type:CS103");
        System.out.println("  C.code: CS106 \t Course Title: Multivar Calculus \t CH :2 \t C.Type:CS103");
        System.out.println("  C.code: CS107 \t Course Title: Linear Algebra \t         CH :3 \t C.Type:CS103");
         Student_displayMenu();
    }
    void CourseRepeat() {
        System.out.println("");
        System.out.println("      Course Repeat");
        System.out.println("");
        System.out.println("    F23BDOCS1E02125\n" +
                "       ZIA UD DIN\n" +
                "Discipline: BS Computer Science(E)\n" +
                "Note: Please fill the course(s) Information carefully. Once you generate challan for selected courses, It will then not allow you to apply it again. Maximum limit of applying for course repeat is 5 for this semester ");
        int examf, course;
        System.out.println(" [1] Select Exam fee type \n ");
        //try block
        try{
            
        examf = in.nextInt();
        if(examf==1){
        System.out.println("[1] Exam fee for marks improvement \n [2] Exam fee for fail subject");
       int marksi;
        marksi = in.nextInt();
        if (marksi == 1) {
            marksi = 3500;
    
        } else if(marksi==2) {
            marksi = 4500;
       
        }
        else{
            System.out.println("Invalid Choice!");
            CourseRepeat();
        }
     
    }
    else{
                System.out.println("Invalid Choice !!");
                CourseRepeat();
                 
    }
      
        System.out.println("_________________________ ");
        System.out.println(" [2] Select course");
        System.out.println("_________________________ ");
        course = in.nextInt();
        if(course==2){
        if (course == 2) {
            System.out.println("_________________________ ");
            System.out.println("     Select one please");
            System.out.println("_________________________ ");
            System.out.println("[1] Programming fundamental");
            System.out.println("[2] Discrete structure");
            System.out.println("[3] Calculus");
            System.out.println("[4] CiT");
            String subject;
            subject = in.next();
        }
    }
        else{
            System.out.println("Invalid Choice !!!");
        }
    
        System.out.println("\n");
        System.out.println("_____________________________________________ ");
        System.out.println("[1] Generate challan And Application form");
        System.out.println("______________________________________________ ");
        int generate;
        generate = in.nextInt();
        if (generate == 1) {
            System.out.println("Generating challan and application form for selected course...");
            // Simulate the process of generating a challan and application form
            System.out.println("Challan and application form generated successfully.\n Check your fee Voucher");
        }
         Student_displayMenu();
    }
    //Ap RuntimeException Class bhe use kersakte hn ,Q ke ye Class InputMismatchException ke parent Class he
    catch(RuntimeException object)
    {
        System.out.println("Invalid Input , Plaese enter a number **");
        in.nextLine();
        CourseRepeat();
    }
    finally
    {
        in.close();
}}

      void   feevouch() {
        System.out.println("_________________________ ");
        System.out.println("       Fee Voucher");
        System.out.println("_________________________ ");
        System.out.println("Student Name: " + UserStud.name);
        System.out.println("Roll No: " + UserStud.rollNo);
        System.out.println("Program: BS Computer Science");
          Student_displayMenu();
    }
    

    void Mycard() {
        System.out.println("_________________________ ");
        System.out.println("        Student Card");
        System.out.println("_________________________ ");
        UserStud.displayUserInfo();
        System.out.println("Program: BS Computer Science");
         Student_displayMenu();
    }
    void Scholarships() {
        System.out.println("_________________________ ");
        System.out.println("         Scholarships");
        System.out.println("_________________________ ");
        System.out.println("Available Scholarships:");
        System.out.println("[1] HEC Need-Based Scholarship");
        System.out.println("[2] PEEF Scholarship");
        System.out.println("[3] University Merit Scholarship");
         Student_displayMenu();
    }
    void Transcript() {
        System.out.println("_________________________ ");
        System.out.println("        Transcript");
        System.out.println("_________________________ ");
        System.out.println("Student Name: " + UserStud.name);
        System.out.println("Roll No: " + UserStud.rollNo);
        System.out.println("Semester: 2");
        System.out.println("GPA: 3.5");
         Student_displayMenu();
    }
    void Logout() {
        System.out.println("Logging out...");
        OuterInterface();
    }
}
// Main class

public class Main
{
    public static void main(String[] args)
     {
        IubEportal portal = new IubEportal();
        portal.OuterInterface();
}
}

