import { submitComment } from './sendcomment.js';
import { fetchComments } from './displaycomment.js';

export function initializeComments(commentFormId, commentTextId, pageKeyId) {
    document.addEventListener('DOMContentLoaded', async () => {
        console.log('DOMContentLoaded event fired');

        const loadComments = async () => {
            try {
                await fetchComments(); // Load and display comments
                console.log('Comments loaded successfully');
            } catch (error) {
                console.error('Error loading comments:', error.message);
                alert('Failed to load comments. Please try again later.');
            }
        };

        // Load comments on page load
        await loadComments();

        const commentForm = document.getElementById(commentFormId);
        const commentText = document.getElementById(commentTextId);
        const pageKey = document.getElementById(pageKeyId);

        if (!commentForm || !commentText || !pageKey) {
            console.error('One or more required DOM elements not found');
            return;
        }

        console.log('Comment form found, adding event listener');

        commentForm.addEventListener('submit', async (event) => {
            event.preventDefault(); // Prevent default form submit
            console.log('Form submit event triggered');

            const commentTextValue = commentText.value.trim();
            const pageKeyValue = pageKey.value.trim();

            if (!commentTextValue) {
                alert('Comment content cannot be empty');
                return;
            }

            console.log('Submitting comment:', { commentTextValue, pageKeyValue });

            try {
                const success = await submitComment({
                    comment: commentTextValue,
                    pageKey: parseInt(pageKeyValue, 10),
                });

                if (success) {
                    console.log('Comment submitted successfully');
                    commentText.value = ''; // Clear textarea
                    await loadComments(); // Re-fetch comments
                }
            } catch (error) {
                console.error('Error submitting comment:', error.message);
                alert(error.message || 'An error occurred. Please try again later.');
            }
        });
    });
}
