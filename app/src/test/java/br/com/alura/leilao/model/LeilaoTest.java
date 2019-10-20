package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricaoQuandoRecebeDescricaoDevolveDescricao() {
        //Criar cenário de teste
        Leilao console = new Leilao("Console");
        //Executar ação esperada
        String descricaoDevolvida = console.getDescricao();
        //Testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLanceQuandoRecebeApenasUmLanceDevolveMaiorLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));
        double maiorLanceConsole = console.getMaiorLance();
        assertEquals(200.0, maiorLanceConsole, 0.0001);
    }

    @Test
    public void getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemCrescenteDevolveMaiorLance() {
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Alex"), 100.0));
        computador.propoe(new Lance(new Usuario("Fran"), 200.0));
        double maiorLanceComputador = computador.getMaiorLance();
        assertEquals(200.0, maiorLanceComputador, 0.0001);
    }

    @Test
    public void getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemDecrescenteDevolveMaiorLance() {
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Alex"), 10000.00));
        carro.propoe(new Lance(new Usuario("Fran"), 9000.00));
        double maiorLanceCarro = carro.getMaiorLance();
        assertEquals(10000.00, maiorLanceCarro, 0.0001);
    }
}
