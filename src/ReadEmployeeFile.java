/**
 * Created by Frank Hall on 6/25/2016.
 */
import java.nio.file.*;
import java.io.*;

public class ReadEmployeeFile
{
    public static void main(String[] args)
    {
        Path file = Paths.get("D:\\java\\Employees.txt");
        String[] array = new String[3];
        String s = "";
        String delimiter = ",";
        int id;
        String name;
        double payRate = 0;
        double gross = 0;
        double total = 0;

        try
        {
            InputStream input = new BufferedInputStream(Files.newInputStream(file)); //reads from txt file
            BufferedReader reader = new BufferedReader(new InputStreamReader(input)); //burreres the txt so we can bring it in all at once and one byte ata a time.
            s = reader.readLine();

            while(s != null)
            {
                array = s.split(delimiter); //puts the txt contents into an string called s and puts s into an array
                id = Integer.parseInt(array[0]);//parses id number
                name = array[1]; //sets name to be the subscript1 in the array.
                payRate = Double.parseDouble(array[2]);// payrate is set to the parsed double avariable and the array subscript 2
                gross = payRate * 40;
                System.out.println("Employee info " +name+ "\tID " +id+ "\tPay rate " +payRate+ "\tGross " +gross);
                total += gross;
                s = reader.readLine();
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Message" +e);
        }
        System.out.println("Total " +total);
    }
}
