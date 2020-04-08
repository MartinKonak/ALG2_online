/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konak_bank;

import java.util.ArrayList;

/**
 *
 * @author Martin Koňák
 */
public class Client {
    //data
    private String name;
    private ArrayList<Account> accounts = new ArrayList();

    //constructor
    public Client(String name) {
        this.name = name;
    }
    
    //methods
    public void addAccount(double value){
        Account a = new Account(value);
        accounts.add(a);
    }
    
    public double sumAllAccs(){
        double sum = 0;
        for(Account i : accounts){
            sum += i.getMoney();
        }
        return sum;
    }
    
    public String getName(){
        return "";
    }
}
