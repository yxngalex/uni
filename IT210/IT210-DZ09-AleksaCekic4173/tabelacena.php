<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IT210-DZ09</title>
    <style>
      body{
          background-color: #f2f2f2;
          font-family: sans-serif;
      }
      table {
        font-size: 25px;
        border-style: solid;
      }
      th {
        background-color: black;
        color: white;
      }
      tr:nth-child(even) {
        background-color: #f2f2f2
      }
      button {
        background-color: coral;
        color: white;
        padding: 10px 24px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        cursor: pointer;
      }
    </style>
  </head>
    <body>
      <table>
        <tr>
          <th>ID</th>
          <th>Naziv Proizvoda</th>
          <th>Lokacija Proizvoda</th>
          <th>Cena Proizvoda</th>
        </tr>
        <?php
          $conn = mysqli_connect("localhost", "root", "", "roba", "3306");
            if ($conn->connect_error) {
              die("Konekcija je izgubljena: " . $conn->connect_error);
            }
            $sql = "SELECT id, naziv_proizvoda, lokacija_proizvoda, cena_proizvoda FROM proizvodi ORDER BY cena_proizvoda DESC";
            $result = $conn->query($sql);
              if ($result->num_rows > 0) {
                while($row = $result->fetch_assoc()) {
                    echo "<tr><td>" . $row["id"]. "</td><td>"
                    . $row["naziv_proizvoda"] . "</td><td>"
                    . $row["lokacija_proizvoda"]. "</td><td>"
                    . $row["cena_proizvoda"].  "</td></tr>";
                  }
                  echo "</table>";
                } else {
                  echo "Nema rezultata";
                  }
            $conn->close();

          ?>
      </table><br>
      <div style="font-size:30px; font-weight: bold;">

      <?php
      
      $conn = mysqli_connect("localhost", "root", "", "roba", "3306");
        if ($conn->connect_error) {
          die("Konekcija izgubljena: " . $conn->connect_error);
        }
        $sql = "SELECT MAX(cena_proizvoda) AS maximum FROM proizvodi";
        $resultMax = $conn->query($sql);
        $row = $resultMax->fetch_assoc();
        $maximum = $row['maximum'];
        echo ("Trenutna najveca cena proizvoda je: $maximum");

        $sql = "SELECT MIN(cena_proizvoda) AS minimum FROM proizvodi";
        $resultMin = $conn->query($sql);
        $row = $resultMin->fetch_assoc();
        $minimum = $row['minimum'];
        echo nl2br ("\n Trenutna najmanja cena proizvoda je: $minimum \n");

       ?>

       </div>
      <form class="" action="tabela.php" method="post"><br>
        <button type="submit" class="btn2" name="submit">Nazad</button>
      </form>
    </body>
</html>
