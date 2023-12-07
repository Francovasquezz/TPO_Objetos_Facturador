package poo.view.Factura;

import poo.model.Factura;
import poo.controller.ControllerGestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class ListaFacturasPorDia extends JFrame {

    private JTextField dateField;
    private JTextField proveedorField;
    private JTextArea resultArea;

    public ListaFacturasPorDia() {
        setTitle("Buscar Facturas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel dateLabel = new JLabel("Enter Date (yyyy-MM-dd):");
        dateField = new JTextField();
        dateField.setToolTipText("Enter date in yyyy-MM-dd format");

        JLabel proveedorLabel = new JLabel("Ingrese el cuit del proveedor:");
        proveedorField = new JTextField();

        JButton searchButton = new JButton("Buscar");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFacturas();
            }
        });

        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(proveedorLabel);
        panel.add(proveedorField);
        panel.add(searchButton);
        panel.add(resultArea);

        add(panel);
    }

    private void searchFacturas() {
        try {
            String dateString = dateField.getText().trim();
            int cuitProveedor = 0;

            if (!dateString.isEmpty()) {
                LocalDate fecha = LocalDate.parse(dateString);
                if (!proveedorField.getText().trim().isEmpty()) {
                    cuitProveedor = Integer.parseInt(proveedorField.getText().trim());
                }
            } else if (!proveedorField.getText().trim().isEmpty()) {
                cuitProveedor = Integer.parseInt(proveedorField.getText().trim());
            } else {
                // Both fields are empty, show an error or handle it according to your requirement
                JOptionPane.showMessageDialog(this, "Enter at least one input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Factura> matchingFacturas = ControllerGestion.getControlador().obtenerFacturasPorFechaOProveedor(
                    !dateString.isEmpty() ? LocalDate.parse(dateString) : null,
                    cuitProveedor
            );

            displayFacturas(matchingFacturas);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void displayFacturas(List<Factura> facturas) {
        StringBuilder resultText = new StringBuilder();
        for (Factura factura : facturas) {
            resultText.append("Factura ID: ").append(factura.getId())
                    .append(", Fecha: ").append(factura.getFecha())
                    .append(", CuitProveedor: ").append(factura.getCuitProveedor())
                    .append(", Productos: ").append(String.join(", ", factura.getDetallesFacturaNames()))
                    .append(", Total: ").append(factura.getMonto())
                    .append("\n");
        }

        resultArea.setText(resultText.toString());
    }
}


