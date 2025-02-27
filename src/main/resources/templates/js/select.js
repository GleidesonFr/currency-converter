

var currencies = {
    'Dolar Americano': 'USD',
    'Euro': 'EUR',
    'Real': 'BRL',
    'Iene': 'JPY',
    'Libra Esterlina': 'GBP',
    'Dolar Canadense': 'CAD',
    'Dolar Australiano': 'AUD',
    'Rand': 'ZAR',
    'Yuan': 'CNY',
    'Peso Argentino': 'ARS'
};

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