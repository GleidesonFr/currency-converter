import axios from 'axios';

export function getData() {
    const from = document.querySelector("#fromCurrency");
    const to = document.querySelector("#toCurrency");
    const valueConversion = document.querySelector("#inputCurrency");

    axios.get('http://localhost:8080/api/currency/', {
        params: {
            fromCurrency: from[from.selectedIndex].value,
            toCurrency: to[to.selectedIndex].value,
            fromValue: parseFloat(valueConversion.value)
        }
    }).then(function (response){
        showResult(response);
    }).catch(function (error){
        showError(error);
    });

}

window.getData = getData;

function showResult(response){
    const activeElement = document.querySelector("#activation-alert");
    activeElement.computedStyleMap.display = 'block';
    activeElement.innerText = 'O resultado é: ' + response;
}

function showError(error){

}
