let inputNome;
let botaoSubmit;

function init() {
    recuperarComponentes();
    definirComportamentos();
}

function recuperarComponentes() {
    botaoSubmit = document.querySelector("button");
    inputNome = document.querySelector("input");
}

function definirComportamentos() {
    botaoSubmit.addEventListener('click', (event) => {
        console.log(event);
        localStorage.setItem('nomeUsuario', JSON.stringify(inputNome.value))
    });
}

init();