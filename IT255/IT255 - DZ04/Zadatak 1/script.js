let spans = [];
spans[0] = "username-err";
spans[1] = "password-err";
spans[2] = "conf-password-err";
spans[3] = "email-err";
spans[4] = "conf-email-err";
spans[5] = "select-err";

let user = {
    username: "",
    email: "",
    password: "",
    role: "",
    date: new Date
}

function validate(b) {

    b.disabled = true;

    let inputs = [];
    inputs[0] = document.getElementById("username").value;
    inputs[1] = document.getElementById("password").value;
    inputs[2] = document.getElementById("conf-password").value;
    inputs[3] = document.getElementById("email").value;
    inputs[4] = document.getElementById("conf-email").value;
    inputs[5] = document.getElementById("is-admin").value;

    const errors = [];
    errors[0] = "<span style='color: red;'>Please enter your username!</span>";
    errors[1] = "<span style='color: red;'>Please enter your password!</span>";
    errors[2] = "<span style='color: red;'>Please confirm your password!</span>";
    errors[3] = "<span style='color: red;'>Please enter your email!</span>";
    errors[4] = "<span style='color: red;'>Please confirm your email!</span>";
    errors[5] = "<span style='color: red;'>Please select your role!</span>";

    let count = 0;

    for (let i in inputs) {
        let errMessage = errors[i];
        let span = spans[i];
        if (inputs[i] === "" || inputs[i] === null) {
            document.getElementById(span).innerHTML = errMessage;
        } else {
            document.getElementById(span).innerHTML = "";
            count++;
        }
    }

    if (inputs[1] !== inputs[2]) {
        document.getElementById("conf-password-err").innerHTML = "Password doesn't match!";
    } else {
        document.getElementById("conf-password-err").innerHTML = "";
        count += 1;
    }

    if (inputs[3] !== inputs[4]) {
        document.getElementById("conf-email-err").innerHTML = "Email doesn't match!";
    } else {
        document.getElementById("conf-email-err").innerHTML = "";
        count += 1;
    }

    if (count === 8) {
        document.getElementById("success").innerHTML = "<span style='color: green'>Everything is OK!</span>";
        user.username = inputs[0];
        user.password = inputs[1];
        user.email = inputs[3];
        if (inputs[5] === "Admin") {
            user.role = "Admin";
        } else {
            user.role = "User";
        }
        localStorage.setItem("user", JSON.stringify(user));
        window.location.replace("success.html");
        document.getElementById("select-err").innerHTML = "";
    } else {
        document.getElementById("success").innerHTML = "";
    }

    setTimeout(() => {
        b.disabled = false;
    }, 2000);
}
