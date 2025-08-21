<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pahana Edu - Login</title>
    <style>
        body {
            font-family: "Times New Roman", serif;
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .login-container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 400px;
            position: relative;
        }
        h2 {
            text-align: center;
            font-size: 18pt;
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 12pt;
        }
        input[type="submit"],
        .instruction-btn {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14pt;
            margin-top: 10px;
        }
        input[type="submit"]:hover,
        .instruction-btn:hover {
            background-color: #45a049;
        }
        .signup-link {
            text-align: center;
            margin-top: 15px;
            font-size: 12pt;
        }
        .signup-link a {
            color: #007BFF;
            text-decoration: none;
        }
        .signup-link a:hover {
            text-decoration: underline;
        }

        /* Modal styles */
        .modal {
            display: none; 
            position: fixed;
            z-index: 1;
            left: 0; top: 0;
            width: 100%; height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.5);
        }
        .modal-content {
            background: #fff;
            margin: 15% auto;
            padding: 20px;
            border-radius: 8px;
            width: 50%;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }
        .close {
            float: right;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
        }
        .close:hover {
            color: red;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>User Login</h2>
    <form action="LoginServlet" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Enter username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter password" required>

        <input type="submit" value="Login">
    </form>

    <!-- Instruction Button -->
    <button type="button" class="instruction-btn" onclick="openModal()">Instructions</button>

    <div class="signup-link">
        New user? <a href="register.jsp">Sign up here</a>
    </div>
</div>

<!-- Modal Box -->
<div id="instructionModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span>
        <h3>Login Instructions</h3>
        <ul>
            <li>Enter your valid <b>Username</b> and <b>Password</b>.</li>
            <li>If you are an <b>Admin</b>, you will be redirected to the Admin Dashboard.</li>
            <li>If you are a <b>Cashier</b>, you will be redirected to the Cashier Dashboard.</li>
            <li>If you are a <b>Customer</b>, you will be redirected to the Customer Home page.</li>
            <li>New users must <b>register first</b> using the Sign-up option.</li>
        </ul>
    </div>
</div>

<script>
    function openModal() {
        document.getElementById("instructionModal").style.display = "block";
    }
    function closeModal() {
        document.getElementById("instructionModal").style.display = "none";
    }
    window.onclick = function(event) {
        if (event.target === document.getElementById("instructionModal")) {
            closeModal();
        }
    }
</script>

</body>
</html>