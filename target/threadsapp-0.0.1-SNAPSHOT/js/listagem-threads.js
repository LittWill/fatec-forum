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
    console.log(botaoSair);
}

function definirComportamentos() {
    botaoSair.addEventListener('click', () => {
        location.href = '/threadsapp/identificacao';
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

function like(threadId) {
    likePergunta(threadId).then(() => {
        console.log('like');
        const likesNumHTML = document.querySelector("#likesNum");
        const likesNum = Number(likesNumHTML.textContent) + 1;
        likesNumHTML.textContent = likesNum;
    });
}

function dislike(threadId) {
    dislikePergunta(threadId).then(() => {
        const dislikesNumHTML = document.querySelector("#dislikesNum");
        const dislikesNum = Number(dislikesNumHTML.textContent) + 1;
        dislikesNumHTML.textContent = dislikesNum;
    });
}

init();