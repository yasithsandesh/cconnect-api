package com.yasithsandesh.cconnect_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SendSessionDTO {
    private String link;
    private long channelId;

    public SendSessionDTO(){}
}
