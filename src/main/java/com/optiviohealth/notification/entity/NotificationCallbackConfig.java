package com.optiviohealth.notification.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notification_callback_config")
@Data
public class NotificationCallbackConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long notificationCallbackConfigId;

    @Column(name = "application_source")
    private String applicationSource;

    @Column(name = "destination_type")
    private String destinationType;

    @Column(name = "callback_enabled")
    private Boolean callbackEnabled;

    @Column(name = "created_tsz")
    private String createdTsz;

    @Column(name = "updated_tsz")
    private String updatedTsz;
}