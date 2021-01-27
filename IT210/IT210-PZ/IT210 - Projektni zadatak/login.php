<?php

$username_error = $password_error = "";
$username = $password = $role = "";
if($_SERVER['REQUEST_METHOD'] == 'POST') {
    require_once('dbutil/dbConnection.php');
    if(empty(trim($_POST['username']))) {
        $username_error = "Username is empty*";
    } else {
        $username = $_POST['username'];
    }

    if(empty(trim($_POST['password']))) {
        $password_error = "Password is empty*";
    } else {
        $password = $_POST['password'];
    }

    if(empty($username_error) && empty($password_error)) {
        $username = trim($_POST['username']);
        $password = trim($_POST['password']);
        $sql = "SELECT id, username, password, role_id FROM korisnici WHERE username = ?";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, 's', $param_username);
            $role = $_GET['role_id'];
            $param_username = $username;
            $param_role = $role;
            $id = 0;
            if (mysqli_stmt_execute($stmt)) {
                mysqli_stmt_store_result($stmt);
                if (mysqli_stmt_num_rows($stmt) == 1) {
                    mysqli_stmt_bind_result($stmt,$id, $username, $user_password, $role);
                    if (mysqli_stmt_fetch($stmt)) {
                        if (password_verify($password, $user_password)) {
                            session_start();
                            $_SESSION['username'] = $username;
                            $_SESSION['user_id'] = $id;
                            $_SESSION['role'] = $role;
                            //Upit za izvlacenje iz shopping carta
                            //Obrisi stanje shopping carta za korisnika
                            if($_SESSION['role'] == 1){
                            header("location: details.php");
                            exit();
                            } else {
                                header("location: index.php");
                            }
                        } else {
                            $password_error = "Wrong Password!";
                        }
                    } else {
                        echo "There was an ERROR : " . mysqli_error($conn);
                    }
                }
            }
        }
        mysqli_stmt_close($stmt);
        mysqli_close($conn);
    }
}
?>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Log in | IT210</title>
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
                <div class="login_container">
                    <div class="inner_container">
                        <form action="<?php $_SERVER['PHP_SELF'] ?>"method="POST">
                            <h1 class="sign_in">Log in</h1><br>
                            <p class="parag">You have to fill in every field or go to the link to register!</p>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control" name="username" value="<?php echo $username ?>" required placeholder="Username*">
                                <span class="help-block"><?php echo $username_error;?></span>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="password" value="<?php echo $password ?>" required placeholder="Password*">
                                <span class="help-block"><?php echo $password_error;?></span>
                            </div>
                            <div class="dugme">
                                <a href="#"><button class="button btn-submit" type="submit">Submit</button></a>
                                <a href="#"><button class="button btn-reset" type="reset">Reset</button></a>
                            </div><br>
                            <div class="opis">
                                <p>If you don't have an account : <a href="register.php">Create it here!</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
