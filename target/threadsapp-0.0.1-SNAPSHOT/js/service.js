function likePergunta(threadId) {
    const PREFIX = `/threadsapp/threads?acao=like&id=`
    const finalURL = PREFIX + threadId;
    console.log(finalURL);

    return fetch(finalURL);
}

function dislikePergunta(threadId) {
    const PREFIX = `/threadsapp/threads?acao=dislike&id=`
    const finalURL = PREFIX + threadId;

    console.log(finalURL);

    return fetch(finalURL);
}