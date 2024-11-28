export async function submitComment(data) {
    try {
        const response = await fetch('http://localhost:8088/api/comments', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        // check response 
        if (!response.ok) {
            const errorDetails = await response.text(); 
            console.error('Response error details:', errorDetails);
            throw new Error('Failed to submit comment. Please try again.');
        }

        const result = await response.json(); 
        console.log('Server response:', result);

        // check result.code
        if (result.code === 0) {
            alert(result.msg); 
            return true; 
        }else{
            alert("send successfully")
            return true;
        }

    } catch (error) {
        console.error('Error during comment submission:', error);
        throw error; 
    }
}
