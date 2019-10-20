package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao_() {
        //Criar cenário de teste
        Leilao console = new Leilao("Console");
        //Executar ação esperada
        String descricaoDevolvida = console.getDescricao();
        //Testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));
        double maiorLance = console.getMaiorLance();
        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Alex"), 100.0));
        computador.propoe(new Lance(new Usuario("Fran"), 200.0));
        double maiorLance = computador.getMaiorLance();
        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Alex"), 10000.00));
        carro.propoe(new Lance(new Usuario("Fran"), 9000.00));
        double maiorLance = carro.getMaiorLance();
        assertEquals(10000.00, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));
        double menorLance = console.getMenorLance();
        assertEquals(200.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Alex"), 100.0));
        computador.propoe(new Lance(new Usuario("Fran"), 200.0));
        double menorLance = computador.getMenorLance();
        assertEquals(100.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Alex"), 10000.00));
        carro.propoe(new Lance(new Usuario("Fran"), 9000.00));
        double menorLance = carro.getMenorLance();
        assertEquals(9000.0, menorLance, 0.0001);
    }

}
