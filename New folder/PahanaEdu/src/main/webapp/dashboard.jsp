<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #f8f9fa;
        }
        .container {
            padding: 30px;
        }
        h1 {
            margin-bottom: 20px;
        }
        h2 {
            margin-top: 30px;
            margin-bottom: 15px;
        }
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .card {
            background: white;
            border-radius: 10px;
            padding: 20px;
            width: 250px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            text-align: center;
            transition: transform 0.2s ease;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .card a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Dashboard</h1>

        <!-- Admin Section -->
        <h2>Admin</h2>
        <div class="card-container">
            <div class="card">
                <a href="manageUsers.jsp">👤 Manage Users</a>
            </div>
            <div class="card">
                <a href="systemSettings.jsp">⚙️ System Settings</a>
            </div>
        </div>

        <!-- Customer Section -->
        <h2>Customer</h2>
        <div class="card-container">
            <div class="card">
                <a href="accountDetails.jsp">📄 View Account Details</a>
            </div>
            <div class="card">
                <a href="makePayments.jsp">💳 Make Payments</a>
            </div>
        </div>

        <!-- Cashier Section -->
        <h2>Cashier</h2>
        <div class="card-container">
            <div class="card">
                <a href="processTransactions.jsp">💵 Process Transactions</a>
            </div>
            <div class="card">
                <a href="generateBills.jsp">🧾 Generate Bills</a>
            </div>
        </div>
    </div>
</body>
</html>
