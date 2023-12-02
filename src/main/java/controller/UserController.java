package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.User;
import model.bo.RoleBO;
import model.bo.UserBO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private UserBO userBO;

    public UserController() {
        userBO = new UserBO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        if (action != null) {
            switch (action) {
                case "formInsert":
                    FormInsert(request, response);
                    break;
                case "formUpdate":
                    FormUpdate(request, response);
                    break;
                case "listDelete":
                    ListDelete(request, response);
                    break;
                case "logout":
                    Logout(request, response);
                    break;
                case "delete":
                    DeleteUser(request, response);
                    break;
            }
        }
        else{
            this.ForwardUrl(request,response,"/index.jsp");
        }
    }

    private void Logout(HttpServletRequest request, HttpServletResponse response) {
        var session = request.getSession();
        session.removeAttribute("user");
        try {
            response.sendRedirect(request.getContextPath() + "/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean isLogged(HttpServletRequest request){
        return request.getSession().getAttribute("user")!=null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    AddUser(request, response);
                    break;
                case "update":
                    UpdateUser(request, response);
                    break;
                case "delete":
                    DeleteUser(request, response);
                    break;
                case "checkLogin":
                    CheckLogin(request, response);
                    break;
                case "filter":
                    Filter(request, response);
                    break;
            }
        }
        else
        {
            this.ForwardUrl(request,response,"/index.jsp");
        }
    }

    private void Filter(HttpServletRequest request, HttpServletResponse response) {
        String value = request.getParameter("value");
        if(value==null) value = (String)request.getAttribute("valueFilter");

        var session = request.getSession();
        session.setAttribute("valueFilter",value);
        var list = userBO.Filter(value);
        request.setAttribute("list",list);
        this.ForwardUrl(request,response,"/ListUser.jsp");
    }

    private void ListDelete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void FormUpdate(HttpServletRequest request, HttpServletResponse response) {
        var username = request.getParameter("username");
        var user = userBO.GetUser(username);
        var list = new RoleBO().GetList();
        request.setAttribute("record",user);
        request.setAttribute("list",list);
        this.ForwardUrl(request,response,"/FormUpdate.jsp");
    }

    private void FormInsert(HttpServletRequest request, HttpServletResponse response) {
        var roleBo = new RoleBO();
        request.setAttribute("list", roleBo.GetList() );
        this.ForwardUrl(request,response,"/FormInsert.jsp");
    }


    private void CheckLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        var user = userBO.CheckLogin(username,password);
        if(user!=null){
            var session = request.getSession();
            session.setAttribute("user", user);
            this.ForwardUrl(request,response,"/Welcome.jsp");
        }
        else{
            this.ForwardUrl(request,response,"/LoginFail.jsp");
        }
    }

    private void AddUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String idrole = request.getParameter("idrole");

        User user = new User(firstName, lastName, username, password, idrole);
        userBO.Insert(user);
        response.sendRedirect(request.getContextPath() + "/user");
    }

    private void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleId = request.getParameter("idrole");

        User user = new User(firstName, lastName, username, password, roleId);

        userBO.Update(user);

        request.setAttribute("valueFilter",request.getSession().getAttribute("valueFilter"));
        this.Filter(request,response);
    }

    private void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        userBO.Delete(username);
        request.setAttribute("valueFilter",request.getSession().getAttribute("valueFilter"));
        this.Filter(request,response);
    }
    private void ForwardUrl(HttpServletRequest request, HttpServletResponse response, String path){
        RequestDispatcher rd = getServletContext().getRequestDispatcher(path);
        try {
            rd.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}