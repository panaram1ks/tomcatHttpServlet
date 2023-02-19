package com.parom.servlet;

import com.parom.dto.FlightDTO;
import com.parom.service.FlightService;
import com.parom.util.JSPHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FlightDTO> flightDTOs = flightService.findAll();

        req.setAttribute("flights", flightDTOs);
        req.getSession().setAttribute("flightsMap", flightDTOs.stream().collect(toMap(FlightDTO::getId, FlightDTO::getDescription)));

        req.getRequestDispatcher(JSPHelper.getPath("content")).forward(req, resp);
    }
}
