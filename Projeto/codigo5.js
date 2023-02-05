function inserir(valor) {
    var valor1 = document.getElementById("campo1").value;
    var valor2 = document.getElementById("campo2").value;
    var valor3 = document.getElementById("campo3").value;
    var valor4 = document.getElementById("campo4").value;
    var valor5 = document.getElementById("campo5").value;

    if (valor1 == "") {
        document.getElementById("campo1").value = valor;
    } else if (valor2 == "") {
        document.getElementById("campo2").value = valor;
    }
}

function corrige() {
    document.getElementById("campo1").value = "";
    document.getElementById("campo2").value = "";
    document.getElementById("campo3").value = "";
    document.getElementById("campo4").value = "";
    document.getElementById("campo5").value = "";
}


function votar() {

    var valor1 = parseInt(document.getElementById("campo1").value);
    var valor2 = parseInt(document.getElementById("campo2").value);
    var candidado = (valor1 * 10) + valor2;
    if (sessionStorage.getItem(candidado) !== null) {
        votos = parseInt(sessionStorage.getItem(candidado)) + 1;
        sessionStorage.setItem(candidado, votos);
    } else {
        sessionStorage.setItem(candidado, 1);
        
    }
    alert("Confirmado voto no candidato "+candidado)
    document.getElementById("campo1").value = "";
    document.getElementById("campo2").value = "";
}

function resultado() {
    document.getElementById("resultado").innerHTML=""
    for(i=0;i<100;i++){
        if (sessionStorage.getItem(i) !== null) {
            //alert(i);
            document.getElementById("resultado").innerHTML += "Cantidado "+i+" tem "+sessionStorage.getItem(i)+" votos<br/>";
        }
    }
}