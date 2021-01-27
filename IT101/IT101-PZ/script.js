function show1(){
    document.getElementById('over1').style.visibility = "visible";
    // document.getElementById('slika1').style.visibility = "hidden";
}

function hide1(){
    document.getElementById('over1').style.visibility = "hidden";
//     document.getElementById('slika1').style.visibility = "visible";
}

function show2(){
    document.getElementById('over2').style.visibility = "visible";
    // document.getElementById('slika1').style.visibility = "hidden";
}

function hide2(){
    document.getElementById('over2').style.visibility = "hidden";
//     document.getElementById('slika1').style.visibility = "visible";
}

function show3(){
    document.getElementById('over3').style.visibility = "visible";
    // document.getElementById('slika1').style.visibility = "hidden";
}

function hide3(){
    document.getElementById('over3').style.visibility = "hidden";
//     document.getElementById('slika1').style.visibility = "visible";
}

//KONTAKT

function validateForm() {
    var name = document.forms["myForm"]["Name"];
    var lastname = document.forms["myForm"]["Lastname"];
    var naslov = document.forms["myForm"]["Naslov"];
    var textarea = document.forms["myForm"]["Textarea"];
    var number = document.forms["myForm"]["Number"];

    if(name.value = ""){
        window.alert("Molimo vas unesite vase ime!!");
        name.focus();
        return false;
    }
    if(lastname.value = ""){
        window.alert("Molimo vas unesite vase prezime!!");
        lastname.focus();
        return false;
    }
    if(naslov.value = ""){
        window.alert("Molimo vas unesite naslov!!");
        naslov.focus();
        return false;
    }
    if(textarea.value = ""){
        window.alert("Molimo vas popunite textarea!!");
        textarea.focus();
        return false;
    }
    if(number.value = ""){
        window.alert("Molimo vas unesite vas broj telefona!!");
        number.focus();
        return false;
    }

    return true;
}