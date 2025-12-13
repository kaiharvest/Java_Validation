package indradwiprabowo.validation;

import indradwiprabowo.validation.container.Data;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSimpleData() {
        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData("   ");

        validate(data);
    }
}
