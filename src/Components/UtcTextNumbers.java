/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class UtcTextNumbers extends JTextField{

    public UtcTextNumbers() {
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNumberKeyTyped(evt);
            }
        });
        
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNumberFocusLost(evt);
            }
        });
    }
    
   public Integer getTextAsNumber(){
       Integer retorno;
       if(this.getText()==null){
           return 0;
       }else{
           retorno= Integer.valueOf(this.getText());
       }
       return retorno;
       
   } 
   
   public void setTextAsNumber(Integer value){
       this.setText(String.valueOf(value));
   }
   
   private void jtxtNumberKeyTyped(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if(caracter<'0'||caracter>'9'){
            evt.consume();
        }
    }  
   
   private void jtxtNumberFocusLost(java.awt.event.FocusEvent evt) {                                     
        if(this.getText().isEmpty() || this.getText().trim()==""){
            this.setBorder(new LineBorder(Color.RED));
        }else{
            this.setBorder(new LineBorder(new Color(213, 217, 223)));
        }
    }  
}
