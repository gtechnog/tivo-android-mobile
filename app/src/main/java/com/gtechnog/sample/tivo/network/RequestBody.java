package com.gtechnog.sample.tivo.network;

import com.google.gson.annotations.SerializedName;

public class Body {

    @SerializedName("type")
    String type = "feedItemFind";

    @SerializedName("bodyId")
    String bodyId = "tsn:8D000019025246D";

    @SerializedName("displayCount")
    int displayCount= 50;

    @SerializedName("feedName")
    String feedName = "/feedList/mobileRoot";

    public Body(String type, String bodyId, int displayCount, String feedName) {
        this.type = type;
        this.bodyId = bodyId;
        this.displayCount = displayCount;
        this.feedName = feedName;
    }
}
