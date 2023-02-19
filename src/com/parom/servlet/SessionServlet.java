package com.parom.servlet;

import com.parom.dto.UserDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    public static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        session.getServletContext();

        UserDTO userDTO = (UserDTO) session.getAttribute(USER);
        if (userDTO == null) {
            userDTO = UserDTO.builder()
                    .id(25L)
                    .mail("test@gmail.com")
                    .build();
            session.setAttribute(USER, userDTO);
        }

        System.out.println(session.isNew());
    }
}
