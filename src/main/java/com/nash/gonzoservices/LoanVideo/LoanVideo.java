package com.nash.gonzoservices.LoanVideo;

import javax.persistence.*;

@Entity
@Table(name = "\"loan_video\"")
public class LoanVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long loan_id, video_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(Long loan_id) {
        this.loan_id = loan_id;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }
}
