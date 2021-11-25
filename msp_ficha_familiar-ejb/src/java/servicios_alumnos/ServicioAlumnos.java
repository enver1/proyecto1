/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios_alumnos;

import framework.componentes.Tabla;
import javax.ejb.Stateless;
import servicios.ServicioBase;


/**
 *
 * @author Administrador
 */
@Stateless
public class ServicioAlumnos extends ServicioBase{
   
    
    public boolean validaAlumno(Tabla tab_alumno){
         
            if (utilitario.validarCedula(tab_alumno.getValor("alu_cedula"))) {
            } else {
                utilitario.agregarMensajeError("Error no puede guardar", "Debe ingresar el número de cédula válida");
                return false;
            }
            if(utilitario.isFechaMayor(utilitario.getFecha(tab_alumno.getValor("alu_fechanacimiento")),utilitario.getFecha(utilitario.getFechaActual()))){							
                utilitario.agregarMensajeInfo("No se puede guardar", "La fecha de nacimiento del alumno no puede ser mayor que la fecha de actual");							
                return false;													
            }            
        return true;
    }
    
    
    
    // periodo lectivo 
    
   
    
}
