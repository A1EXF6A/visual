/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class CpCombo extends JComboBox {

    private DefaultComboBoxModel<Integer> model;

    public CpCombo() {
        model = new DefaultComboBoxModel();
        this.setModel(model);   
    }

    public boolean addEvenNumbers(Integer number) {
        if (number % 2 == 0) {
            model.addElement(number);
            return true;
        }
        return false;
    }
}
