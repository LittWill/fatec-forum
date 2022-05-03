let form;
let inputNome;
let botaoSubmit;

function init() {
    localStorage.removeItem('nomeUsuario');
    console.log(localStorage.getItem('nomeUsuario'));
    recuperarComponentes();
    definirComportamentos();
}

function recuperarComponentes() {
    form = document.querySelector("form");
    botaoSubmit = document.querySelector("button");
    inputNome = document.querySelector("input");
}

function definirComportamentos() {
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        armazenarENavegar();

    });
    botaoSubmit.addEventListener('click', () => {
        armazenarENavegar();
    });
    inputNome.addEventListener('input', () => {
        const value = inputNome.value;
        botaoSubmit.disabled = value === '' ? true : false;
    });
}

function armazenarENavegar(){
    localStorage.setItem('nomeUsuario', JSON.stringify(inputNome.value))
    location.href = '/threadsapp/threads';
}

init();