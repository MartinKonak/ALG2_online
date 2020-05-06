/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

/**
 *
 * @author Martin Koňák
 */
public class Parser{
    
    public static Command parse(String line){
        String[] p = line.split(" +"); //p[0] dir; p[1] -e; p[2] .java
        //TODO prázdný příkaz
        if (p == null) {
            return null;
        }
        char first = 0;
        
        try{
            first = Character.toUpperCase(p[0].charAt(0));
        }catch(Exception f){
            throw new RuntimeException("");
        }
        
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1);
        try{
        Class c = Class.forName(name);
            Command command = (Command)c.newInstance();
            command.setParams(p);
            return command;
        } catch(Exception e){
            throw new RuntimeException("Parse failed\n");
        }  

    }
}
