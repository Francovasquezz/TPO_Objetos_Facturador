package poo.view.Proveedores;

import poo.controller.ControllerGestion;
import poo.model.Factura;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class ListaDeudaProveedor extends JFrame {
    private JTextField proveedorField;
    private JTextArea resultArea;

    public ListaDeudaProveedor() {
        setTitle("Obtener Deuda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel proveedorLabel = new JLabel("Ingrese el cuit del proveedor:");
        proveedorField = new JTextField();

        JButton searchButton = new JButton("Obtener deuda");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerDeuda();
            }
        });

        panel.add(proveedorLabel);
        panel.add(proveedorField);
        panel.add(searchButton);
        panel.add(resultArea);

        add(panel);
    }

    private void obtenerDeuda() {
        try {
            if (proveedorField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "You must enter the cuit", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int cuitProveedor = Integer.parseInt(proveedorField.getText().trim());

            double deuda = ControllerGestion.getControlador().totalDeudaPorProveedor(cuitProveedor);

            displayDeuda(cuitProveedor, deuda);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void displayDeuda(int cuit, double deuda) {
        StringBuilder resultText = new StringBuilder();
            resultText.append("Cuit proveedor: ").append(cuit)
                    .append(", Deuda: ").append(String.valueOf(deuda))
                    .append("\n");

        resultArea.setText(resultText.toString());
    }
}


