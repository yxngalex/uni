<?php
require_once('tags/header.php');
if (isset($_GET['id']) && !empty(trim($_GET['id']))){
require_once('dbConnection.php');
?>
    <style>
        a {
            font-size: 26px;
            text-decoration-color: black;
            font-family: 'Roboto';
            font-weight: bold;
        }
    </style>
    <title>Izbrisi artikal</title>
</head>
<body>
<p><?php
    $sql = "DELETE FROM artikli WHERE id= ?";
    if ($stmt = mysqli_prepare($conn, $sql)) {
        mysqli_stmt_bind_param($stmt, "i", $param_id);
        $param_id = trim($_GET['id']);
        if (mysqli_stmt_execute($stmt)) {
            echo "Uspesno je izbrisan artikal sa id-om : " . $param_id;
            echo "<br><a href='artikli.php'>" . "Link za prethodnu stranu" . "</a>";
        } else {
            echo "Doslo je do greske prilikom brisanja!";
        }
    }
    mysqli_close($conn);
    }
    ?>
</p>
</body>
</html>
