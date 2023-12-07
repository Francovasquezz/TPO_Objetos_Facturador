package poo.view.OrdenesDePago;

import poo.controller.ControllerGestion;
import poo.dto.OrdenDePagoDTO;
import poo.enums.FormaPago;

import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class CrearOrden extends JFrame{
    private JPanel contentPane;
    private JTextField IdOrdenDePago;
    private JTextField TotalCancelar;
    private JComboBox<String> formaDePagoComboBox;
    private JTextField FormaDePago;
    private JTextField TotalRetenciones;
    private JTextField Fecha;

    public CrearOrden(){
        setResizable(false);
        setTitle("Crear Orden de Pago");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 442, 327);
        contentPane = new JPanel();
        contentPane.setBackground(UIManager.getColor("null"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane.setBackground(new Color(196, 243, 129));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(new Color(196, 243, 129));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2, 5, 5));
        buttonPanel.setBackground(new Color(196, 243, 129));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lbidOrdenDePago = new JLabel("ID de Orden:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lbidOrdenDePago, gbc);

        IdOrdenDePago = new JTextField();
        IdOrdenDePago.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(IdOrdenDePago, gbc);

        JLabel lbTotalCancelar= new JLabel("Total a Cancelar");
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lbTotalCancelar, gbc);

        TotalCancelar = new JTextField();
        TotalCancelar.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(TotalCancelar, gbc);


        JLabel lbFormaDePago = new JLabel("Forma De Pago:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lbFormaDePago, gbc);

        // Create a JComboBox and add options
        formaDePagoComboBox = new JComboBox<>(new String[]{"Cheque", "Efectivo"});
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(formaDePagoComboBox, gbc);;

        JLabel lbTotalRetenciones= new JLabel("Total de Retenciones:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(lbTotalRetenciones, gbc);

        TotalRetenciones = new JTextField();
        TotalRetenciones.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(TotalRetenciones, gbc);


        JLabel lbFecha= new JLabel("Fecha:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(lbFecha, gbc);

        Fecha = new JTextField();
        Fecha.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(Fecha, gbc);


        JButton btnCrearOrden = new JButton("Crear Orden de Pago");

        btnCrearOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (IdOrdenDePago.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de id debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (TotalCancelar.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de Total a Cancelar debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (formaDePagoComboBox.getSelectedItem() == null) {
                    // Check if no option is selected in the JComboBox
                    JOptionPane.showMessageDialog(null, "Seleccione una forma de pago", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (TotalRetenciones.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de Total Retenciones debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (Fecha.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de Fecha debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        int id_Orden = Integer.parseInt(IdOrdenDePago.getText());
                        int cancelar_orden = Integer.parseInt(TotalCancelar.getText());
                        FormaPago forma_orden = FormaPago.valueOf(formaDePagoComboBox.getSelectedItem().toString().toUpperCase());
                        int retenciones_orden = Integer.parseInt(TotalRetenciones.getText());
                        String fecha_orden = String.valueOf(Fecha.getText());

                        OrdenDePagoDTO nueva_orden = new OrdenDePagoDTO(id_Orden, cancelar_orden, forma_orden, retenciones_orden, fecha_orden);
                        boolean respuesta = ControllerGestion.getControlador().crearOrdenDePago(nueva_orden);

                        if (respuesta) {
                            JOptionPane.showMessageDialog(null, "La orden se ha creado correctamente", "Orden Creado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La orden ya existe en el sistema", "Orden Duplicado", JOptionPane.ERROR_MESSAGE);
                        }
                        IdOrdenDePago.setText("");
                        TotalCancelar.setText("");
                        formaDePagoComboBox.setSelectedIndex(0);
                        TotalRetenciones.setText("");
                        Fecha.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "no ingrese caracteres en los campos de solo numeros", "Error caracter ingresado erroneamente", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;

        btnCrearOrden.setBackground(Color.BLUE);
        btnCrearOrden.setOpaque(true);
        btnCrearOrden.setFont(new Font("Arial", Font.BOLD, 14));
        btnCrearOrden.setForeground(Color.WHITE);
        btnCrearOrden.setPreferredSize(new Dimension(200, 20));

        buttonPanel.add(btnCrearOrden, gbc);

        JButton btnNewButton = new JButton("Volver atrás");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        buttonPanel.add(btnNewButton, gbc);

        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

    }

}
