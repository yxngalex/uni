<?php
require_once('../header.php');
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){

require_once '../dbutil/dbConnection.php';
$name_err = $laptop_desc_err = $image_err = $price_err = $quantity_err = "";
$id = $laptop_name = $laptop_description = $image = $price = $quantity = "";

if($_SERVER['REQUEST_METHOD'] == 'GET'){
    if(isset($_GET['id']) && !empty(trim($_GET['id']))){
        $sql = "SELECT * FROM laptops WHERE laptop_id = ?";
        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "i", $param_id);
            $param_id = trim($_GET['id']);
            if(mysqli_stmt_execute($stmt)){
                $result = mysqli_stmt_get_result($stmt);
                if(mysqli_num_rows($result) == 1){
                    $row = mysqli_fetch_array($result);
                }
                $id = $row['laptop_id'];
                $laptop_name = $row['laptop_name'];
                $laptop_description = $row['laptop_description'];
                $image = $row['image'];
                $price = $row['price'];
                $quantity = $row['quantity'];
            }
        }
    }

}

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $id = $_POST['id'];
    $laptop_name = $_POST['laptop_name'];
    $laptop_description = $_POST['laptop_description'];
    $image = $_POST['image'];
    $price = $_POST['price'];
    $quantity = $_POST['quantity'];

    if (empty(trim($_POST['laptop_name']))) {
        $name_err = "Laptop name can't be null!";
    } else {
        $laptop_name = trim($_POST['laptop_name']);
    }


    if (empty(trim($_POST['laptop_description']))) {
        $email_err = "Description can't be null!";
    } else {
        $laptop_description = trim($_POST['laptop_description']);
    }


    if (empty(trim($_POST['image']))) {
        $image_err = "Image can't be null!";
    } else {
        $image = trim($_POST['image']);
    }

    if (empty(trim($_POST['price']))) {
        $price_err = "Price can't be null!";
    } else {
        $price = trim($_POST['price']);
    }

    if (empty(trim($_POST['quantity']))) {
        $quantity_err = "Quantity can't be null!";
    } else {
        $quantity = trim($_POST['quantity']);
    }

    if (empty($name_err) && empty($image_err) && empty($laptop_desc_err) && empty($price_err) && empty($quantity_err)) {
        $sql = "UPDATE `laptops` SET `laptop_name` = ?, `laptop_description` = ?, `image` = ? ,`price`= ?, `quantity` = ? WHERE `laptop_id` = ?;";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "sssiii", $param_name, $param_desc, $param_image, $param_price, $param_quant, $param_id);
            $param_name = $laptop_name;
            $param_desc = $laptop_description;
            $param_image = $image;
            $param_price = $price;
            $param_quant = $quantity;
            $param_id = $id;

            if (mysqli_stmt_execute($stmt)) {
                header("location: ../products.php");
                exit();
            } else {
                echo "ERROR: " . mysqli_error($conn);
                exit();
            }
        } else {
            echo "ERROR: " . mysqli_error($conn);
            exit();
        }
        mysqli_stmt_close($stmt);
    }
    mysqli_close($conn);
}

require_once '../header.php';
?>
<title>Update laptop</title>
<link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2 class="pull-left">Update laptop</h2><br><br><br>
                </div>
                <p>You have to fill in every field to update your old laptop:</p>
                <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
                    <input type="hidden" name="id" value="<?php echo $id;?>">
                    <div class="form-group <?php echo (!empty($name_err)) ? 'has-error' : ''; ?>">
                        <label>Laptop name</label>
                        <input type="text" class="form-control" name="laptop_name" value="<?php echo $laptop_name ?>">
                        <span class="help-block"><?php echo $name_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($laptop_desc_err)) ? 'has-error' : ''; ?>">
                        <label>Laptop Description</label>
                        <input type="text" class="form-control " name="laptop_description" value="<?php echo $laptop_description; ?>">
                        <span class="help-block"><?php echo $laptop_desc_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($image_err)) ? 'has-error' : ''; ?>">
                        <label>Image</label>
                        <input type="text" class="form-control" name="image" value="<?php echo $image; ?>"/>
                        <span class=" help-block"><?php echo $image_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($price_err)) ? 'has-error' : ''; ?>">
                        <label>Price</label>
                        <input type="text" class="form-control" name="price" value="<?php echo $price; ?>"/>
                        <span class=" help-block"><?php echo $price_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($quantity_err)) ? 'has-error' : ''; ?>">
                        <label>Quantity</label>
                        <input type="text" class="form-control" name="quantity" value="<?php echo $quantity; ?>"/>
                        <span class=" help-block"><?php echo $quantity_err; ?></span>
                    </div>
                    <div class="form-group">
                        <button class="button btn-read-more" type="submit" value="Update">Update</button>
                        <button class="button btn-read-more" type="reset" value="Reset">Reset</button>
                        <a href="../products.php" class="btn btn-default">Back</a>
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


