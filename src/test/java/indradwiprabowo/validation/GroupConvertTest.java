package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest {

    @Test
    void testGroupConvert() {
        Payment payment = new Payment();
        payment.setOrderId("011");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomers(new Customer());

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }

}
