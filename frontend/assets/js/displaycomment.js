export async function fetchComments() {
    try {
        // 获取隐藏字段的值
        const pageKeyElement = document.getElementById('page-key');
        console.log('page-key',pageKeyElement);
        const pageKey = pageKeyElement ? pageKeyElement.value : null;

        if (!pageKey) {
            console.error('Page key not found');
            return;
        }

        // 构造带查询参数的 URL
        const url = `http://localhost:8088/api/comments?pageKey=${encodeURIComponent(pageKey)}`;
        // Fetch comments from the API
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        // Parse the JSON response
        const result = await response.json();

        // Validate the structure of the response
        if (!result || !Array.isArray(result.data)) {
            throw new Error('Unexpected response format: data is not an array');
        }

        const comments = result.data; // Extract the array of comments

        // Update the comments list in the DOM
        const commentsList = document.getElementById('comments-list');
        commentsList.innerHTML = ''; // Clear any existing comments

        comments.forEach(commentt => {
            const commentElement = document.createElement('div');
            commentElement.className = 'comment';
            commentElement.innerHTML = `
                <p><strong>Anonymous User</strong> - ${new Date(commentt.createTime).toLocaleString()}</p>
                <p>${commentt.comment}</p>
            `;
            commentsList.appendChild(commentElement);
        });

        console.log('Comments loaded successfully');
    } catch (error) {
        console.error('Error loading comments:', error.message);
        alert('Failed to load comments. Please try again later.');
    }
}
