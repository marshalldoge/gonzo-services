package com.nash.gonzoservices.LoanVideo;

import javax.persistence.*;

@Entity
@Table(name = "\"loan_video\"")
public class LoanVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer load_id, video_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLoad_id() {
        return load_id;
    }

    public void setLoad_id(Integer load_id) {
        this.load_id = load_id;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }
}
