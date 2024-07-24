<h1 align="center">Tarea: Implementar filtro que calcule el Tiempo Transcurrido</h1>
<p>Implementar filtro que calcule el Tiempo Transcurrido</p>

<h1>Instrucciones de tareas</h1>

El siguiente desafío es agregar mayor funcionalidad a nuestro proyecto (de la sección actual) agregando un nuevo filtro llamado <b>TiempoTranscurridoFilter</b> que debe calcular cuánto tiempo se demora en cargar cada página o respuesta en cuestión.

Crear nuevo evento con funcionalidad antes y después para realizar el cálculo del tiempo trascurrido, en el antes se debe crear un tiempo de inicio, mientras que en el después el tiempo de término, luego restar ambas y obtenemos el resultado final. El cálculo del resultado tiene que ser en medida de milisegundos.

El resultado se tiene que imprimir en el logs (o consola) con un mensaje descriptivo y simple, por ejemplo: <b>El tiempo de carga de la página es de X milisegundos</b>, donde X es el resultado obtenido.

Una vez terminada y probada la tarea deberán enviar el código fuente de todos los archivos involucrados, además de las imágenes screenshot (imprimir pantalla).

NO subir el proyecto completo, sólo los archivos involucrados, que son los siguientes:

- Clase filtro <b>TiempoTranscurridoFilter.</b>

<h1>Resolución del Profesor</h1>

Clase Filtro TiempoTranscurridoFilter:

```java
package org.aguzman.apiservlet.webapp.headers.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter("/*")
public class TiempoTranscurridoFilter implements Filter {

    private static final Logger logger =  Logger.getLogger("TiempoTranscurridoFilter");
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long inicio = System.currentTimeMillis();
        chain.doFilter(request, response);
        long fin = System.currentTimeMillis();
        long resultado = fin - inicio;

        // imprimimos en el logs o imprimir directamente en consola con System.out.println
        logger.info(String.format("El tiempo de carga de la página es de %s milisegundos", resultado));

    }
}
```
