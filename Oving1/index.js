/**
 * Denne filen skal løse tre oppgaver:
 *
 *
 * 1) Knapp som endrer en verdi
 * 2) Knapp som skjuler/viser innhold
 * 3) Opprett et array med tilfeldig stikkord, og gjengi innholdet som en liste på nettsiden.
 */


// 1
let value = 0;

let incrementTxt = document.querySelector('.increment p');
incrementTxt.textContent = value.toString();

let incrementBtn = document.querySelector('.increment button');
incrementBtn.onclick = function() {
    value++;
    incrementTxt.textContent = value.toString();
};


// 2
let secretTxt = document.querySelector('.secret h3');
let secretBtn = document.querySelector('.secret button');
secretBtn.onclick = function () {
    if(secretTxt.style.display === "block") {
        secretTxt.style.display = "none";
        secretBtn.textContent = "Vis tekst"
    } else {
        secretTxt.style.display = "block";
        secretBtn.textContent = "Skjul tekst"
    }

}


// 3
let arr = ["Det første punktet", "Et punkt til", "Det siste poenget er"];
let container = document.querySelector('.array ul');
arr.map((point) => {
    container.appendChild(document.createElement("li")).textContent = point;
})
