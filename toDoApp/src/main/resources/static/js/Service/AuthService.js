class AuthService {
    async login(username, password) {
        const response = await fetch("/auth/login", {
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
}