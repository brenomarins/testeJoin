package br.breno.testeJoin.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {

    @NotBlank(message = "O nome do produto é obrigatório.")
    private String nome;

    @NotBlank(message = "A descrição do produto é obrigatória.")
    private String descricao;

    @NotBlank(message = "A categoria relacionada ao produto é obrigatória.")
    private Long categoriaId;

    @NotBlank(message = "O preço do produto é obrigatório.")
    private BigDecimal preco;
}