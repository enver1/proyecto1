/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq_visualizar_componentes;

import framework.componentes.Barra;
import framework.componentes.Boton;
import framework.componentes.Reporte;
import framework.componentes.VisualizarPDF;
import java.util.HashMap;
import java.util.Map;
import sistema.aplicacion.Pantalla;
import sistema.aplicacion.Utilitario;

/**
 *
 * @author Administrador
 */
public class pre_VisualizarPDF extends Pantalla{

    private VisualizarPDF vpdf_ver = new VisualizarPDF(); // agregar geter y setter
    private Reporte rep_reporte = new Reporte(); // agregar metodos get y set 
    
//    private final Utilitario utilitario = new Utilitario();

    public pre_VisualizarPDF() {
         
        //boton con el icono de impresora reporte
        bar_botones.agregarReporte();         
        rep_reporte.setId("rep_reporte");
        rep_reporte.getBot_aceptar().setMetodo("aceptarReporte");
        agregarComponente(rep_reporte);
         
                  
        vpdf_ver.setTitle("FORMULARIOS");
        vpdf_ver.setId("vpdf_ver");         
        agregarComponente(vpdf_ver);
         
       Map parametros_rep = new HashMap();
            parametros_rep.put("ide_perf", 0);
            vpdf_ver.setTitle("ACTA DE CONSTATACIÓN FÍSICA");
            vpdf_ver.setVisualizarPDF("rep_seguridad/rep_usuarioxperfil.jasper", parametros_rep);
            vpdf_ver.dibujar();
        
    }
    
     public void aceptarReporte() {
        
            Map parametros_rep = new HashMap();
            parametros_rep.put("ide_perf", 0);
            vpdf_ver.setTitle("ACTA DE CONSTATACIÓN FÍSICA");
            vpdf_ver.setVisualizarPDF("rep_activos/rep_usuarioxperfil.jasper", parametros_rep);
            vpdf_ver.dibujar();
       
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

    public VisualizarPDF getVpdf_ver() {
        return vpdf_ver;
    }

    public void setVpdf_ver(VisualizarPDF vpdf_ver) {
        this.vpdf_ver = vpdf_ver;
    }

    public Reporte getRep_reporte() {
        return rep_reporte;
    }

    public void setRep_reporte(Reporte rep_reporte) {
        this.rep_reporte = rep_reporte;
    }
    
    
    
}
