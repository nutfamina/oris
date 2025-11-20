package ru.itis.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Успех!</title></head>");
        out.println("<body>");
        out.println("<h1>Спасибо! Ваши данные сохранены.</h1>");
        out.println("<a href='form'>Вернуться к форме</a>");
        out.println("</body>");
        out.println("</html>");
    }
}


