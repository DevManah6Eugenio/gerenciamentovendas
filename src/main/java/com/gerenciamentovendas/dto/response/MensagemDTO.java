package com.gerenciamentovendas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MensagemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mensagem;
}
