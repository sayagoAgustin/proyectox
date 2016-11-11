/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.stockDAO;
import com.proyectox.model.Producto;
import com.proyectox.model.Stock;
import com.proyectox.model.Tienda;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ignacio
 */
@Named(value = "altaStock")
//@RequestScoped
@SessionScoped
public class altaStock implements Serializable {
    private Stock st;
    private int porcentaje;
    private Producto prodSelect=new Producto();
    private Stock sotckProdSelect= new Stock();
    stockDAO daoSt= new stockDAO();

    /**
     * Creates a new instance of altaStock
     */
    public altaStock() {
        st=new Stock();
        porcentaje=0;
        prodSelect=null;
        sotckProdSelect=null;
    }

    public Stock getSt() {
        return st;
    }

    public void setSt(Stock st) {
        this.st = st;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
    
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Stock getSotckProdSelect() {
        return sotckProdSelect;
    }
    
    public void setSotckProdSelect(Stock sotckProdSelect) {
        this.sotckProdSelect = sotckProdSelect;
    }
    
    public Producto getProdSelect() {
        return prodSelect;
    }



    public void setProdSelect(Producto prodSelect) {
        this.prodSelect = prodSelect;
        //en base al producto seleccionado busca en el stock para mostar los datos en detalle 
        
        this.setSotckProdSelect(daoSt.Buscar(this.prodSelect));
    }


    
    

    

    
    
    
    public String altaStock(Producto prod){
       
        //recupero el id tineda de la session
//        FacesContext contect= FacesContext.getCurrentInstance();
//        altaTienda t= contect.getApplication().evaluateExpressionGet(contect,"#{altaTienda}", altaTienda.class);
//        st.setTienda(t);
        
        //id producto
        st.setProducto(prod);
        
        //calculo del descuento
        float descuento= (st.getPreventast()* this.porcentaje)/100;
        st.setDescuetost(descuento);
        
        //Seteo del estado
        st.setEstadost(1);
        
        daoSt.insertarStock(this.st);
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "***"+prod.getDesprod()+"*** se cargo el Stock", "");
        FacesContext.getCurrentInstance().addMessage(null, msj);
        return "indexProducto.xhtml";
    }
   
     public String modificarStok(){
        
        //recupero el id tineda de la session
//        FacesContext contect= FacesContext.getCurrentInstance();
//        altaTienda t= contect.getApplication().evaluateExpressionGet(contect,"#{altaTienda}", altaTienda.class);
//        st.setTienda(t);
        
        //calculo del descuento
        float descuento= (sotckProdSelect.getPreventast()* this.porcentaje)/100;
        sotckProdSelect.setDescuetost(descuento);
        
        //Seteo del estado
        sotckProdSelect.setEstadost(1);
      
        daoSt.modStock(this.sotckProdSelect);
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se modifico el Stock de "+this.prodSelect.getDesprod()+"", "");
        FacesContext.getCurrentInstance().addMessage(null, msj);
        return "indexProducto.xhtml";
    }
     
     
    
 
     
    
    public String eliminar(){
        stockDAO dao= new stockDAO();
        this.sotckProdSelect.setEstadost(0);
        dao.modStock(this.sotckProdSelect);
        FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se elimino el producto del Stock", "");
        FacesContext.getCurrentInstance().addMessage(null, msj);
        return "indexProducto.xhtml";
    }


    
    
    
}
