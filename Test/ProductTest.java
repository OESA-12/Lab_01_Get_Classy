import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest
{
    Product p1, p2, p3,p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("Mushrooms", "From the Forbidden Forest", "0001",10);
        p2 = new Product("Transfiguration Textbook", "A Beginner's Guide to Transfiguration", "0002", 200);
        Product.setIDSeed(0);
        p3 = new Product("Transfiguration Textbook 2", "A Guide to Advanced Transfiguration", 200);
        p4 = new Product( "Dark Arts Defence", "Dark Arts Defence – Basics for Beginners", 200);
        p5 = new Product( "Dark Arts Defence 2", "Defence Against the Dark Arts", 200);
        p6 = new Product( "Comet 290", "Broomstick", 2000);
    }

    @Test
    void getProdName()
    {
        assertEquals("Mushrooms", p1.getProdName());
    }
    @Test
    void getProdDesc()
    {
        p1.setProdDesc("From the Forbidden Forest");
        assertEquals("From the Forbidden Forest", p1.getProdDesc());
    }
    @Test
    void getIdString()
    {
        assertEquals("0001", p1.getIdString());
    }
    @Test
    void getProdCost()
    {
        assertEquals(10, p1.getProdCost());
    }
}