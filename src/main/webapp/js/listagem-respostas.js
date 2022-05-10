function likeThread(threadId) {
    const PREFIX = `/threadsapp/threads?acao=like&id=`
    const finalURL = PREFIX + threadId;
    console.log(finalURL);

    return fetch(finalURL);
}

function dislikeThread(threadId) {
    const PREFIX = `/threadsapp/threads?acao=dislike&id=`
    const finalURL = PREFIX + threadId;

    console.log(finalURL);

    return fetch(finalURL);
}

function likeResposta(respostaId) {
    const PREFIX = `/threadsapp/respostas?acao=like&respostaId=`
    const finalURL = PREFIX + respostaId;

    console.log(finalURL);

    return fetch(finalURL);
}

function dislikeResposta(respostaId) {
    const PREFIX = `/threadsapp/respostas?acao=dislike&respostaId=`
    const finalURL = PREFIX + respostaId;

    console.log(finalURL);

    return fetch(finalURL);
}

//------

async function threadLike(threadId, event) {
    console.log(event);
    const numLikesHTML = event.target.children[0];
    const numLikes = Number(numLikesHTML.textContent);
    await likeThread(threadId).then((response) => {
        console.log(response);
        if (response.ok && numLikesHTML !== undefined){
            numLikesHTML.textContent = numLikes + 1;
        }
        else{
            alert('Não foi possível avaliar a thread!');
        }
    });
}

async function threadDislike(threadId, event) {
    console.log(event);
    const numLikesHTML = event.target.children[0];
    const numLikes = Number(numLikesHTML.textContent);
    await dislikeThread(threadId).then((response) => {
        console.log(response);
        if (response.ok && numLikesHTML !== undefined){
            numLikesHTML.textContent = numLikes + 1;
        }
        else{
            alert('Não foi possível avaliar a thread!');
        }
    });
}

async function respostaLike(respostaId, event) {
    console.log(event);
    const numLikesHTML = event.target.children[0];
    const numLikes = Number(numLikesHTML.textContent);
    await likeResposta(respostaId).then((response) => {
        console.log(response);
        if (response.ok && numLikesHTML !== undefined){
            numLikesHTML.textContent = numLikes + 1;
        }
        else{
            alert('Não foi possível avaliar a resposta!');
        }
    });
}

async function respostaDislike(respostaId, event) {
    console.log(event);
    const numDislikesHTML = event.target.children[0];
    const numDislikes = Number(numDislikesHTML.textContent);
    await dislikeResposta(respostaId).then((response) => {
        if (response.ok && numDislikesHTML !== undefined){
            numDislikesHTML.textContent = numDislikes + 1;
        }
        else{
            alert('Não foi possível avaliar a resposta!');
        }
        
    });
}