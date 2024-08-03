<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPGRE SYSTEM</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
<style>
body {
    font-family: Arial, sans-serif;
    background-color: lightblue;
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
}

/* Navigation Bar Styles */
.navbar {
    width: 100%;
    background-color: skyblue;
    padding: 10px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.2);
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
    display: flex;
    justify-content: flex-end; /* Aligns items to the right */
}

.navbar a {
    color: #fff;
    text-decoration: none;
    padding: 10px 20px;
    display: inline-block;
    font-size: 16px;
    background-color: skyblue; /* Set background color to skyblue */
}

.navbar a:hover {
    background-color: #0056b3; /* Darker blue on hover */
    color: #fff;
    border-radius: 5px;
}

.main-content {
    margin-top: 60px; /* Adjust based on the height of the navbar */
    text-align: center;
}

h1 {
    margin: 20px 0;
    color: #007bff;
    text-align: center;
}

.button-container {
    display: flex;
    gap: 30px; /* space between buttons */
    margin-bottom: 30px;
}

a {
    text-decoration: none;
    color: skyblue;
    background-color: #007bff;
    padding: 10px 20px;
    border-radius: 5px;
    transition: background-color 0.3s ease, transform 0.3s ease;
}

a:hover {
    background-color: #0056b3;
    transform: scale(1.05);
}

.role-cards {
    display: flex;
    justify-content: center;
    gap: 30px;
    margin-bottom: 30px;
}

.flip-card {
    background-color: transparent;
    width: 250px;
    height: 300px;
    perspective: 1000px; /* Specify the depth of the 3D effect */
}

.flip-card-inner {
    position: relative;
    width: 100%;
    height: 100%;
    text-align: center;
    transition: transform 0.6s;
    transform-style: preserve-3d;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
}

.flip-card:hover .flip-card-inner {
    transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
    position: absolute;
    width: 100%;
    height: 100%;
    backface-visibility: hidden;
}

.flip-card-front {
    background-color: skyblue;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 24px;
    font-weight: bold;
}

.flip-card-back {
    background-color: #f8f9fa;
    color: #333;
    transform: rotateY(180deg);
    padding: 20px;
}

.flip-card-back h3 {
    color: #007bff;
    border-bottom: 2px solid #007bff;
    padding-bottom: 10px;
    margin-bottom: 15px;
}

.flip-card-back p {
    line-height: 1.6;
}

</style>
</head>
<body>
    <div class="navbar">
        <a href="index.jsf">Home</a>
        <a href="login.jsf">Login</a>
        <a href="about.jsf">About</a>
    </div>
    <div class="main-content">
        <h1>EMPGRE SYSTEM</h1>


        <div class="role-cards">
            <div class="flip-card">
                <div class="flip-card-inner">
                    <div class="flip-card-front">
                        <i class="fas fa-user fa-5x"></i>
                    </div>
                    <div class="flip-card-back">
                        <h3>Employee Role</h3>
                        <p>
                            Employees can apply grievances, view submitted grievances, and check their status.
                        </p>
                    </div>
                </div>
            </div>

            <div class="flip-card">
                <div class="flip-card-inner">
                    <div class="flip-card-front">
                        <i class="fas fa-user-tie fa-5x"></i>
                    </div>
                    <div class="flip-card-back">
                        <h3>HR Role</h3>
                        <p>
                            HR can register employees, view submitted grievances, and resolve issues.
                        </p>
                    </div>
                </div>
            </div>

            <div class="flip-card">
                <div class="flip-card-inner">
                    <div class="flip-card-front">
                        <i class="fas fa-user-shield fa-5x"></i>
                    </div>
                    <div class="flip-card-back">
                        <h3>Admin Role</h3>
                        <p>
                            Admin has full access to all functionalities, including employee management, grievance handling, and system settings.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
