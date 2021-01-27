<?php
require_once('../header.php');
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 2){

$username_err = $email_err = $password_err = $conf_pass_err = "";
$id = $username = $email = $password = $conf_pass = "";
if(isset($_SESSION['username'])){
        require_once '../dbutil/dbConnection.php';
        $sql = "SELECT * FROM korisnici WHERE username = ?";
        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "s", $param_user);
            $param_user = trim($_SESSION['username']);
            if(mysqli_stmt_execute($stmt)){
                $result = mysqli_stmt_get_result($stmt);
                if(mysqli_num_rows($result) == 1){
                    $row = mysqli_fetch_array($result);
                    $id = $row['id'];
                    $username = $row['username'];
                    $email = $row['email'];
                } else {
                    echo "User does not exist!";
                }
            }
        }
}
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    require_once "../dbutil/dbConnection.php";
    $id = $_POST['id'];
    $username = $_POST['username'];
    $email = $_POST['email'];

    if (empty(trim($_POST['username']))) {
        $username_err = "Username is empty!";
    } else {
        $sql = "SELECT id FROM korisnici WHERE username = ?";

        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "s", $param_username);
            $param_username = trim($_POST['username']);
            if (mysqli_stmt_execute($stmt)) {
                mysqli_stmt_store_result($stmt);
                if (mysqli_stmt_num_rows($stmt) == 1) {
                    $username = trim($_POST['username']);
                } else {
                    echo "poghcamp";
                }
            } else {
                header("location: ../error.php");
                exit();
            }
        } else {
            header("location: ../error.php");
            exit();
        }
    }

    if (empty(trim($_POST['email']))) {
        $email_err = "Email is empty!";
    } else {
        $sql = "SELECT id FROM korisnici WHERE email = ?";

        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "s", $param_email);
            $param_email = trim($_POST['email']);
            if (mysqli_stmt_execute($stmt)) {
                mysqli_stmt_store_result($stmt);
                if (mysqli_stmt_num_rows($stmt) >= 1) {
                    $email = trim($_POST['email']);
                } else {
                    echo "GRESKA" . mysqli_error($conn);
                }
            } else {
                header("location: ../error.php");
                exit();
            }
        } else {
            header("location: ../error.php");
            exit();
        }
    }

    if (empty(trim($_POST['password']))) {
        $password_err = "Password is empty";
    } elseif (strlen(trim($_POST['password'])) < 8) {
        $password_err = "Password needs to have at least 8 characters!";
    } else {
        $password = trim($_POST['password']);
    }

    if (empty(trim($_POST['conf_pass']))) {
        $conf_pass_err = "Confirm password!";
    } else {
        $conf_pass = trim($_POST['conf_pass']);
        if (empty($password_err) && ($password != $conf_pass)) {
            $conf_pass_err = "Passwords do not match!";
        }
    }

    if (empty($username_err) && empty($password_err) && empty($email_err) && empty($conf_pass_err)) {
        $sql = "UPDATE `korisnici` SET `username` = ?, `email` = ?, `password`= ? WHERE `id` = ?;";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "sssi", $param_username, $param_email, $param_password, $param_id);
            $param_username = $username;
            $param_email = $email;
            $param_password = password_hash($password, PASSWORD_DEFAULT);
            $param_id = $id;

            if (mysqli_stmt_execute($stmt)) {
                header("location: ../index.php");
                exit();
            } else {
                header("location: ../error.php");
                exit();
            }
        } else {
            header("location: ../error.php");
            exit();
        }
    }
    mysqli_close($conn);
}
?>
<title>Update user</title>
<link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2 class="pull-left"><?php if(isset($_SESSION['username'])) { echo "Update " . $_SESSION['username']; }?></h2><br><br>
                </div>
                <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
                    <input type="hidden" name="id" value="<?php echo $id;?>">
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
                        <button class="button btn-read-more" type="submit" value="Update">Update</button>
                        <button class="button btn-read-more" type="reset" value="Reset">Reset</button>
                        <a href="../index.php" class="btn btn-default">Home</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<?php
require_once ('../footer.php');
} else {
    header("location: index.php" );
    exit();
}
?>

</body>
</html>
