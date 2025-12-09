package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.CreditCardPaymentGroup;
import indradwiprabowo.validation.payload.EmailErrorPayload;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest{

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("31111");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if (payloadClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }

            System.out.println("====================");
        }
    }

}
