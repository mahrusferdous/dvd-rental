package info.cognit.dvdrental.dto;

import lombok.Data;

@Data
public class Response<T> {
    T body;
    ResponseStatus status;
    String message;
}
