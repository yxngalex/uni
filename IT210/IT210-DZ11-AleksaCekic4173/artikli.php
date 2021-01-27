<?php
require_once('tags/header.php');
require_once('dbConnection.php');
?>
        <style type="text/css">
            td, a {
                text-align: center;
                font-size: 15px;
                text-decoration: none;
                text-decoration-color: black;
            }
            th {
                text-align: center;
                font-size: 20px;
                font-weight: bold;

            }

        </style>

    </head>
    <body>
        <div class="wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="mid-col-12">
                        <?php
                        require_once('dbConnection.php');
                        $sql = "SELECT id, naziv_artikla FROM artikli";
                        if($result = mysqli_query($conn,$sql)){
                            if(mysqli_num_rows($result) > 0) {?>
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th>Naziv Artikla</th>
                                    <th>Opcija</th>
                                </tr>
                            </thead>
                            <tbody>
                            <?php
                            while($row = mysqli_fetch_array($result)){
                                echo "<tr>";
                                    echo "<td>" . "<a href='detaljniartikli.php?id=" . $row['id'] . "'>" . $row['naziv_artikla'] . "</a>" . "</td>";
                                    echo "<td>";
                                        echo "<a href='delete.php?id=" . $row['id'] . "'  title='Delete user' data-toggle='tooltip'><span class='glyphicon glyphicon-trash'></span></a>";
                                    echo "</td>";
                                echo "</tr>";
                            }
                            ?>
                            </tbody>
                        </table>
                        <?php
                            mysqli_free_result($result);
                            } else {
                                echo "<h4> <em>Nista nije pronadjeno</em>";
                            }
                        } else {
                                echo "<h4>Greska</h4>" . mysqli_error($conn);
                        }
                        mysqli_close($conn);
                        ?>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
