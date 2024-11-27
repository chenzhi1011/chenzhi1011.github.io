export async function submitComment(data) {
    try {
        const response = await fetch('http://localhost:8088/api/comments', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        // 检查状态码是否为 2xx
        if (!response.ok) {
            const errorDetails = await response.text(); // 获取错误信息
            console.error('Response error details:', errorDetails);
            throw new Error('Failed to submit comment. Please try again.');
        }

        console.log('Comment submitted successfully with status:', response.status);
        return true; // 表示成功
    } catch (error) {
        console.error('Error during comment submission:', error);
        throw error; // 抛出错误以便调用方处理
    }
}
