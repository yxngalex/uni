<?php
require_once('../header.php');
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){

$name_err = $laptop_desc_err = $image_err = $price_err = $quantity_err = "";
$laptop_name = $laptop_description = $image = $price = $quantity = "";

if ($_SERVER["REQUEST_METHOD"] === "POST") {
    require_once "../dbutil/dbConnection.php";
    if (empty(trim($_POST['laptop_name']))) {
        $name_err = "Name can't be null!";
    } else {
        $laptop_name = trim($_POST['laptop_name']);
    }

    if (empty(trim($_POST['laptop_description']))) {
        $laptop_desc_err = "Description can't be null!";
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
        $sql = "INSERT INTO `laptops` (`laptop_name`, `laptop_description`, `image`, `price`, `quantity`) VALUES (?,?,?,?,?)";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "sssii", $param_name, $param_description, $param_image, $param_price, $param_quantity);
            $param_name = $laptop_name;
            $param_description = $laptop_description;
            $param_image = $image;
            $param_price = $price;
            $param_quantity = $quantity;
            if (mysqli_stmt_execute($stmt)) {
                header("location: ../products.php");
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
<title>Add laptop</title>
<link rel="stylesheet" href="../style.css" type="text/css">
</head>
<body>
<div class="wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="page-header">
                    <h2 class="pull-left">Add a laptop</h2><br><br><br>
                </div>
                <p>You have to fill in every field to add a new laptop:</p>
                <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
                    <div class="form-group <?php echo (!empty($name_err)) ? 'has-error' : ''; ?>">
                        <label>Laptop Name</label>
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
                        <span class="help-block"><?php echo $image_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($price_err)) ? 'has-error' : ''; ?>">
                        <label>Price</label>
                        <input type="number" class="form-control" name="price" value="<?php echo $price; ?>"/>
                        <span class="help-block"><?php echo $price_err; ?></span>
                    </div>
                    <div class="form-group <?php echo (!empty($quantity_err)) ? 'has-error' : ''; ?>">
                        <label>Quantity</label>
                        <input type="number" class="form-control " name="quantity" value="<?php echo $quantity; ?>">
                        <span class="help-block"><?php echo $quantity_err; ?></span>
                    </div>
                    <div class="form-group">
                        <button class="button btn-read-more" type="submit" value="Submit">Submit</button>
                        <button class="button btn-read-more" type="reset" value="Reset">Reset</button>
                        <a href="../products.php"><button class="button btn-read-more" type="button">Back</button></a>
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
