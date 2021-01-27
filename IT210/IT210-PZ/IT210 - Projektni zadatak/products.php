<?php
    require_once ('header.php');
    if(isset($_SESSION['username'])) {
        require_once('dbutil/dbConnection.php');
        if (isset($_POST['buy'])) {

            $sql = "INSERT INTO `facture_item` (`quantity`, `price`, `laptop_id`) VALUES (?,?,?)";
            if ($stmt = mysqli_prepare($conn, $sql)) {
                mysqli_stmt_bind_param($stmt, "iii", $param_quantity, $price, $id);
                $param_quantity = $_POST['quantity'];
                $dbPrice = $_POST['hidden_price'];
                $sumPrice = $dbPrice * $param_quantity;
                $price = $sumPrice;
                $id = $_POST['hidden_id'];
                if (mysqli_stmt_execute($stmt)) {
                    header("location: products.php");
                } else {
                    echo "ERROR:" . mysqli_error($conn);
                }
            } else {
                echo "ERROR.. " . mysqli_error($conn);
            }
            $quantity = $_POST['hidden_quantity'];
            if ($quantity > 0) {
                $inputQuantity = trim($_POST['quantity']);
                $totalQuv = $quantity - $inputQuantity;
                $sql = "UPDATE `laptops` SET `quantity` = ? WHERE `laptop_id` = ?";
                if ($stmt = mysqli_prepare($conn, $sql)) {
                    mysqli_stmt_bind_param($stmt, 'ii', $changed_quantity, $id);
                    $changed_quantity = $totalQuv;
                    $id = $_POST['hidden_id'];
                    if (mysqli_stmt_execute($stmt)) {
                        header("location: products.php");
                    } else {
                        echo "ERROR: " . mysqli_error($conn);
                    }
                } else {
                    echo "ERROR" . mysqli_error($conn);
                }
            } else {
                echo "Out of stock!";
            }
            $facture_id = 0;
            $sql = "SELECT fac_item_id FROM facture_item WHERE laptop_id = '$id'";
            if ($result = mysqli_query($conn, $sql)) {
                if ($stmt = mysqli_query($conn, $sql)) {
                    if (mysqli_num_rows($result) > 0) {
                        while ($row = mysqli_fetch_array($result)) {
                            $facture_id = $row['fac_item_id'];
                        }
                    } else {
                        echo "ERROR: " . mysqli_error($conn);
                    }
                } else {
                    echo "ERROR: " . mysqli_error($conn);
                }
            }

            $sql = "INSERT INTO `facture` (`sum`, `user_id` , `fact_item_id`) VALUES(?,?,?)";
            if ($stmt = mysqli_prepare($conn, $sql)) {
                mysqli_stmt_bind_param($stmt, "iii", $param_sum, $param_user_id, $param_fact_item_id);
                $dbPrice = $_POST['hidden_price'];
                $sumPrice = $dbPrice * $param_quantity;
                $param_sum = $sumPrice;
                $param_user_id = trim($_SESSION['user_id']);
                $param_fact_item_id = $facture_id;
                if (mysqli_stmt_execute($stmt)) {
                    header('location: products.php');
                } else {
                    echo "ERROR: " . mysqli_error($conn);
                }
            } else {
                echo "ERROR: " . mysqli_error($conn);
            }
        }
?>

<head>
    <title>Products | IT210</title>
    <link rel="stylesheet" href="owl/OwlCarousel2-2.3.4/dist/assets/owl.carousel.css">
    <link rel="stylesheet" href="owl/OwlCarousel2-2.3.4/dist/assets/owl.theme.default.css">
    <style>
        .owl-prev {
            left: -30px;
        }
        .owl-next {
            right: -30px;
        }
        .owl-prev, .owl-next{
            position: absolute;
            top: 30%;
        }
        .owl-prev span, .owl-next span {
            font-size: 60px;
            color: #787878;
        }
        .owl-theme .owl-nav [class*="owl-"]:hover{
            background-color: transparent;
        }
        th {
            color: white;
        }
        td {
            color: white;
        }
        a {
            color: white;
        }
    </style>
</head>


<div class="wrapper">
        <div class="container mt-5 mb-5">
            <h1>Laptop computers</h1>
            <div class="owl-carousel owl-theme">
                <?php
                $sql = "SELECT * FROM laptops";
                if($result = mysqli_query($conn, $sql)){
                if($stmt = mysqli_query($conn, $sql)){
                if(mysqli_num_rows($result) > 0){

                while($row = mysqli_fetch_array($result)){
                    if($row['quantity'] > 0){
                ?>
                <form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
                <div class="ml-2 mr-2" style="background-color: #dddddd">
                    <div class="card">
                        <img src="<?php echo $row['image'] ?>" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title"><?php echo $row['laptop_name'] ?></h5>
                            <?php echo $row['laptop_description'] . "<br>" . "<br>" ?>
                            <h5 class="card-price">$<?php echo $row['price'] ?></h5>
                            <input type="text" name="quantity" class="form_control" value="1">
                            <input type="hidden" name="hidden_quantity" class="form_control" value="<?php echo $row['quantity'] ?>">
                            <input type="hidden" name="hidden_name" value="<?php echo $row['laptop_name'] ?>">
                            <input type="hidden" name="hidden_price" value="<?php echo $row['price'] ?>">
                            <input type="hidden" name="hidden_id" value="<?php echo $row['laptop_id'] ?>">
                            <button class="button btn-read-more" type="submit" value="Add to cart" name="buy">Buy</button>
                        </div>
                    </div>
                </div><br><br>
                </form>
                <?php
                     }
                    }
                   }
                  }
                 }
                ?>
            </div>
            <?php
            if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){
            ?>
            <div class="container_products">
                <h1>Laptop Overview</h1><br>
                <a href="crud/createLaptop.php"><button class="button btn-read-more pull-right" type="button">Add a new laptop</button></a>
                <?php
                    $sql = "SELECT * FROM laptops";
                    if($result = mysqli_query($conn, $sql)){
                        if($stmt = mysqli_query($conn, $sql)){
                            if(mysqli_num_rows($stmt) > 0){?>
                <table class="table table-bordered table-striped tabela">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <?php
                        while($row = mysqli_fetch_array($stmt)) {
                            echo "<tr>";
                            echo "<td>" . $row['laptop_id'] . "</td>";
                            echo "<td><a href='crud/updateLaptop.php?id=" . $row['laptop_id'] ."'>" . $row['laptop_name'] . "</a></td>";
                            echo "<td>" . $row['laptop_description'] . "</td>";
                            echo "<td>" . $row['image'] . "</td>";
                            echo "<td>" . $row['price'] . "</td>";
                            echo "<td>" . $row['quantity'] . "</td>";
                            echo "<td><a href='crud/deleteLaptop.php?id=" . $row["laptop_id"] . "' class='text-light'><i class='fa fa-trash'></i></a></td>";
                            echo "</tr>";
                        }
                    ?>
                    </tbody>
                </table>
                <?php
                    mysqli_free_result($result);
                            } else {
                                echo "<h4><em>Database is empty!</em></h4>";
                            }
                        } else {
                            echo "404 ERROR";
                        }
                        mysqli_close($conn);
                    }

                ?>
            </div>
            <?php
            }else if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 2){
            ?>
                <div class="container mt-5 mb-5"">
                    <h1>Search laptops</h1>
                    <p>Input the name of the laptop to search the database!</p>
                    <form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
                        <input class="form-control search_bar" type="text" name="search" id="search_text" placeholder="Search" aria-label="Search">
                        <button type="submit" name="submit" class="search_button"><i class="fa fa-search"></i></button>
                    </form>
                </div>
                <div class="search_products">
                    <div class="owl-carousel owl-theme">
                        <?php
                         if(isset($_POST['submit'])){
                            $search_value = trim($_POST['search']);

                            $sql = "SELECT * FROM laptops WHERE laptop_name LIKE '$search_value%'";
                            if($result = mysqli_query($conn, $sql)){
                                if($stmt = mysqli_query($conn, $sql)){
                                    if(mysqli_num_rows($result) > 0){

                                        while($row = mysqli_fetch_array($result)){
                                            if($row['quantity'] > 0) {
                        ?>
                            <form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
                            <div class="ml-2 mr-2" style="background-color: #dddddd">
                                <div class="card">
                                    <img src="<?php echo $row['image'] ?>" class="card-img-top">
                                    <div class="card-body">
                                        <h5 class="card-title"><?php echo $row['laptop_name'] ?></h5>
                                        <?php echo $row['laptop_description'] . "<br>" . "<br>" ?>
                                        <h5 class="card-price">$<?php echo $row['price'] ?></h5>
                                        <input type="text" name="quantity" class="form_control" value="1">
                                        <input type="hidden" name="hidden_quantity" class="form_control" value="<?php echo $row['quantity'] ?>">
                                        <input type="hidden" name="hidden_name" value="<?php echo $row['laptop_name'] ?>">
                                        <input type="hidden" name="hidden_price" value="<?php echo $row['price'] ?>">
                                        <input type="hidden" name="hidden_id" value="<?php echo $row['laptop_id'] ?>">
                                        <button class="button btn-read-more" type="submit" value="Add to cart" name="buy">Buy</button>
                                    </div>
                                </div>
                            </div><br><br>
                            </form>
                         <?php
                                            } else {
                                                ?>
                                                    <div class="ml-2 mr-2" style="background-color: #dddddd">
                                                    <div class="card">
                                                        <img src="<?php echo $row['image'] ?>" class="card-img-top">
                                                        <div class="card-body">
                                                            <h5 class="card-title"><?php echo $row['laptop_name'] ?></h5>
                                                            <?php echo $row['laptop_description'] . "<br>" . "<br>" ?>
                                                            <h5 class="card-price">OUT OF STOCK</h5>
                                                            <input type="hidden" name="hidden_quantity" class="form_control" value="<?php echo $row['quantity'] ?>">
                                                            <input type="hidden" name="hidden_name" value="<?php echo $row['laptop_name'] ?>">
                                                            <input type="hidden" name="hidden_price" value="<?php echo $row['price'] ?>">
                                                            <input type="hidden" name="hidden_id" value="<?php echo $row['laptop_id'] ?>">
                                                        </div>
                                                    </div>
                                                </div><br><br>
                                                <?php
                                            }
                                        }
                                    }
                                }
                            }
                             mysqli_close($conn);
                         }
                        ?>
                        </div>
                </div>
            <?php
            }else{
            ?>
            <div class="container products">
                <h1>ANNOTATION</h1>
                <p>You will need to log in if you already have an account or register if you don't to continue with the shopping.
            </div>
            <?php
            }
            } else {
                header("location: login.php");
                exit();
            }
            ?>
        </div>
    </div>
</div>
<script src="owl/OwlCarousel2-2.3.4/dist/owl.carousel.js"></script>
<script>
    $('.owl-carousel').owlCarousel({
        autoplay: true,
        autoplayHoverPause: true,
        items: 4,
        nav: true,
        dots: true,
        loop: false,
    });
</script>
<?php
require_once ('footer.php');
?>
</body>
</html>