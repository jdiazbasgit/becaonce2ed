primos =[1, 2, 3]
function numeroPrimos() {
   for (let i = 4; i < 100; i++) {
      soyPrimo = true

      for (let j = i - 1; j > 1; j--) {
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

