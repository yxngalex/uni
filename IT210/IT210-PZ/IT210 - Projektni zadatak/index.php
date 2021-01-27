<?php
require_once ('header.php');
?>

<head>
    <title>Home | IT210</title>
</head>

            <div id="sidebar">
                <div class="toggle-btn" onclick="toggleSidebar()">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                <ul>
                    <a href="index.php"><li>Home</li></a>
                    <a href="about.php"><li>About</li></a>
                    <a href="products.php"><li>Products</li></a>
                    <a href="contact.php"><li>Contact</li></a>
                    <a href="<?php if(isset($_SESSION['username'])) { echo "logout.php";} else { echo "login.php"; } ?>"><li><?php if(isset($_SESSION['username'])){ echo "Log out"; } else { echo "Log in"; } ?></li></a>
                    <?php
                    if(isset($_SESSION['username']) && isset($_SESSION['role']) && $_SESSION['role'] == 2){
                        echo "<a href='crud/update.php?username='" . $_SESSION['username'] . "><li>Edit Profile</li></a>";
                    }
                    ?>
                    <?php
                    if(isset($_SESSION['role']) && $_SESSION['role'] == "1"){
                        echo "<a href='details.php'><li>Admin Page</li></a>";
                    }
                    ?>
                </ul>
            </div>

            <div class="wrapper">
                <div class="container">
                    <div class="welcome">
                        <h1 class="welcome_header">Welcome to IT210!</h1>
                        <h2 class="aaa"><?php if(isset($_SESSION['username'])) { echo "Welcome " . $_SESSION['username']; } else { echo "Welcome User !"; }?></h2>
                        <img class="welcome_image" src="images/laptop.png" alt="image of laptop"/>
                        <p class="intro_par">
                            THE BEST SELLING LAPTOP WEBSITE OF 2020!
                        </p>
                    </div>
                    <div class="about_container">
                        <h1>What do we offer?</h1>
                        <p>Most of our clients are satisfied with our products great design, fast performance, longer lifespan,
                            and most importantly excellent price!</p>
                        <h2>Here's some of our products best features:</h2>
                        <ul class="laptop_list">
                            <li>Fast Performance</li>
                            <li>Long lifespan</li>
                            <li>Great Design</li>
                            <li>Brand new O.S.</li>
                            <li>Easy to handle</li>
                        </ul>
                        <a href="about.php"><button class="button btn-read-more" type="button">Read More</button></a>
                    </div>
                    <!----Slider---->
                    <div class="slider">
                        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="images/image1.jpg" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">

                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="images/image2.jpg" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">

                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="images/image3.jpg" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">

                                    </div>
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

            <?php
            require_once ('footer.php');
            ?>
    </body>
</html>