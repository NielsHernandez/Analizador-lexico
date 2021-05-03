/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

/**
 * clase Token permite el analisis de los lexema correspondiente a una gramatica proporcionada
 * @author niels
 */
public class Token {
    /**
     * delcaracion de arraylist para procesar lexemas y generar una lista de tokens
     */

    private ArrayList<Lexema> lexemas;
    private ArrayList<Lexema> tokens;
    
    /**
     * constructor vacio en caso de ser necesario
     */

    public Token() {

    }
    
    /**
     * metodo initToken inicializa la gramatica a utilizar en mi proyecto JavaScript
     */

    public void initToken() {
        lexemas = new ArrayList();
        tokens = new ArrayList();

        lexemas.add(new Lexema("function", "reservada", "codigo=100"));
        lexemas.add(new Lexema("var", "reservada", "codigo=100"));
        lexemas.add(new Lexema("switch", "reservada", "codigo=100"));
        lexemas.add(new Lexema("case", "reservada", "codigo=100"));
        lexemas.add(new Lexema("if", "reservada", "codigo=100"));
        lexemas.add(new Lexema("else", "reservada", "codigo=100"));
        lexemas.add(new Lexema("for", "reservada", "codigo=100"));
        lexemas.add(new Lexema("while", "reservada", "codigo=100"));
        lexemas.add(new Lexema("parseFloat", "reservada", "codigo=100"));
        lexemas.add(new Lexema("break", "reservada", "codigo=100"));
        lexemas.add(new Lexema("textContent", "reservada", "codigo=100"));
        lexemas.add(new Lexema("innerHTML", "reservada", "codigo=100"));
        lexemas.add(new Lexema("document", "reservada", "codigo=100"));
        lexemas.add(new Lexema("getElementById", "reservada", "codigo=100"));
        lexemas.add(new Lexema("return", "reservada", "codigo=100"));
        lexemas.add(new Lexema("continue", "reservada", "codigo=100"));
        lexemas.add(new Lexema("try", "reservada", "codigo=100"));
        lexemas.add(new Lexema("catch", "reservada", "codigo=100"));
        lexemas.add(new Lexema("console", "reservada", "codigo=100"));
        lexemas.add(new Lexema("log", "reservada", "codigo=100"));

        lexemas.add(new Lexema("0", "numero", "codigo=102"));
        lexemas.add(new Lexema("1", "numero", "codigo=102"));
        lexemas.add(new Lexema("2", "numero", "codigo=102"));
        lexemas.add(new Lexema("3", "numero", "codigo=102"));
        lexemas.add(new Lexema("4", "numero", "codigo=102"));
        lexemas.add(new Lexema("5", "numero", "codigo=102"));
        lexemas.add(new Lexema("6", "numero", "codigo=102"));
        lexemas.add(new Lexema("7", "numero", "codigo=102"));
        lexemas.add(new Lexema("8", "numero", "codigo=102"));
        lexemas.add(new Lexema("9", "numero", "codigo=102"));

        lexemas.add(new Lexema("(", "simbolo", "codigo=1"));
        lexemas.add(new Lexema(")", "simbolo", "codigo=2"));
        lexemas.add(new Lexema("{", "simbolo", "codigo=6"));
        lexemas.add(new Lexema("=", "simbolo", "codigo=8"));
        lexemas.add(new Lexema(";", "simbolo", "codigo=5"));
        lexemas.add(new Lexema(":", "simbolo", "codigo=4"));
        lexemas.add(new Lexema("}", "simbolo", "codigo=7"));
        lexemas.add(new Lexema(".", "simbolo", "codigo=3"));

        lexemas.add(new Lexema("+", "operador", "codigo=103"));
        lexemas.add(new Lexema("-", "operador", "codigo=103"));
        lexemas.add(new Lexema("*", "operador", "codigo=103"));
        lexemas.add(new Lexema("/", "operador", "codigo=103"));
        lexemas.add(new Lexema("%", "operador", "codigo=103"));

    }
    
    /**
     * metodo buscar, permite la busca de caracteres de la correspondiente gramatica
     * cuenta con bucles y condicionales if para la respectiva validacion
     * @param caracter recive un parametro String
     */
    public void buscar(String caracter) {

        String noSpaceStr = caracter.replaceAll("\\s", "");

        boolean noEncontrado = true;

        for (Lexema item : lexemas) {

            String temp = item.getLexema();

            if (temp.equals(noSpaceStr)) {

                System.out.println("encontrado");
                System.out.println(item.toString());
                tokens.add(item);
                noEncontrado = false;

            }

        }

        if (noEncontrado == true) {

            if (!noSpaceStr.isEmpty()) {
                tokens.add(new Lexema(noSpaceStr, "identificador", "codigo=101"));
            } else {

            }

        }

    }
    
    
/**
 * lista de tokens despues de ser identificados
 * @return devuleve una lista de tokens
 */
    public ArrayList<Lexema> getTokens() {
        return tokens;
    }

}
