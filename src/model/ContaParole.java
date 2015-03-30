/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author Migno
 */
public class ContaParole {

    int parole;
    int pd;                    //parole diverse
    
    String[] a;
    HashMap h; 
    
    public ContaParole() {
        parole = 0;
        pd = 0;
        h = new HashMap();
    }
    
    
    public void readFromFile() {
        try {
            FileInputStream f = new FileInputStream("data/miseriaenobilta.txt");
            InputStreamReader in = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(in);
            while (b.ready()) {
                String s = b.readLine();
                a = s.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < a.length; i++) {
                    if (h.containsValue(a[i])) {
                        pd++;
                    }
                    h.put(a[i], a[i]);
                    parole++;
                }
            }
            System.out.println("Numero totale delle parole: " + parole);
            System.out.println("Numero delle parole diverse: " + pd); 
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
