angleMode = "radians";
var PI_2 = 1 / 2 * PI;

var Pendulum = function (origin, armLength) {
    this.origin = origin;
    this.armLength = armLength;
    this.position = new PVector();
    this.angle = PI_2;

    this.aVelocity = 0.0;
    this.aAcceleration = 0.0;

    this.damping = 0.995;
    this.ballRadius = 48.0;
    this.dragging = false;
};

Pendulum.prototype.go = function () {
    this.update();
    this.display();
};

Pendulum.prototype.update = function () {
    if (!this.dragging) {
        var gravity = 0.4;
        // Calculate acceleration (see: http://www.myphysicslab.com/pendulum1.html)
        this.aAcceleration = (-1 * gravity / this.armLength) * sin(this.angle);
        this.aVelocity += this.aAcceleration;
        this.aVelocity *= this.damping;
        this.angle += this.aVelocity;
    }
};

Pendulum.prototype.display = function () {
    this.position = new PVector(
        this.armLength * sin(this.angle),
        this.armLength * cos(this.angle));
    this.position.add(this.origin);
    stroke(0, 0, 0);
    fill(163, 92, 0);
    strokeWeight(2);
    rect(this.origin.x - 150, this.origin.y - 50, 300, 50);
    rect(this.origin.x - 150, this.origin.y, 50, this.armLength + this.ballRadius / 2);

    rect(this.origin.x + 100, this.origin.y, 50, this.armLength + this.ballRadius / 2);
    stroke(163, 92, 0);
    line(this.origin.x - 148.5, this.origin.y, this.origin.x - 103, this.origin.y);
    line(this.origin.x + 147.0, this.origin.y, this.origin.x + 102, this.origin.y);
    stroke(0);

    line(this.origin.x, this.origin.y, this.position.x, this.position.y);
    fill(20, 54, 204);
    if (this.dragging) {
        fill(0, 166, 144);
    }
    ellipse(this.position.x, this.position.y, this.ballRadius, this.ballRadius);
};

Pendulum.prototype.handleClick = function (mx, my) {
    var d = dist(mx, my, this.position.x, this.position.y);
    if (d < this.ballRadius) {
        this.dragging = true;
    }
};

Pendulum.prototype.stopDragging = function () {
    this.aVelocity = 0;
    this.dragging = false;
};

Pendulum.prototype.handleDrag = function (mx, my) {
    if (this.dragging) {
        var diff = PVector.sub(this.origin, new PVector(mx, my));
        this.angle = atan2(-1 * diff.y, diff.x) - PI / 2;
    }
};

var p = new Pendulum(new PVector(200, 90), 200);

var draw = function () {
    background(255);
    p.go();
};

mousePressed = function () {
    p.handleClick(mouseX, mouseY);
};

mouseDragged = function () {
    p.handleDrag(mouseX, mouseY);
};

mouseReleased = function () {
    p.stopDragging();
};



/*
angleMode = "radians";

var Pendulum  = function(origin, armLength) {
    this.origin = origin;
    this.armLength = armLength;
    this.position = new PVector();
    this.angle = PI/4;
    
    this.aVelocity = 0.0;
    this.aAcceleration = 0.0;
    this.damping = 0.995;
    this.ballRadius = 24.0;      
    this.dragging = false;
};

Pendulum.prototype.go = function() {
    this.update();
    this.display();
};

Pendulum.prototype.update = function() {
    if (!this.dragging) {
        var gravity = 0.4;
        this.aAcceleration = (-1 * gravity / this.armLength) * sin(this.angle);
        this.aVelocity += this.aAcceleration;

        this.aVelocity *= this.damping;
        this.angle += this.aVelocity;                         
    }
};

Pendulum.prototype.display = function() {

    this.position = new PVector(
       this.armLength * sin(this.angle),
       this.armLength * cos(this.angle));
    this.position.add(this.origin);
    stroke(0, 0, 0);
    strokeWeight(2);

    line(this.origin.x, this.origin.y, this.position.x, this.position.y);
    fill(175, 175, 175);
    if (this.dragging) {
        fill(0, 0, 0);
    }

    ellipse(this.position.x, this.position.y, this.ballRadius*2, this.ballRadius*2);
};

Pendulum.prototype.handleClick = function(mx, my) {
    var d = dist(mx, my, this.position.x, this.position.y);
    if (d < this.ballRadius) {
        this.dragging = true;
    }
};

Pendulum.prototype.stopDragging = function() {
    if (this.dragging) {
        this.aVelocity = 0; // No velocity once you let go
        this.dragging = false;
    }
};

Pendulum.prototype.handleDrag = function(mx, my) {
    if (this.dragging) {
      var diff = PVector.sub(this.origin, new PVector(mx, my));
      this.angle = atan2(-1*diff.y, diff.x) - PI/2;
    }
};

var p = new Pendulum(new PVector(width/2, 0), 175);

draw = function() {
    background(255);
    p.go();
};

mousePressed = function() {
    p.handleClick(mouseX, mouseY);
};

mouseDragged = function() {
    p.handleDrag(mouseX, mouseY);
};

mouseReleased = function() {
    p.stopDragging();
};
*/