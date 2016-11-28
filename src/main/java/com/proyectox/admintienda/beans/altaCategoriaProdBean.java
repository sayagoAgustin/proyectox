/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.CategoriaProdDAO;
import com.proyectox.model.Categoria;
import java.io.Serializable;
//import com.proyectox.utils.HibernateUtil;
import java.util.List;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Agustin
 */
@Named(value = "categoriaProd")
@SessionScoped
public class altaCategoriaProdBean implements Serializable{
//    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Categoria cateProd;
    
    public altaCategoriaProdBean() {
        cateProd = new Categoria();
    }

    public Categoria getCateProd() {
        return cateProd;
    }

    public void setCateProd(Categoria cateProd) {
        this.cateProd = cateProd;
    }
    
    public String insertarCateProd() {
        CategoriaProdDAO a = new CategoriaProdDAO();
        a.insertar(cateProd);
        return "index";
    }
    
//    public List<Categoria> listaCategorias() {
//        
//        List<Categoria> listarCatetegorias = null;
//        CategoriaProdDAO cdao = new CategoriaProdDAO();
//        try {
//            listarCatetegorias = cdao.buscarTodos();
//            System.out.println("Carga Datos lista");
//            return listarCatetegorias;
//        } catch (Exception e) {
//            System.out.println("Error en listado de categorias " + e.getMessage());
//            return listarCatetegorias;
//        }
//        
//    }
    
//    public Categoria buscarCategoria(Integer idCat){
//        String Hql = "FROM Categoria WHERE idcat='"+idCat+"'";
//        Categoria c=null;
//        try {
//            c = (Categoria) session.createQuery(Hql).list().get(0);
//        } catch (Exception e) {
//            System.out.println("Error en listado de categorias " + e.getMessage());
//        }finally{
//            return c;
//        }
//        
//    }

    List<Categoria> listaCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Categoria buscarCategoria(Integer idcat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
