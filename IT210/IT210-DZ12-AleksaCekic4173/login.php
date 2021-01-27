<?php

$username_error = $password_error = "";
$username = $password = "";
 if($_SERVER['REQUEST_METHOD'] == "POST") {
     require_once "dbconnection.php";
     $username = trim($_POST['username']);
     $password = trim($_POST['password']);
     $sql = "SELECT username, password FROM korisnici WHERE username = ?";
     if ($stmt = mysqli_prepare($conn, $sql)) {
         mysqli_stmt_bind_param($stmt, "s", $param_username);
         $param_username = $username;
         if (mysqli_stmt_execute($stmt)) {
             mysqli_stmt_store_result($stmt);
             if (mysqli_stmt_num_rows($stmt) == 1) {
                 mysqli_stmt_bind_result($stmt, $username, $user_password);
                 if (mysqli_stmt_fetch($stmt)) {
                     if (password_verify($password, $user_password)) {
                         session_start();
                         $_SESSION['username'] = $username;
                         header("location:welcome.php");
                         exit();
                     } else {
                         $password_error = "Wrong Password!";
                     }
                 } else {
                     echo "There was an ERROR: " . mysqli_error();
                 }
             }
         } else {
             echo "There was an ERROR: " . mysqli_error();
         }

     }
     mysqli_stmt_close($stmt);
     mysqli_close($conn);
 }
?>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style type="text/css">
        body {
            font: 14px sans-serif;
            font-family: monospace;
            background-color: crimson;
            margin-left: 500px;
            margin-top: 50px;
        }

        .wrapper {
            width: 350px;
            padding: 20px;
            background-color: white;
        }
        a{
            color: black;
            text-decoration: unset;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <h2>Login</h2>
    <p>You have to fill in every field or go to the link to register!</p>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
        <div class="form-group">
            <label>Username</label>
            <input type="text" class="form-control" name="username" value="<?php echo $username ?>" required>
            <span class="help-block" style="color: red"><?php echo $username_error; ?></span>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" name="password" value="<?php echo $password?>" required>
            <span class=" help-block" style="color: red"><?php echo $password_error; ?></span>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Submit">
            <input type="reset" class="btn btn-default" value="Reset">
        </div>
        <p>If you don't have an account : <a href="register.php">Create it here!</a></p>
    </form>
</div>
</body>
</html>
