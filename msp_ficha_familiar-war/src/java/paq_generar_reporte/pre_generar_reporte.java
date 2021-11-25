/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq_generar_reporte;

import framework.componentes.Barra;
import framework.componentes.Boton;
import framework.componentes.Grupo;
import framework.componentes.MenuPanel;
import framework.componentes.PanelTabla;
import framework.componentes.Tabla;
import framework.reportes.GenerarReporte;
import framework.reportes.ReporteDataSource;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_generar_reporte extends Pantalla{
    
    private final MenuPanel mep_menu = new MenuPanel();
    private Tabla tab_tabla;

    public pre_generar_reporte() {        
        mep_menu.setMenuPanel("OPCIONES", "20%");
        mep_menu.agregarItem("Listado de Usuarios", "dibujarListadoUsuarios", "ui-icon-note");
        agregarComponente(mep_menu);
    }
            
    public void dibujarListadoUsuarios() {               
        Grupo grupo = new Grupo();
        Barra bar_menu = new Barra();
        bar_menu.setId("bar_menu");
        bar_menu.limpiar(); // elimina el botones: insertar,guardar, eliminar, inicio, anterior, siguiente, fin 
        bar_menu.agregarSeparador();
        Boton bot_pdf = new Boton();
        bot_pdf.setValue("Ver PDF");
        bot_pdf.setMetodo("generarPDF");
        bar_menu.agregarComponente(bot_pdf);
        Boton bot_xml = new Boton();
        bot_xml.setValue("Descargar XML");
        bot_xml.setMetodo("descargarXML");
        bot_xml.setAjax(false);
        bar_menu.agregarComponente(bot_xml);
        tab_tabla = new Tabla();
        tab_tabla.setId("tab_tabla");
        tab_tabla.setTabla("sis_usuario", "ide_usua", 1);
        tab_tabla.setLectura(true);
        tab_tabla.setRows(15);
        tab_tabla.dibujar();
        PanelTabla pat_panel = new PanelTabla();
        pat_panel.setPanelTabla(tab_tabla);
        grupo.getChildren().add(bar_menu);
        grupo.getChildren().add(pat_panel);
        mep_menu.dibujar(1, "Titulo: Listado de Usuarios", grupo);            
    }
 
//    
//    public void generarPDF(){
//        //Genera el reporte en PDF
//        ReporteDataSource data = new ReporteDataSource(lisDetalle);
//        GenerarReporte generarReporte = new GenerarReporte();
//        generarReporte.setDataSource(data);
//        // generarReporte.generarPDF(parametros, "/reportes/comprobanteRetencion.jasper", parametros.get("CLAVE_ACC") + "");
//        generarReporte.generarPDF(parametros, "/reportes/comprobanteRetencion.jasper");
//    }
    

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
//
//    public MenuPanel getMep_menu() {
//        return mep_menu;
//    }

    public Tabla getTab_tabla() {
        return tab_tabla;
    }

    public void setTab_tabla(Tabla tab_tabla) {
        this.tab_tabla = tab_tabla;
    }
    
    
    
}
