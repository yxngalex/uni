<?php
$username_error = $email_error = $conf_email_error = $password_error = $conf_password_error = "";
$username = $email = $conf_email = $role_id = $password = $conf_password ="";

if($_SERVER['REQUEST_METHOD'] == "POST"){
    require_once('dbutil/dbConnection.php');
    $sql = "SELECT id FROM korisnici WHERE username = ?";
    if($stmt = mysqli_prepare($conn, $sql)){
        mysqli_stmt_bind_param($stmt, 's', $param_user);
        $param_user = trim($_POST['username']);
        if(mysqli_stmt_execute($stmt)){
            mysqli_stmt_store_result($stmt);
            if(mysqli_stmt_num_rows($stmt) >= 1){
                $username_error = "*Username already exists";
            } else {
                $username = trim($_POST['username']);
            }
        } else {
            echo "Error: execute";
        }
        mysqli_stmt_close($stmt);
    } else {
        echo "ERROR: prepare";
    }
    $email = trim($_POST['email']);
    $sql = "SELECT id FROM korisnici where email = ?";
    if($stmt = mysqli_prepare($conn, $sql)){
        mysqli_stmt_bind_param($stmt, "s", $param_email);
        $param_email = $email;
        if(mysqli_stmt_execute($stmt)){
            mysqli_stmt_store_result($stmt);
            if(mysqli_stmt_num_rows($stmt) >= 1){
                $email_error = "*Email already exists";
            } else {
                echo "ERROR: execute";
            }
            mysqli_stmt_close($stmt);
        } else {
            echo "ERROR: prepare";
        }
    }
    $conf_email = trim($_POST['conf_email']);
    if($conf_email != $email){
        $conf_email_error = "*Email doesn't match";
    } else {
        $conf_email = trim($_POST['conf_email']);
    }
    if(strlen(trim($_POST['password'])) < 8){
        $password_error = "*Password has to be at least 8 characters";
    } else {
        $password = trim($_POST['password']);
    }
    $conf_password = trim($_POST['conf_password']);
    if($conf_password != $password){
        $conf_password_error = "*Password doesn't match";
    } else {
        $conf_password = trim($_POST['conf_password']);
    }

    $role_id = $_POST['role_id'];
    if(empty($username_error) && empty($email_error) && empty($conf_email_error) && empty($password_error) && empty($conf_password_error)) {
        $sql = "INSERT INTO `korisnici` (`username`, `email`, `password`,`role_id`) VALUES (?, ?, ?, ?);";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "sssi", $param_username, $param_email, $param_password, $param_role);
            $param_username = $username;
            $param_email = $email;
            $param_password = password_hash($password, PASSWORD_DEFAULT);
            $param_role = $role_id;
            if (mysqli_stmt_execute($stmt)) {
                header("location: login.php");
            } else {
                echo "There was an ERROR " . mysqli_error($conn);
            }
        } else {
            echo "There was an ERROR " . mysqli_error($conn);
        }

    }
}
?>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sign up | IT210</title>
        <link rel="shortcut icon" type="image/png" href="images/icon.png"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <link type="text/css" href="style.css" rel="stylesheet">
    </head>
    <body>
        <div class="background">
            <div class="wrapper">
                <div class="register">
                    <div class="inner_register">
                        <form action="<?php $_SERVER['PHP_SELF'] ?>"method="POST">
                            <h1 class="sign_in">Register</h1><br>
                            <p class="parag">You have to fill in every field to register.</p>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control" name="username" value="<?php echo $username ?>" required placeholder="Username*">
                                <span class="help-block"><?php echo $username_error;?></span>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" value="<?php echo $email ?>" required placeholder="Email*">
                                <span class="help-block"><?php echo $email_error;?></span>
                            </div>
                            <div class="form-group">
                                <label>Confirm Email</label>
                                <input type="email" class="form-control" name="conf_email" value="<?php echo $conf_email ?>" required placeholder="Confirm Email*">
                                <span class="help-block"><?php echo $conf_email_error;?></span>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="password" value="<?php echo $password ?>" required placeholder="Password*">
                                <span class="help-block"><?php echo $password_error;?></span>
                            </div>
                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input type="password" class="form-control" name="conf_password" value="<?php echo $conf_password ?>" required placeholder="Confirm Password*">
                                <span class="help-block"><?php echo $conf_password_error;?></span>
                            </div>
                            <div class="form-group">
                                <label>User type</label>
                                <select name="role_id">
                                    <option value="2">user</option>
                                </select>
                            </div>
                            <div class="rdugme">
                                <a href="#"><button class="button btn-submit" type="submit">Submit</button></a>
                                <a href="#"><button class="button btn-reset" type="reset">Reset</button></a>
                            </div>
                            <div class="ropis">
                                <p>If you already have an account : <a href="login.php">Log in here!</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
