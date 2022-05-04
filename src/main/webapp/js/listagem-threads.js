import {likePergunta, dislikePergunta} from './service.js'

let threadId;
let spanNomeUsuario;
let botaoSair;
let botaoLike;
let botaoDislike;

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
    threadId = document.querySelector("#thread-id").value;
    botaoLike = document.querySelector("#btn-like");
    botaoDislike = document.querySelector("#btn-dislike");
}

function definirComportamentos() {
    botaoSair.addEventListener('click', () => {
        location.href = '/threadsapp/identificacao';
    });
    botaoLike.onclick = () => like(threadId);
    botaoDislike.onclick = () => dislike(threadId);
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
    console.log('like');
    likePergunta(threadId).then(() => {
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