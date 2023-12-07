package poo.controller;
import poo.enums.*;
import poo.model.*;
import poo.dto.*;


import java.time.LocalDate;
import java.util.*;

public class ControllerGestion {

    private static List<Factura> facturas;
    private static List<DetalleFactura> detallesFactura;
    private static List<NotaDeCredito> notasDeCredito;
    private static List<NotaDeDebito> notasDeDebito;
    private static List<ChequePropio> chequesPropio;
    private static List<ChequeTerceros> chequesTerceros;
    private static List<OrdenDeCompra> ordenesDeCompra;
    private static List<OrdenDePago> ordenesDePago;

    private static List<Proveedor> proveedores;
    private static List<Producto> productos;
    private static List<ProductoPorProveedor> productosPorProveedor;
    private static ControllerGestion INSTANCE;


    private ControllerGestion(){
        iniciarOrdenesDePago();
        iniciarProductos();
        iniciarProveedores();
        iniciarProductosPorProveedor();
    }

    public static synchronized ControllerGestion getControlador(){
        if(INSTANCE == null) {
            INSTANCE = new ControllerGestion();
        }
        return INSTANCE;
    }


/*
    public double facturasPorDiaProveedor(int idProvedor, Date fecha) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        double montoTotal = 0;
        for (Factura factura: facturas) {
            if (factura.getCuit() == idProvedor || factura.getFecha() == fecha) {
                montoTotal += factura.getMonto();
            }
        }
        return montoTotal;
    };



    NOTA: NO SE SI ESTA BIEN public CuentaCorrienteDTO obtenerCuentaCorrienteProveedores(int idProvedor) throws Exception{
        Proveedor proveedor = proveedorDAO.search(idProvedor, Proveedor.class);
        int cuitProveedor= proveedor.getCuit();
        List<NotaDeCredito> notasDeCredito = notaDeCreditoDAO.getAll(NotaDeCredito.class).stream().filter(notaDeCredito -> notaDeCredito.getCuitProveedor() == cuitProveedor).toList();
        List<NotaDeDebito> notasDeDebito = notaDeDebitoDAO.getAll(NotaDeDebito.class).stream().filter(notaDeDebito -> notaDeDebito.getCuitProveedor() == cuitProveedor).toList();
        List<Factura> facturas = facturaDAO.getAll(Factura.class).stream().filter(factura -> factura.getCuitProveedor().equals(cuitProveedor)).toList();
        Double montoCredito = notasDeCredito.stream().mapToDouble(NotaDeCredito::getMonto).sum();
        Double montoDebito = notasDeDebito.stream().mapToDouble(NotaDeDebito::getMonto).sum();

        return  new CuentaCorrienteDTO(proveedor.getNombre(), montoCredito-montoDebito, facturas, notasDeCredito, notasDeDebito);
    };

    public void facturasPorDiaProveedor(int idProvedor){

    };

    public void consultarPrecioPorRubro(){};

    public void totalDeudaPorProveedor(){};

    public double obtenerDeudaPorProveedor(int cuit) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        List<NotaDeCredito> notasDeCredito = this.notaDeCreditoDAO.getAll(NotaDeCredito.class);
        List<NotaDeDebito> notasDeDebito = this.notaDeDebitoDAO.getAll(NotaDeDebito.class);
        List<ChequePropio> chequesPropio = this.chequePropioDAO.getAll(ChequePropio.class);
        List<ChequeTerceros> chequesTerceros = this.chequeTerceroDAO.getAll(ChequeTerceros.class);

        return proveedorDAO.search(cuit).getDocumentosDeudaProveedor(facturas, notasDeCredito, notasDeDebito, chequesPropio, chequesTerceros);
    };

    public double obtenerImpuestosRetenidos(int cuit) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        double impuestosRetenidos = 0;
        for (Factura factura: facturas) {
            if (factura.getCuit() != cuit) continue;

            Collection<Impuesto> impuestos = factura.getImpuestos();
            for (Impuesto impuesto: impuestos) {
                impuestosRetenidos += factura.getMonto() * impuesto.getPercentage();
            }
        }
        return impuestosRetenidos;
    };

    public void consultaLibroIva(){};
 */



    /*Consultar Precio producto por proveedor*/

    private static void iniciarProductos(){
        productos = new ArrayList<>();
        productos.add(new Producto(1, "Coca Cola", TipoRubro.PRODUCTOS_REVENTA, TipoUnidad.UNIDAD, 0.21));
        productos.add(new Producto(2, "Pepsi", TipoRubro.PRODUCTOS_REVENTA, TipoUnidad.UNIDAD, 0.21));
        productos.add(new Producto(3, "Ibuprofeno", TipoRubro.MEDICINA_PREPAGA, TipoUnidad.UNIDAD, 0.05));
        productos.add(new Producto(4, "Tafirol", TipoRubro.MEDICINA_PREPAGA, TipoUnidad.UNIDAD, 0.05));
    }

