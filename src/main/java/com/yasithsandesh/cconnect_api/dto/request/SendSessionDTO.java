package com.yasithsandesh.cconnect_api.dto.request;




public class SendSessionDTO {
    private String link;
    private long channelId;

    public SendSessionDTO(){}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }
}
