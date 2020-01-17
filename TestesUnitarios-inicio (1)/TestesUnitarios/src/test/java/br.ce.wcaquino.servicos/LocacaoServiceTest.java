package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class LocacaoServiceTest {

    @Test
    public void teste() {
        //cenario

        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        //acao
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificacao
        assertEquals(5.0,locacao.getValor(), 0.01);
        assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

        //verificacao usando o assertThat
        assertThat(locacao.getValor(), is(5.0)); // redução dos imports
        assertThat(locacao.getValor(),is(CoreMatchers.equalTo(5.0))); // outra forma
        assertThat(locacao.getValor(), is(CoreMatchers.not(4.0))); // se fosse uma negação

        assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true)); // redução dos imports
        assertThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true)); // redução dos imports

    }
}
