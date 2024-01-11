package java_comparator_example;

public class Patient implements Comparable<Patient>{

    private String firstName;
    private String lastName;
    private String ssn;

    Patient(String firstName, String lastName, String ssn){
        if(ssn==null || ssn.trim().isEmpty())
            throw new IllegalArgumentException("SSN can not be empty. Please add SSN.");
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    @Override
    public int compareTo(Patient that){
        return this.getLastName().compareTo(that.getLastName());
    }

    @Override
    public boolean equals(Object that){
        if(this == that)
            return true;
        if(that == null || this.getClass() !=that.getClass())
            return false;
        Patient patient = (Patient) that;
        return this.ssn.equals(patient.getSSN());
    }

    @Override
    public int hashCode(){
        return this.getSSN().hashCode();
    }

    @Override
    public String toString(){
        return "Patient { firstName: "+ getFirstName() +", lastName: "+ getLastName() +", ssn: "+getSSN();
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSSN(){
        return ssn;
    }
}
