/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_grados;

import framework.componentes.Division;
import framework.componentes.PanelTabla;
import framework.componentes.Tabla;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_paralelo extends Pantalla{
    
    private Tabla tab_tabla1 = new Tabla();

    public pre_paralelo() {
        
         tab_tabla1.setId("tab_tabla1");
        tab_tabla1.setHeader("Registro de paraleos");
        tab_tabla1.setTabla("paralelo", "par_codigo", 1);        
        tab_tabla1.getColumna("par_codigo").setNombreVisual("Código");        
        tab_tabla1.getColumna("par_nombre").setNombreVisual("Nombre");                                     
        tab_tabla1.dibujar();
        
        PanelTabla pat_panel = new PanelTabla();
        pat_panel.setPanelTabla(tab_tabla1);

        Division div_division = new Division();
        div_division.dividir1(pat_panel);
        agregarComponente(div_division);
    }
    
    

    @Override
    public void insertar() {
        tab_tabla1.insertar();
    }

    @Override
    public void guardar() {
        tab_tabla1.guardar();
        utilitario.getConexion().guardarPantalla();
    }

    @Override
    public void eliminar() {
        tab_tabla1.eliminar();
    }

    public Tabla getTab_tabla1() {
        return tab_tabla1;
    }

    public void setTab_tabla1(Tabla tab_tabla1) {
        this.tab_tabla1 = tab_tabla1;
    }
    
    
}
