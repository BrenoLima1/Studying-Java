class User {

    constructor(id, name, role, password, token = null) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.token = token
    }

    isLoggedin() {
        return this.token != null;
    }

    logout() {
        this.token = null;
        localStorage.removeItem('authToken');
    }
}
