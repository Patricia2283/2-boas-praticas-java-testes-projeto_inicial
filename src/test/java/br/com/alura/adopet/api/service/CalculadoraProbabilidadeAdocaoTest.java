package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraProbabilidadeAdocaoTest {

    @Test
    @DisplayName("Probabilidade ALTA para Pet com peso baixo e idade baixa")
    void probabilidadeAltaCenario01() {
        // 4 anos - 4kg - probabilidade ALTA

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                    "Abrigo feliz",
                    "94999999999",
                    "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDto(
                    TipoPet.GATO,
                    "Miau",
                    "Siames",
                    4,
                    "Cinza",
                    4.0f
        ), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);

    }

    @Test
    @DisplayName("Probabilidade MEDIA para Pet com peso baixo e idade alta")
    void probabilidadeMediaCenario02() {
        // 15 anos - 4kg - probabilidade MEDIA

        //ARRANGE
        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo feliz",
                "94999999999",
                "abrigofeliz@email.com.br"
        ));
        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "Siames",
                15,
                "Cinza",
                4.0f
        ), abrigo);

        //ACT
        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        //ASSERT
        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);

    }

}