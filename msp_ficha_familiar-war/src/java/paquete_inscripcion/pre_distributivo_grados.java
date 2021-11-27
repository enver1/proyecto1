/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_inscripcion;

import framework.componentes.Combo;
import framework.componentes.Etiqueta;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_distributivo_grados extends Pantalla {   
    

    
    private final Combo com_periodo_lectivo = new Combo();
    
    public pre_distributivo_grados() {
        bar_botones.agregarComponente(new Etiqueta("Periodo Lectivo:"));
//        com_periodo_lectivo.setCombo(null);
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
