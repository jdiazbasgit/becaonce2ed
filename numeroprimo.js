primos = [1, 2, 3]

function numerosPrimos() {
   
    for (i = 4; i < 100; i++) {
        soyPrimo = true
        for (j = i-1; j > 1; j--) {
            if (i % j == 0) {
                soyPrimo = false;
                break
            }
        }
        if (soyPrimo) {
            primos.push(i)
        }
    }
    console.log(primos)
    
}




