/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author caiof
 */
public class ConectaDriver_DB {
    public static  void carregaDriver(){
       try { // Conecttando o driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Banco de dados carregado com sucesso!");




       } catch (Exception ex) { // Erro driver não encontrado
            JOptionPane.showMessageDialog(null,"ERRO S001 Não possui banco de dados");
        }

    }
    
}
