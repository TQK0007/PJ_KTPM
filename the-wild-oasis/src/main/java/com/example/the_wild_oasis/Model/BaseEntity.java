package com.example.the_wild_oasis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass

public class BaseEntity {

    @Column(name = "created_at")
    @JsonIgnore
    private LocalDateTime createAt;

    @Column(name = "created_by")
    @JsonIgnore
    private String createBy;

    @Column(name = "updated_at")
    @JsonIgnore
    private LocalDateTime updateAt;

    @Column(name = "updated_by")
    @JsonIgnore
    private String updateBy;

}
