package org.fasttrackit.transfer;

import java.time.LocalDate;
import java.util.StringJoiner;

// DTO (Data transfer Object)
public class CreateTaskRequest {


    private String description;
    private LocalDate deadline;

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


    @Override
    public String toString() {
        return new StringJoiner(", ", CreateTaskRequest.class.getSimpleName() + "[", "]")
                .add("description='" + description + "'")
                .add("deadline=" + deadline)
                .toString();
    }
}
