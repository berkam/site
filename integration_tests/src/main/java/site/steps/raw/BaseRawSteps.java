package site.steps.raw;

import org.springframework.http.ResponseEntity;

import java.util.function.Supplier;

public class BaseRawSteps {

    protected ResponseEntity<?> execute(Supplier<ResponseEntity<?>> supplier) {
        ResponseEntity<?> response = supplier.get();
        //logger.debug(String.valueOf(response.getStatusCode()));
//        log.debug(String.valueOf(response.getBody()));
        return response;
    }
}
