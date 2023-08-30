package com.example.wasaaaaa.controllers;

import com.example.wasaaaaa.models.DaoUser;
import com.example.wasaaaaa.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "users", urlPatterns = {
        "/user/start",
        "/user/admin",
        "/user/login",
        "/user/instructor",
        "/user/user"
})
public class ServletUser extends HttpServlet {
    private String action;
    private String redirect = "/user/start";
    HttpSession session;
    private User user;
    private Long userId, personId, roleId;
    private String firstName, lastName, curp, birthdate, email, password, status;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/start":
                redirect = "/index.jsp";
                break;
            case "/user/admin":
                redirect = "/views/admin.jsp";
                break;
            case "/user/instructor":
                redirect = "/views/instructor.jsp";
                break;
            case "/user/user":
                redirect = "/views/user.jsp";
                break;
            default:
                System.out.println(action);
            break;
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/user/login":
                email = req.getParameter("correo");
                password = req.getParameter("contra");
                try {
                    user = new DaoUser().loginUser(email,password);
                    if (user != null) {
                        session = req.getSession();
                        session.setAttribute("user", user);
                        System.out.println(session);
                        if (user.getRoleId() == 1) {
                            redirect = "/user/admin";
                        } else if (user.getRoleId() == 2) {
                            redirect = "/user/instructor";
                        } else if (user.getRoleId() == 3) {
                            redirect = "/user/user";
                        }
                    } else {
                        redirect = "/user/start?result=false&message=" + URLEncoder
                                .encode("Credenciales inválidas. Intenta de nuevo",
                                        StandardCharsets.UTF_8);
                    }
                } catch (Exception e) {
                    redirect = "/user/start?result=false&message=" + URLEncoder
                            .encode("Usuario y/o contraseña incorrecta",
                                    StandardCharsets.UTF_8);
                }
                break;
            case "":

                break;
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }
}
