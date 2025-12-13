package indradwiprabowo.validation;

import indradwiprabowo.validation.container.Data;
import indradwiprabowo.validation.container.DataInteger;
import indradwiprabowo.validation.container.Entry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSimpleData() {
        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData("   ");

        validate(data);
    }

    @Test
    void testSampleEntry() {
        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("");
        sampleEntry.getEntry().setValue("");

        validate(sampleEntry);
    }

    // Data Container bukan Generic Type


    @Test
    void testSampleDataInteger() {
        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);
    }

}
