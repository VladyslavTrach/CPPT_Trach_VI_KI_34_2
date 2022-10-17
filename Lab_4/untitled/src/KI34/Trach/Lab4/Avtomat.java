package KI34.Trach.Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//Оголошую абстрактний клас Avtomat
public abstract class Avtomat implements Weighed
{
    public Barrel barrel;
    public Barrel.Firemods firemode;
    public Magazine magazine;
    public Scope scope;
    public Stock stock;
    public double weight = 5;
    public PrintWriter fout;



//Конструктор класу Avtomat
    public Avtomat () throws FileNotFoundException {
        barrel = new Barrel();
        firemode  = Barrel.Firemods.Locked;
        magazine = new Magazine();
        scope = new Scope();

        fout = new PrintWriter(new File("Log.txt"));
    }

    //Метод, що дозволяє автомату стріляти
    public void shoot (int numberOfShots) {
        if (barrel.currentBarrelResource > numberOfShots && magazine.currentMagazineCapacity > numberOfShots && numberOfShots > 0 && barrel.getFiremod() != Barrel.Firemods.Locked){
            barrel.currentBarrelResource -= numberOfShots;
            magazine.currentMagazineCapacity -= numberOfShots;
            scope.currentAccuracy -= numberOfShots * 0.02321;

            fout.println("AR has shooted " + numberOfShots + " times");

        } else if(magazine.currentMagazineCapacity < numberOfShots) {
            System.out.println("Error. There`s no enough bullets in magazine.\n");
        }else if(barrel.currentBarrelResource < numberOfShots) {
            System.out.println("Error. There`s no left barrel resource.\n");
        } else if(firemode == Barrel.Firemods.Locked) {
            System.out.println("Error. Fire mod is locked.\n");
        }
    }

    //Метод, що виводить інформацію про автомат
    public void showInfo () {
        System.out.println("\nBarrel resource is : " + barrel.currentBarrelResource + " rounds\nIt is " + magazine.currentMagazineCapacity + " bullets left in the magazine.\n" + "Gun accuracy : " + scope.currentAccuracy + "%.\nFiremode : " + barrel.getFiremod() + "\n\n");

        fout.println("The information about AR was outputed");
    }

    //Метод, що проводить повне обслуговування автомату
    public void fullService () {
        barrel.setFiremodLocked();
        barrel.cleanBarrel();
        magazine.reload();
        scope.reconfigurate();

        fout.println("AR has been serviced");
    }

    //Метод, що переводить режим вогню в автоматичний
    public void setAutomatic () {
        barrel.setFiremodAutomatic();

        fout.println("AR has been set to automatic");
    }

    //Метод, що переводить режим вогню в напів-автоматичний
    public void setSemiAutomatic () {
        barrel.setFiremodSemiautomatic();

        fout.println("AR has been set to semi-automatic");
    }

    //Метод, що переводить режим вогню на запобіжник
    public void setLocked () {
        barrel.setFiremodLocked();

        fout.println("AR has been set to locked");
    }

    //Метод, що виводить точність прицілу
    public void getTotalAcc (){
        System.out.println(scope.totalAcc);
    }

    //Метод, що закриває файл
    public void closeFile (){
        fout.close();
    }


    @Override // Метод, що визначає вагу автомата
    public double weight() {
        weight += magazine.currentMagazineCapacity * 0.025;
        return weight;
    }
}

//Оголошую  клас Barrel
class Barrel {
    public final int barrelResource = 10000;
    public int currentBarrelResource;


    //Визначення всіх можливих режимів вогню
    enum Firemods {Automatic, Semiautomatic, Locked}
    private Firemods firemod;

    //Конструктор класу Barrel
    public Barrel()
    {
        currentBarrelResource = barrelResource;
        firemod = Firemods.Locked;
    }

    //Метод, що переводить режим вогню в автоматичний
    public void setFiremodLocked() {
        firemod = Firemods.Locked;
    }

    //Метод, що переводить режим вогню в напів-автоматичний
    public void setFiremodSemiautomatic() {
        firemod = Firemods.Semiautomatic;
    }

    //Метод, що переводить режим вогню на запобіжник
    public void setFiremodAutomatic() {
        firemod = Firemods.Automatic;
    }

    //Метод, що видає інформацію про поточний режим вогню
    public Firemods getFiremod() {
        return firemod;
    }

    //Метод, який очищує ствол
    public void cleanBarrel() {
        currentBarrelResource = 10000;
        System.out.println("Gun is cleaned");
    }
}

//Оголошую  клас Magazine
class Magazine {
    public final int magazineCapacity = 30;
    public int currentMagazineCapacity;

    //Конструктор класу Magazine
    public Magazine()
    {
        currentMagazineCapacity = magazineCapacity;
    }

    //Метод, що перезаряджає автомат
    public void reload() {
        currentMagazineCapacity = 30;
        System.out.println("Gun is reloaded");
    }

}
//Оголошую  клас Scope
class Scope {
    public static double idealAccuracy = 100;
    public double currentAccuracy;
    public static double totalAcc = 0;


    //Конструктор класу Scope
    public Scope()
    {
        currentAccuracy = idealAccuracy;
    }


    //Метод з додаткового заваддня при здачі 3 лаби
    public Scope(double acc)
    {
        currentAccuracy = acc;
        if (acc > 50)
        {
            totalAcc += acc;
        }
    }

    //Метод, який переналаштовує приціл
    public void reconfigurate() {
        currentAccuracy = 100;
        System.out.println("Scope is reconfigured");
    }

}



