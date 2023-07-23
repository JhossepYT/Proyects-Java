let res = 0;
const divRes = document.getElementById("06");
const inputNum1 = document.getElementById("num1");
const inputNum2 = document.getElementById("num2");


function sumar() {
  const num1 = Number(inputNum1.value);
  const num2 = Number(inputNum2.value);
  res = num1 + num2;
  modificarRes();
}

function restar() {
  const num1 = Number(inputNum1.value);
  const num2 = Number(inputNum2.value);
  res = num1 - num2;
  modificarRes();
}

function multiplicar() {
  const num1 = Number(inputNum1.value);
  const num2 = Number(inputNum2.value);
  res = num1 * num2;
  modificarRes();
}

function dividir() {
  const num1 = Number(inputNum1.value);
  const num2 = Number(inputNum2.value);
  if (num2 === 0 || num1 === 0) {
    res = "The division by 0 is not defined gracioson xD"
  } else {
    res = num1 / num2;
  }
  modificarRes();
}

function modificarRes() {
  divRes.innerHTML = "Result: " + res
}