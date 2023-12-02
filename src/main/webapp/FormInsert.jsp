<%@ page import="java.util.ArrayList" %>
<%@ page import="model.bean.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Register</title>
    <style>
        /* CSS inline */
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="lastname"],
        input[type="tel"],
        textarea {
            width: 100%;
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ddd;
        }

        textarea {
            height: 80px;
        }

        .button-group {
            text-align: center;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-right: 10px;
        }

        input[type="reset"] {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <%
        //ArrayList<Role> list = (ArrayList<Role>)request.getAttribute("list");
    %>
    <div class="container">
        <h2>Register</h2>
        <form action="user?action=add" method="post">
            <div class="form-group">
                <label for="firstname">First name</label>
                <input type="text" id="firstname" name="firstname" placeholder="Nhập firstname" required>
            </div>
            <div class="form-group">
                <label for="lastname">Last name:</label>
                <input type="lastname" id="lastname" name="lastname" placeholder="Nhập lastname" required>
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="tel" id="username" name="username" placeholder="Nhập username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="text" id="password" name="password" placeholder="Nhập password" required>
            </div>
            <input type="hidden" name="idrole" value="ROLE2">
<%--            <div class="form-group">--%>
<%--                <label for="idrole">Role:</label>--%>
<%--                <select name="idrole" id="idrole">--%>
<%--                    <% for (var item : list) { %>--%>
<%--                    <option value="<%=item.getIdRole()%>"><%=item.getRoleName()%></option>--%>
<%--                    <% }   %>--%>
<%--                </select>--%>
<%--            </div>--%>
            <div class="button-group">
                <input type="submit" value="Thêm">
                <input type="reset" value="Đặt lại">
            </div>
        </form>
    </div>
</body>
</html>