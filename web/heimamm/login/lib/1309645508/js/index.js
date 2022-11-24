function _defineProperty(obj, key, value) {
    if (key in obj) {
        Object.defineProperty(obj, key, {value: value, enumerable: true, configurable: true, writable: true});
    } else {
        obj[key] = value;
    }
    return obj;
}

var accentcolor = document.getElementById("accentcolor");

document.addEventListener("click", changeWidth);

function changeWidth(e) {
    accentcolor.style = "width: " + e.clientX + "px;";
}

// Particles with mojs

// count = 10 seems to be the magic number for  performance on mobile and older devices

var innerRadius = void 0;
var outerRadius = void 0;
var smallSize = 20;
var bigSize = 25;

function setRadius() {
    if (window.innerWidth <= 425) {
        innerRadius = parseInt(window.innerWidth * 0.1);
        outerRadius = parseInt(window.innerWidth * 0.6);
    } else if (window.innerWidth > 425 && window.innerWidth < 1080) {
        innerRadius = parseInt(window.innerWidth * 0.07);
        outerRadius = parseInt(window.innerWidth * 0.28);
    } else if (window.innerWidth > 1080) {
        innerRadius = parseInt(window.innerHeight * .15);
        outerRadius = parseInt(window.innerHeight * .3);
    } else {
    }
}

setRadius();
var DURATION = 1000;
var count = 15;

var smoke = new mojs.Burst({
    opacity: .7,
    parent: "#accentcolor",
    left: 0, top: 0,
    degree: 270,
    angle: -135,
    count: count,
    radius: _defineProperty({}, innerRadius, outerRadius),
    children: {
        fill: ['var(--prim)', "var:(--prim)"],
        pathScale: 'rand(0.5, 1)',
        radius: 'rand(12, 13)',
        swirlSize: 'rand(20, 25)',
        swirlFrequency: 'rand(2, 4)',
        direction: [1, -1],
        duration: "rand(" + 1 * DURATION + ", " + 2 * DURATION + ")",
        delay: 'rand(0, 2000)',
        easing: 'quad.out',
        isSwirl: true,
        isForce3d: true
    }
});

var smokeBefore = new mojs.Burst({
    opacity: .7,
    parent: "#accentcolor",
    left: 0, top: 0,
    degree: 270,
    angle: -135,
    count: count,
    radius: _defineProperty({}, innerRadius, outerRadius),
    children: {
        fill: ['#var(--prim1)', "var(--prim1)"],
        pathScale: 'rand(0.5, 1)',
        radius: 'rand(12, 13)',
        swirlSize: "rand(20, 25)",
        swirlFrequency: 'rand(2, 4)',
        direction: [1, -1],
        duration: "rand(" + 1 * DURATION + ", " + 2 * DURATION + ")",
        delay: 'rand(0, 2000)',
        easing: 'quad.out',
        isSwirl: true,
        isForce3d: true
    }
});

smokeBefore.tune({x: "50vw", y: "50vh"}).generate().replay();
smoke.tune({x: "50vw", y: "50vh"}).generate().replay();

var leftParticles = new mojs.Tween({
    repeat: 99999,
    delay: 3000,
    onUpdate: function onUpdate() {
        smokeBefore.tune({x: "50vw", y: "50vh"}).generate().replay();
    }
}).play();

var rightParticles = new mojs.Tween({
    repeat: 99999,
    delay: 3000,
    onUpdate: function onUpdate() {
        smoke.tune({x: "50vw", y: "50vh"}).generate().replay();
    }
}).play(500);

let deg = -90;
let app = 3;

const toRgb = col => {
    var schemeColor = col.split(" ");
    schemeColor = schemeColor.map(function (c) {
        return Math.ceil(c * 255);
    });

    return `rgb(${schemeColor.join(", ")})`;
};

window.wallpaperPropertyListener = {
    applyUserProperties: properties => {
        if (properties.schemecolor)
            document.documentElement.style.setProperty("--primary", toRgb(properties.schemecolor.value));
        if (properties.accentcolor)
            document.documentElement.style.setProperty("--secondary", toRgb(properties.accentcolor.value));
        if (properties.body)
            document.documentElement.style.setProperty("--sec", toRgb(properties.body.value));
        if (properties.smoke)
            document.documentElement.style.setProperty("--prim", toRgb(properties.smoke.value));
        if (properties.smokeBefore)
            document.documentElement.style.setProperty("--prim1", toRgb(properties.smokeBefore.value));

    }
};

document.addEventListener("DOMContentLoaded", () => {
    let interval = setInterval(() => {
        document.documentElement.style.setProperty("--angle", deg + "deg");

        deg += app;
        app = Math.max(app - 0.02, 0.025);
    }, 5);
}, false);