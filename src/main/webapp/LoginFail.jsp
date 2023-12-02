<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Error</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .container {
      text-align: center;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
      color: #e74c3c;
    }

    a {
      display: inline-block;
      margin-top: 10px;
      padding: 10px 20px;
      text-decoration: none;
      color: #fff;
      background-color: #3498db;
      border-radius: 5px;
      transition: background-color 0.3s;
    }

    a:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Invalid username and password</h1>
    <a href="user">Try again</a>
    <a href="user?action=formInsert">Register</a>
  </div>
</body>
</html>
