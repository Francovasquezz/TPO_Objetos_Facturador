package poo.view.Proveedores;

import poo.controller.ControllerGestion;
import javax.swing.*;
import java.util.Vector;

public class ListaProveedores extends JFrame {
    private JList lista_de_productos;
    private JPanel Panel = new JPanel();

    public ListaProveedores() {
        super("Lista de productos");

        setTitle("Lista de productos");

        System.out.println("Lista de productos del sistema:");
        Vector<String> proveedores = ControllerGestion.getControlador().obtenerProveedores();
        lista_de_productos = proveedores != null ? new JList(proveedores) : new JList();
        setBounds(100, 100, 1000, 400);
        setContentPane(Panel);
        setContentPane(lista_de_productos);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
