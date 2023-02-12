package com.parom.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@WebServlet("/downloadText")
public class DownloadTextFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setContentType("text/plane");
        resp.setContentType("application/json");


//        Files.readAllBytes(Path.of("resources", "first.json"));
        try (ServletOutputStream outputStream = resp.getOutputStream();
             InputStream resourceAsStream = DownloadServlet.class.getClassLoader().getResourceAsStream("first.json");) {
             outputStream.write(resourceAsStream.readAllBytes());
        }
    }
}
