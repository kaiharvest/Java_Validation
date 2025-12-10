package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("1020120920910920");
        payment.setVirtualAccount("312123");
        payment.setAmount(10L);

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
    }

}
