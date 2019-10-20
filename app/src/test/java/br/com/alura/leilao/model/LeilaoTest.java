package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricao() {
        //Criar cenário de teste
        Leilao console = new Leilao("Console");
        //Executar ação esperada
        String descricaoDevolvida = console.getDescricao();
        //Testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLance() {
        //Criar cenário de teste
        Leilao console = new Leilao("Console");
        //Executar ação esperada
        console.propoe(new Lance(new Usuario("Alex"), 200.0));
        double maiorLanceDevolvido = console.getMaiorLance();
        //Testar resultado esperado
        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

}