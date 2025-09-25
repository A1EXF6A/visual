package Tarea;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CpTabla extends JTable {

    private DefaultTableModel model;

    public CpTabla() {
        model = new DefaultTableModel();
        model.addColumn("Pares");
        model.addColumn("Impares");
        model.addColumn("Texto");
        this.setModel(model);
        this.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(Color.WHITE);

                if (value != null) {
                    try {
                        int num = Integer.parseInt(value.toString());
                        if (num % 2 == 0 && column == 0) {
                            c.setBackground(Color.GREEN);
                        } else if (num % 2 != 0 && column == 1) {
                            c.setBackground(Color.RED);
                        }
                    } catch (NumberFormatException e) {
                        c.setBackground(Color.WHITE); 
                    }
                }
                return c;
            }
        });
    }

    public void addInformation(String information) {
        model.setValueAt(information, searchRow(information), searchColumn(information));
    }

    public int searchColumn(String information) {   
        try {
            int num = Integer.parseInt(information);
            if (num % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        } catch (NumberFormatException e) {
            return 2;
        }
    }

    public int searchRow(String information) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, searchColumn(information)) == null) {
                return i;
            }
        }
        model.addRow(new Object[]{null, null, null});
        return model.getRowCount() - 1;
    }
}
