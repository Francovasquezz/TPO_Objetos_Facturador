package poo.view.ProductosPorProveedor;


import poo.controller.ControllerGestion;
import poo.dto.ProductoDTO;
import poo.dto.ProductoPorProveedorDTO;
import poo.enums.TipoRubro;
import poo.enums.TipoUnidad;
import poo.model.Producto;
import poo.model.Proveedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProductoPorProveedor extends JFrame {
    private JPanel contentPane;
    private JTextField ultimoPrecio;
    private JTextField idProducto;
    private JTextField idProveedor;

    public CrearProductoPorProveedor() {
        setResizable(false);
        setTitle("Crear producto por proveedor");

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

        JLabel lbUltimoPrecio = new JLabel("Precio del producto:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lbUltimoPrecio, gbc);

        ultimoPrecio = new JTextField();
        ultimoPrecio.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(ultimoPrecio, gbc);

        JLabel lbProducto = new JLabel("ID de Producto:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lbProducto, gbc);

        idProducto = new JTextField();
        idProducto.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(idProducto, gbc);

        JLabel lbProveedor = new JLabel("CUIT de proveedor:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lbProveedor, gbc);

        idProveedor = new JTextField();
        idProveedor.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(idProveedor, gbc);



        JButton btnCrearProducto = new JButton("Crear Producto");

        btnCrearProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ultimoPrecio.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de precio debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (idProducto.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de producto debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                    } else if (idProveedor.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "el campo de proveedor debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);

                    } else {
                        double precio_producto = Integer.parseInt(ultimoPrecio.getText());
                        Long producto = Long.valueOf(String.valueOf(idProducto.getText()));
                        Long proveedor = Long.valueOf(String.valueOf(idProveedor.getText()));


                        ProductoPorProveedorDTO producto_por_provee = new ProductoPorProveedorDTO(precio_producto, producto, proveedor);
                        boolean respuesta = ControllerGestion.getControlador().crearProductoPorProveedor(producto_por_provee);

                        if (respuesta) {
                            JOptionPane.showMessageDialog(null, "El producto por proveedor se ha creado correctamente", "Orden Creado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La orden ya existe en el sistema", "Orden Duplicado", JOptionPane.ERROR_MESSAGE);
                        }
                        ultimoPrecio.setText("");
                        idProducto.setText("");
                        idProveedor.setText("");
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