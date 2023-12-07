package poo.view.Productos;
import poo.controller.ControllerGestion;
import poo.dto.OrdenDePagoDTO;
import poo.dto.ProductoDTO;
import poo.dto.ProductoPorProveedorDTO;
import poo.enums.FormaPago;
import poo.enums.TipoRubro;
import poo.enums.TipoUnidad;

import javax.swing.JComboBox;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class CrearProducto extends JFrame {
    private JPanel contentPane;
    private JTextField idProducto;
    private JTextField nombreProducto;
    private JComboBox<String> rubro;
    private JComboBox<String> tipoUnidad;
    private JTextField tipoIva;

    public CrearProducto() {
        setResizable(false);
        setTitle("Crear producto");

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

        JLabel lbIdProducto = new JLabel("Id del Producto:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lbIdProducto, gbc);

        idProducto = new JTextField();
        idProducto.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(idProducto, gbc);

        JLabel lbNombreProducto = new JLabel("Nombre de producto:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lbNombreProducto, gbc);

        nombreProducto = new JTextField();
        nombreProducto.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(nombreProducto, gbc);


        JLabel lbRubro = new JLabel("Rubro:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lbRubro, gbc);

        // Create a JComboBox and add options
        rubro = new JComboBox<>(new String[]{"MEDICINA_PREPAGA", "VIATICOS_MOVILIDAD", "MANTENIMINETO_MUEBLES", "LIBRERIA", "PAPELERIA_IMPRESIONES", "PRODUCTOS_REVENTA"});
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(rubro, gbc);


        JLabel lbTipoUnidad = new JLabel("Tipo unidad:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(lbTipoUnidad, gbc);

        // Create a JComboBox and add options
        tipoUnidad = new JComboBox<>(new String[]{"UNIDAD", "PESO", "HORA"});
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(tipoUnidad, gbc);
        ;

        JLabel lbTipoIva = new JLabel("Tipo IVA:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(lbTipoIva, gbc);

        tipoIva = new JTextField();
        tipoIva.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(tipoIva, gbc);


        JButton btnCrearProducto = new JButton("Crear Producto");

        btnCrearProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (idProducto.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de id debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (nombreProducto.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de nombre debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (rubro.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "el campo de rubro debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (tipoUnidad.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null, "el campo tipo unidad debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);

                    } else if (tipoIva.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de IVA debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int id_Producto = Integer.parseInt(idProducto.getText());
                        String nombre_Producto = String.valueOf(nombreProducto.getText());
                        TipoRubro tipo_rubro = TipoRubro.valueOf(rubro.getSelectedItem().toString());
                        TipoUnidad tipo_Unidad = TipoUnidad.valueOf(tipoUnidad.getSelectedItem().toString());
                        double tipo_Iva = Double.parseDouble(tipoIva.getText());

                        ProductoDTO nuevo_producto = new ProductoDTO(id_Producto, nombre_Producto, tipo_rubro, tipo_Unidad, tipo_Iva);
                        boolean respuesta = ControllerGestion.getControlador().crearProducto(nuevo_producto);

                        if (respuesta) {
                            JOptionPane.showMessageDialog(null, "La orden se ha creado correctamente", "Orden Creado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La orden ya existe en el sistema", "Orden Duplicado", JOptionPane.ERROR_MESSAGE);
                        }
                        idProducto.setText("");
                        nombreProducto.setText("");
                        rubro.setSelectedIndex(0);
                        tipoUnidad.setSelectedIndex(0);
                        tipoIva.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "no ingrese caracteres en los campos de solo numeros", "Error caracter ingresado erroneamente", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;

        btnCrearProducto.setBackground(Color.BLUE);
        btnCrearProducto.setOpaque(true);
        btnCrearProducto.setFont(new Font("Arial", Font.BOLD, 14));
        btnCrearProducto.setForeground(Color.WHITE);
        btnCrearProducto.setPreferredSize(new Dimension(200, 20));

        buttonPanel.add(btnCrearProducto, gbc);

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
