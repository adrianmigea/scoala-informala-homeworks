/**
 * This class models a student having first name,last name, date of birth,gender and cnp.
 * Created by Adrian Migea on 23/01/2017.
 */
public class Student {
    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String gender;
    private String cnp;

    /**
     * This is the constructor
     * @param firstName is the first name of a student
     * @param lastName is the last name of a student.
     * @param dateOfBirth is the student birthday.
     * @param gender can be M or F.
     * @param cnp is the student id.
     * @throws EmptyParameterException
     */
    public Student(String firstName, String lastName, int dateOfBirth, String gender, String cnp) throws EmptyParameterException {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setDateOfBirth(dateOfBirth);
        setCnp(cnp);
    }

    public void setFirstName(String firstName) throws EmptyParameterException {
        if (firstName.equals("")) {
            throw new EmptyParameterException("first name is empty");
        }
        this.firstName = firstName;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) throws EmptyParameterException {
        if(lastName.equals("")){
            throw new EmptyParameterException("last name is empty");
        }
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(int dateOfBirth) throws EmptyParameterException {
        if(dateOfBirth<=1900 || dateOfBirth>=2018){
            throw new EmptyParameterException("date of birth should be grater than 1900 and lower than 2018");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setGender(String gender) throws EmptyParameterException {
        if(gender.equals("M") || gender.equals("F")|| gender.equals("m")|| gender.equals("f")){
            this.gender=gender;
        } else throw new EmptyParameterException("gender should be M,F or m,f ");
    }

    public String getGender() {
        return gender;
    }

    public void setCnp(String cnp) throws EmptyParameterException {
        if (cnp.length()!=13){
            throw new EmptyParameterException("cnp should have 13 digits");
        }
        this.cnp = cnp;
    }

    public String getCnp() {
        return cnp;
    }

    /**
     * This method calculates the age of a student.
     * @return age
     */
    public int calculateAge(){
        return 2017-getDateOfBirth();
    }

    /**
     * This method returns the student features.
     * @return student features.
     */
    public String toString(){
        return "Student " + " firstName "+firstName+" lastName "+lastName+" dateOfBirth "+dateOfBirth+
                " gender "+gender+" cnp "+cnp;
    }


}
