package com.yasithsandesh.cconnect_api.dto.request;

public class FavoriteAddDTO {
    private String userId;
    private long serviceProfileId;

    public FavoriteAddDTO() {

    }

    public FavoriteAddDTO(long serviceProfileId, String userId) {
        this.serviceProfileId = serviceProfileId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getServiceProfileId() {
        return serviceProfileId;
    }

    public void setServiceProfileId(long serviceProfileId) {
        this.serviceProfileId = serviceProfileId;
    }
}
