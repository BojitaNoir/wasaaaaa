package com.example.wasaaaaa.controllers;

import com.example.wasaaaaa.models.DaoUser;
import com.example.wasaaaaa.models.User;
import com.example.wasaaaaa.models.Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "users", urlPatterns = {
        "/user/start",
        "/user/admin",
        "/user/login",
        "/user/instructor",
        "/user/user",
        "/user/logut",
        "/user/save-I",
        "/user/view-createI",
        "/user/view-createC",
        "/user/save-C",
        "/user/view-class",
        "/user/register",
        "/user/view-register",
        "/user/enrollment"
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
                List<Class> clases = new DaoUser().findAllClasses();
                req.setAttribute("classes", clases);
                List<User> users = new DaoUser().findAll();
                req.setAttribute("users", users);
                redirect = "/views/admin.jsp";
                break;
            case "/user/user":
                List<Class> clases4 = new DaoUser().findAllClasses();
                req.setAttribute("classes", clases4);
                session = req.getSession();
                User user4 = (User) session.getAttribute("user");
                List<Class> clases6 = new DaoUser().findClassEnrollment(user4.getUserId());
                req.setAttribute("clases2", clases6);
                System.out.println(clases6);
                redirect = "/views/user.jsp";
                break;
            case "/user/logut":
                HttpSession session = req.getSession(false);
                session.invalidate();
                redirect = "/user/start";
                break;
            case "/user/view-createI":
                redirect = "/views/crearInstructor.jsp";
                break;
            case "/user/view-createC":
                List<User> instructors = new DaoUser().findInstructors();
                req.setAttribute("instructors", instructors);
                System.out.println(instructors);
                redirect = "/views/crearClase.jsp";
                break;
            case "/user/instructor":
                session = req.getSession();
                User user = (User) session.getAttribute("user");
                List<Class> clases2 = new DaoUser().findAllClassesInstructor(user.getUserId());
                req.setAttribute("classes", clases2);
                redirect = "/views/instructor.jsp";
                break;
            case "/user/view-class":
                Long id = Long.valueOf(req.getParameter("id"));
                List<User> users2 = new DaoUser().findUserClass(id);
                req.setAttribute("users", users2);
                redirect = "/views/class.jsp";
                break;
            case "/user/view-register":
                redirect = "/views/registro.jsp";
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
            case "/user/save-I":
                firstName = req.getParameter("firstName");
                lastName = req.getParameter("lastName");
                curp = req.getParameter("curp");
                birthdate = req.getParameter("birthdate");
                email = req.getParameter("email");
                password = req.getParameter("password");
                user = new User(null,null,firstName,lastName,curp,birthdate,email,password,"Activo",2L);
                boolean result = new DaoUser().saveUser(user);
                if (result) {
                    redirect = "/user/admin?result=" + result + "&message=" + URLEncoder.encode("Guardado", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/admin?result=" + result + "&message=" + URLEncoder.encode("No se guardo", StandardCharsets.UTF_8);
                }
                break;
            case "/user/save-C":
                String nombreClase = req.getParameter("nombreClase");
                String descripcion = req.getParameter("descripcion");
                long instructorID = Long.parseLong(req.getParameter("instructorID"));
                boolean result2 = new DaoUser().saveC(nombreClase,descripcion,instructorID);
                if (result2) {
                    redirect = "/user/admin?result=" + result2 + "&message=" + URLEncoder.encode("Guardado", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/admin?result=" + result2 + "&message=" + URLEncoder.encode("No se guardo", StandardCharsets.UTF_8);
                }
                break;
            case "/user/register":
               firstName = req.getParameter("nombres");
                lastName = req.getParameter("apellidos");
                curp = req.getParameter("curp");
                birthdate = req.getParameter("fecha");
                email = req.getParameter("correo");
                password = req.getParameter("password");
                User user3 = new User(null,null,firstName,lastName,curp,birthdate,email,password,"Activo",3L);
                boolean result3 = new DaoUser().saveUser(user3);
                if (result3) {
                    redirect = "/user/start?result=" + result3 + "&message=" + URLEncoder.encode("Guardado", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/start?result=" + result3 + "&message=" + URLEncoder.encode("No se guardo", StandardCharsets.UTF_8);
                }
                break;
            case "/user/enrollment":
                Long clase_id = Long.valueOf(req.getParameter("id"));
                session = req.getSession();
                User user5 = (User) session.getAttribute("user");
                boolean resultE = new DaoUser().enrollment(clase_id,user.getUserId());
                if (resultE){
                    redirect = "/user/user?result=false&message=" + URLEncoder
                            .encode("Matriculado en la clase",
                                    StandardCharsets.UTF_8);
                }else {
                    redirect = "/user/user?result=false&message=" + URLEncoder
                            .encode("Error en matricularse en la clase",
                                    StandardCharsets.UTF_8);
                }
                break;
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }
}
