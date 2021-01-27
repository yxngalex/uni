<?php
 require_once('tags/header.php');
 if(isset($_GET['id']) && !empty(trim($_GET['id']))){
     require_once ('dbConnection.php');
?>
        <title>Detalji</title>
        <style type="text/css">
            p {
                font-weight: bold;
                font-family: 'Roboto';
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="container-fluid">
                <p>Opis artikla kojeg ste izabrali : <?php
                        $id_artikla = $_GET['id'];
                        $sql = "SELECT opis_artikla FROM artikli WHERE id = '$id_artikla'";
                        $prikaz = mysqli_query($conn, $sql);
                        $broj_redova = mysqli_num_rows($prikaz);
                        if($broj_redova == 1){
                        while($row = mysqli_fetch_assoc($prikaz)){
                            echo $row['opis_artikla'];
                        }
                        } else {
                            echo "ID nije jedinstven!";
                        }
                    ?>
                </p>
                <br>
                <p>Vlasnik ovog artikla je : <?php
                        $sql = "SELECT vlasnik FROM artikli WHERE id ='$id_artikla'";
                        $prikaz = mysqli_query($conn, $sql);
                        $broj_redova = mysqli_num_rows($prikaz);
                        if($broj_redova == 1){
                            while($row = mysqli_fetch_assoc($prikaz)){
                                echo $row['vlasnik'];
                            }
                        } else {
                            echo "ID nije jedinstven!";
                        }
                        }
                    ?>
                </p>
            </div>
        </div>
    </body>
</html>
