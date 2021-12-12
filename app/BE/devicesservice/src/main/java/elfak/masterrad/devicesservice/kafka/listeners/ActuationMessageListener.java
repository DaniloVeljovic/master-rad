package elfak.masterrad.devicesservice.kafka.listeners;

import elfak.masterrad.analyticsservice.kafka.models.ActuationMessage;
import elfak.masterrad.devicesservice.mapper.Mapper;
import elfak.masterrad.devicesservice.models.ActuationStatus;
import elfak.masterrad.devicesservice.models.entities.Actuation;
import elfak.masterrad.devicesservice.services.ActuationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ActuationMessageListener {

    private final Logger logger = LoggerFactory.getLogger(ActuationMessageListener.class);

    @Autowired
    private ActuationService actuationService;

    @Autowired
    private Mapper mapper;

    @KafkaListener(topics = "${kafka.actuationMessageTopic}", containerFactory = "greetingKafkaListenerContainerFactory")
    public void messageListener(ActuationMessage message) {
        logger.info("Received actuation message: " + message);
        Actuation actuation = mapper.mapMessageToEntity(message);
        actuation.setStatus(ActuationStatus.NEW);
        actuationService.saveActuation(actuation);
    }


}
