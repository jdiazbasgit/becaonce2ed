const operador = (num1, num2, signo, callback) => {
    return callback(num1, num2, signo);
}

function resultado(signo) {
    numero1 = document.querySelector("#numero1").value;
    numero2 = document.querySelector("#numero2").value;

    operador(numero1, numero2, signo, (a, b, signo) => {
        a = parseInt(a);
        b = parseInt(b);
        var out;
        switch (signo) {
            case "+":
                out = a + b;
                break
            case "-":
                out = a - b;
                break
            case "*":
                out = a * b;
                break
            case "/":
                out = a / b;
                break
        }

        document.querySelector("#out").innerHTML = out;

    })
}