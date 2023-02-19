package com.parom.servlet;

import com.parom.service.FlightService;
import com.parom.util.JSPHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("flights", flightService.findAll());
        req.getRequestDispatcher(JSPHelper.getPath("flights")).forward(req, resp);
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
////        try () {
//        PrintWriter writer = resp.getWriter();
//        writer.write("<h1>Список перелетов</h1>");
//        writer.write("<ul>");
//        flightService.findAll().forEach(flightDTO -> {
//            writer.write(
//                    """
//                            <li>
//                                <a href="/tickets?flightId=%d">%s</a>
//                            </li>
//                            """.formatted(flightDTO.getId(), flightDTO.getDescription())
//            );
//        });
//        writer.write("</ul>");

//        }
    }
}
