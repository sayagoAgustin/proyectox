/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.services.items;

import com.proyectox.model.Categoria;
import com.proyectox.model.Producto;
import java.util.List;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="ListaProductos")
public class ItemList {
     
    private List<Categoria> items;
      
    public ItemList(){
    }
  
    public ItemList(List<Categoria> items){
        this.items = items;
    }
  
    @XmlElement(name="producto")
    public List<Categoria> getItems(){
        return items;
    }
}