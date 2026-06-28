const API_URL = "/api/v1/users";

const usersTableBody = document.getElementById("users-table-body");
const usersCount = document.getElementById("users-count");

document.addEventListener(
    "DOMContentLoaded",
    initializePage
);

async function initializePage() {
    await loadUsers();
}

async function loadUsers() {

    try {

        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Failed to load users.");
        }

        const users = await response.json();

        renderUsers(users);

    } catch (error) {

        console.error(error);

    }

}

function renderUsers(users) {

    usersTableBody.replaceChildren();

    usersCount.textContent = users.length;

    users.forEach(user => {
        usersTableBody.append(createUserRow(user));
    });

}

function createUserRow(user) {

    const row = document.createElement("tr");

    row.innerHTML = `
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.lastName}</td>
        <td class="email">${user.email}</td>
        <td>${user.age}</td>

        <td class="actions-column">

            <button
                    class="btn btn-secondary"
                    data-id="${user.id}">

                Edit

            </button>

            <button
                    class="btn btn-danger"
                    data-id="${user.id}">

                Delete

            </button>

        </td>
    `;

    return row;

}