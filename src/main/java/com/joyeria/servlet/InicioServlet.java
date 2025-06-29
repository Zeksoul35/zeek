package com.joyeria.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Joyería \"El Brillante\" - Inicio</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">"); // Enlace al CSS
            out.println("</head>");
            out.println("<body>");

            out.println("<header>");
            out.println("<h1>Joyería \"El Brillante\"</h1>");
            out.println("<nav>");
            out.println("<ul>");
            out.println("<li><a href=\"inicio\">Inicio</a></li>");
            out.println("<li><a href=\"productos\">Productos</a></li>");
            // Podríamos añadir un enlace a contacto si tuviéramos un ContactoServlet
            // out.println("<li><a href=\"contacto\">Contacto</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</header>");

            out.println("<main>");
            out.println("<section id=\"bienvenida\">");
            out.println("<h2>Bienvenidos a nuestra Joyería</h2>");
            out.println("<p>Descubra piezas únicas y diseños exclusivos que capturan la esencia de la elegancia y el arte.</p>");
            out.println("<p>Explore nuestra <a href=\"productos\">colección de productos</a>.</p>");
            out.println("</section>");

            out.println("<section id=\"novedades\">");
            out.println("<h3>Novedades Destacadas</h3>");
            out.println("<p>Próximamente aquí presentaremos nuestras últimas creaciones y ofertas especiales.</p>");
            // Placeholder para futuras imágenes o descripciones de novedades
            out.println("</section>");
            out.println("</main>");

            out.println("<footer>");
            out.println("<p>&copy; 2023 Joyería \"El Brillante\". Todos los derechos reservados.</p>");
            out.println("</footer>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}
