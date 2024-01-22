import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class ProductReader
{
    public static void main(String[] args) throws IOException {
        JFileChooser chooser = new JFileChooser();
        File fileSelected;
        String product;
        String sFormat;
        ArrayList<String> productList = new ArrayList<>();

        String idString;
        String prodName;
        String prodDesc;
        double prodCost;

        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);

        BufferedReader reader;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {

            fileSelected = chooser.getSelectedFile();
            Path file = fileSelected.toPath();

            InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.CREATE));
            reader = new BufferedReader(new InputStreamReader(in));

            String[] fields;
            while (reader.ready())
            {
                product = reader.readLine();
                productList.add(product);
            }
            sFormat = String.format("%6s%12s%30s%10s", "ID#", "Product", "Description", "Cost");
            System.out.println(sFormat);

            sFormat = String.format("%58s", "==========================================================");
            System.out.println(sFormat);

            for (String list : productList)
            {
                fields = list.split(",");

                if (fields.length == 4)
                {
                    idString = fields[0].trim();
                    prodName = fields[1].trim();
                    prodDesc = fields[2].trim();
                    prodCost = parseDouble(fields[3].trim());
                    sFormat = String.format("%6s%12s%30s%10.1f", idString, prodName, prodDesc, prodCost);
                    System.out.println(sFormat);

                }
                else
                {
                    System.out.println("Found a record that may be corrupt: ");
                    System.out.println(list);

                }
            }
            reader.close();
        }
    }

}