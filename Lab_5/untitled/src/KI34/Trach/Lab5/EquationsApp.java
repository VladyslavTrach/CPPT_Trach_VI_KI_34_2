package KI34.Trach.Lab5;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
/**
 * Class <code>EquationsApp</code> Implements driver for Equations class
 * @author Vladyslav Trach
 * @version 1.0
 */
public class EquationsApp {

    public static void main(String[] args)
    {
        try
        {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try
            {
                try
                {
                    Equations eq = new Equations();

                    out.print("func = tg(4x) /x \nEnter X: ");
                    fout.print(eq.calculate(in.nextInt()));
                } catch (XEcualsFiveExeption e) {
                    throw new RuntimeException(e);
                } finally
                {
                    // Цей блок виконається за будь-яких обставин
                    fout.flush();
                    fout.close();
                }
            }
            catch (CalcException ex)
            {
                // Блок перехоплює помилки обчислень виразу
                out.print(ex.getMessage());
            }
        }
        catch (FileNotFoundException ex)
        {
// Блок перехоплює помилки роботи з файлом навіть якщо вони
// виникли у блоці finally
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}
/**
 * Class <code>CalcException</code> more precises ArithmeticException
 * @author Vladyslav Trach
 *  * @version 1.0
 */
class CalcException extends ArithmeticException
{
    public CalcException(){}
    public CalcException(String cause)
    {
        super(cause);
    }
}
/**
 * Class <code>Equations</code> implements method for (tg(4x) / x) expression
 * calculation
 * @author Vladyslav Trach
 *  * @version 1.0
 */
class Equations
{

    public double calculate(int x) throws CalcException, XEcualsFiveExeption {
        double y, rad;
        if (x == 5){
            throw new XEcualsFiveExeption();
        }
        rad = x * Math.PI / 180.0;
        try
        {
            y = (Math.tan(rad * 4)) / x;

            // Якщо результат не є числом, то генеруємо виключення
            if (Double.isNaN(y) || y==Double.NEGATIVE_INFINITY ||
                    y==Double.POSITIVE_INFINITY ||  x == 90 / 4 || x == -90 / 4)
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

        return y;
    }
}