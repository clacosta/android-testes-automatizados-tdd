package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario ALEX = new Usuario("Alex");

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao_() {
        //Executar ação esperada
        String descricaoDevolvida = CONSOLE.getDescricao();
        //Testar resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));
        double maiorLance = CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));
        double maiorLance = CONSOLE.getMaiorLance();
        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.00));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.00));
        double maiorLance = CONSOLE.getMaiorLance();
        assertEquals(10000.00, maiorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));
        double menorLance = CONSOLE.getMenorLance();
        assertEquals(200.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente() {
        CONSOLE.propoe(new Lance(ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 200.0));
        double menorLance = CONSOLE.getMenorLance();
        assertEquals(100.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente() {
        CONSOLE.propoe(new Lance(ALEX, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 9000.0));
        double menorLance = CONSOLE.getMenorLance();
        assertEquals(9000.0, menorLance, 0.0001);
    }

    @Test
    public void deve_DevolvorTresMaioresLances_QundoRecebeExatosTresLances() {
        CONSOLE.propoe(new Lance(ALEX, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 300.0));
        CONSOLE.propoe(new Lance(ALEX, 400.0));
        List<Lance> tresMaioredsLances = CONSOLE.tresMaioresLances();
        assertEquals(3, tresMaioredsLances.size());
        
    }
}
