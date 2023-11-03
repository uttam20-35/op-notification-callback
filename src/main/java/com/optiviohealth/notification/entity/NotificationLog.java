package com.optiviohealth.notification.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notification_log")
@Data
public class NotificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "notification_id")
    private String notificationId;

    @Column(name = "vendor_event_id")
    private String vendorEventId;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "application_source")
    private String applicationSource;

    @Column(name = "notification_status")
    private String notificationStatus;

    @Column(name = "notificationPurpose")
    private String notificationPurpose;

    @Column(name = "reason")
    private String reason;

    @Column(name = "created_tsz")
    private String createdTsz;

    @Column(name = "updated_tsz")
    private String updatedTsz;
}
