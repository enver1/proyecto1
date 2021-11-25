/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_asignaturas;

import framework.componentes.AutoCompletar;
import framework.componentes.Boton;
import framework.componentes.Division;
import framework.componentes.Etiqueta;
import framework.componentes.PanelTabla;
import framework.componentes.Tabla;
import org.primefaces.event.SelectEvent;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_asignaturas extends Pantalla {
    
    
    private Tabla tab_tabla1 = new Tabla();
    private AutoCompletar aut_filtrar_asignatura = new AutoCompletar();        
    private Boton bot_clean = new Boton();

    public pre_asignaturas() {
        
        aut_filtrar_asignatura.setId("aut_filtrar_asignatura");
        aut_filtrar_asignatura.setAutoCompletar("SELECT asi_codigo, asi_nombre FROM asignaturas ORDER BY asi_nombre");
        aut_filtrar_asignatura.setMetodoChange("filtrarAsignatura");
        bar_botones.agregarComponente(new Etiqueta("Asignatura: "));
        bar_botones.agregarComponente(aut_filtrar_asignatura);
        
        bot_clean.setIcon("ui-icon_cancel");
        bot_clean.setTitle("Limpiar");
        bot_clean.setMetodo("limpiar");
        bar_botones.agregarComponente(bot_clean);
        
        tab_tabla1.setId("tab_tabla1");
        tab_tabla1.setHeader("Registro de Asignaturas");
        tab_tabla1.setTabla("asignaturas", "asi_codigo", 1);
        tab_tabla1.getColumna("ASI_CODIGO").setNombreVisual("IDE");
        tab_tabla1.getColumna("ASI_ASI_CODIGO").setVisible(false);
        tab_tabla1.getColumna("TIP_CODIGO").setVisible(false);
        tab_tabla1.getColumna("INS_CODIGO").setVisible(false);
        tab_tabla1.getColumna("ASI_NOMBRE").setNombreVisual("Nombre");
        tab_tabla1.getColumna("ASI_NOMBRE").setMayusculas(true);
        tab_tabla1.getColumna("ASI_OBSERVACIONES").setNombreVisual("Observaciones");
        tab_tabla1.getColumna("ASI_OBSERVACIONES").setMayusculas(true);      
        tab_tabla1.setTipoFormulario(true);
        tab_tabla1.dibujar();
        
        PanelTabla pat_panel = new PanelTabla();
        pat_panel.setPanelTabla(tab_tabla1);
        
        Division div_division = new Division();
        div_division.dividir1(pat_panel);
        agregarComponente(pat_panel);
                
        
    }
    
    public void limpiar() {
        if (aut_filtrar_asignatura.getValue() != null) {
            aut_filtrar_asignatura.setValue(null);            
            utilitario.addUpdate("aut_filtrar_asignatura");
        }
    }

    public void filtrarAsignatura(SelectEvent evt){
        aut_filtrar_asignatura.onSelect(evt);
        if (aut_filtrar_asignatura.getValue()!=null) {
            tab_tabla1.setFilaActual(aut_filtrar_asignatura.getValor());
            utilitario.addUpdate("tab_tabla1");
        }else{
            utilitario.agregarMensajeInfo("No existe la Asignatura", "Ingrese otra Asignatura");
        }
        
    }
    public AutoCompletar getAut_filtrar_asignatura() {
        return aut_filtrar_asignatura;
    }

    public void setAut_filtrar_asignatura(AutoCompletar aut_filtrar_asignatura) {
        this.aut_filtrar_asignatura = aut_filtrar_asignatura;
    }

    public Tabla getTab_tabla1() {
        return tab_tabla1;
    }

    public void setTab_tabla1(Tabla tab_tabla1) {
        this.tab_tabla1 = tab_tabla1;
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
    
    
    
}
