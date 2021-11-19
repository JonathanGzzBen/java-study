package com.JonathanGzzBen.JpaApi.Customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CustomerDTO {
    private Long id = 0L;
    private String firstName = "";
    private String lastName = "";
}
