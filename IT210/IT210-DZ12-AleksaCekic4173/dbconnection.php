<?php
define('DB_SERVER', 'localhost');
define('DB_USERNAME', 'root');
define('DB_PASSWORD','');
define('DB_NAME','it210dz12');
define('DB_PORT','3306');

$conn = mysqli_connect(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME, DB_PORT);

if($conn === false){
    die("ERROR: Connection has been lost!" . mysqli_connect_error());
}
?>