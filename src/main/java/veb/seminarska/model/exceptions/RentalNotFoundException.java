package veb.seminarska.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RentalNotFoundException extends RuntimeException {

    public RentalNotFoundException(Long id) {
        super(String.format("Rentals section with id: %d was not found", id));
    }
}
