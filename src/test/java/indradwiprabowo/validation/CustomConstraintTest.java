package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class CustomConstraintTest extends AbstractValidatorTest {

    @Test
    void testCustomConstraint() {
        Payment payment = new Payment();
        payment.setOrderId("indra");

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }
}
