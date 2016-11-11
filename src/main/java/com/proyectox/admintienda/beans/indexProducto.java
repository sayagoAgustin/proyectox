/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.model.Categoria;
import com.proyectox.model.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author ignacio
 */
@Named(value = "indexProducto")
@SessionScoped
public class indexProducto implements Serializable {
    private Producto producto;
    private List<SelectItem> lisCategorias;
    private Categoria categoria;
    

    
    /**
     * Creates a new instance of indexProducto
     */
    public indexProducto() {
        this.producto=new Producto();
        categoria= new Categoria();

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        
    }

        public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

        public List<SelectItem> getLisCategorias() {
        altaCategoriaProd dao = new altaCategoriaProd();
        this.lisCategorias = new ArrayList<>();
        List<Categoria> c = dao.listaCategorias();
        lisCategorias.clear();
        
        for (Categoria categorias : c) {
            SelectItem cateItem = new SelectItem(categorias.getIdcat(), categorias.getDescat());
            this.lisCategorias.add(cateItem);
        }
        
        return lisCategorias;
    }
      
    public void setLisCategorias(List<SelectItem> listaCategorias) {
        this.lisCategorias = listaCategorias;
    }

    public void completar (){
        //como en el select menu solo tengo el id de la categoria, 
        //se la busca para recuperar la entidad completa y seteo 
        //en el producto
        altaCategoriaProd daoC= new altaCategoriaProd();
        Categoria c= daoC.buscarCategoria(this.categoria.getIdcat());
        this.producto.setCategoria(c);
    }

    



    
}
