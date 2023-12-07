package poo.view.ProductosPorProveedor;

import poo.controller.ControllerGestion;
import javax.swing.*;
import java.util.Vector;

public class ListaProductosPorProveedor extends JFrame {
    private JList lista_de_productos_por_proveedor;
    private JPanel Panel = new JPanel();

    public ListaProductosPorProveedor() {
        super("Lista de productos por proveedor");

        setTitle("Lista de productos por proveedor");

        System.out.println("Lista de productos por proveedor del sistema:");
        Vector<String> productos_por_proveedor = ControllerGestion.getControlador().obtenerProductosProveedor();
        lista_de_productos_por_proveedor = productos_por_proveedor != null ? new JList(productos_por_proveedor) : new JList();
        setBounds(100, 100, 1000, 400);
        setContentPane(Panel);
        setContentPane(lista_de_productos_por_proveedor);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
