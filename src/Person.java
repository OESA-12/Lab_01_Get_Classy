import java.util.Calendar;

public class Person
{
    public String firstName;
    public String lastName;
    public String idString;
    public String inputTitle;
    public int yearOfBirth;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed)
    {
        Person.IDSeed = IDSeed;
    }

    public static int getIDSeed()
    {
        return IDSeed;
    }

    public Person( String firstName, String lastName, String idString, String inputTitle, int yearOfBirth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idString = idString;
        this.inputTitle = inputTitle;
        this.yearOfBirth = yearOfBirth;
    }
    public Person(String firstName, String lastName, int yearOfBirth)
    {
        this.idString = this.genidString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    private String genidString()
    {
        String newID = "" + IDSeed;
        while(newID.length() < 8)
        {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getIdString()
    {
        return idString;
    }

    public void setIdString(String idString)
    {
        this.idString = idString;
    }

    public String getInputTitle()
    {
        return inputTitle;
    }

    public void setInputTitle(String inputTitle)
    {
        this.inputTitle = inputTitle;
    }

    public int getYearOfBirth()
    {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth)
    {
        this.yearOfBirth = yearOfBirth;
    }

    public String fullName()
    {
        return this.firstName + " " + this.lastName;
    }

    public String formalName()
    {
        return this.inputTitle + " " + fullName();
    }

    public String getAge()
    {
        return Integer.toString(Calendar.getInstance().get(Calendar.YEAR) - this.yearOfBirth);
    }

    public String toCSVRecordMethod()
    {
        return getFirstName() + ", " + getLastName() + ", " + getIdString() + ", " + getInputTitle() + ", " + getAge();
    }
}
