package com.gtechnog.sample.tivo.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

class ExpandedFeedAction {

    @SerializedName("feedContentType")
    private String feedContentType;

    @SerializedName("feedName")
    private String feedName;

    @SerializedName("type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpandedFeedAction that = (ExpandedFeedAction) o;
        return Objects.equals(feedContentType, that.feedContentType) &&
                Objects.equals(feedName, that.feedName) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedContentType, feedName, type);
    }

    @Override
    public String toString() {
        return "ExpandedFeedAction{" +
                "feedContentType='" + feedContentType + '\'' +
                ", feedName='" + feedName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
