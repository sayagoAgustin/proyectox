/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.CategoriaProdDAO;
import com.proyectox.model.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author Notebook Sayago
 */
@Named(value = "listarCategorias")
@ViewScoped
//@SessionScoped
public class listarCategorias{
    
    private List<Categoria> categorias;
    /**
     * Creates a new instance of listarCategorias
     */
    public listarCategorias() {
    }
  

    public List<Categoria> getCategorias() {
        CategoriaProdDAO ctad = new CategoriaProdDAO();
        this.categorias = ctad.buscarTodos();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
