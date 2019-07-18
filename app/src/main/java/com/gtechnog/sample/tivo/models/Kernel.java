package com.gtechnog.sample.tivo.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Kernel {

    @SerializedName("expandedFeedAction")
    private ExpandedFeedAction expandedFeedAction;

    @SerializedName("feedContentType")
    private String feedContentType;

    @SerializedName("feedName")
    public String feedName;

    @SerializedName("type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kernel kernel = (Kernel) o;
        return Objects.equals(expandedFeedAction, kernel.expandedFeedAction) &&
                Objects.equals(feedContentType, kernel.feedContentType) &&
                Objects.equals(feedName, kernel.feedName) &&
                Objects.equals(type, kernel.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expandedFeedAction, feedContentType, feedName, type);
    }

    @Override
    public String toString() {
        return "Kernel{" +
                "expandedFeedAction=" + expandedFeedAction +
                ", feedContentType='" + feedContentType + '\'' +
                ", feedName='" + feedName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
