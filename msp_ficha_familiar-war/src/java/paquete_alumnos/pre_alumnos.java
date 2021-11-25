/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete_alumnos;

import framework.componentes.AutoCompletar;
import framework.componentes.Boton;
import framework.componentes.Division;
import framework.componentes.Etiqueta;
import framework.componentes.PanelTabla;
import framework.componentes.Tabla;
import javax.ejb.EJB;
import org.primefaces.event.SelectEvent;
import servicios_alumnos.ServicioAlumnos;
import sistema.aplicacion.Pantalla;

/**
 *
 * @author Administrador
 */
public class pre_alumnos extends Pantalla {
            
    private Tabla tab_tabla1 = new Tabla();
    private Tabla tab_tabla2 = new Tabla();   
    private AutoCompletar aut_filtrar_alumno = new AutoCompletar();        
    private Boton bot_clean = new Boton();
    @EJB
    private final ServicioAlumnos ser_alumno = (ServicioAlumnos) utilitario.instanciarEJB(ServicioAlumnos.class);
   
    public pre_alumnos() {
            
        aut_filtrar_alumno.setId("aut_filtrar_alumno");            
        aut_filtrar_alumno.setAutoCompletar("SELECT alu_codigo, alu_nombre_completo from alumnos ORDER BY alu_nombre_completo");            
        aut_filtrar_alumno.setMetodoChange("filtrarAlumno");            
        bar_botones.agregarComponente(new Etiqueta("Alumno: "));            
        bar_botones.agregarComponente(aut_filtrar_alumno);
                        
        bot_clean.setIcon("ui-icon-cancel");
        bot_clean.setTitle("Limpiar");            
        bot_clean.setMetodo("limpiar");            
        bar_botones.agregarComponente(bot_clean);
            
        tab_tabla1.setId("tab_tabla1");  
        tab_tabla1.setHeader("Registro de alumnos");
        tab_tabla1.setTipoFormulario(true);
        tab_tabla1.setTabla("alumnos", "alu_codigo", 1);        
        tab_tabla1.getColumna("ALU_CODIGO").setNombreVisual("IDE");
        tab_tabla1.getColumna("INS_CODIGO").setNombreVisual("INSTITUCIÓN");
        tab_tabla1.getColumna("INS_CODIGO").setCombo("institucion","ins_codigo","ins_nombre","");
        tab_tabla1.getColumna("alu_nombre").setVisible(false);
        tab_tabla1.getColumna("eal_codigo").setVisible(false);
        tab_tabla1.getColumna("alu_estado").setVisible(false);
        tab_tabla1.getColumna("alu_cedula").setNombreVisual("CÉDULA");   
        tab_tabla1.getColumna("alu_cedula").setMascara("9999999999");
        tab_tabla1.getColumna("ALU_NOMBRE_COMPLETO").setNombreVisual("NOMBRE");
        tab_tabla1.getColumna("ALU_NOMBRE_COMPLETO").setMayusculas(true);
        tab_tabla1.getColumna("ALU_SEXO").setVisible(false);
        tab_tabla1.getColumna("ALU_DIRECCION").setNombreVisual("DIRECCIÓN");  
        tab_tabla1.getColumna("ALU_DIRECCION").setMayusculas(true);
        tab_tabla1.getColumna("ALU_FECHANACIMIENTO").setNombreVisual("FECHA DE NACIMIENTO");
        tab_tabla1.getColumna("ALU_FECHANACIMIENTO").setRequerida(true);
        tab_tabla1.getColumna("ALU_LUGARNACIMIENTO").setNombreVisual("LUGAR DE NACIMIENTO");  
        tab_tabla1.getColumna("ALU_LUGARNACIMIENTO").setMayusculas(true);
        tab_tabla1.getColumna("ALU_PADRE").setNombreVisual("NOMBRE DEL PADRE");  
        tab_tabla1.getColumna("ALU_PADRE").setMayusculas(true);
        tab_tabla1.getColumna("ALU_PRFPADRE").setNombreVisual("PROFESIÓN DEL PADRE");
        tab_tabla1.getColumna("ALU_PRFPADRE").setMayusculas(true);
        tab_tabla1.getColumna("ALU_MADRE").setNombreVisual("NOMBRE DE LA MADRE");  
        tab_tabla1.getColumna("ALU_MADRE").setMayusculas(true);
        tab_tabla1.getColumna("ALU_PRFMADRE").setNombreVisual("PROFESIÓN DE LA MADRE");  
        tab_tabla1.getColumna("ALU_PRFMADRE").setMayusculas(true);
        tab_tabla1.getColumna("ALU_CORREO").setVisible(false);                        
        tab_tabla1.agregarRelacion(tab_tabla2);                                      
        tab_tabla1.dibujar();        
        PanelTabla pat_panel1 = new PanelTabla();
        pat_panel1.setPanelTabla(tab_tabla1);
        
        tab_tabla2.setId("tab_tabla2");
        tab_tabla2.setTabla("representante", "rep_codigo", 2);
        tab_tabla2.getColumna("rep_codigo").setNombreVisual("Nº");
        tab_tabla2.getColumna("rep_nombres").setNombreVisual("NOMBRE DEL REPRESENTANTE");
        tab_tabla2.getColumna("rep_nombres").setMayusculas(true);
        tab_tabla2.getColumna("rep_parentesco").setNombreVisual("PARENTESCO"); 
        tab_tabla2.getColumna("rep_parentesco").setMayusculas(true);
        tab_tabla2.getColumna("rep_telefono").setNombreVisual("TELÉFONO");
        tab_tabla2.getColumna("rep_telefono").setMascara("99-999999");
        tab_tabla2.getColumna("rep_celular").setNombreVisual("CELULAR");
        tab_tabla2.getColumna("rep_celular").setMascara("9999999999");        
        tab_tabla2.setCampoForanea("alu_codigo");      
        tab_tabla2.dibujar();        
        PanelTabla pat_panel2 = new PanelTabla();
        pat_panel2.setPanelTabla(tab_tabla2);                                                                 
         
        Division div = new Division();
        div.dividir2(pat_panel1, pat_panel2, "60%", "h");
        agregarComponente(div);
    }
    
