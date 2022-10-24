package KI34.Trach.lab7;
import java.util.*;
import java.io.*;

public class HDDDriver {
    public static void main(String[] args)
    {
        Suitcase <? super Data> suitc1 = new Suitcase <Data>();
        suitc1.AddData(new Clothing("T-shirt",  15));
        suitc1.AddData(new Thing("Shampoo" , 2,2));
        suitc1.AddData(new Clothing("Jeans",  3));
        suitc1.AddData(new Thing("Hair dryer" , 3,5));

        Data res = suitc1.findMin();
        System.out.print("The smallest element in Suitcase is: \n");
        res.print();
    }
}




