package KI34.Trach.Lab4;

import java.io.FileNotFoundException;

//Оголошую  клас AssaultRifle
public abstract class AssaultRifle extends Avtomat implements Weighed {

    //Конструктор класу AssaultRifle
    public AssaultRifle() throws FileNotFoundException {
        barrel = new Barrel();
        firemode  = Barrel.Firemods.Locked;
        magazine = new Magazine();
        scope = new Scope();
        stock = new Stock();

        stock.setStockHeavy();
    }

     public void OutInfo () {

    }

    @Override // Метод, що визначає вагу ШГ
    public double weight() {
        if(stock.stockType == Stock.typeOfStock.Heavy){
            weight = 6;
        } else if (stock.stockType == Stock.typeOfStock.Light) {
            weight = 4;
        }
        weight += magazine.currentMagazineCapacity * 0.025;
        return weight;
    }

}

//Оголошую  клас Stock
class Stock {
    typeOfStock stockType;
    enum typeOfStock {Heavy, Normal, Light};

    //Конструктор класу AssaultRifle
    public Stock (){
        stockType = typeOfStock.Normal;
    }


    //Метод, що встановлює важкий приклад
    public void setStockHeavy(){
        stockType = typeOfStock.Heavy;
    }

    //Метод, що встановлює нормальний приклад

    public void setStockNormal(){
        stockType = typeOfStock.Normal;
    }

    //Метод, що встановлює легкий приклад

    public void setStockLight(){
        stockType = typeOfStock.Light;
    }


}
