public class Product
{
    public String prodName;
    public String prodDesc;
    public String idString;
    public double prodCost;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed)
    {
        Product.IDSeed = IDSeed;
    }

    public static int getIDSeed()
    {
        return IDSeed;
    }

    public Product(String prodName, String prodDesc, String idString, double prodCost)
    {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.idString = idString;
        this.prodCost = prodCost;
    }
    public Product(String prodName, String prodDesc, double prodCost)
    {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodCost = prodCost;
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

    public String getProdName()
    {
        return prodName;
    }

    public void setProdName(String prodName)
    {
        this.prodName = prodName;
    }

    public String getProdDesc()
    {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc)
    {
        this.prodDesc = prodDesc;
    }

    public String getIdString()
    {
        return idString;
    }

    public void setIdString(String idString)
    {
        this.idString = idString;
    }

    public double getProdCost()
    {
        return prodCost;
    }
    public void setProdCost(double prodCost)
    {
        this.prodCost = prodCost;
    }

    public String toCSVRecordMethod()
    {
        return this.prodName + ", " + this.prodDesc + ", " + this.idString + ", " + this.prodCost;
    }
}
