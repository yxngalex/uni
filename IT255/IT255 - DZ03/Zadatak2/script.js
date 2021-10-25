document.getElementById("plus").onclick = () => {
    let firstNum = parseInt(document.getElementById("first").value);
    let secondNum = parseInt(document.getElementById("second").value);
    let result = document.getElementById("result");

    result.value = firstNum + secondNum;
}

document.getElementById("minus").onclick = () => {
    let firstNum = parseInt(document.getElementById("first").value);
    let secondNum = parseInt(document.getElementById("second").value);
    let result = document.getElementById("result");

    result.value = firstNum - secondNum;
}

document.getElementById("multiply").onclick = () => {
    let firstNum = parseInt(document.getElementById("first").value);
    let secondNum = parseInt(document.getElementById("second").value);
    let result = document.getElementById("result");

    result.value = firstNum * secondNum;
}

document.getElementById("divide").onclick = () => {
    let firstNum = parseInt(document.getElementById("first").value);
    let secondNum = parseInt(document.getElementById("second").value);
    let result = document.getElementById("result");

    result.value = firstNum / secondNum;
}
