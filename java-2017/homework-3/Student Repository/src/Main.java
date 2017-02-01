import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the Main class.
 * Created by Adrian Migea on 23/01/2017.
 */
public class Main {
    private static Logger LOGGER=Logger.getLogger("Main");

    /**
     * This is the main method.
     * @param args
     * @throws EmptyParameterException
     */
    public static void main(String[] args) throws EmptyParameterException {
        Student student1 = new Student("Adrian ", "Migea ", 2000,"M", "1921213434433");
        Student student2 = new Student("Alexandra ", "Popa ", 1995,"F", "2113313332345");
        Student student3=new Student("Andrei ","Pista ",2000,"M","1920200000044");
        Student student4=new Student("Andreea ","Tarnu",2001,"f","2121212121214");

        StudentCatalog studentList = new StudentCatalog();
        studentList.addStudentToList(student1);
        studentList.addStudentToList(student2);
        studentList.addStudentToList(student3);
        studentList.addStudentToList(student4);

        studentList.sortStudentList();
        System.out.println("student list sorts after dateOfBirth " + studentList.getStudents());
        System.out.println("student list after delete "+ studentList.deleteStudentWithSameId("1921213434433"));
        System.out.println("student with same age " + studentList.getStudentWithSameAge(17));
        Main main=new Main();
        main.exceptionHandle1();
        main.exceptionHandle2();
        main.exceptionHandle3();
    }

    /**
     * This method tests if a student has a empty parameter.
     */
    private void exceptionHandle1(){
        try {
            Student s3 = new Student("Andrei", "Popa", 1992, "", "1921213434456");
        } catch(EmptyParameterException e){
            LOGGER.log(Level.SEVERE,"a paramater is empty",e);
        }
    }

    /**
     * This method tests if a student has a empty parameter.
     */
    private void exceptionHandle2(){
        try {
            Student s1 = new Student("", "Migea ", 1992, "M", "1921213434477");
        } catch(EmptyParameterException e){
            LOGGER.log(Level.SEVERE,"parameter should not be empty",e);
        }
    }

    /**
     * This method tests if a student has valid parameters.
     */
    private void exceptionHandle3(){
        try{
            Student student2 = new Student("Alexandra ", "Popa ", 1995,"F", "2113313332345");
        } catch(EmptyParameterException e){
            LOGGER.log(Level.SEVERE,"a student shouldn't have a empty parameter");
        }
    }

}




