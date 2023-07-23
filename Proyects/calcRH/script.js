let num1 = 0;
let num2 = 0;
let res = 0;
const divRes = document.getElementById("06");


function queryData() {
  num1 = Number(prompt("Ingresa el primer numero"));
  num2 = Number(prompt("Ingresa el segundo numero"));
}

function sumar() {
  res = num1 + num2
  modificarRes()
}

function restar() {
  res = num1 - num2
  modificarRes()
}
function multiplicar() {
  res = num1 * num2
  modificarRes()
}
function dividir() {
  if(num2 === 0) {
    res === "No se puede la division entre 0";
    return;
  }
  res = num1 / num2
  modificarRes()
}

function modificarRes() {
  divRes.innerHTML = res
}