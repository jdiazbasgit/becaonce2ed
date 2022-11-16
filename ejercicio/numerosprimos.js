function numerosprimos() {
    numero = primos;
    primos = 100;

    for (let i = 0; i > primos; i--) {

        if (i % 1 == 0)
            document.querySelector("#tabla").innerHTML = document.querySelector("#tabla").innerHTML + primos.substring(i, i + 1)

    }
}