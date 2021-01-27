<?php
require_once('header.php');
if($_SERVER['REQUEST_METHOD'] == "POST"){
    require_once('dbutil/dbConnection.php');

    $firstname = $_POST['firstname'];
    $lastname = $_POST['lastname'];
    $email = trim($_POST['email']);
    $subject = $_POST['subject'];
    $textarea = $_POST['textarea'];

    $sql = "INSERT INTO contact(firstname, lastname, email, subject, textarea) 
            VALUES(?,?,?,?,?)";

    if($stmt =mysqli_prepare($conn, $sql)){
        mysqli_stmt_bind_param($stmt, 'sssss', $param_fn, $param_ln, $param_email, $param_sub, $param_ta);
        $param_fn = $firstname;
        $param_ln = $lastname;
        $param_email = $email;
        $param_sub = $subject;
        $param_ta = $textarea;
        if(mysqli_stmt_execute($stmt)){
            echo "Your message has been sent successfully!";
            echo "<br>";
        } else {
            echo "There was an error while sending your message!";
            echo "<br>";
        }
    }
    mysqli_close($conn);
}
?>

    <head>
        <title>CONTACT | IT210</title>
    </head>

        <div class="wrapper">
            <div class="container">
                <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF'])?>" method="POST">
                    <h1>Do you have any complaints?</h1><br>
                    <p class="hes">Don't hesitate to contact us via this contact form below!</p>
                    <div class="form-group">
                        <label>First Name</label>
                        <input type="text" class="form-control" name="firstname" required placeholder="First Name*">
                    </div>
                    <div class="form-group">
                        <label>Last Name</label>
                        <input type="text" class="form-control" name="lastname" required placeholder="Last Name*">
                    </div>
                    <div class="form-group">
                        <label>Email address</label>
                        <input type="text" class="form-control" name="email" required placeholder="Email Address*">
                    </div>
                    <div class="form-group">
                        <label>Subject</label>
                        <input type="text" class="form-control" name="subject" required placeholder="Subject*">
                    </div>
                    <div class="form-group">
                        <label>Your Message</label>
                        <textarea rows="22" cols="158" minlength="5" maxlength="300" placeholder="Please leave your message here. Min 5 characters. Max 300 characters." name="textarea"></textarea>
                    </div>
                    <div class="form-group">

                        <a href="#"><button class="button btn-submit" type="submit">Submit</button></a>
                        <a href="#"><button class="button btn-reset" type="reset">Reset</button></a>
                    </div><br><br>
                    <div class="contact-form">
                        <p>Do you have any more questions?</p>
                        <p>Make sure you contact us on our email: abraham.lincoln1865@zimbra.ac.rs</p>
                        <p>Phone Number #1: +381 999 899</p>
                        <p>Phone Number #2: +381 420 690</p>
                        <p>Phone Number #3: +381 133 769</p>
                        <p>If you have any ideas you'd like to personally discuss, <a href="https://www.google.com/maps/place/%D0%9C%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B0%D0%BD/@43.3070309,21.9469006,19.25z/data=!4m13!1m7!3m6!1s0x4755b0b3ec7cb9a7:0xf513b5a4e0503ea7!2z0KbQtdC90YLQsNGALCDQndC40Yg!3b1!8m2!3d43.3186073!4d21.8911924!3m4!1s0x4755b06571362991:0x25d6cceab952b797!8m2!3d43.3070305!4d21.9472396" target="_blank">click here</a> to see where our headquarters is located!</p>
                    </div>
                </form>
            </div>
        </div>
    <?php
    require_once('footer.php');
    ?>
    </body>
</html>
