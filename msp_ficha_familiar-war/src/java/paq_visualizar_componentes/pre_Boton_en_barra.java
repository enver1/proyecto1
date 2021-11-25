/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq_visualizar_componentes;

import framework.componentes.Boton;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_Boton_en_barra extends Pantalla{
    
    Boton bot_borrar = new Boton();

    public pre_Boton_en_barra() {
        bot_borrar.setValue("Borrar");
        bot_borrar.setMetodo("borrar");
        bar_botones.agregarBoton(bot_borrar);
    }
    
    

    @Override
    public void insertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
