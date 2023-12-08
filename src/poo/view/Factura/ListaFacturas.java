package poo.view.Factura;

import poo.controller.ControllerGestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ListaFacturas extends JFrame {

    private JList<String> lista_de_facturas;
    private JPanel panel = new JPanel();

    public ListaFacturas() {
        super("Lista de facturas");

        setTitle("Lista de facturas");

        System.out.println("Lista de facturas del sistema:");
        List<String> facturas = ControllerGestion.getControlador().obtenerFacturas();
        lista_de_facturas = facturas != null ? new JList<>(facturas.toArray(new String[0])) : new JList<>();
        JScrollPane scrollPane = new JScrollPane(lista_de_facturas);
        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the window when the close button is clicked
                dispose();
            }
        });

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(scrollPane);
        add(closeButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
