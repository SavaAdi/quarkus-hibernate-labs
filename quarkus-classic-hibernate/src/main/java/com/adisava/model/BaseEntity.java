package com.adisava.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "baseSeq", sequenceName = "base_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "baseSeq")
    private Long id;

    @Version
    private Long version;

    @UpdateTimestamp
    @JsonbDateFormat(value = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    @CreationTimestamp
    @JsonbDateFormat(value = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
