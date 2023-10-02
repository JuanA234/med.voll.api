/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.infra.errores;

/**
 *
 * @author JuanAndres
 */
public class ValidacionDeIntegridad extends RuntimeException{

    public ValidacionDeIntegridad(String s) {
        super(s);
    }
    
    
}
