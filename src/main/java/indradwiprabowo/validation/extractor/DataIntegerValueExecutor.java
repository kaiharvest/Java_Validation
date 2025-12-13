package indradwiprabowo.validation.extractor;

import indradwiprabowo.validation.container.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExecutor implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {

    @Override
    public void extractValues(DataInteger originalValue, ValueReceiver receiver) {
        Integer data = originalValue.getData();

        receiver.value(null, data);
    }

}
