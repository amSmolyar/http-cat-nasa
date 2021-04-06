package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    private final boolean verified;
    private final int sentCount;

    public Status(
            @JsonProperty("verified") boolean verified,
            @JsonProperty("sentCount") int sentCount
    ) {
        this.verified = verified;
        this.sentCount = sentCount;
    }

    public boolean isVerified() {
        return verified;
    }

    public int getSentCount() {
        return sentCount;
    }

    @Override
    public String toString() {
        return  "\n     {" +
                "\n         verified = '" + verified + "'" +
                "\n         sentCount = '" + sentCount + "'" +
                "\n     }";
    }
}
