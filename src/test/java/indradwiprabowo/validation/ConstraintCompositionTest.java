package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest {

    @Test
    void testComposition() {
        Payment payment = new Payment();
        payment.setOrderId("1212323238989jskdjksjdk");

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }

}
