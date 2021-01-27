<?php
require_once "dbConnection.php";
if (isset($_POST['submit'])) {

    $id = mysqli_real_escape_string($conn, $_POST['id']);
    $naziv_proizvoda = mysqli_real_escape_string($conn, $_POST['naziv_proizvoda']);
    $lokacija_proizvoda = mysqli_real_escape_string($conn, $_POST['lokacija_proizvoda']);
    $cena_proizvoda = mysqli_real_escape_string($conn, $_POST['cena_proizvoda']);

    $sql = "INSERT INTO proizvodi (id, naziv_proizvoda, lokacija_proizvoda, cena_proizvoda)
       VALUES ('$id', '$naziv_proizvoda', '$lokacija_proizvoda', '$cena_proizvoda')";

    if (mysqli_query($conn, $sql)) {
        echo "Uspesno ste ubacili nov proizvod u bazi!";
    } else {
        echo "Greska: " . $sql . ":-" . mysqli_error($conn);
    }
    mysqli_close($conn);
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"></script>
    <title>IT210-DZ09</title>
    <style>
        body {
            background-color: #f2f2f2;
        }

        form {
            font-size: 20px;
            font-family: sans-serif;
        }

        button {
            background-color: coral;
            color: black;
            padding: 10px 50px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
        }
        h2 {
            font-family: sans-serif;
            font-size: 30px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2>Unesite proizvod u bazu!</h2><br>
<form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST"><br>
    <label>ID Proizvoda: </label>
    <input type="int" name="id"><br><br>
    <label>Naziv Proizvoda: </label>
    <input type="text" name="naziv_proizvoda"><br><br>
    <label>Trenutna Lokacija Proizvoda: </label>
    <input type="text" name="lokacija_proizvoda"><br><br>
    <label>Cena Proizvoda: </label>
    <input type="number" name="cena_proizvoda"><br><br>

    <button type="submit" class="btn" name="submit">Dodaj Proizvod</button>
</form>
<form action="tabela.php" method="post">
    <button type="submit" class="btn2" name="submit">Prikazi Proizvode</button>
</form>
</body>
</html>