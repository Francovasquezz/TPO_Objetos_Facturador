package poo.dto;

import poo.enums.TipoResponsabilidad;

import java.time.LocalDate;

public class ProveedorDTO {

    private int cuit;
    private TipoResponsabilidad responsabilidad;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String mail;
    private double ingresosBrutos;
    private String  fechaInicioActividades;


    public ProveedorDTO() {
    }

    public ProveedorDTO(int cuit, TipoResponsabilidad responsabilidad, String razonSocial, String nombre, String direccion, String telefono, String mail, double ingresosBrutos, String fechaInicioActividades) {
        this.cuit = cuit;
        this.responsabilidad = responsabilidad;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.ingresosBrutos = ingresosBrutos;
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public TipoResponsabilidad getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(TipoResponsabilidad responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getIngresosBrutos() {
        return ingresosBrutos;
    }

    public void setIngresosBrutos(double ingresosBrutos) {
        this.ingresosBrutos = ingresosBrutos;
    }

    public String getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(String fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }
}
