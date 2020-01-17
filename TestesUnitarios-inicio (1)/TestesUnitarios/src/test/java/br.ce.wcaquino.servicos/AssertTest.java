package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void test() {
        //boleanos
        Assert.assertTrue(true); //compara valores boleanos
        Assert.assertFalse(false); // verifica expressões falsas

        // valores inteiros
        Assert.assertEquals(1, 1); // verifica 2 valores

        // float e double
        // para valores boleanos e floalt tem que colocar um delta de comparação esse delta é a margem de erro
        Assert.assertEquals(0.51, 0.51, 0.01);
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        //Tipos primitivos
        int i = 5; //unboxing
        Integer i2 = 5; //autobox
        //Assert.assertEquals(i, i2);
        // Essa expressão não é permitida pelo java porque ele usa o conseito de autobox e unboxing
        // No assertEquals isso não é permitido para que ela funcione é preciso passar o tipo primitivo para o objeto
        // ou o objeto para o tipo primitivo

        //Ficaria dessa formar
        Assert.assertEquals(Integer.valueOf(i), i2); // tipo primitivo para o objeto
        Assert.assertEquals(i, i2.intValue()); // objeto para o tipo primitivo

        //Strings
        Assert.assertEquals("bola", "bola");
        //Metotos especificos da classe string
        Assert.assertTrue("bola".equalsIgnoreCase("Bola")); // para ignorar letras maiusculas e minusculas
        Assert.assertTrue("bola".startsWith("bo")); // para trexos da palavra

        //Objetos
        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");
        Usuario u3 = u2;
        Usuario u4 = null;

        //Assert.assertEquals(u1, u2);
        // Essa expressão vai falhar porque quem deve dizer se um objeto é igual a outro é o proprio objeto
        // Nesse momento o Usuario não tem o metodo Equals implementado nele
        // Como esse metodo não tem nenhum metodo vinculado a ele fica implicido que ele está extendendo da super classe Objet
        // Nesse caso a comparação que o Object faz é apenas se um objeto é igual ao outro, mesmo no sentido de mesma instancia
        Assert.assertEquals(u1, u2); // Nesse momento ela vai funcionar porque foi criado o metodo Equal no usuario

        //Para comparar as instancias usasse o AssertSame
        //Assert.assertSame(u1, u2);
        //Esse teste vai falhar porque mesmo os objetos sendo iguais as instancias são diferentes
        Assert.assertSame(u2, u2); // só podendo ser comparados assim

        // Se tivesse uma terceira variavel
        Assert.assertSame(u3, u2); // nesse caso funcionaria pois a instancia é a mesma

        //Se o objeto for nullo
        // pode verificar de duas formas
        Assert.assertTrue(u4 == null);
        // ou
        Assert.assertNull(u4);

        //Formas negativas
        Assert.assertNotEquals("casa", "bola"); //garante que as strings são diferentes
        Assert.assertNotSame(u1, u2);//garante que apesar de serem iguais eles são de instancias diferentes
        Assert.assertNotNull(u2); //garsante que as instanscias não estão nulas.

        //String no assert
        // essa string é mostrada quando ocore algum erro no assert
        //Assert.assertEquals("Erro de comparação", 1, 2);

    }
}