    private static void iniciarProveedores(){
        proveedores = new ArrayList<>();
        proveedores.add(new Proveedor(21430007, TipoResponsabilidad.RESPONSABLE_INSCRIPTO, "COTO SRL", "Coto", "Callefalsa123", "250005555", "coto@mail.com", 15600.98, "2017/01/01"));
        proveedores.add(new Proveedor(21430008, TipoResponsabilidad.RESPONSABLE_INSCRIPTO, "JUMBO SRL", "Jumbo", "Callefalsa23", "250006666", "jumbo@mail.com", 158900.78, "2018/01/01"));
        proveedores.add(new Proveedor(21430009, TipoResponsabilidad.MONOTRIBUTO, "Farmacia SOL", "Farmacia SOL", "Callefalsa456", "250007777", "sol@mail.com", 8900.78, "2019/01/01"));
        proveedores.add(new Proveedor(21430010, TipoResponsabilidad.RESPONSABLE_INSCRIPTO, "Farmacity S.A", "Farmacity", "Callefalsa789", "250008888","fcity@mail.com", 15000.78, "2015/11/01"));
    }

    private static void iniciarProductosPorProveedor(){
        productosPorProveedor = new ArrayList<>();
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(0), 100, productos.get(0)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(0), 20000, productos.get(1)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(1), 300, productos.get(0)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(1), 40000, productos.get(1)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(2), 500, productos.get(2)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(2), 60000, productos.get(3)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(3), 700, productos.get(2)));
        productosPorProveedor.add(new ProductoPorProveedor(proveedores.get(3), 80000, productos.get(3)));
    }


    /*PRODUCTOS POR PROVEEDORES*/
    public static Vector<String> obtenerProductosProveedor(){
        Vector<String> listaProductosProveedor = new Vector<>();
        if (productosPorProveedor != null) {
            listaProductosProveedor.add("Cuit                                                       Nombre Proveedor                                                          Nombre Producto                                Precio Producto");
            for(int i = 0; i < productosPorProveedor.size(); i++) {
                listaProductosProveedor.add(productosPorProveedor.get(i).getProveedor().getCuit() + "                                                    " + productosPorProveedor.get(i).getProveedor().getNombre() +  "                                                                 " + productosPorProveedor.get(i).getProducto().getNombreProducto() + "                                                             " + productosPorProveedor.get(i).getUltimoPrecio());
            }
        }
        return listaProductosProveedor;
    }


    public boolean crearProductoPorProveedor(ProductoPorProveedorDTO dto) {
        // Obtener instancias de Producto y Proveedor a partir de los IDs
        Producto producto = productos.stream()
                .filter(p -> p.getIdProducto() == dto.getIdProducto())
                .findFirst()
                .orElse(null);

        Proveedor proveedor = proveedores.stream()
                .filter(p -> p.getCuit() == dto.getIdProveedor())
                .findFirst()
                .orElse(null);

        // Verificar si se encontraron instancias válidas
        if (producto != null && proveedor != null) {
            // Crear ProductoPorProveedor y agregarlo a la lista
            ProductoPorProveedor productoPorProveedorAux = new ProductoPorProveedor(proveedor, dto.getUltimoPrecio(), producto);

            // Verificar si ya existe una relación para el mismo proveedor y producto
            if (!productosPorProveedor.contains(productoPorProveedorAux)) {
                productosPorProveedor.add(productoPorProveedorAux);
                return true;  // ProductoPorProveedor creado exitosamente
            } else {
                return false;  // Ya existe una relación para el mismo proveedor y producto
            }
        } else {
            return false;  // No se encontraron instancias válidas de Producto y/o Proveedor
        }
    }

    public List<ProductoPorProveedor> obtenerProductosPorProveedorYProducto(int idProducto) {
        List<ProductoPorProveedor> productosFiltrados = new ArrayList<>();

        for (ProductoPorProveedor productoPorProveedor : productosPorProveedor) {
            if (productoPorProveedor.getProducto().getIdProducto() == idProducto)
            {
                productosFiltrados.add(productoPorProveedor);
            }
        }

        return productosFiltrados;
    }


    /*PROVEEDORES*/
    public static Proveedor toModelProveedor(ProveedorDTO dto) {
        Proveedor proveedor = new Proveedor(dto.getCuit(), dto.getResponsabilidad(), dto.getRazonSocial(), dto.getNombre(), dto.getDireccion(), dto.getTelefono(), dto.getMail(), dto.getIngresosBrutos(), dto.getFechaInicioActividades());
        return proveedor;
    }
    public boolean crearProveedor(ProveedorDTO dto) {
        Proveedor proveedorAux = toModelProveedor(dto);
        boolean existe = false;
        for(int i = 0; i < proveedores.size(); i++) {
            if(proveedorAux.getCuit() == proveedores.get(i).getCuit()) {
                existe = true;
            }
        }
        if(!existe) {
            proveedores.add(proveedorAux);
        } else {
            return false;
        }
        return true;
    }

    public static Vector<String> obtenerProveedores() {
        Vector<String> listaProveedores = new Vector<>();
        if (proveedores != null) {
            listaProveedores.add("Cuit                                      Nombre                                      Razon social                                      Tipo Responsabilidad");
            for(int i = 0; i < proveedores.size(); i++) {
                listaProveedores.add(proveedores.get(i).getCuit() + "                           " + proveedores.get(i).getNombre() + "                                      " + proveedores.get(i).getRazonSocial() + "                                      " + proveedores.get(i).getResponsabilidad() );
            }
        }
        return listaProveedores;
    }


    /*-PROVEEDORES*/

    /*PRODUCTOS*/
    public static Producto toModelProducto(ProductoDTO dto) {
        Producto producto = new Producto(dto.getIdProducto(), dto.getNombreProducto(), dto.getRubro(), dto.getTipoUnidad(), dto.getTipoIva());
        return producto;
    }

    public boolean crearProducto(ProductoDTO dto) {
        Producto productoAux = toModelProducto(dto);
        boolean existe = false;
        for(int i = 0; i < productos.size(); i++) {
            if(productoAux.getIdProducto() == productos.get(i).getIdProducto()) {
                existe = true;
            }
        }
        if(!existe) {
            productos.add(productoAux);
        } else {
            return false;
        }
        return true;
    }

    public static Vector<String> obtenerProductos() {
        Vector<String> listaProductos = new Vector<>();
        if (productos != null) {
            listaProductos.add("id              Nombre                                      Rubro                                        Tipo Unidad                                       Tipo IVA");
            for(int i = 0; i < productos.size(); i++) {
                listaProductos.add(productos.get(i).getIdProducto() + "              " + productos.get(i).getNombreProducto() + "                         " + productos.get(i).getRubro() + "                        " + productos.get(i).getTipoUnidad() + "                                      " + productos.get(i).getTipoIva());
            }
        }
        return listaProductos;
    }
    /*-PRODUCTO*/

    /*ORDENES DE PAGO*/
    private static void iniciarOrdenesDePago(){
        ordenesDePago = new ArrayList<>();
        ordenesDePago.add(new OrdenDePago(1, 1000, FormaPago.EFECTIVO, 150, "11/11/2002"));
        ordenesDePago.add(new OrdenDePago(2, 2000, FormaPago.EFECTIVO, 440, "11/11/2001"));
    }
    public static Vector<String> obtenerOrdenesDePago() {
        Vector<String> listaOrdenesDePago = new Vector<>();
        if (ordenesDePago != null) {
            listaOrdenesDePago.add("idOrdenDePago              Total a Cancelar             Forma de Pago              Total Retenciones                                 Fecha");
            for(int i = 0; i < ordenesDePago.size(); i++) {
                listaOrdenesDePago.add(ordenesDePago.get(i).getIdOrdenDePago() + "                                            " + ordenesDePago.get(i).getTotalCancelar() + "                                        " + ordenesDePago.get(i).getFormaPago() + "                                      " + ordenesDePago.get(i).getTotalRetenciones() + "                                      " + ordenesDePago.get(i).getFecha());
            }
        }
        return listaOrdenesDePago;
    }
    public static OrdenDePago toModelOrdenDePago(OrdenDePagoDTO dto) {
        OrdenDePago ordenDePago = new OrdenDePago(dto.getIdOrdenDePago(), dto.getTotalCancelar(), dto.getFormaPago(), dto.getTotalRetenciones(), dto.getFecha());
        return ordenDePago;
    }
    public boolean crearOrdenDePago(OrdenDePagoDTO dto) {
        OrdenDePago ordenDePagoAux = toModelOrdenDePago(dto);
        boolean existe = false;
        for(int i = 0; i < ordenesDePago.size(); i++) {
            if(ordenDePagoAux.getIdOrdenDePago() == ordenesDePago.get(i).getIdOrdenDePago()) {
                existe = true;
            }
        }
        if(!existe) {
            ordenesDePago.add(ordenDePagoAux);
        } else {
            return false;
        }
        return true;
    }
    /*-ORDEN DE PAGO*/
}
