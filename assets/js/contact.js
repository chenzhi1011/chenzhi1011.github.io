//submit contact form to backend;
document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('contact-form');
    const formMessage = document.getElementById('form-message');

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        const formData = new FormData(form);
        const data = Object.fromEntries(formData);

        fetch('/api/contact', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(result => {
            if (result.success) {
                formMessage.textContent = '感谢您的留言！我们会尽快回复您。';
                form.reset();
            } else {
                formMessage.textContent = '抱歉，提交失败。请稍后再试。';
            }
        })
        .catch(error => {
            console.error('Error:', error);
            formMessage.textContent = '抱歉，提交失败。请稍后再试。';
        });
    });
});