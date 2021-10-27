const user = JSON.parse(localStorage.getItem("user"));

console.log(user);

if (user.password.length >= 6 && user.password.length <= 10) {
    console.log("yooo");
    document.getElementById("date").innerHTML = user.date;
} else {
    document.getElementById("date").innerHTML = "Your password must be 6 to 10 characters!";
}