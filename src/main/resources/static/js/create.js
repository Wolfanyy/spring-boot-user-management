const form = document.getElementById("create-user-form");
const errorMessage = document.getElementById("error-message");

form.addEventListener("submit", async (event) => {
    event.preventDefault();

    hideError();

    const user = {
        name: document.getElementById("name").value.trim(),
        lastName: document.getElementById("lastName").value.trim(),
        email: document.getElementById("email").value.trim(),
        age: Number(document.getElementById("age").value)
    };

    try {
        const response = await fetch("/api/v1/users", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(user)
        });

        if (response.ok) {
            window.location.href = "/users";
            return;
        }

        let message = "Error";

        try {
            const error = await response.json();
            message = error.message || message;
        } catch {
            message = await response.text();
        }

        showError(message);

    } catch {
        showError("Unable to connect to server");
    }
});

function showError(message) {
    errorMessage.textContent = message;
    errorMessage.classList.remove("hidden");
}

function hideError() {
    errorMessage.textContent = "";
    errorMessage.classList.add("hidden");
}