class TaskService {
    baseUrl = "http://localhost:8080";

    constructor(baseUrl) {
        this.baseUrl = baseUrl;
    }

    async getTasks() {
        const token = localStorage.getItem("authToken");
        const response = await fetch(`${this.baseUrl}/tasks`, {
            headers: {
                "Authorization": `Bearer ${token}`
            }
        });
        if (!response.ok) throw new Error("Failed to fetch tasks");
        return await response.json();
    }

    async createTask(task) {
        const token = localStorage.getItem("authToken");
        const response = await fetch(`${this.baseUrl}/tasks`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`
            },
            body: JSON.stringify(task)
        });
        if (!response.ok) throw new Error("Failed to create task");
        return await response.json();
    }

    async updateTask(taskId, task) {
        const token = localStorage.getItem("authToken");
        const response = await fetch(`${this.baseUrl}/tasks/${taskId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`
            },
            body: JSON.stringify(task)
        });
        if (!response.ok) throw new Error("Failed to update task");
        return await response.json();
    }

    async deleteTask(taskId) {
        const token = localStorage.getItem("authToken");
        const response = await fetch(`${this.baseUrl}/tasks/${taskId}`, {
            method: "DELETE",
            headers: {
                "Authorization": `Bearer ${token}`
            }
        });
        if (response.ok) {
            console.log("Task deleted successfully!");
            return true;
        } else {
            console.error("Failed to delete task.");
            return false;
        }
    }
}