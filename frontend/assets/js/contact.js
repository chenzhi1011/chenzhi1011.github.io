document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('contact-form'); 
    const formMessage = document.getElementById('form-message'); 

    form.addEventListener('submit', function (e) {
        e.preventDefault(); 

        const formData = new FormData(form); 
        const data = Object.fromEntries(formData); 

        
        fetch('http://localhost:8088/api/contact', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json', 
            },
            body: JSON.stringify(data), 
        })
            .then(response => {
                if (!response.ok) {
                    console.log('HTTP status:', response.status);
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(result => {
                
                console.log('Received result:', result);
                if (result && result.code === 1) { 
                    formMessage.textContent = 'Thanks for your message!';
                    formMessage.style.color = 'green'; 
                    form.reset(); 
                } else {
                    formMessage.textContent = result.msg || 'Sorry! There is something wrong with your submission. Please try again.';
                    formMessage.style.color = 'red'; 
                }
            })
            .catch(error => {
                console.error('Error:', error);
                formMessage.textContent = 'Sorry! Unknown Error. Please try again later.';
                formMessage.style.color = 'red'; 
            });
    });
});
