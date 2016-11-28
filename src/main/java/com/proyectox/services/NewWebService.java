/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.services;

import com.proyectox.admintienda.beans.listarCategorias;
import com.proyectox.admintienda.dao.productoDAO;
import com.proyectox.model.Categoria;
import com.proyectox.model.Producto;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.proyectox.services.items.ItemList;
 
@Path("/producto")
public class NewWebService {
 
    //--------------------LISTAR TODOS LOS PRODUCTO----------------------------------------------
        @GET
        @Path("/listar")
        @Produces("application/xml")
        public ItemList listarTodosProductosXML() throws Exception {
            listarCategorias pdao = new listarCategorias();
            ArrayList<Categoria> listaDeProductos = (ArrayList<Categoria>) pdao.getCategorias();
            return new ItemList(listaDeProductos);
             
        }
}