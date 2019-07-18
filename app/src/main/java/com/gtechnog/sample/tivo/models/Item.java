package com.gtechnog.sample.tivo.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Item {

    @SerializedName("details")
    public Details details;

    @SerializedName("feedName")
    private String feedName;

    @SerializedName("itemId")
    public String itemId;

    @SerializedName("kernel")
    public Kernel kernel;

    @SerializedName("type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return details.equals(item.details) &&
                feedName.equals(item.feedName) &&
                itemId.equals(item.itemId) &&
                kernel.equals(item.kernel) &&
                type.equals(item.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, feedName, itemId, kernel, type);
    }

    @Override
    public String toString() {
        return "Item{" +
                "details=" + details +
                ", feedName='" + feedName + '\'' +
                ", itemId='" + itemId + '\'' +
                ", kernel=" + kernel +
                ", type='" + type + '\'' +
                '}';
    }
}
