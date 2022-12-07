function update() {
    let angle = 0
    lastanglemag = Math.abs(Math.sin(angle));
    angle += .1;

    pendulum.angle = Math.sin(angle);

    currentanglemag = Math.abs(pendulum.angle);

    if (currentanglemag > lastanglemag && currentanglemag > Math.abs(Math.sin(angle + 0.1))) {
        console.log("pendulum is at its maximum")
    }

    requestAnimationFrame(update)
}

update();