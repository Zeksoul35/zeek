package com.joyeria.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Clase simple para representar un producto
class Producto {
    String nombre;
    String descripcion;
    String imagenUrl; // Opcional, para el futuro
    double precio;    // Opcional, para el futuro

    public Producto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    // Getters si fueran necesarios para una plantilla más compleja
}

public class ProductosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lista de productos de ejemplo (hardcodeada)
        Producto[] productos = {
            new Producto("Collar de Diamantes \"Eternidad\"", "Un deslumbrante collar con diamantes incrustados, perfecto para ocasiones especiales."),
            new Producto("Anillo de Zafiro \"Océano Profundo\"", "Elegante anillo de oro blanco con un zafiro central de corte ovalado, rodeado de pequeños diamantes."),
            new Producto("Pendientes de Perlas \"Lágrima Lunar\"", "Clásicos y sofisticados pendientes de perlas cultivadas con un brillo nacarado.")
        };

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Joyería \"El Brillante\" - Productos</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">"); // Enlace al CSS
            out.println("</head>");
            out.println("<body>");

            out.println("<header>");
            out.println("<h1>Joyería \"El Brillante\"</h1>");
            out.println("<nav>");
            out.println("<ul>");
            out.println("<li><a href=\"inicio\">Inicio</a></li>");
            out.println("<li><a href=\"productos\">Productos</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</header>");

            out.println("<main>");
            out.println("<section id=\"catalogo-productos\">");
            out.println("<h2>Nuestro Catálogo de Joyas</h2>");

            if (productos.length > 0) {
                out.println("<div class=\"lista-productos\">");
                for (Producto p : productos) {
                    out.println("<article class=\"producto-item\">");
                    out.println("<h3>" + escapeHtml(p.nombre) + "</h3>");
                    out.println("<p>" + escapeHtml(p.descripcion) + "</p>");
                    // Aquí podríamos añadir imagen y precio en el futuro
                    // out.println("<img src=\"" + escapeHtml(p.imagenUrl) + "\" alt=\"" + escapeHtml(p.nombre) + "\">");
                    // out.println("<p class=\"precio\">€" + String.format("%.2f", p.precio) + "</p>");
                    out.println("</article>");
                }
                out.println("</div>");
            } else {
                out.println("<p>No hay productos disponibles en este momento. Vuelva pronto.</p>");
            }

            out.println("</section>");
            out.println("</main>");

            out.println("<footer>");
            out.println("<p>&copy; 2023 Joyería \"El Brillante\". Todos los derechos reservados.</p>");
            out.println("</footer>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // Método simple para escapar HTML y prevenir XSS básicos
    private String escapeHtml(String text) {
        if (text == null) {
            return "";
        }
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#039;");
    }
}
