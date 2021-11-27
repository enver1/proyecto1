/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_inscripcion;

import framework.componentes.Boton;
import framework.componentes.Dialogo;
import framework.componentes.Division;
import framework.componentes.PanelTabla;
import framework.componentes.Tabla;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_periodo_lectivo extends Pantalla{

    private Tabla tab_tabla1= new Tabla();

    public pre_periodo_lectivo() {
//comentario agregado 11:45 viernes 26
        //comentario agregado 12:53
        // comentario 01:01
        // comentario 1:04
        //2:43 comentario  
        tab_tabla1.setId("tab_tabla1");
        tab_tabla1.setHeader("Periodos Lectivos");
        tab_tabla1.setTabla("periodo_lectivo", "per_codigo", 1);
        tab_tabla1.getColumna("ins_codigo").setVisible(false);
        tab_tabla1.getColumna("per_nombre").setNombreVisual("Nombre");
        tab_tabla1.getColumna("per_fechainicio").setNombreVisual("Fecha inicio");
        tab_tabla1.getColumna("per_fechafin").setNombreVisual("Fecha fin");
        tab_tabla1.getColumna("per_activo").setNombreVisual("Estado");
        tab_tabla1.dibujar();

        PanelTabla pat_panel = new PanelTabla();
        pat_panel.setPanelTabla(tab_tabla1);

        Division div_division = new Division();
        div_division.dividir1(pat_panel);
        agregarComponente(pat_panel);
    }
    
    @Override
    public void insertar() {
        tab_tabla1.insertar();        

    }

    @Override
    public void guardar() {
        if (tab_tabla1.getValor("per_fechainicio") != null && !tab_tabla1.getValor("per_fechainicio").isEmpty()) {
            if (tab_tabla1.getValor("per_fechafin") != null && !tab_tabla1.getValor("per_fechafin").isEmpty()) {
                tab_tabla1.guardar();
                utilitario.getConexion().guardarPantalla();
            } else {
                utilitario.agregarMensajeInfo("No se puede guardar facha fin", "La fecha ingresada no es valida");
            }
        } else {
            utilitario.agregarMensajeInfo("No se puede guardar facha inicio", "La fecha ingresada no es valida");

        }

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
