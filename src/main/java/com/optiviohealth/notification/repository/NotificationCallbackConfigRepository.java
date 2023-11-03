package com.optiviohealth.notification.repository;

import com.optiviohealth.notification.entity.NotificationCallbackConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationCallbackConfigRepository extends JpaRepository<NotificationCallbackConfig, Long> {

}
