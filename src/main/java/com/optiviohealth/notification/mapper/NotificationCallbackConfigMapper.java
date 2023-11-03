package com.optiviohealth.notification.mapper;

import com.optiviohealth.notification.CreateNotificationCallbackRequest;
import com.optiviohealth.notification.entity.NotificationCallbackConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificationCallbackConfigMapper {
    NotificationCallbackConfigMapper MAPPER = Mappers.getMapper(NotificationCallbackConfigMapper.class);

    com.optiviohealth.notification.NotificationCallbackConfig mapToGrpcNotificationCallbackConfigObject(NotificationCallbackConfig notificationCallbackConfig);

    NotificationCallbackConfig mapToNotificationCallbackConfigObject(CreateNotificationCallbackRequest createNotificationCallbackRequest);
}
