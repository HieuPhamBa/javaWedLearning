/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabuoi14;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamBaHieu
 */
public class SqlManager {
    public SqlManager(){
        DBConnector dbc = new DBConnector();
        try {
            dbc.connect();
        } catch (Exception ex) {
        
        }
    }
    public void Manager(){
        
    }
}
