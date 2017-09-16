/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.taller3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YOHAN TALON 00
 */
@WebServlet (name = "ProcesarFormularioLogin", urlPatterns = {"/ProcesarFormularioLogin"})
public class ProcesarFormularioLogin extends HttpServlet{
    
    String usuarioyohan ="yohan";
    String contraseñayohan = "1234";
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()){
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Inicia de Seccion con Exito</title>");
            out.print("</head>");
            out.print("<body>");
            String usuario = req.getParameter("Usuario");
            String contraseña = req.getParameter("Contrasena");
            if ((usuario.compareTo(usuarioyohan)==0)&&(contraseña.compareTo(contraseñayohan)==0)) {
                resp.sendRedirect("./index.html");
                System.out.println("hola "+usuario+"  "+contraseña);
                req.getSession().setAttribute("nombre", usuario);
            } else {
               resp.sendRedirect("./login.html");
            }
            
            //Integer edad = Integer.parseInt(req.getParameter("edad"));
            out.print("Bienvenido "+usuario +" su contraseña es: "+contraseña);
            //out.print("Bienvenido, "+nombre+" "+apellido+", usted es "+(edad > 18 ? "Mayor" : "Menor")+" de edad");
            out.print("</body>");
            out.print("</html>");
        } 
    }
    
}
