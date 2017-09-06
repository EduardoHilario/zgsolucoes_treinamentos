package br.com.zg.provaestagio.test

import br.com.zg.provaestagio.model.Controle
import br.com.zg.provaestagio.model.Portao
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import static org.junit.Assert.assertEquals

@RunWith(JUnit4.class)
class ControleTest {

	@Test
	public void testarComando() throws Exception {
		def controle1 = new Controle(new Portao());
		def controle2 = new Controle(new Portao());
		def controle3 = new Controle(new Portao());
		def controle4 = new Controle(new Portao());
		def controle5 = new Controle(new Portao());
		def controle6 = new Controle(new Portao());




		assertEquals( controle1.executeComando("..P...O....."), "001234321000");
		assertEquals( controle2.executeComando(".P...."), "012345");
		assertEquals( controle3.executeComando("...P.P...P.."), "000122222345");
		assertEquals( controle4.executeComando("P..O.."), "123210");
		assertEquals( controle5.executeComando("P..P...PO..."), "123333343210");
		assertEquals( controle6.executeComando("P...O.O.P...P.."), "123432344444555");
	}

	@Test
	void testSet() {
		Controle c= new Controle(null)
		c.portao = new Portao()
		println(c.portao)
	}



}
