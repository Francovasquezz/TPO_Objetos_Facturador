package poo.view.OrdenesDePago;

import poo.controller.ControllerGestion;
import javax.swing.*;
import java.util.Vector;

public class ListaOrdenes extends JFrame {
    private JList lista_de_ordenes;
    private JPanel Panel = new JPanel();

    public ListaOrdenes() {
        super("ListaOrdenes");

        setTitle("Lista de Ordenes de Pago");

        System.out.println("Lista de ordenes de pago:");
        Vector<String> ordenes = ControllerGestion.getControlador().obtenerOrdenesDePago();
        lista_de_ordenes = ordenes != null ? new JList(ordenes) : new JList();
        setBounds(100, 100, 1000, 400);
        setContentPane(Panel);
        setContentPane(lista_de_ordenes);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}