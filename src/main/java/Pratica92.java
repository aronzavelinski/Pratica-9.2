
import java.io.IOException;


/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica92 {
    public static void main(String[] args) throws IOException {
        MostraHora h = new MostraHora();

        System.out.println("Pressione Enter para terminar...");
        h.start();

        System.in.read();
        h.stop();
    }
}
