package com.gtechnog.sample.tivo.network;

import com.google.gson.annotations.SerializedName;

public class RequestBody {

    @SerializedName("type")
    private String type;

    @SerializedName("bodyId")
    private String bodyId;

    @SerializedName("displayCount")
    private int displayCount;

    @SerializedName("feedName")
    private String feedName;

    public RequestBody(String type, String bodyId, int displayCount, String feedName) {
        this.type = type;
        this.bodyId = bodyId;
        this.displayCount = displayCount;
        this.feedName = feedName;
    }
}
