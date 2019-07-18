package com.gtechnog.sample.tivo.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Details {

    @SerializedName("caption")
    public String caption;

    @SerializedName("expandedViewCaption")
    private String expandedViewCaption;

    @SerializedName("type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return Objects.equals(caption, details.caption) &&
                Objects.equals(expandedViewCaption, details.expandedViewCaption) &&
                Objects.equals(type, details.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, expandedViewCaption, type);
    }

    @Override
    public String toString() {
        return "Details{" +
                "caption='" + caption + '\'' +
                ", expandedViewCaption='" + expandedViewCaption + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
