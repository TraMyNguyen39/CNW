<%@ page import="model.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách User</title>
    <style>
        /* CSS inline */
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .filter-input {
            margin-bottom: 10px;
        }

        .add-button {
            float: right;
            margin-bottom: 10px;
        }

        .edit-link, .delete-link, .add-link {
            display: inline-block;
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 3px;
            margin-right: 5px;
        }

        .delete-link {
            background-color: #f44336;
        }
        .add-link {
            background-color: #3669f4;
        }

        label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        }

        select {
            padding: 5px;
            border-radius: 3px;
            margin-bottom: 10px;
        }

        .filter-input {
            padding: 5px;
            border-radius: 3px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<%
    if(session.getAttribute("user")==null){
        response.sendRedirect(request.getContextPath() + "/user");
    }
    var user = (User)session.getAttribute("user");
    var list = (ArrayList<User>)request.getAttribute("list");
%>
    <div class="container">
        <form action="">
            <table id="employeeTable">
                <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Role</th>
                </tr>
                </thead>
                <tbody>
                <%for (var item:list) { %>
                <tr>
                    <td><%=item.getFirstName()%></td>
                    <td><%=item.getLastName()%></td>
                    <td><%if(item.getIdRole().equals("ROLE1")){%>
                        Admin
                    <%} else{%>
                        User
                        <%}%>
                    </td>
                    <%if(user.getIdRole().equals("ROLE1")){ %>
                    <td>
                        <a href="user?action=formUpdate&username=<%=item.getUserName()%>" class="edit-link">Edit</a>
                        <a href="user?action=delete&username=<%=item.getUserName()%>" class="delete-link">Delete</a>
                    </td>
                    <%}
                    %>
                </tr>
                <%}%>

                </tbody>
            </table>
        </form>
        <a href="javascript:history.go(-1)">Trở về danh sách</a>

    </div>

</body>
</html>