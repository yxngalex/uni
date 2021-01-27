<?php
session_start();
if(isset($_SESSION['username'])){
?>
<html>
<head>
    <title>Welcome</title>
    <style type="text/css">
        body{
            margin-top: 50px;
            font-size: 20px;
            text-align: center;
            background-color: crimson;
        }
        p{
            font-family: monospace;
            background-color: green;
        }
    </style>

</head>
<body>
    <p>Hello <?php
        echo $_SESSION['username'] . ", WELCOME TO THE PAGE!!";
        $_SESSION = array();
        session_destroy();
        } else {
            echo "There was an error while logging in, please return back to the login page following " . "<a href='login.php'>this link</a>!";
        }?></p>
</body>
</html>
