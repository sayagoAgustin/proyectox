/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.productoDAO;
import com.proyectox.admintienda.dao.stockDAO;
import com.proyectox.model.Categoria;
import com.proyectox.model.Producto;
import com.proyectox.model.Stock;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author ignacio
 */
@Named(value = "altaProducto")
//@RequestScoped
@SessionScoped
public class altaProducto implements Serializable{
    private boolean carga;
    private boolean opciones;
    private List<Producto>prodConsultado;

        
    /**
     * Creates a new instance of altaProducto
     */
    public altaProducto() {
        carga=false;
        opciones=false;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
    }
    
     
    public boolean isOpciones() {
        return opciones;
    }

    public void setOpciones(boolean opciones) {
        this.opciones = opciones;
    }

    public List<Producto> getProdConsultado() {
        return prodConsultado;
    }

    public void setProdConsultado(List<Producto> prodConsultado) {
        this.prodConsultado = prodConsultado;
    }

    
    
    public void buscar(Producto consultado){
        productoDAO dao= new productoDAO();
        
        if(consultado.getCodbarprod().equals("") || consultado.getCodbarprod().equals(" ")){
            consultado.setCodbarprod("0");
        }
        prodConsultado=dao.Buscar(consultado);
        
        if (prodConsultado.isEmpty()){
            FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "***"+consultado.getDesprod()+"*** no existe en el Historial", "");
            FacesContext.getCurrentInstance().addMessage(null, msj);
            this.setCarga(true);
            this.setOpciones(false);

        }else{
            this.setCarga(false);
            this.setOpciones(true);
            
        }
    }
    
    public String cargar(Producto carga){
        productoDAO daoP= new productoDAO();
        carga.setCategoria(carga.getCategoria());
        daoP.insertarProducto(carga);
        this.setCarga(false);
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "**" + carga.getDesprod() + "** Se cargo en el Historial", "");
        FacesContext.getCurrentInstance().addMessage(null, msj);
        
        return "altaStock.xhtml";
    }
    

    
}