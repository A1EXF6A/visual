/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CpFormattedField extends JFormattedTextField{
    public CpFormattedField(){
    this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyTyped(evt);
            }
        });
} 
    private void jFormattedTextField1KeyTyped(java.awt.event.KeyEvent evt) {                                              
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
            return;
        }
        String texto = this.getText();
        if (c == '.' && texto.contains(".")) {
            evt.consume();
            return;
        }
        if (texto.contains(".")) {
            int posPunto = texto.indexOf('.');
            int decimales = texto.length() - posPunto - 1;
            if (posPunto < this.getCaretPosition() && decimales >= 2) {
                evt.consume();
            }
        }
    } 
}
