<?php
    require_once('header.php');
    if(isset($_SESSION['username'])){
        require_once('dbutil/dbConnection.php');
        $user_id = 0;
        $sql = "SELECT id FROM korisnici WHERE username = ?";
        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "s", $param_user);
            $param_user = trim($_SESSION['username']);
            if(mysqli_stmt_execute($stmt)){
                $result = mysqli_stmt_get_result($stmt);
                if(mysqli_num_rows($result) == 1){
                    $row = mysqli_fetch_array($result);
                    $user_id = $row['id'];
                } else {
                    echo "User does not exist!";
                }
            }
        }

?>
<head>
    <title>Shopping cart</title>
</head>
<body>
<div class="wrapper">
    <div class="px-4 px-lg-0">
        <!-- For demo purpose -->
        <div class="container text-white py-5 text-center">
            <h1 class="display-4">Purchase your laptop</h1>
            <p class="lead mb-0">If you are done or satisfied with out product click on the button down below to proceed to the checkout. </p>
            <p class="lead">Thank you, <a href="index.php" class="text-white font-italic">
                    <u>Yours truly IT210.</u></a>
            </p>
        </div>

        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                        <!-- Shopping cart table -->
                        <div class="table-responsive">
                            <?php
                            $laptop_name = $laptop_description = $image = $price = 0;

                            $sql = "SELECT laptops.laptop_id, facture.user_id ,laptops.laptop_name, facture_item.quantity, facture_item.price, facture.user_id
                                    FROM facture_item
                                    JOIN laptops ON laptops.laptop_id = facture_item.laptop_id
                                    JOIN facture ON facture.fact_item_id = facture_item.fac_item_id WHERE facture.user_id = '$user_id'";
                            if($result = mysqli_query($conn, $sql)){
                                if($stmt = mysqli_query($conn, $sql)) {
                                    if (mysqli_num_rows($result) > 0) {
                            ?>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Price</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Quantity</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <?php
                                    while ($row = mysqli_fetch_array($result)) {
                                        echo "<tr>";
                                        echo "<td>" . $row['laptop_name'] . "</td>";
                                        echo "<td>$" . $row['price'] . "</td>";
                                        echo "<td>" . $row['quantity'] . "</td>";
                                        echo "</tr>";
                                }
                                ?>
                                    <tr>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                            <?php
                                    } else {
                                        echo "Cart is empty!";
                                    }
                                } else {
                                    echo "ERROR: " . mysqli_error($conn);
                                }
                            }
                            ?>
                        </div>
                        <!-- End -->
                    </div>
                </div>

                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon code</div>
                        <div class="p-4">
                            <p class="font-italic mb-4">If you have a coupon code, please enter it in the box below</p>
                            <div class="input-group mb-4 border rounded-pill p-2">
                                <input type="text" placeholder="Apply coupon" aria-describedby="button-addon3" class="form-control border-0">
                                <div class="input-group-append border-0">
                                    <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Apply coupon</button>
                                </div>
                            </div>
                        </div>
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
                        <div class="p-4">
                            <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
                            <textarea name="" cols="30" rows="2" class="form-control"></textarea>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                        <div class="p-4">
                            <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$390.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping and handling</strong><strong>$10.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                    <h5 class="font-weight-bold">$400.00</h5>
                                </li>
                            </ul><a href="paid.php" class="btn btn-dark rounded-pill py-2 btn-block">Procceed to checkout</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<?php
    mysqli_close($conn);
} else {
        header("location: index.php");
        exit();
}
?>
</body>
</html>
