package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ValidacaoPetDisponivelTest {
    @Mock
    private PetRepository petRepository;
    @InjectMocks
    private ValidacaoPetDisponivel validacao;

    @Mock
    private Pet pet;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoPet() {

        //ARRANGE
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(false);

        //ASSERT + ACT
        Assertions.assertDoesNotThrow( () -> validacao.validar(dto)); //precisa passar no formato de expressão lambda
    }

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoPet() {

        //ARRANGE
        BDDMockito.given(petRepository.getReferenceById(dto.idPet())).willReturn(pet);
        BDDMockito.given(pet.getAdotado()).willReturn(true);

        //ASSERT + ACT
        Assertions.assertThrows(ValidacaoException.class, () -> validacao.validar(dto)); //precisa passar no formato de expressão lambda
    }

}