package payment.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import payment.config.kafka.KafkaProcessor;
import payment.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RequstPaymentCompleted'"
    )
    public void wheneverRequstPaymentCompleted_UpdatePaymentStatus(
        @Payload RequstPaymentCompleted requstPaymentCompleted
    ) {
        RequstPaymentCompleted event = requstPaymentCompleted;
        System.out.println(
            "\n\n##### listener UpdatePaymentStatus : " +
            requstPaymentCompleted +
            "\n\n"
        );

        // Sample Logic //
        Order.updatePaymentStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
