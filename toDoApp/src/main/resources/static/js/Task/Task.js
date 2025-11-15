class Task {
    constructor(id, title, description, status = "PENDING", createdAt = new Date(), userId = null) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status; // PENDING, IN_PROGRESS, DONE
        this.createdAt = createdAt;
        this.userId = userId; // quem criou a tarefa
    }

    markAsDone() {
        this.status = "DONE";
    }

    markInProgress() {
        this.status = "IN_PROGRESS";
    }

    updateDetails(title, description) {
        this.title = title;
        this.description = description;
    }
}