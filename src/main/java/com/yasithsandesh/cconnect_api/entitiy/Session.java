package com.yasithsandesh.cconnect_api.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Table(name = "session")
@Getter @Setter
public class Session  implements Serializable {
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

    @Column(name = "link", nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name = "channel_id",nullable = false)
    private Channel channel;

    public Session(){

    }

    public Session(String link, Channel channel){
        this.link = link;
        this.channel = channel;
    }

}
