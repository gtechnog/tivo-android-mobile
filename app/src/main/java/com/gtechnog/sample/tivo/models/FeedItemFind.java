package com.gtechnog.sample.tivo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Objects;

public class FeedItemFind {

    @SerializedName("caption")
    private String caption;

    @SerializedName("items")
    public ArrayList<Item> items;

    @SerializedName("type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedItemFind that = (FeedItemFind) o;
        return caption.equals(that.caption) &&
                items.equals(that.items) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption, items, type);
    }

    @Override
    public String toString() {
        return "FeedItemFind{" +
                "caption='" + caption + '\'' +
                ", items=" + items +
                ", type='" + type + '\'' +
                '}';
    }
}
