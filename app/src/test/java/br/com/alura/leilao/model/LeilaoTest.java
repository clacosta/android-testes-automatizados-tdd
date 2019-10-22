package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    private final Leilao console = new Leilao("Console");
    private final Usuario alex = new Usuario("Alex");
    private final Usuario fran = new Usuario("Fran");
    
    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao_() {
        //Executar ação esperada
        String descricaoDevolvida = console.getDescricao();
        //Testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        console.propoe(new Lance(alex, 200.0));
        double maiorLance = console.getMaiorLance();
        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(fran, 200.0));
        double maiorLance = console.getMaiorLance();
        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(new Lance(alex, 10000.00));
        console.propoe(new Lance(fran, 9000.00));
        double maiorLance = console.getMaiorLance();
        assertEquals(10000.00, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        console.propoe(new Lance(alex, 200.0));
        double menorLance = console.getMenorLance();
        assertEquals(200.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(fran, 200.0));
        double menorLance = console.getMenorLance();
        assertEquals(100.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        console.propoe(new Lance(alex, 10000.00));
        console.propoe(new Lance(fran, 9000.00));
        double menorLance = console.getMenorLance();
        assertEquals(9000.0, menorLance, 0.0001);
    }

}
