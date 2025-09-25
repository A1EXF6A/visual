/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class CpTexto extends JTextField{
    public CpTexto(){
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
    }
    
    
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
        char key = evt.getKeyChar();
        if (key < 'A' || key > 'Z') {
            evt.consume(); 
        }
    } 
}
