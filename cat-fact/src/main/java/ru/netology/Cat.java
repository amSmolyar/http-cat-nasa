package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    private final Status status;
    private final String type;
    private final boolean deleted;
    private final String id;
    private final String user;
    private final String text;
    private final int v;
    private final String source;
    private final String updatedAt;
    private final String createdAt;
    private final boolean used;

    public Cat(
            @JsonProperty("status") Status status,
            @JsonProperty("type") String type,
            @JsonProperty("deleted") boolean deleted,
            @JsonProperty("_id") String id,
            @JsonProperty("user") String user,
            @JsonProperty("text") String text,
            @JsonProperty("__v") int v,
            @JsonProperty("source") String source,
            @JsonProperty("updatedAt") String updatedAt,
            @JsonProperty("createdAt") String createdAt,
            @JsonProperty("used") boolean used
    ) {
        this.status = status;
        this.type = type;
        this.deleted = deleted;
        this.id = id;
        this.user = user;
        this.text = text;
        this.v = v;
        this.source = source;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.used = used;
    }

    public Status getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public int getV() {
        return v;
    }

    public String getSource() {
        return source;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public String toString() {
        return "Cat" +
                "\n{" +
                "\n     status = " + status +
                "\n     type = '" + type + "'" +
                "\n     deleted = '" + deleted + "'" +
                "\n     id = '" + id + "'" +
                "\n     user = '" + user + "'" +
                "\n     text = '" + text + "'" +
                "\n     v = '" + v + "'" +
                "\n     source = '" + source + "'" +
                "\n     updatedAt = '" + updatedAt + "'" +
                "\n     createdAt = '" + createdAt + "'" +
                "\n     used = '" + used + "'" +
                "\n}";
    }
}
