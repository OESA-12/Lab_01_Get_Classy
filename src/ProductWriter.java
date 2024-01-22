import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter
{
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String idString;
        String prodName;
        String prodDesc;
        double prodCost;
        boolean doContinue;
        ArrayList<Product> ProductList = new ArrayList<>();

        do
        {
            prodName = SafeInput.getNonZeroLenString(in, "Input product name");
            prodDesc = SafeInput.getNonZeroLenString(in, "Input description");
            idString = SafeInput.getNonZeroLenString(in, "Enter Id");
            prodCost = SafeInput.getDouble(in, "Input cost");

            Product productInput = new Product(prodName, prodDesc, idString, prodCost);

            ProductList.add(productInput);

            doContinue = SafeInput.getYNConfirm(in, "Do you want to continue");

            System.out.println(ProductList);
            System.out.println(doContinue);

        } while (doContinue);

        String fileName;
        fileName = SafeInput.getNonZeroLenString(in, "What do you want the file to be called");
        FileWriter writer = new FileWriter(fileName + ".txt");

        for (Product i : ProductList)
        {
            writer.write(i.toCSVRecordMethod());
            writer.write("\n");
        }
        writer.close();
    }
}
