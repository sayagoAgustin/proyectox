/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.dao;

import com.proyectox.model.Categoria;
import com.proyectox.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Agustin
 */
public class altaCategoriaProdDAO {
    private Session session = HibernateUtil.getSessionFactory().openSession();
   
    
    public void insertar(Categoria cate) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(cate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en insertar " + e.getMessage());
            tx.rollback();
        }
    }
    
    public void borrar(Categoria cate) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(cate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error en borrar" + e.getMessage());
            tx.rollback();
        }
    }
    
    public List<Categoria> buscarTodos(){
        session= HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Categoria").list();
    }
    
    public List<Categoria> buscarPorTitulo(String titulo) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
        Query q = session.createQuery("from Categoria as m where m.medDescripcion like concat('%',:cadena,'%')");
        q.setParameter("cadena", titulo);
        return q.list();
    }
}
