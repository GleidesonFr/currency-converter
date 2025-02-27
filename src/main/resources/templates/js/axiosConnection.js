export function getData() {
    const from = document.querySelector("#fromCurrency");
    const to = document.querySelector("#toCurrency");
    const valueConversion = document.querySelector("#inputCurrency");

    axios.post('http://localhost:8080/api/currency/', {
        fromCurrency: from[from.selectedIndex].value,
        toCurrency: to[to.selectedIndex].value,
        fromValue: parseFloat(valueConversion.value)
    }, {
        headers: {
            'Content-Type': 'application/json'
        }

    }).then(function (response){
        console.log(response.data);
        showResult(response);
    }).catch(function (error){
        console.log(error);
        showError(error);
    });

}

function showResult(response){
    const activeElement = document.querySelector("#activation-alert");
    activeElement.computedStyleMap.display = 'block';
    activeElement.innerText = 'O resultado é: ' + response;
}

function showError(error){

}
