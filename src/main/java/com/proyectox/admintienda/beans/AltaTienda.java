package com.proyectox.admintienda.beans;

import com.proyectox.admintienda.dao.TiendaDAO;
import com.proyectox.model.Tienda;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@Named(value = "altaTienda")
@RequestScoped
public class AltaTienda {

    private Tienda tienda;

    /**
     * Creates a new instance of AltaTienda
     */
    public AltaTienda() {
        this.tienda = new Tienda();
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public String insertarTienda() {
        TiendaDAO tdao = new TiendaDAO();
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        
        tienda.setAdmintien((String) context.getExternalContext().getUserPrincipal().getName());
        tdao.insertarTienda(tienda);
        return "index";
    }

   

}
