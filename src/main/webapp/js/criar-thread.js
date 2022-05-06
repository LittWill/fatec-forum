let autorNomeElement;

function init () {
    autorNomeElement = document.querySelector("#autorNome");
    autorNomeElement.value = JSON.parse(localStorage.getItem('nomeUsuario'));
}

init();

