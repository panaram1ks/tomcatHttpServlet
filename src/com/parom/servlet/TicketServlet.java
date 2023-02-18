package com.parom.servlet;

import com.parom.dto.TicketDTO;
import com.parom.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Long flightId = Long.valueOf(req.getParameter("flightId"));
        try (PrintWriter printWriter = resp.getWriter()) {
                printWriter.write("<h1>Купленные билеты</h1>");
                printWriter.write("<ul>");
            List<TicketDTO> allByFlightId = ticketService.findAllByFlightId(flightId);
            allByFlightId.forEach(ticketDTO -> printWriter.write("""
                    <li>
                        %s
                    </li>
                    """.formatted(ticketDTO.getGetPassengerName())));
            printWriter.write("</ul>");

        }

    }
}
