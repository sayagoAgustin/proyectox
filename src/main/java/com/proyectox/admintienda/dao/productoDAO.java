/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.dao;


import com.proyectox.model.Producto;
import com.proyectox.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ignacio
 */
public class productoDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<Producto> Buscar(Producto ingreso){
        List<Producto> consul=null;
        
        try {
            String Hql= "FROM Producto WHERE codbarprod="+ingreso.getCodbarprod()+"OR desprod='"+ingreso.getDesprod()+"'";
            Query query = session.createQuery(Hql);
            consul= query.list();
            
        } catch (Exception e) {
            throw e;
        }finally{
            return consul;
        }
    }
    
     public void insertarProducto(Producto producto) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(producto);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en insertar " + e.getMessage());
            tx.rollback();
        }
    }
    
     public List<Producto> listar(){
        List<Producto> consul=null;
        
        try {
            String Hql= "FROM Producto";
            Query query = session.createQuery(Hql);
            consul= query.list();
            
        } catch (Exception e) {
            throw e;
        }finally{
            return consul;
        }
    }
    
}
