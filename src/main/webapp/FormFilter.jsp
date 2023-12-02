<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%
        if(session.getAttribute("user")==null){
            response.sendRedirect(request.getContextPath() + "/user");
        }
    %>
    <title>Form Filter User</title>
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

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ddd;
        }

        select {
            width: 100%;
            padding: 5px;
            border-radius: 3px;
            border: 1px solid #ddd;
        }

        .button-group {
            text-align: center;
            margin-top: 15px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-right: 10px;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #2196F3;
            color: white;
            text-decoration: none;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Filter User</h2>
        <form action="user?action=filter" method="post">
            <div class="form-group">
                <label for="value">Giá trị:</label>
                <input type="text" id="value" name="value" placeholder="Nhập giá trị" required>
            </div>
            <div class="button-group">
                <input type="submit" value="Filter">
                <a href="javascript:history.go(-1)">Quay lại</a>
            </div>
        </form>
    </div>
</body>
</html>