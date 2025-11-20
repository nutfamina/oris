package ru.itis.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@WebServlet("/form")
public class myDZServlet extends HttpServlet {
    private static final String DATA_FILE = "dz1.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String error = request.getParameter("error");
        out.println("<html>");
        out.println("<head><title>Форма регистрации</title></head>");
        out.println("<body>");
        out.println("<h1>Форма регистрации</h1>");

        if (error != null) {
            out.println("<p style='color:red;'>Ошибка: " + error + "</p>");
        }
        out.println("<form method=\"post\" action=\"form\">");
        out.println("Логин: <input type=\"text\" name=\"login\"><br>");
        out.println("Email: <input type=\"text\" name=\"email\"><br>");
        out.println("Пароль: <input type=\"password\" name=\"password\"><br>");
        out.println("Сообщение: <textarea name=\"message\"></textarea><br>");
        out.println("<input type=\"submit\" value=\"Отправить\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String message = request.getParameter("message");

        String error = validateForm(login, email, password, message);

        if (error != null) {
            response.sendRedirect("form?error=" + java.net.URLEncoder.encode(error, "UTF-8"));
            return;
        }

        saveToFile(login, email, password, message);
        response.sendRedirect("success");
    }

    private String validateForm(String login, String email, String password, String message) {
        if (login == null || login.trim().isEmpty()) {
            return "Логин не ожет быть пустым";
        }
        if (email == null || email.trim().isEmpty()) {
            return "Email не может быть пуст";
        }
        if (!email.contains("@")) {
            return "Email должен содержать собачку";
        }
        if (password == null || password.trim().isEmpty()) {
            return "Пароль не может быть пустым";
        }
        if (message == null || message.trim().isEmpty()) {
            return "Сообщение не может быть пустым";
        }
        return null;
    }


    private void saveToFile(String login, String email, String password, String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE, true))) {
            String data = String.format("Дата: %s | Логин: %s | Email: %s | Пароль: %s | Сообщение: %s%n",
                    new Date(), login, email, password, message);
            writer.println(data);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());

        }
    }
}

