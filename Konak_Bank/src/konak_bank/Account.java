package konak_bank;

/**
 *
 * @author Martin Koňák
 */
public class Account {
    //data
    private double money;

    //constructor
    public Account(double money) {
        this.money = money;
    }
    
    //methods
    public double addMoney(double value){
       return money + value;
    }
    
    public double takeMoney(double value){
        if (value <= money) {
            return money - value;
        }else{
            return 0;
        }
    }

    public double getMoney() {
        return money;
    }
    
    
    
}
