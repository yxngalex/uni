<?php

  define('DB_SERVER', 'localhost');
  define('DB_USERNAME', 'root');
  define('DB_PASSWORD', '');
  define('DB_NAME', 'roba');
  define('DB_PORT', '3306');

  $conn = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME, DB_PORT);

  if($conn === false) {
    die("GRESKA: Veza se nije uspostavila!" . mysqli_connect_error());
  }

 ?>
