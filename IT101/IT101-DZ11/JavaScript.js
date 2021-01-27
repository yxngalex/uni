function rezultat() {
    var arr = document.getElementsByClassName("input");
    var suma = 0;
    var n = document.getElementById('N').value;


    for (var i = 0; i < arr.length; i++) {
        suma += parseFloat(arr[i].value);

    }
    suma = suma - n;
    document.getElementById('U').innerHTML = suma;


    if (suma >= 35) {
        var x = " ";
        x1 = " Aleksa Cekic ima uslov za ispit";
        x = x1.fontcolor("green");
    }
    else {
        x2 = " Aleksa Cekic nema uslov za ispit"
        x = x2.fontcolor("red");

    }

    document.getElementById("uslov").innerHTML = x;


}
function ocena() {
    var arr = document.getElementsByClassName("input");
    var suma = 0;
    var n = document.getElementById('N').value;
    for (var i = 0; i < arr.length; i++) {
        suma += parseFloat(arr[i].value);

    }
    suma = suma - n;

    var ispit = document.getElementById("ispit").value;
    var ukupno = parseFloat(suma) + parseFloat(ispit);

    if (ukupno <= 50) {
        var y = " ";
        y = "Ocena: 5"
    } else if (ukupno < 61 && ukupno > 50) {
        y = "Ocena: 6";
    }
    else if (ukupno < 71 && ukupno > 60) {
        y = "Ocena: 7";
    }
    else if (ukupno < 81 && ukupno > 70) {
        y = "Ocena: 8";
    }
    else if (ukupno < 91 && ukupno > 80) {
        y = "Ocena: 9";
    }
    else if(ukupno < 100 && ukuono > 90) {
        y = "Ocena: 10";
    }else{
        y = " ";
    }
    document.getElementById("ocena").innerHTML = y;
}
