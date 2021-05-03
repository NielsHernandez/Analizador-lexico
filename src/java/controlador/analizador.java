/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * clase analizador hereda de HttpServlet utilizada en el backend para procesar las peticiones por el cliente por medio del metodo POST
 * @author niels
 */
public class analizador extends HttpServlet {

    /**
     * variables de clase utilizadas para rescatar valores a procesar
     */
    private String codigo;
    private Token tk;
    private String BufferCadena;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado - Anlisis</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //rescatando los datos de la peticion y guardandolos en la variable codigo
        codigo = request.getParameter("codigo");
        tk = new Token();
        tk.initToken();
        BufferCadena = "";

        /**
         * generacion de codigo html para el cliente
         */
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>analizador</title>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("</head>");
            out.println("<body>");
            //variable auxiliar sirve como buffer para los caracteres

            for (int i = 0; i < codigo.length(); i++) {

                if (codigo.charAt(i) == ' ' || codigo.charAt(i) == '(' || codigo.charAt(i) == ')' || codigo.charAt(i) == '{' || codigo.charAt(i) == '}'
                        || codigo.charAt(i) == '=' || codigo.charAt(i) == ';' || codigo.charAt(i) == ':' || codigo.charAt(i) == '.') {

                    tk.buscar(BufferCadena);
                    BufferCadena = "";

                    if (codigo.charAt(i) != ' ') {

                        String q = Character.toString(codigo.charAt(i));
                        tk.buscar(q);
                    }

                } else {
                    //si no se encuentra un caracter que haga corte se siguen alamacenando en el buffer
                    BufferCadena += Character.toString(codigo.charAt(i));

                }

            }

            /**
             * Escribir la tabla
             */
            out.println("<div class='container'>");
            out.println("<table class=\"table table-hover\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Lexema</th>");
            out.println("<th>Token</th>");
            out.println("<th>Código</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            /**
             * codigo auto generado por el bucle
             */
            for (Lexema item : tk.getTokens()) {

                if (item.getLexema().equals("prueba")) {

                } else {
                    out.println("<tr>");
                    out.println("<td>" + item.getLexema() + "</td>");
                    out.println("<td>" + item.getToken() + "</td>");
                    out.println("<td>" + item.getCódigo() + "</td>");
                    out.println("</tr>");
                }

            }

           

            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            /**
             * fin de la tabla
             */
            
            out.println("<div class='container'>");
            out.println("<h2>resumen de los lexemas reconocidos:</h2>");
            out.println("<table class=\"table table-hover\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Lexema</th>");
            out.println("<th>Total</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            
            /**
             * lista que contara los lexemas repetido una vez el analisis este completo
             */

            ArrayList<String> repetidos = new ArrayList();

            ArrayList<Lexema> temp = tk.getTokens();

            for (int i = 0; i < temp.size(); i++) {

                if (!repetidos.contains(temp.get(i).getLexema())) {

                    int contador = 0;

                    for (int j = 0; j < temp.size(); j++) {

                        if (temp.get(i).getLexema().equals(temp.get(j).getLexema())) {
                            contador++;

                        }

                    }
                    repetidos.add(temp.get(i).getLexema());
                    out.println("<tr>");
                    out.print("<td>" + temp.get(i).getLexema() + "</td><td>" + contador + "</td>");
                    out.println("</tr>");

                }

            }
            
            out.print("<tr><td><strong>Cantidad Lexemas</strong></td><td><b>" + tk.getTokens().size() + "</b></td><tr>");

            out.println("</tbody>");
            out.println("</table>");
             
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
