package indradwiprabowo.validation;

import indradwiprabowo.validation.groub.CreditCardPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInternasionalizationTest extends AbstractValidatorTest {

    @Test
    void testI18n() {
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("212323234334");
        payment.setAmount(10L);

        validateWithGroup(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {
        Payment payment = new Payment();
        payment.setOrderId("212323234334");
        payment.setAmount(10L);

        Locale local = new Locale("in", "ID");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, local);
            System.out.println(message);

            System.out.println("====================");
        }
    }

}
