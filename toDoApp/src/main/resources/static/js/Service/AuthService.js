class AuthService {
    async login(username, password) {
        const response = await fetch("http://localhost:8080/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password })
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem("authToken", data.token);
            return new User(data.id, data.name, data.role, data.token);
        } else {
            throw new Error("Login failed");
        }
    }

    async register(username, email, password) {
        const response = await fetch("http://localhost:8080/auth/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, email, password })
        });

        if (response.ok) {
            return await response.json(); // pode retornar o usuário criado
        } else {
            throw new Error("Registration failed");
        }
    }

    logout() {
        localStorage.removeItem("authToken");
    }

    isLoggedIn() {
        return localStorage.getItem("authToken") !== null;
    }
}