package example.test.lab3;

import java.io.FileNotFoundException;

public class AssaultRiffleApp {
    public static void main(String[] args) throws FileNotFoundException {
        AssaultRiffle AR1 = new AssaultRiffle();



        Scope scope1 = new Scope(12);
        Scope scope2 = new Scope(31);
        Scope scope3 = new Scope(23);
        Scope scope4 = new Scope(75);
        Scope scope5 = new Scope(65);
        Scope scope6 = new Scope(85);

        //AR1.getTotalAcc();

        System.out.println(Scope.totalAcc);
        //вивести суму точностей яка більше 50
        AR1.closeFile();
    }
}
