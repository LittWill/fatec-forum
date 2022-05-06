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

function likeThread(threadId) {
    likePergunta(threadId).then(() => {
        const likesNumHTML = document.querySelector(`#likesNum-${threadId}`);
        const likesNum = Number(likesNumHTML.textContent) + 1;
        likesNumHTML.textContent = likesNum;
    });
}

function dislikeThread(threadId) {
    dislikePergunta(threadId).then(() => {
        const dislikesNumHTML = document.querySelector(`#dislikesNum-${threadId}`);
        const dislikesNum = Number(dislikesNumHTML.textContent) + 1;
        dislikesNumHTML.textContent = dislikesNum;
    });
}