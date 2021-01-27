<?php
$username_err = $email_err = $password_err = $conf_pass_err = "";
$username =  $email = $password = $conf_pass = "";
if($_SERVER['REQUEST_METHOD'] == "POST"){
    require_once "dbconnection.php";
        $sql = "SELECT id FROM korisnici WHERE username = ?";

        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "s", $param_username);
            $param_username = trim($_POST['username']);
            if(mysqli_stmt_execute($stmt)){
                mysqli_stmt_store_result($stmt);
                if(mysqli_stmt_num_rows($stmt) >= 1){
                    $username_err = "Username already exists";
                } else {
                    $username = trim($_POST['username']);
                }
            } else {
                echo "Error: execute";
            }
            mysqli_stmt_close($stmt);
        } else {
            echo "Error: prepare";
        }
        $email = trim($_POST['email']);
        $sql = "SELECT id FROM korisnici WHERE email = ?";

        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "s", $param_email);
            $param_email = $email;
            if(mysqli_stmt_execute($stmt)){
                mysqli_stmt_store_result($stmt);
                if(mysqli_stmt_num_rows($stmt) >= 1){
                    $email_err = "Email already exists";
                }
            } else {
                echo "Error: execute";
            }
            mysqli_stmt_close($stmt);
        } else {
            echo "Error: prepare";
        }

        if (strlen(trim($_POST['password'])) < 8){
        $password_err = "Password has to be at least 8 characters";
        } else{
            $password = trim($_POST['password']);
        }

        $conf_pass = trim($_POST['conf_pass']);
        if($password != $conf_pass){
            $conf_pass_err = "Password & confirm password do not match!!!";
        } else {
            $conf_pass = trim($_POST['conf_pass']);
        }

        if (empty($username_err) && empty($email_err) && empty($password_err) && empty($conf_pass_err)){
            $sql = "INSERT INTO `korisnici` (`username`, `email`, `password`) VALUES (?,?,?);";
            if ($stmt = mysqli_prepare($conn, $sql)){
                mysqli_stmt_bind_param($stmt, "sss", $param_username, $param_email, $param_password);
                $param_username = $username;
                $param_email = $email;
                $param_password = password_hash($password, PASSWORD_DEFAULT);

            if (mysqli_stmt_execute($stmt)){
                header("location: login.php");
            } else {
                echo "There was an ERROR " . mysqli_error($conn);
            }

        } else {
            echo "there was an ERROR " . mysqli_error($conn);
        }
    }
        mysqli_stmt_close($stmt);
        mysqli_close($conn);
}

?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style type="text/css">
        body {
            font: 14px sans-serif;
            margin-left: 600px;
            background-color: crimson;
        }
        h3{
            text-align: center;
            border-bottom: 1px solid black;
        }
        .wrapper {
            margin-top: 40px;
            width: 450px;
            background-color: white;
            padding: 20px;
            border: 3px solid black;
            border-radius: 10%;
        }
        a{
            color: black;
            border-bottom: 1px solid black;
        }
        .btn{
            margin-left: 80px;
            height: 40px;
            width: 80px;
        }
        p{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <h3>Register Page</h3>
    <p>You have to fill in every blank field to proceed!</p>
    <form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
        <div class="form-group">
            <label>Username</label>
            <input type="text" class="form-control" name="username" value="<?php echo $username;?>" required>
            <span class="help-block" style="color: red"><?php echo $username_err;?></span>
        </div>
        <div class="form-group">
            <label>E mail</label>
            <input type="text" class="form-control" name="email" value="<?php echo $email;?>" required>
            <span class="help-block" style="color: red"><?php echo $email_err;?></span>
        </div>
        <div class="form-group ">
            <label>Password</label>
            <input type="password" class="form-control" name="password" value="<?php echo $password;?>" required>
            <span class="help-block" style="color: red"><?php echo $password_err;?></span>
        </div>
        <div class="form-group">
            <label>Confirm password</label>
            <input type="password" class="form-control" name="conf_pass" value="<?php echo $conf_pass;?>" required>
            <span class="help-block" style="color: red"><?php echo $conf_pass_err;?></span>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Submit">
            <input type="reset" class="btn btn-default" value="Reset">
        </div>

        <p>Already have an account? <a href="login.php">Login here!!</a></p>
    </form>
</div>
</body>
</html>