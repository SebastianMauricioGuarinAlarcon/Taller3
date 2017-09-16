/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.taller3;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YOHAN TALON 00
 */
@WebFilter(filterName = "FiltroAutenticacion", urlPatterns = {"/index.html","/ProcesarFormulario","/"})
public class FiltroAutenticacion implements Filter{
    
    String Usuario;
    String Contraseña;
    String UsuarioYohan = "yohan";
    String ContraseñaYohan = "1234";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;
        
        Usuario = (String) req.getSession().getAttribute("Usuario");
        Contraseña = (String) req.getSession().getAttribute("Contraseña");
        
        
        if (req.getSession().getAttribute("nombre") == null) {
            // no esta conectado
            resp.sendRedirect("./login.html");
        } else {
            
            //resp.sendRedirect("./index.html");
            // esta autentificado
            // continua con la ejecucion de la aplicacion
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
