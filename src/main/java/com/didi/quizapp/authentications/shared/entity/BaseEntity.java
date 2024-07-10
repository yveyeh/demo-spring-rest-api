package com.didi.quizapp.authentications.shared.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.UUID;


@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({AuditingEntityListener.class})
@Table(name = "base_entities")
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    protected UUID id;

    protected String slug;

    protected String title;

    protected String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    protected OffsetDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    protected OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    protected OffsetDateTime deletedAt;


    @PrePersist
    protected void onCreate() {
        this.updatedAt = this.createdAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        this.updatedAt = this.deletedAt = OffsetDateTime.now();
    }

}
