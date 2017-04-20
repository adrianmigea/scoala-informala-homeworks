import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class models a student catalog.
 * Created by Adrian Migea on 23/01/2017.
 */
public class StudentCatalog {
    private List<Student> studentList = new ArrayList<>();

    /**
     * This method adds student to the list.
     * @param newStudent is a student.
     */
    public void addStudentToList(Student newStudent){
        studentList.add(newStudent);
    }

    public List<Student> getStudents(){
        return studentList;
    }

    /**
     * This method returns the students with same age.
     * @param age is the student age.
     * @return studentWithSameAge.
     * @throws EmptyParameterException
     */
    public List<Student> getStudentWithSameAge(int age)throws EmptyParameterException{
        List<Student> studentWithSameAge=new ArrayList<>();
        for (Student s:studentList) {
            if(s.calculateAge()<0){
                throw new EmptyParameterException("age is negative");
            }else if (s.calculateAge()==age){
                studentWithSameAge.add(s);
            }
        }
    return studentWithSameAge;
    }

    /**
     * This method deletes the students with same cnp.
     * @param cnp is the student id.
     * @return studentWithoutSameCnp.
     * @throws EmptyParameterException
     */
    public List<Student> deleteStudentWithSameId(String cnp) throws EmptyParameterException{
        List<Student> studentWithoutSameCnp=new ArrayList<>();
        for(Student s:studentList){
            if(s.getCnp()!=cnp){
                studentWithoutSameCnp.add(s);
            }else if(s.getCnp().isEmpty()){
                throw new EmptyParameterException("cnp is empty");
            }
        }
    return studentWithoutSameCnp;
    }

    /**
     * This method sorts the student list.
     */
    public void sortStudentList(){
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getDateOfBirth()-o2.getDateOfBirth();
            }
        });

    }


}