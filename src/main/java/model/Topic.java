package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Topic {
    private final int id;
    private final String name;
    private final String description;
    private final LocalDate registrationDate;
    private final boolean active;

    public Topic(@JsonProperty("id") int id,
                 @JsonProperty("name") String name,
                 @JsonProperty("description") String description,
                 @JsonProperty("registrationDate") String registrationDate,
                 @JsonProperty("active") boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.registrationDate = LocalDate.parse(registrationDate);
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public boolean isActive() {
        return active;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "id:" + id +
//                ", name:'" + name + '\'' +
//                ", description:'" + description + '\'' +
//                ", registrationDate:'" + registrationDate + '\'' +
//                ", active:" + active +
//                '}';
//    }
}
