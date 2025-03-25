package payment.domain;

import java.util.*;
import lombok.*;
import payment.domain.*;
import payment.infra.AbstractEvent;

@Data
@ToString
public class RequstPaymentCompleted extends AbstractEvent {

    private Long id;
    private Long itemId;
    private String paymentId;
    private Integer price;
    private String name;
    private String buyerName;
    private String buyerTel;
    private String buyerEmail;
}
