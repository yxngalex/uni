<?php
require_once('header.php');
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] === 1){

?>
<head>

    <title>USER DETAILS | IT210</title>
    <script type="text/javascript">
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
    <style>
        th {
            color: white;
        }
        td {
            color: white;
        }
        a {
            color: white;
        }
    </style>
</head>

<div class="wrapper">
    <div class="container">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header cleafix">
                        <h2>User's details</h2>
                        <p>Only admin has an access on this page!</p>
                            <a href="crud/create.php"><button class="button btn-read-more pull-right" type="button">Add a new user</button></a>
                    </div>
                    <?php
                    require_once ('dbutil/dbConnection.php');
                    $sql = "SELECT * FROM korisnici;";
                    if($result = mysqli_query($conn, $sql)){
                        if($stmt = mysqli_query($conn, $sql)){
                            if(mysqli_num_rows($stmt) > 0){?>
                                <table class="table table-bordered table-striped tabela">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Username</th>
                                        <th>E-mail</th>
                                        <th>Options</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <?php
                                    while($row = mysqli_fetch_array($stmt)){
                                        echo "<tr>";
                                        echo "<td>" .$row['id'] . "</td>";
                                        echo "<td>" .$row['username'] . "</td>";
                                        echo "<td>" .$row['email'] . "</td>";
                                            echo "<td>";
                                            echo "<a href='crud/read.php?id=" . $row['id'] . "' title='View user' data-toggle='tooltip'><i class=\"fa fa-eye\" id='an_eye'></i></a>";
                                            echo "<a href='crud/updateAdmin.php?id=" . $row['id'] . "' title='Update user' data-toggle='tooltip'><i class=\"fa fa-pencil\"></i></a>";
                                            echo "<a href='crud/delete.php?id=" . $row['id'] . "' title='Delete user' data-toggle='tooltip' name='delete'><i class=\"fa fa-trash\"></i></a>";
                                            echo "</td>";
                                        echo "</tr>";
                                    }
                                    ?>
                                    </tbody>
                                </table>
                                <?php
                                mysqli_free_result($result);
                            } else {
                                echo "<h4><em>Database is empty!</em></h4>";
                            }
                        }
                    } else {
                        echo "<h4><em>ERROR</em></h4>";
                    }
                    mysqli_close($conn);
                    ?>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
    <?php
        require_once('footer.php');
} else {
    header("location: index.php" );
    exit();
}
    ?>
</body>
</html>
