package br.breno.testeJoin.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroCustomizado {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
}
