var currencies = {
    'United States Dollar ': 'USD',
    'Euro': 'EUR',
    'Brazilian Real': 'BRL',
    'Japanese Yen': 'JPY',
    'British Pound Sterling': 'GBP',
    'Canadian Dollar': 'CAD',
    'Australian Dollar': 'AUD',
    'South African Rand': 'ZAR',
    'Chinese Yuan': 'CNY',
    'Argentine Peso': 'ARS'
};

var inputCurrency = document.querySelector("#inputCurrency");

inputCurrency.addEventListener('keydown',() =>{
    if(!parseInt(inputCurrency.value)){
        inputCurrency.value = '';
    }
});

function seeSelectionCurrency() {
    const fromCurrency = document.querySelector('#fromCurrency');
    const toCurrency = document.querySelector('#toCurrency');

    if(fromCurrency.options.length === 1){
        for(let keyCurrency in currencies){
            fromCurrency[fromCurrency.options.length] = new Option(keyCurrency, currencies[keyCurrency]);
        }        
    }

    if (toCurrency.options.length === 1) {
        for(let keyCurrency in currencies){
            toCurrency[toCurrency.options.length] = new Option(keyCurrency, currencies[keyCurrency]);
        }
    }
}

function exchangeSidesOfTheCurrency(){
    const fromCurrency = document.querySelector('#fromCurrency');
    const toCurrency = document.querySelector('#toCurrency');
    let optionSelected = fromCurrency.selectedIndex;
    fromCurrency.selectedIndex = toCurrency.selectedIndex;
    toCurrency.selectedIndex = optionSelected;
}

function getData() {
    const from = document.querySelector("#fromCurrency");
    const to = document.querySelector("#toCurrency");
    const valueConversion = document.querySelector("#inputCurrency");

    axios.post('http://127.0.0.1:8080/api/currency/', {
        fromCurrency: from[from.selectedIndex].value,
        toCurrency: to[to.selectedIndex].value,
        fromValue: parseFloat(valueConversion.value)
    }, {
        headers: {
            'Content-Type': 'application/json'
        }

    }).then(function (response){
        console.log(response.data);
        showResult(response.data);
    }).catch(function (error){
        console.log(error);
        showError(error);
    });

}

function showResult(response){
    const activeElement = document.querySelector("#activation-alert");
    const toCurrency = document.querySelector('#toCurrency');
    activeElement.style.display = 'block';
    activeElement.innerText = `The result is ${toCurrency[toCurrency.selectedIndex].value} ${parseFloat(response).toFixed(2)}`;
}