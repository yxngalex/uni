<?php
require_once '../header.php';

if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){
    if(isset($_POST['id']) && !empty($_POST['id'])){
        require_once '../dbutil/dbConnection.php';
        $sql = "DELETE FROM korisnici WHERE id = ?";
        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "i", $p_id);
            $p_id = trim($_POST['id']);
            if(mysqli_stmt_execute($stmt)){
                header('location: ../details.php');
                exit();
            }
            echo "ERROR: " . mysqli_error($conn);
            exit();
        } else {
            mysqli_stmt_close($stmt);
        }
        mysqli_close($conn);
    }

?>
<title>Delete user</title>
<link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div class="wrapper">
    <div class="container">
        <div class="page-header clearfix">
            <h2>Delete user</h2>
        </div>
        <div class="form-group">
            <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="POST">
                <div class="option">
                    <input type="hidden" name="id" value="<?php echo trim($_GET['id']) ?>"/>
                    <p>Are you sure you want to delete this user?</p>
                    <p>
                        <button class="button btn-yes" type="submit" value="Yes">Yes</button>
                        <a href="../details.php"><button class="button btn-read-more">No</button></a><br><br>
                    </p>
                </div>
            </form>
            <div class="random_text">
                <h2>ARE YOU REALLY SURE YOU WANT TO DELETE THIS USER?</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
                    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
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
