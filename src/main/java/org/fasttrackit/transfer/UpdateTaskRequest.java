package org.fasttrackit.transfer;

import java.time.LocalDate;
import java.util.StringJoiner;

// DTO (Data transfer Object)
public class UpdateTaskRequest {


    private String description;
    private LocalDate deadline;
    private boolean done;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UpdateTaskRequest.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("deadline=" + deadline)
                .add("done=" + done)
                .toString();
    }
}
