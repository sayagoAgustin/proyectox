/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.altaCategoriaProdDAO;
import com.proyectox.model.Categoria;
import com.proyectox.utils.HibernateUtil;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.hibernate.Session;

/**
 *
 * @author Agustin
 */
@Named(value = "altaCategoriaProd")
@RequestScoped
public class altaCategoriaProd {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Categoria cateProd;
    
    public altaCategoriaProd() {
        cateProd = new Categoria();
    }

    public Categoria getCateProd() {
        return cateProd;
    }

    public void setCateProd(Categoria cateProd) {
        this.cateProd = cateProd;
    }
    
    public String insertarCateProd() {
        altaCategoriaProdDAO a = new altaCategoriaProdDAO();
        a.insertar(cateProd);
        return "index";
    }
    
    public List<Categoria> listaCategorias() {
        
        List<Categoria> listarCatetegorias = null;
        String Hql = "FROM Categoria";
        try {
            listarCatetegorias = session.createQuery(Hql).list();
        } catch (Exception e) {
            System.out.println("Error en listado de categorias " + e.getMessage());
        }finally{
            return listarCatetegorias;
        }
        
    }
    
    public Categoria buscarCategoria(Integer idCat){
        String Hql = "FROM Categoria WHERE idcat='"+idCat+"'";
        Categoria c=null;
        try {
            c = (Categoria) session.createQuery(Hql).list().get(0);
        } catch (Exception e) {
            System.out.println("Error en listado de categorias " + e.getMessage());
        }finally{
            return c;
        }
        
    }
    
}
