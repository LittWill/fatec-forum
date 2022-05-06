let spanNomeUsuario;
let botaoSair;

const elementosHTML = document.querySelector("#sessao")

function init() {
    if (!isSessaoValida()) {
        location.href = '/threadsapp/identificacao';
        return;
    }

    recuperarComponentes();

    definirComportamentos();
}

function recuperarComponentes() {

    spanNomeUsuario = elementosHTML.querySelector("#nome-usuario");
    spanNomeUsuario.textContent += JSON.parse(localStorage.getItem('nomeUsuario'));
    botaoSair = elementosHTML.querySelector("button");
}

function definirComportamentos() {
    botaoSair.addEventListener('click', () => {
        location.href = '/threadsapp/identificacao';
        console.log('ok');
    });
}

function isSessaoValida() {
    let isSessaoValida = true;
    const nomeUsuario = localStorage.getItem('nomeUsuario');
    if (undefined == nomeUsuario) {
        isSessaoValida = false;
    }

    return isSessaoValida;
}

init();