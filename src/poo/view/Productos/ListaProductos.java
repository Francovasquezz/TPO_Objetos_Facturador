package poo.view.Productos;

import poo.controller.ControllerGestion;
import javax.swing.*;
import java.util.Vector;

public class ListaProductos extends JFrame {
    private JList lista_de_productos;
    private JPanel Panel = new JPanel();

    public ListaProductos() {
        super("Lista de productos");

        setTitle("Lista de productos");

        System.out.println("Lista de productos del sistema:");
        Vector<String> productos = ControllerGestion.getControlador().obtenerProductos();
        lista_de_productos = productos != null ? new JList(productos) : new JList();
        setBounds(100, 100, 1000, 400);
        setContentPane(Panel);
        setContentPane(lista_de_productos);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
