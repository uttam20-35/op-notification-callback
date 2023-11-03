
package com.optiviohealth.notification.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_destination_config")
@Data
public class NotificationDestinationConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "destination_config")
    private String destinationConfig;

    @Column(name = "created_tsz")
    private String createdTsz;

    @Column(name = "updated_tsz")
    private String updatedTsz;
}