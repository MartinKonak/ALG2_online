/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konak_bank;

/**
 *
 * @author Martin Koňák
 */

//Person is a Client
public class Person extends Client{
    private String name;

    public Person(String name) {
        super(name);
        this.name = name;
    }
    
    @Override
    public String getName(){
        if (name.contains("ova")) {
            return ("pani " + name);
        }else{
            return ("pan " + name);
        }
    }
    
    
}
