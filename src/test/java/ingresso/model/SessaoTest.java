package ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.validacao.GerenciadorDeSessao;

public class SessaoTest {

	@Test
	public void oPrecoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		
		Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("22.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "sci-fi", new BigDecimal ("12.0"));
		
		BigDecimal somDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());
		
		
	Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
			Assert.assertEquals(somDosPrecosDaSalaEFilme, sessao.getPreco());
	}

}
