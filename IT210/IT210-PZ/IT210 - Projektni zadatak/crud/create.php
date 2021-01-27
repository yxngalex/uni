<?php
require_once('../header.php');
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){
$username_err = $email_err = $password_err = $conf_pass_err = "";
$username = $email = $password = $conf_pass = "";
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    require_once "../dbutil/dbConnection.php";
    if (empty(trim($_POST['username']))) {
        $username_err = "Username field can't be empty";
    } else {
        $sql = "SELECT id FROM korisnici WHERE username = ?";

        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "s", $param_username);
            $param_username = trim($_POST['username']);
            if (mysqli_stmt_execute($stmt)) {
                mysqli_stmt_store_result($stmt);
                if (mysqli_stmt_num_rows($stmt) == 1) {
                    $username_err = "*Username already exists";
                    $username = trim($_POST['username']);
                } else {
                    $username = trim($_POST['username']);
                }
            } else {
                header("location: ../error.php");
                exit();
            }
            mysqli_stmt_close($stmt);
        } else {
            header("location: ../error.php");
            exit();
        }
    }

    if (empty(trim($_POST['email']))) {
        $email_err = "You have to fill in username!";
    } else {
        $sql = "SELECT id FROM korisnici WHERE email = ?";

        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "s", $param_email);
            $param_email = trim($_POST['email']);
            if (mysqli_stmt_execute($stmt)) {
                mysqli_stmt_store_result($stmt);
                if (mysqli_stmt_num_rows($stmt) >= 1) {
                    $email_err = "*User with this email already exists";
                    $email = trim($_POST['email']);
                } else {
                    $email = trim($_POST['email']);
                }
            } else {
                header("location: ../error.php");
                exit();
            }
            mysqli_stmt_close($stmt);
        } else {
            header("location: ../error.php");
            exit();
        }

    }

    if (empty(trim($_POST['password']))) {
        $password_err = "Password can't be empty!";
    } elseif (strlen(trim($_POST['password'])) < 8) {
        $password_err = "Password has to be at least 8 characters";
    } else {
        $password = trim($_POST['password']);
    }

    if (empty(trim($_POST['conf_pass']))) {
        $conf_pass_err = "You have to confirm your password.";
    } else {
        $conf_pass = trim($_POST['conf_pass']);
        if (empty($password_err) && ($password != $conf_pass)) {
            $conf_pass_err = "Password doesn't match";
        }
    }
    $role_id = $_POST['role_id'];
    if (empty($username_err) && empty($password_err) && empty($email_err) && empty($conf_pass_err)) {
        $sql = "INSERT INTO `korisnici` (`username`, `email`, `password`, `role_id`) VALUES (?,?,?,?)";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "sssi", $param_username, $param_email, $param_password, $param_roles);
            $param_username = $username;
            $param_email = $email;
            $param_password = password_hash($password, PASSWORD_DEFAULT);
            $param_roles = $role_id;
            if (mysqli_stmt_execute($stmt)) {
                header("location: ../index.php");
                exit();

            } else {
                echo "There was an ERROR " . mysqli_error($conn);
            }
        } else {
            echo "There was an ERROR " . mysqli_error($conn);
        }
        mysqli_stmt_close($stmt);
    }
    mysqli_close($conn);
}
require_once '../header.php';
?>
<title>Create user</title>
<link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2 class="pull-left">Create user</h2><br><br><br>
                </div>
                <p>You have to fill in every field to add a user:</p>
                <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
                    <div class="form-group <?php echo (!empty($username_err)) ? 'has-error' : ''; ?>">
                        <label>Username</label>
                        <input type="text" class="form-control" name="username" value="<?php echo $username ?>">
                        <span class="help-block"><?php echo $username_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($email_err)) ? 'has-error' : ''; ?>">
                        <label>E-mail</label>
                        <input type="email" class="form-control " name="email" value="<?php echo $email; ?>">
                        <span class="help-block"><?php echo $email_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($password_err)) ? 'has-error' : ''; ?>">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" value="<?php echo $password; ?>"/>
                        <span class=" help-block"><?php echo $password_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($conf_pass_err)) ? 'has-error' : ''; ?>">
                        <label>Confirm password</label>
                        <input type="password" class="form-control" name="conf_pass" value="<?php echo $conf_pass; ?>"/>
                        <span class=" help-block"><?php echo $conf_pass_err; ?></span>
                    </div>
                    <div class="form-group">
                        <label>User Type</label>
                        <select name="role_id">
                            <option value="1">admin</option>
                            <option value="2">user</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="button btn-read-more" type="submit" value="Submit">Submit</button>
                        <button class="button btn-read-more" type="reset" value="Reset">Reset</button>
                        <a href="../index.php"><button class="button btn-read-more" type="button">Home</button></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<?php
    require_once('../footer.php');
} else {
    header("location: index.php" );
    exit();
}
?>
</body>
</html>
