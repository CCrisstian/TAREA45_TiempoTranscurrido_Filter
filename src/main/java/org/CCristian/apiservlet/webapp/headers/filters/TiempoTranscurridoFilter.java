package org.CCristian.apiservlet.webapp.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class TiempoTranscurridoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        long inicio = System.currentTimeMillis(); // Tiempo de INICIO

        filterChain.doFilter(servletRequest, servletResponse);

        long fin = System.currentTimeMillis(); // Tiempo de FIN

        long tiempoTranscurrido = fin - inicio; // Calcular el tiempo transcurrido

        servletRequest.getServletContext().log("El tiempo de carga de la página es de " + tiempoTranscurrido + " milisegundos.");
    }
}
