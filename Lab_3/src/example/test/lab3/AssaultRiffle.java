package example.test.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class AssaultRiffle
{
    private Barrel barrel;
    private Barrel.Firemods firemode;
    private Magazine magazine;
    private Scope scope;
    private PrintWriter fout;




    public AssaultRiffle () throws FileNotFoundException {
        barrel = new Barrel();
        firemode  = Barrel.Firemods.Locked;
        magazine = new Magazine();
        scope = new Scope();

        fout = new PrintWriter(new File("Log.txt"));
    }

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
    public void showInfo () {
        System.out.println("\nBarrel resource is : " + barrel.currentBarrelResource + " rounds\nIt is " + magazine.currentMagazineCapacity + " bullets left in the magazine.\n" + "Gun accuracy : " + scope.currentAccuracy + "%.\nFiremode : " + barrel.getFiremod() + "\n\n");

        fout.println("The information about AR was outputed");
    }

    public void fullService () {
        barrel.setFiremodLocked();
        barrel.cleanBarrel();
        magazine.reload();
        scope.reconfigurate();

        fout.println("AR has been serviced");
    }

    public void setAutomatic () {
        barrel.setFiremodAutomatic();

        fout.println("AR has been set to automatic");
    }

    public void setSemiAutomatic () {
        barrel.setFiremodSemiautomatic();

        fout.println("AR has been set to semi-automatic");
    }

    public void setLocked () {
        barrel.setFiremodLocked();

        fout.println("AR has been set to locked");
    }

    public void getTotalAcc (){
        System.out.println(scope.totalAcc);
    }

    public void closeFile (){
        fout.close();
    }
}

class Barrel {
    public final int barrelResource = 10000;
    public int currentBarrelResource;

    enum Firemods {Automatic, Semiautomatic, Locked}
    private Firemods firemod;

    public Barrel()
    {
        currentBarrelResource = barrelResource;
        firemod = Firemods.Locked;
    }

    public void setFiremodLocked() {
        firemod = Firemods.Locked;
    }

    public void setFiremodSemiautomatic() {
        firemod = Firemods.Semiautomatic;
    }

    public void setFiremodAutomatic() {
        firemod = Firemods.Automatic;
    }

    public Firemods getFiremod() {
        return firemod;
    }

    public void cleanBarrel() {
        currentBarrelResource = 10000;
        System.out.println("Gun is cleaned");
    }
}

class Magazine {
    public final int magazineCapacity = 30;
    public int currentMagazineCapacity;

    public Magazine()
    {
        currentMagazineCapacity = magazineCapacity;
    }

    public void reload() {
        currentMagazineCapacity = 30;
        System.out.println("Gun is reloaded");
    }

}

class Scope {
    public static double idealAccuracy = 100;
    public double currentAccuracy;
    public static double totalAcc = 0;


    public Scope()
    {
        currentAccuracy = idealAccuracy;
    }

    public Scope(double acc)
    {
        currentAccuracy = acc;
        if (acc > 50)
        {
            totalAcc += acc;
        }
    }

    public void reconfigurate() {
        currentAccuracy = 100;
        System.out.println("Scope is reconfigured");
    }

}



