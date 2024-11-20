export async function fetchComments() {
    const response = await fetch('/api/comments');
    const comments = await response.json();

    const commentsList = document.getElementById('comments-list');
    commentsList.innerHTML = '';
    comments.forEach(comment => {
        const commentElement = document.createElement('div');
        commentElement.className = 'comment';
        commentElement.innerHTML = `
            <p><strong>匿名用户</strong> - ${new Date(comment.created_at).toLocaleString()}</p>
            <p>${comment.content}</p>
        `;
        commentsList.appendChild(commentElement);
    });
}
