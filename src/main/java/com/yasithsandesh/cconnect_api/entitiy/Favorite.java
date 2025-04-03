package com.yasithsandesh.cconnect_api.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Table(name = "favorite")
@Data
public class Favorite  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "service_profile_id",nullable = false)
    private ServiceProfile serviceProfile;

    public Favorite() {}

    public Favorite( String userId, ServiceProfile serviceProfile) {
        this.userId = userId;
        this.serviceProfile = serviceProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }
}
