/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 * clase lexema utilizada para describir las propiedades de un lexema y crear objetos tipo lexema para su posterior uso
 * @author niels
 */
public class Lexema {
    
    /**
     * varibles string para describer un lexema
     */
    
    private String Lexema, Token, Código;
/**
 * constructor para inicializar un lexamo con sus propiedades
 * @param Lexema es el lexema
 * @param Token es el token perteneciente al lexema
 * @param Código codigo identificativo
 */
    public Lexema(String Lexema, String Token, String Código) {
        this.Lexema = Lexema;
        this.Token = Token;
        this.Código = Código;
    }
    /**
     * constructor vacio se utilizara de ser necesario
     */
    public Lexema(){}
    
    /**
     * metodos getter y setter para obtener y fijar valores a las propiedades de objeto Lexema
     * @return 
     */

    public String getLexema() {
        return Lexema;
    }

    public void setLexema(String Lexema) {
        this.Lexema = Lexema;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getCódigo() {
        return Código;
    }

    public void setCódigo(String Código) {
        this.Código = Código;
    }
    
    /**
     * metodo toString devuelve una descripcion del objeto Lexema
     * @return String
     */

    @Override
    public String toString() {
        return "Lexema{" + "Lexema=" + Lexema + ", Token=" + Token + ", C\u00f3digo=" + Código + '}';
    }
    
    
    
    
    
}
