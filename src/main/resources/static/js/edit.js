const form = document.getElementById("edit-user-form");
const errorMessage = document.getElementById("error-message");

const userId = window.location.pathname.split("/")[2];

document.addEventListener("DOMContentLoaded", loadUser);

form.addEventListener("submit", updateUser);

async function loadUser() {

    try {

        const response = await fetch(`/api/v1/users/${userId}`);

        if (!response.ok) {
            throw new Error();
        }

        const user = await response.json();

        document.getElementById("name").value = user.name;
        document.getElementById("lastName").value = user.lastName;
        document.getElementById("email").value = user.email;
        document.getElementById("age").value = user.age;

    } catch {

        showError("Unable to load user.");

    }

}

async function updateUser(event) {

    event.preventDefault();

    hideError();

    const user = {
        name: document.getElementById("name").value.trim(),
        lastName: document.getElementById("lastName").value.trim(),
        email: document.getElementById("email").value.trim(),
        age: Number(document.getElementById("age").value)
    };

    try {

        const response = await fetch(`/api/v1/users/${userId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
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

        showError("Unable to connect to server.");

    }

}

function showError(message) {

    errorMessage.textContent = message;
    errorMessage.classList.remove("hidden");

}

function hideError() {

    errorMessage.textContent = "";
    errorMessage.classList.add("hidden");

}