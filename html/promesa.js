sinPromesa = () => {
  dejarMovilEnTienda = true;
  movilroto = true;
  setTimeout(() => {
    movilroto = false;
    console.log("el movil esta arrglado, puedes venir a recogerlo");
  }, 5000);
  if (movilroto) console.log("no puedo llamar, el movil esta roto");
  else console.log("hola cariño como estas");
};

async function conPromesa () => {
    /*dejoElMovil().then((result) => {
    console.log(result);
    if (movilroto) console.log("no puedo llamar, el movil esta roto");
    else console.log("hola cariño como estas");
  });*/
  const result=await dejoElMovil();
  console.log(result);
  if (movilroto) console.log("no puedo llamar, el movil esta roto");
  else console.log("hola cariño como estas");
};

dejoElMovil = () => {
  return new Promise((resolve) => {
    setTimeout(() => {
      movilroto = false;
      resolve("el movil esta arreglado, puedes venir a recogerlo");
    }, 5000);
  });
};
