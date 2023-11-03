package com.optiviohealth.notification.service;

import com.optiviohealth.notification.CreateNotificationCallbackRequest;
import com.optiviohealth.notification.GetNotificationCallbackByRequest;
import com.optiviohealth.notification.NotificationCallbackConfig;
import com.optiviohealth.notification.ReactorNotificationCallbackConfigServiceGrpc;
import com.optiviohealth.notification.exception.NotFoundException;
import com.optiviohealth.notification.mapper.NotificationCallbackConfigMapper;
import com.optiviohealth.notification.repository.NotificationCallbackConfigRepository;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Log4j2
@GrpcService
public class NotificationCallbackConfigService extends ReactorNotificationCallbackConfigServiceGrpc.NotificationCallbackConfigServiceImplBase {
    private final NotificationCallbackConfigRepository notificationCallbackConfigRepository;

    @Autowired
    public NotificationCallbackConfigService(NotificationCallbackConfigRepository notificationCallbackConfigRepository) {
        this.notificationCallbackConfigRepository = notificationCallbackConfigRepository;
    }

    @Override
    public Mono<NotificationCallbackConfig> createNotificationCallback(CreateNotificationCallbackRequest request) {
        try {

            com.optiviohealth.notification.entity.NotificationCallbackConfig notificationCallbackConfig = notificationCallbackConfigRepository
                    .save(NotificationCallbackConfigMapper.MAPPER.mapToNotificationCallbackConfigObject(request));
            return Mono.just(NotificationCallbackConfigMapper.MAPPER.mapToGrpcNotificationCallbackConfigObject(notificationCallbackConfig));
        } catch (Exception e) {
            log.error("Error creating Notification Callback", e);
            throw new RuntimeException("Error creating Notification Callback", e);
        }
    }

    public Mono<NotificationCallbackConfig> getNotificationCallbackById(GetNotificationCallbackByRequest request) {
        try {
            Optional<com.optiviohealth.notification.entity.NotificationCallbackConfig> notificationCallbackConfig = notificationCallbackConfigRepository
                    .findById(request.getNotificationCallbackConfigId());
            if (notificationCallbackConfig.isPresent()) {
                return Mono.just(NotificationCallbackConfigMapper.MAPPER.mapToGrpcNotificationCallbackConfigObject(notificationCallbackConfig.get()));
            } else {
                return Mono.error(new NotFoundException("Notification Config not found"));
            }
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

}