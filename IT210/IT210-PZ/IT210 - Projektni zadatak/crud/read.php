<?php
require_once('../header.php');
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){
if(isset($_GET['id']) && !empty(trim($_GET['id']))){
    require_once '../dbutil/dbConnection.php';
    $sql = "SELECT * FROM korisnici WHERE id = ?";
    if($stmt = mysqli_prepare($conn, $sql)){
        mysqli_stmt_bind_param($stmt, "i", $param_id);
        $param_id = trim($_GET['id']);
        if(mysqli_stmt_execute($stmt)){
            $result = mysqli_stmt_get_result($stmt);
            if(mysqli_num_rows($result) == 1){
                $row = mysqli_fetch_array($result);
            }
            $username = $row['username'];
        }
    }
    mysqli_close($conn);
} else {
    header("location:../index.php");
    exit();
}
?>
<link rel="stylesheet" href="../style.css" type="text/css">
<title>User detail's</title>
</head>
<body>
<div class="wrapper">
    <div class="container">
        <div class="container-fluid">
            <div class="page-header clearfix">
                <h2>User's details</h2>
                <p>Only admin can edit user's profile!</p>
            </div>
            <div class="form-group">
                <label>ID</label>
                <p class="form-control-static"><?php echo $row['id'];?></p>
            </div>
            <div class="form-group">
                <label>Username</label>
                <p class="form-control-static"><?php echo $row['username'];?></p>
            </div>
            <div class="form-group">
                <label>Password:</label>
                <p class="form-control-static"><?php echo $row['password'];?></p>
            </div>
            <div class="form-group">
                <label>Email:</label>
                <p class="form-control-static"><?php echo $row['email'];?></p>
            </div>
            <p>
                <a href="../details.php"><button class="button btn-read-more" type="button">Back</button></a>
                <a href="delete.php"><button class="button btn-read-more" type="button">Delete</button></a>
                <a href='update.php'><button class="button btn-read-more" type="button">Update</button></a>
            </p>
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