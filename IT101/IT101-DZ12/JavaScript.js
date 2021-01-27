function rezultat() {
    var arr = document.getElementsByClassName("input");
    var suma = 0;
    var n = document.getElementById('N').value;
    
    for (var i = 0; i < arr.length; i++) {
        suma += parseFloat(arr[i].value);

    }
    suma = suma - n;
    document.getElementById('U').innerHTML = suma;
}