/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.stockDAO;
import com.proyectox.model.Producto;
import com.proyectox.model.Stock;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author ignacio
 */
@Named(value = "bean")
@RequestScoped
public class Bean {
    private Producto prodSelect;
    private Stock s;
    /**
     * Creates a new instance of Bean
     */
    public Bean() {
        prodSelect=new Producto();
        s=null;
    }

    public Producto getProdSelect() {
        return prodSelect;
    }

    public void setProdSelect(Producto prodSelect) {
        this.prodSelect = prodSelect;
        stockDAO daoSt= new stockDAO();
        this.setS(daoSt.Buscar(prodSelect));
    }

    public Stock getS() {
        return s;
    }

    public void setS(Stock s) {
        this.s = s;
    }
    
}
