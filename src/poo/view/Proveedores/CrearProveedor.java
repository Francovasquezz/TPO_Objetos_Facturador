package poo.view.Proveedores;

import poo.controller.ControllerGestion;
import poo.dto.ProductoDTO;
import poo.dto.ProveedorDTO;
import poo.enums.TipoResponsabilidad;
import poo.enums.TipoRubro;
import poo.enums.TipoUnidad;
import poo.model.Proveedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CrearProveedor extends JFrame {

    private JPanel contentPane;
    private JTextField cuit;
    private JTextField nombre;
    private JTextField razonSocial;
    private JComboBox<String> tipoResponsabilidad;
    private JTextField direccion;
    private JTextField telefono;
    private JTextField mail;
    private JTextField ingresosBrutos;
    private JTextField fechaInicioActividades;

public CrearProveedor() {
    setResizable(false);
    setTitle("Crear Proveedor");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 800, 800);
    contentPane = new JPanel();
    contentPane.setBackground(UIManager.getColor("null"));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    contentPane.setBackground(new Color(186, 246, 200));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout());
    setLocationRelativeTo(null);

    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridBagLayout());
    formPanel.setBackground(new Color(186, 246, 200));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(0, 2, 5, 5));
    buttonPanel.setBackground(new Color(186, 246, 200));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(5, 5, 5, 5);

    JLabel lbCuit = new JLabel("Cuit:");
    gbc.gridx = 0;
    gbc.gridy = 0;
    formPanel.add(lbCuit, gbc);

    cuit = new JTextField();
    cuit.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 0;
    formPanel.add(cuit, gbc);

    JLabel lbNombre = new JLabel("Nombre:");
    gbc.gridx = 0;
    gbc.gridy = 1;
    formPanel.add(lbNombre, gbc);

    nombre = new JTextField();
    nombre.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 1;
    formPanel.add(nombre, gbc);

    JLabel lbRazonSocial = new JLabel("Razon social:");
    gbc.gridx = 0;
    gbc.gridy = 2;
    formPanel.add(lbRazonSocial, gbc);

    razonSocial = new JTextField();
    razonSocial.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 2;
    formPanel.add(razonSocial, gbc);

    JLabel lbTipoResponsabilidad = new JLabel("Tipo responsabilidad:");
    gbc.gridx = 0;
    gbc.gridy = 3;
    formPanel.add(lbTipoResponsabilidad, gbc);

    tipoResponsabilidad = new JComboBox<>(new String[]{"RESPONSABLE_INSCRIPTO", "MONOTRIBUTO"});
    gbc.gridx = 1;
    gbc.gridy = 3;
    formPanel.add(tipoResponsabilidad, gbc);

    JLabel lbDireccion = new JLabel("Direccion:");
    gbc.gridx = 0;
    gbc.gridy = 4;
    formPanel.add(lbDireccion, gbc);

    direccion = new JTextField();
    direccion.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 4;
    formPanel.add(direccion, gbc);

    JLabel lbTelefono = new JLabel("Telefono:");
    gbc.gridx = 0;
    gbc.gridy = 5;
    formPanel.add(lbTelefono, gbc);

    telefono = new JTextField();
    telefono.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 5;
    formPanel.add(telefono, gbc);

    JLabel lbMail = new JLabel("Mail:");
    gbc.gridx = 0;
    gbc.gridy = 6;
    formPanel.add(lbMail, gbc);

    mail = new JTextField();
    mail.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 6;
    formPanel.add(mail, gbc);

    JLabel lbIngresosBrutos = new JLabel("Ingresos brutos:");
    gbc.gridx = 0;
    gbc.gridy = 7;
    formPanel.add(lbIngresosBrutos, gbc);

    ingresosBrutos = new JTextField();
    ingresosBrutos.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 7;
    formPanel.add(ingresosBrutos, gbc);

    JLabel lbFechaInicioActividades = new JLabel("Fecha inicio actividades:");
    gbc.gridx = 0;
    gbc.gridy = 8;
    formPanel.add(lbFechaInicioActividades, gbc);

    fechaInicioActividades = new JTextField();
    fechaInicioActividades.setColumns(15);
    gbc.gridx = 1;
    gbc.gridy = 8;
    formPanel.add(fechaInicioActividades, gbc);





    JButton btnCrearProveedor = new JButton("Crear Proveedor");

    btnCrearProveedor.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                if (cuit.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo de id debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                } else if (nombre.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo de nombre debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                } else if (razonSocial.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo de rubro debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                } else if (tipoResponsabilidad.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "el campo tipoResponsabilidad debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                }
                else if (direccion.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo direccion debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                }
                else if (telefono.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo telefono debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                }
                else if (mail.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo mail debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                }
                else if (ingresosBrutos.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo ingresos brutos debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                }
                else if (fechaInicioActividades.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "el campo fecha debe estar completo", "Formulario incompleto", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    int cuit_proveedor = Integer.parseInt(cuit.getText());
                    String nombre_Proveedor = String.valueOf(nombre.getText());
                    String razon_proveedor = String.valueOf(razonSocial.getText());
                    TipoResponsabilidad responsabilidad_proveedor = TipoResponsabilidad.valueOf(tipoResponsabilidad.getSelectedItem().toString());
                    String direccion_proveedor = String.valueOf(direccion.getText());
                    String telefono_proveedor = String.valueOf(telefono.getText());
                    String mail_proveedor = String.valueOf(mail.getText());
                    double ingresos_proveedor = Double.parseDouble(ingresosBrutos.getText());
                    String fecha_proveedor = String.valueOf(fechaInicioActividades.getText());

                    ProveedorDTO nuevo_proveedor = new ProveedorDTO(cuit_proveedor, responsabilidad_proveedor, razon_proveedor, nombre_Proveedor, direccion_proveedor, telefono_proveedor, mail_proveedor, ingresos_proveedor, fecha_proveedor);
                    boolean respuesta = ControllerGestion.getControlador().crearProveedor(nuevo_proveedor);

                    if (respuesta) {
                        JOptionPane.showMessageDialog(null, "La orden se ha creado correctamente", "Proveedor Creado", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La orden ya existe en el sistema", "proveedor Duplicado", JOptionPane.ERROR_MESSAGE);
                    }
                    cuit.setText("");
                    nombre.setText("");
                    razonSocial.setText("");
                    tipoResponsabilidad.setSelectedIndex(0);
                    direccion.setText("");
                    telefono.setText("");
                    mail.setText("");
                    ingresosBrutos.setText("");
                    fechaInicioActividades.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "no ingrese caracteres en los campos de solo numeros", "Error caracter ingresado erroneamente", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;

    btnCrearProveedor.setBackground(Color.BLUE);
    btnCrearProveedor.setOpaque(true);
    btnCrearProveedor.setFont(new Font("Arial", Font.BOLD, 14));
    btnCrearProveedor.setForeground(Color.WHITE);
    btnCrearProveedor.setPreferredSize(new Dimension(200, 20));

    buttonPanel.add(btnCrearProveedor, gbc);

    JButton btnNewButton = new JButton("Volver atrás");
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    gbc.gridx = 0;
    gbc.gridy = 9;
    gbc.gridwidth = 1;
    buttonPanel.add(btnNewButton, gbc);

    contentPane.add(formPanel, BorderLayout.CENTER);
    contentPane.add(buttonPanel, BorderLayout.SOUTH);

}
}
