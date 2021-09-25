package site.steps.wrapper;

import org.springframework.http.ResponseEntity;

import java.util.Objects;
import java.util.function.Supplier;

public class BaseWrapperSteps {

    protected void execute(Supplier<ResponseEntity<?>> supplier) {
        ResponseEntity<?> response = supplier.get();
        if (response.getStatusCode().isError())
            throw new RuntimeException(Objects.requireNonNull(response.getBody()).toString());
    }
}
