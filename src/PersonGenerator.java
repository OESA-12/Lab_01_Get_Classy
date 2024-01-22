import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String firstName;
        String lastName;
        String idString;
        String inputTitle;
        int yearOfBirth;
        boolean doContinue;
        ArrayList<Person> PersonList = new ArrayList<>();


        do
        {
            firstName = SafeInput.getNonZeroLenString(in, "Input first name");
            lastName = SafeInput.getNonZeroLenString(in, "Input last name");
            idString = SafeInput.getNonZeroLenString(in, "Enter Id");
            inputTitle = SafeInput.getNonZeroLenString(in, "Input title");
            yearOfBirth = SafeInput.getRangedInt(in, "Input year of birth ",1940,2000);

            Person personInput = new Person (firstName, lastName, idString, inputTitle, yearOfBirth);

            PersonList.add(personInput);

            doContinue = SafeInput.getYNConfirm(in, "Do you want to continue");

            System.out.println(PersonList);
            System.out.println(doContinue);

        } while (doContinue);

        String fileName;
        fileName = SafeInput.getNonZeroLenString(in, "What do you want the file to be called");
        FileWriter writer = new FileWriter(fileName + ".txt");

        for (Person i : PersonList)
        {
            writer.write(i.toCSVRecordMethod());
            writer.write("\n");
        }
        writer.close();
    }
}