    public void limpiar() {
        if (aut_filtrar_alumno.getValue() != null) {
            aut_filtrar_alumno.setValue(null);            
            utilitario.addUpdate("aut_filtrar_alumno");
        }
    }
        
    public void filtrarAlumno(SelectEvent evt){
        aut_filtrar_alumno.onSelect(evt);
        if (aut_filtrar_alumno.getValue()!=null) {
            tab_tabla1.setFilaActual(aut_filtrar_alumno.getValor());
            utilitario.addUpdate("tab_tabla1");
        }else{
            utilitario.agregarMensajeInfo("No existe el Alumno", "Ingrese otro Alumno");
        }        
    }

    @Override
    public void insertar() {
        if (tab_tabla1.isFocus()) {
           if(tab_tabla1.isFilaInsertada() == false){
               tab_tabla1.insertar();
               tab_tabla2.insertar();
           }else {
                utilitario.agregarMensajeInfo("No se puede Insertar",
                        "Debe guardar el Usuario actual");
           }
        }
        if(tab_tabla2.isFocus()){
            tab_tabla2.insertar();
            
        }
    }

    @Override
    public void guardar() {   
        
        if (tab_tabla1.getValor("ALU_FECHANACIMIENTO") != null){
            if(ser_alumno.validaAlumno(tab_tabla1)){
             if (tab_tabla1.guardar()) {
            if (tab_tabla2.guardar()) {
                utilitario.getConexion().guardarPantalla();
            }
        }
        } 
        }else{
            utilitario.agregarMensajeInfo("No se puede guardar", "La fecha de nacimiento es requerida");
                
            
        }
           
        
    }

    @Override
    public void eliminar() {
      if (tab_tabla1.isFocus()) {
          tab_tabla2.eliminar();          			      
          tab_tabla1.eliminar();
          
          
      } else if (tab_tabla2.isFocus()) {			
          tab_tabla2.eliminar();                                   
          
      }
    }

    public Tabla getTab_tabla1() {
        return tab_tabla1;
    }

    public void setTab_tabla1(Tabla tab_tabla1) {
        this.tab_tabla1 = tab_tabla1;
    }

    public Tabla getTab_tabla2() {
        return tab_tabla2;
    }

    public void setTab_tabla2(Tabla tab_tabla2) {
        this.tab_tabla2 = tab_tabla2;
    }            

    public AutoCompletar getAut_filtrar_alumno() {
        return aut_filtrar_alumno;
    }

    public void setAut_filtrar_alumno(AutoCompletar aut_filtrar_alumno) {
        this.aut_filtrar_alumno = aut_filtrar_alumno;
    }
    
    
    
}                    

    

