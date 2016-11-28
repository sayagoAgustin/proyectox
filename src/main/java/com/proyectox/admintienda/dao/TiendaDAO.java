/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectox.admintienda.dao;

import com.proyectox.model.Tienda;
import com.proyectox.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Notebook Sayago
 */
public class TiendaDAO {
    private Session session;
    
    public void insertarTienda(Tienda tienda) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(tienda);
            tx.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Error en insertar " + e.getMessage());
            tx.rollback();
            session.close();
        }
    }
    
}
