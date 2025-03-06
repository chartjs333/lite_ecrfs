document.addEventListener('DOMContentLoaded', function() {
    const passwordInput = document.getElementById('newPassword');
    const form = document.querySelector('form');

    if (passwordInput) {
        passwordInput.addEventListener('input', validatePassword);
    }

    if (form) {
        form.addEventListener('submit', validateForm);
    }
});

function validatePassword(e) {
    const password = e.target.value;
    
    // Define requirements
    const requirements = {
        length: password.length >= 12 && password.length <= 16,
        uppercase: /[A-Z]/.test(password),
        lowercase: /[a-z]/.test(password),
        number: /[0-9]/.test(password),
        special: /[!@#$%^*\-_]/.test(password) // Удалил & из списка специальных символов
    };

    // Update requirement indicators
    for (const [requirement, isMet] of Object.entries(requirements)) {
        const element = document.getElementById(requirement);
        if (element) {
            if (isMet) {
                element.classList.remove('unmet');
                element.classList.add('met');
            } else {
                element.classList.remove('met');
                element.classList.add('unmet');
            }
        }
    }
}

function validateForm(e) {
    const password = document.getElementById('newPassword').value;
    const confirmPassword = document.getElementById('confirmNewPassword').value;

    const isValid = 
        password.length >= 12 && 
        password.length <= 16 &&
        /[A-Z]/.test(password) &&
        /[a-z]/.test(password) &&
        /[0-9]/.test(password) &&
        /[!@#$%^*\-_]/.test(password); // Удалил & из списка специальных символов

    if (!isValid) {
        e.preventDefault();
        alert('Please ensure your password meets all requirements.');
    } else if (password !== confirmPassword) {
        e.preventDefault();
        alert('Passwords do not match.');
    }
}
