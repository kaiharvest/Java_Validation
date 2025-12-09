package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.PaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void testGroupSequence() {
        Payment payment = new Payment();
        payment.setAmount(10_000_000L);
        payment.setOrderId("0001");
        payment.setCreditCard("4111111111111111");

        validateWithGroup(payment, PaymentGroup.class);
    }

}
