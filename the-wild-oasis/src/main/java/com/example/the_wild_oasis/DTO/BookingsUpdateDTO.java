package com.example.the_wild_oasis.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Optional;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingsUpdateDTO {
    private Optional<Double> extrasPrice = Optional.empty();
    private Optional<Double> totalPrice = Optional.empty();
    private Optional<String> status = Optional.empty();
    private Optional<Boolean> hasBreakfast = Optional.empty();
    private Optional<Boolean> isPaid = Optional.empty();
}
