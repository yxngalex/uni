<?php
    require_once 'tags/header.php';
    if($_SERVER['REQUEST_METHOD'] == "POST"){
        require_once 'dbConnection.php';

        $ime = trim($_POST['ime']);
        $prezime = trim($_POST['prezime']);
        $godine = trim($_POST['godine']);
        $naziv_artikla = trim($_POST['naziv_artikla']);
        $opis_artikla = trim($_POST['opis_artikla']);
        $vlasnik = trim($_POST['vlasnik']);

        $sql = "INSERT INTO korisnici (ime, prezime, godine)
              VALUES (?, ?, ?)";

        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "ssi", $ime, $prezime, $godine);
            $param_ime = $ime;
            $param_prezime = $prezime;
            $param_godine = $godine;
            if(mysqli_stmt_execute($stmt)){
                echo "Uspesno ste uneli korisnika u bazu!";
                echo "<br>";
            } else {
                echo "Doslo je do greske prilikom unosenja korisnika";
                echo "<br>";
            }
        }

        $sql = "INSERT INTO artikli (naziv_artikla, opis_artikla, vlasnik)
              VALUES (?, ?, ?)";

        if($stmt = mysqli_prepare($conn, $sql)){
            mysqli_stmt_bind_param($stmt, "sss", $naziv_artikla, $opis_artikla, $vlasnik);
            $param_naziv = $naziv_artikla;
            $param_opis = $opis_artikla;
            $param_vlasnik = $vlasnik;
            if(mysqli_stmt_execute($stmt)){
                echo "Uspesno ste uneli artikal u bazu!";
                echo "<br>";
            } else {
                echo "Doslo je do greske prilikom unosenja artikla";
                echo "<br>";
            }
        }
    }
?>
            <style type="text/css">

                a{
                    text-decoration: none;

                }

            </style>

            <script type="text/javascript"></script>
            <title>Index</title>
    </head>
    <body>
         <div class="wrapper">
             <h2>Unesite Korisnika u bazu!</h2><br>
             <p>Morate popuniti sva polja za unos korisnika!</p>
             <form action="<?php $_SERVER['PHP_SELF']?>" method="POST">
                 <div class="form-group">
                         <label>Ime</label>
                         <input type="text" class="form-container" name="ime">
                 </div>
                 <div class="form-group">
                         <label>Prezime</label>
                         <input type="text" class="form-container" name="prezime">
                 </div>
                 <div class="form-group">
                         <label>Koliko korisnik ima Godina?</label>
                         <input type="text" class="form-container" name="godine">
                 </div>
             <br>
             <h2>Unesite podatke o artiklu u bazu!</h2>
             <p>Morate uneti sve podatke</p>
                 <div class="form-group">
                     <label>Naziv Artikla</label>
                     <input type="text" class="form-container" name="naziv_artikla">
                 </div>
                 <div class="form-group">
                     <label>Opis artikla:</label>
                     <input type="text" class="form-container" name="opis_artikla">
                 </div>
                 <div class="form-group">
                     <label>Vlasnik ovog artikla:</label>
                     <select name="vlasnik">
                         <?php
                            require_once "dbConnection.php";
                            $sql = "SELECT ime, prezime FROM korisnici";
                            $prikaz = mysqli_query($conn, $sql);
                            $broj_redova = mysqli_num_rows($prikaz);
                         ?>
                         <?php
                            if($broj_redova > 0){
                                while($row = mysqli_fetch_assoc($prikaz)){
                                    ?>
                         <option value="<?php echo $row['ime'];?>"><?php echo $row['ime'] . " " . $row['prezime']; ?></option>
                         <?php
                                }
                            }
                            mysqli_close($conn);
                         ?>
                     </select>
                 </div>
                 <input type="Submit" class="btn btn-primary" name="submit">
                 <p>Pogledajte listu artikla <a href="artikli.php">ovde</a>.</p>
             </form>
         </div>
    </body>
</html>
