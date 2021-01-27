<?php
require_once('header.php');
if(isset($_SESSION['username'])){
    $username_id = trim($_SESSION['user_id']);
    require_once('dbutil/dbConnection.php');
    if(isset($_POST['purchase'])){
        $sql = "DELETE FROM facture_item
                JOIN facture ON facture.fact_item_id = facture_item.fac_item_id 
                WHERE user_id = ?";
        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "i", $p_username_id);
            $p_username_id = $username_id;
            if(mysqli_stmt_execute($stmt)){
                header('location: ../index.php');
                exit();
            }
            echo "ERROR: " . mysqli_error($conn);
            exit();
        } else {
            mysqli_stmt_close($stmt);
        }
    }
?>
        <title>Thank you for your purchase!</title>
        <style>
            #main_title {
                text-align: center;
            }
            .paid_p {
                text-align: center;
            }
            .container_paid {
                margin: 50px 0;
                position: relative;
                height: 100%;
                width: 100%;
            }
            h2 {
                text-align: center;
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
            .container_information {
                margin: 120px 0;
            }
        </style>
    </head>

        <div class="wrapper">
            <div class="container">
                <div class="container_paid">
                <h1 id="main_title">Thank you for your purchase!</h1>
                    <p class="paid_p">Except your items to arrive shorty!</p>
                </div>
                <div class="container_information">
                    <h2>Items that you ordered</h2>
                    <?php
                        $sql = "SELECT facture.date, facture.sum, laptops.laptop_name, korisnici.username, facture_item.quantity FROM facture 
                                JOIN korisnici ON korisnici.id = facture.user_id
                                JOIN facture_item ON facture_item.fac_item_id = facture.fact_item_id
                                JOIN laptops ON laptops.laptop_id = facture_item.laptop_id WHERE facture.user_id = '$username_id'";
                        if($result = mysqli_query($conn, $sql)){
                                if($stmt = mysqli_query($conn, $sql)) {
                                    if (mysqli_num_rows($result) > 0) {
                    ?>
                    <table class="table table-bordered table-striped tabela">
                            <thead>
                                <tr>
                                    <th>User name</th>
                                    <th>Laptop name</th>
                                    <th>Date ordered</th>
                                    <th>Total price</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                            <?php
                            while($row = mysqli_fetch_array($stmt)) {
                                echo "<tr>";
                                echo "<td>" . $row['username'] . "</td>";
                                echo "<td>" . $row['laptop_name'] . "</td>";
                                echo "<td>" . $row['date'] . "</td>";
                                echo "<td>$" . $row['sum'] . "</td>";
                                echo "<td>" . $row['quantity'] . "</td>";
                                echo "</tr>";
                            }
                            ?>
                            </tbody>
                    </table>
                    <?php
                        } else {
                            echo "ERROR: " . mysqli_error($conn);
                            }
                        } else {
                            echo "ERROR: " . mysqli_error($conn);
                          }
                        }
                    ?>
                    <a href="index.php"><button class="button btn-read-more" type="submit" value="purchase" name="purchase">Back</button></a>
                </div>
            </div>
        </div>
    </body>
</html>
<?php
    require_once('footer.php');
} else {
    header('location: index.php');
    exit();
}
?>
