package poo.view;

import poo.view.Factura.ListaFacturas;
import poo.view.Factura.ListaFacturasPorDia;
import poo.view.OrdenesDePago.*;
import poo.view.Productos.CrearProducto;
import poo.view.Productos.ListaProductos;
import poo.view.ProductosPorProveedor.CrearProductoPorProveedor;
import poo.view.ProductosPorProveedor.ListaProductosPorProveedor;
import poo.view.ProductosPorProveedor.VistaProductosPorProveedor;
import poo.view.Proveedores.CrearProveedor;
import poo.view.Proveedores.ListaProveedores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import static javax.swing.UIManager.setLookAndFeel;

public class Menu extends JFrame {

    private JPanel contentPane;

    public Menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Sistema de Facturacion");
        setBounds(100, 100, 550, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setBackground(new Color(22, 113, 40));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(new Color(22, 113, 40));
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Crear el menú "ordenes"
        JMenu menuOrdenesDePago = new JMenu("Ordenes de Pago");
        menuOrdenesDePago.setFont(new Font("Calibri", Font.ITALIC, 14));
        menuBar.add(menuOrdenesDePago);

        JMenuItem orden1NewMenuItem = new JMenuItem("Crear orden de pago");
        orden1NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearOrden ventana = new CrearOrden();
                ventana.setVisible(true);
            }
        });
        menuOrdenesDePago.add(orden1NewMenuItem);

        JMenu menuProductos= new JMenu("Productos");
        menuProductos.setFont(new Font("Calibri", Font.ITALIC, 14));
        menuBar.add(menuProductos);

        JMenuItem producto1NewMenuItem = new JMenuItem("Crear producto");
        producto1NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearProducto ventana = new CrearProducto();
                ventana.setVisible(true);
            }
        });
        menuProductos.add(producto1NewMenuItem);

        JMenuItem producto2NewMenuItem = new JMenuItem("Consultar listas de productos");
        producto2NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaProductos ventana = new ListaProductos();
                ventana.setVisible(true);
            }
        });
        menuProductos.add(producto2NewMenuItem);

        JMenuItem producto3NewMenuItem = new JMenuItem("Crear Proveedor");
        producto3NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearProveedor ventana = new CrearProveedor();
                ventana.setVisible(true);
            }
        });
        menuProductos.add(producto3NewMenuItem);

        JMenuItem producto4NewMenuItem = new JMenuItem("Consultar listas de proveedores");
        producto4NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaProveedores ventana = new ListaProveedores();
                ventana.setVisible(true);
            }
        });
        menuProductos.add(producto4NewMenuItem);

        JMenuItem producto5NewMenuItem = new JMenuItem("Crear producto por proveedor");
        producto5NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CrearProductoPorProveedor ventana = new CrearProductoPorProveedor();
                ventana.setVisible(true);
            }
        });
        menuProductos.add(producto5NewMenuItem);

        JMenuItem producto6NewMenuItem = new JMenuItem("Mostrar listas de productos por proveedor");
        producto6NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaProductosPorProveedor ventana = new ListaProductosPorProveedor();
                ventana.setVisible(true);
            }
        });
        menuProductos.add(producto6NewMenuItem);

        JMenu menuFacturas = new JMenu("Facturas");
        menuFacturas.setFont(new Font("Calibri", Font.ITALIC, 14));
        menuBar.add(menuFacturas);

        JMenuItem factura1NewMenuItem = new JMenuItem("Mostrar todas las facturas");
        factura1NewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaFacturas ventana = new ListaFacturas();
                ventana.setVisible(true);
            }
        });
        menuFacturas.add(factura1NewMenuItem);





        JButton botonConsultarOrdenesDePago = new JButton("Consultar Ordenes de Pago");
        botonConsultarOrdenesDePago.setFont(new Font("Calibri", Font.PLAIN, 37));
        botonConsultarOrdenesDePago.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaOrdenes ventana = new ListaOrdenes();
                ventana.setVisible(true);
            }
        });
        Dimension botonSize = new Dimension(Integer.MAX_VALUE, 80);

        botonConsultarOrdenesDePago.setBounds(50, 50, 450, 450);
        panelBotones.add(botonConsultarOrdenesDePago);

        contentPane.add(panelBotones, BorderLayout.CENTER);

        JButton botonConsultarProductosPorProveedor = new JButton("Consultar productos por proveedor");
        botonConsultarProductosPorProveedor.setFont(new Font("Calibri", Font.PLAIN, 30));
        botonConsultarProductosPorProveedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaProductosPorProveedor ventana = new VistaProductosPorProveedor();
                ventana.setVisible(true);
            }
        });
        botonConsultarProductosPorProveedor.setBounds(50, 50, 450, 450);
        panelBotones.add(botonConsultarProductosPorProveedor);

        contentPane.add(panelBotones, BorderLayout.CENTER);


        JButton botonConsultarFacturasPorFechaProveedor = new JButton("Consultar facturas por fecha y/o proveedor");
        botonConsultarFacturasPorFechaProveedor.setFont(new Font("Calibri", Font.PLAIN, 30));
        botonConsultarFacturasPorFechaProveedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListaFacturasPorDia ventana = new ListaFacturasPorDia();
                ventana.setVisible(true);
            }
        });
        botonConsultarFacturasPorFechaProveedor.setBounds(50, 50, 450, 450);
        panelBotones.add(botonConsultarFacturasPorFechaProveedor);

        contentPane.add(panelBotones, BorderLayout.CENTER);

        botonConsultarOrdenesDePago.setMaximumSize(botonSize);
        botonConsultarProductosPorProveedor.setMaximumSize(botonSize);
        botonConsultarFacturasPorFechaProveedor.setMaximumSize(botonSize);


        int espacioVertical = 20;
        panelBotones.add(botonConsultarOrdenesDePago);
        panelBotones.add(Box.createRigidArea(new Dimension(0, espacioVertical)));
        panelBotones.add(botonConsultarProductosPorProveedor);
        panelBotones.add(Box.createRigidArea(new Dimension(0, espacioVertical)));
        panelBotones.add(botonConsultarFacturasPorFechaProveedor);
        panelBotones.add(Box.createRigidArea(new Dimension(0, espacioVertical)));


        JButton botonSalida = new JButton("Salir del sistema");
        botonSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        contentPane.add(botonSalida, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        Menu frame = new Menu();
        frame.setVisible(true);
    }
}