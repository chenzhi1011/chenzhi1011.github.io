export async function submitComment() {
    document.getElementById('comment-form').addEventListener('submit', async function (e) {
        e.preventDefault();

        const commentText = document.getElementById('comment-text').value.trim();

        if (commentText) {
            const response = await fetch('/api/comments', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ content: commentText })
            });

            if (response.ok) {
                alert('评论成功');
                document.getElementById('comment-text').value = '';
                location.reload(); // 刷新页面以重新加载评论
            } else {
                alert('评论失败，请稍后重试');
            }
        }
    });
}
