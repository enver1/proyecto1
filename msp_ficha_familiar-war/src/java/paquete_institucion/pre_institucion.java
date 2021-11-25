/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_institucion;

import framework.componentes.Division;
import framework.componentes.PanelTabla;
import framework.componentes.Tabla;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author user
 */
public class pre_institucion extends Pantalla {

    private Tabla tab_tabla1 = new Tabla();

    public pre_institucion() {

        tab_tabla1.setId("tab_tabla1");
        tab_tabla1.setHeader("Registro de institución");
        tab_tabla1.setTabla("institucion", "ins_codigo", 1);
        tab_tabla1.getColumna("ins_codigo").setNombreVisual("Código");
        tab_tabla1.getColumna("ins_nombre").setNombreVisual("Nombre");
        tab_tabla1.getColumna("ins_nombre").setMayusculas(true);
        tab_tabla1.getColumna("ins_direccion").setNombreVisual("Dirección");
        tab_tabla1.getColumna("ins_direccion").setMayusculas(true);
        tab_tabla1.getColumna("ins_telefono").setNombreVisual("Teléfono");
        tab_tabla1.getColumna("ins_telefono").setMascara("99-999999");
        tab_tabla1.getColumna("ins_correo").setNombreVisual("Correo");        
        tab_tabla1.getColumna("ins_tipoescuela").setVisible(false);
        tab_tabla1.getColumna("ins_rector").setNombreVisual("Rector");
        tab_tabla1.getColumna("ins_rector").setMayusculas(true);
        tab_tabla1.getColumna("ins_logo").setVisible(false);
        tab_tabla1.setTipoFormulario(true);             
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
