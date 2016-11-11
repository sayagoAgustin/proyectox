/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.dao;
    
import com.proyectox.model.Categoria;
import com.proyectox.model.Producto;
import com.proyectox.model.Stock;
import com.proyectox.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ignacio
 */
public class stockDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    
    
    
    public void insertarStock(Stock st) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(st);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en insertar " + e.getMessage());
            tx.rollback();
        }finally{
            
        }
    }
    
    public Stock Buscar(Producto consulta){
        Stock st=null;
        
        try {
            String Hql= "FROM Stock WHERE producto.idprod='"+consulta.getIdprod()+"'";
            Query query = session.createQuery(Hql);
            st= (Stock) query.list().get(0);
            
        } catch (Exception e) {
            throw e;
        }finally{
            
            return st;
        }
    }
    
    
    
    public void modStock(Stock st) {
        Transaction tx = session.beginTransaction();
        try {
            session.merge(st);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en modificar " + e.getMessage());
            tx.rollback();
        }finally{
            
        }
    }
    
    
}
