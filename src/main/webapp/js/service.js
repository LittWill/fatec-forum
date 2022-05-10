export function likePergunta(threadId) {
    const PREFIX = `/threadsapp/threads?acao=like&id=`
    const finalURL = PREFIX + threadId;
    console.log(finalURL);

    return fetch(finalURL);
}

export function dislikePergunta(threadId) {
    const PREFIX = `/threadsapp/threads?acao=dislike&id=`
    const finalURL = PREFIX + threadId;

    console.log(finalURL);

    return fetch(finalURL);
}

export function likeResposta(respostaId){
    const PREFIX = `/threadsapp/respostas?acao=like&id=`
    const finalURL = PREFIX + respostaId;

    console.log(finalURL);

    return fetch(finalURL);
}

export function dislikeResposta(respostaId){
    const PREFIX = `/threadsapp/respostas?acao=dislike&id=`
    const finalURL = PREFIX + respostaId;

    console.log(finalURL);

    return fetch(finalURL);
}