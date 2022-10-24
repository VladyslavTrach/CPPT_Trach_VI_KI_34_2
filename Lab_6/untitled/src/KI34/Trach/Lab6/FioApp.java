package KI34.Trach.Lab6;
import java.io.*;
import java.util.*;


public class FioApp {
    public static void main(String[] args) throws IOException, XEcualsFiveExeption {
        // TODO Auto-generated method stub
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter data: ");
        double data = s.nextDouble();
        obj.calculate(data);
        System.out.println("Result is: " + obj.getResult());


        obj.writeResTxt("textRes.txt");
        obj.writeResBin("BinRes.bin");


        obj.readResBin("BinRes.bin");
        System.out.println("Result is: " + obj.getResult());
        obj.readResTxt("textRes.txt");
        System.out.println("Result is: " + obj.getResult());
        // дописати трай кетч блок для обробки ексепшина у ситуації коли файла не існує
    }
}
class CalcWFio
{
    public void writeResTxt(String fName)
    {
        try
        {
            File f = new File (fName);
            if (f.exists())
            {
                PrintWriter f32 = new PrintWriter(fName);
                f32.printf("%f ",result);
                f32.close();
            }
            else
                throw new FileNotFoundException("File " + fName + " not found");
        }
        catch (FileNotFoundException ex)
        {
            System.out.print(ex.getMessage());
        }


    }

    public void readResTxt(String fName)
    {
        try
        {
            File f = new File (fName);
            if (f.exists())
            {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            }
            else
                throw new FileNotFoundException("File " + fName + "not found");
        }
        catch (FileNotFoundException ex)
        {
            System.out.print(ex.getMessage());
        }
    }

    public void writeResBin(String fName) throws FileNotFoundException, IOException
    {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    public void readResBin(String fName) throws FileNotFoundException, IOException
    {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    static class CalcException extends ArithmeticException
    {
        public CalcException(String cause)
        {
            super(cause);
        }
    }

    public void calculate(double x) throws CalcException, XEcualsFiveExeption {
        double y, rad;
        if (x == 5){
            throw new XEcualsFiveExeption();
        }
        rad = x * Math.PI / 180.0;
        try
        {
            y = (Math.tan(rad * 4)) / x;

            // Якщо результат не є числом, то генеруємо виключення
            if (Double.isNaN(y) || y==Double.NEGATIVE_INFINITY || y==Double.POSITIVE_INFINITY || x == 90 / 4 || x == -90 / 4)
                throw new ArithmeticException();
        }
        catch (ArithmeticException ex)
        {
            // створимо виключення вищого рівня з поясненням причини
            // виникнення помилки
            if (rad * 4 == Math.PI/2.0 || rad * 4 ==- Math.PI/2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if (x == 0)
                throw new CalcException("Exception reason: X = 0");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        result = y;
    }

    public double getResult()
    {
        return result;
    }
    private double result;
}