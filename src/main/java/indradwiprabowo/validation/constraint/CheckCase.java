package indradwiprabowo.validation.constraint;

import indradwiprabowo.validation.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface CheckCase {

    String message() default "invalid case format";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    CaseMode mode();
}
