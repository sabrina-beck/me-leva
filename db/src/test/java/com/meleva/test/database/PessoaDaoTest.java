package com.meleva.test.database;

import com.meleva.dao.pessoa.PessoaDao;
import com.meleva.modelo.Celular;
import com.meleva.modelo.Pessoa;
import com.meleva.modelo.builder.PessoaBuilder;
import com.meleva.service.pessoa.to.PessoaTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author sabrina on 26/05/16.
 */
public class PessoaDaoTest {

    private PessoaDao pessoaDao;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = PostgresTestSuite.jdbcTemplate();
        pessoaDao = new PessoaDao(jdbcTemplate);
    }

    @Test
    public void criar() {
        Pessoa esperado = pessoaDeTest().build();
        pessoaDao.criar(esperado);

        Optional<PessoaTO> foo = pessoaDao.buscaPorEmail("foo@bar.com");
        assertThat(foo.isPresent(), is(true));
        assertPessoa(esperado, foo.get());

        jdbcTemplate.execute("DELETE FROM pessoa;");
    }

    @Test
    public void buscaPorEmailQueNaoExiste() {
        Optional<PessoaTO> foo = pessoaDao.buscaPorEmail("foo@bar.com");
        assertThat(foo.isPresent(), is(false));
    }

    @Test
    public void buscaSenha() {
        Pessoa esperado = pessoaDeTest().build();
        pessoaDao.criar(esperado);
        Optional<String> senha = pessoaDao.buscaSenha(esperado.getEmail());

        assertThat(senha.isPresent(), is(true));
        assertThat(senha.get(), equalTo(esperado.getSenha()));

        jdbcTemplate.execute("DELETE FROM pessoa;");
    }

    @Test
    public void buscaSenhaDePessoaQueNaoExiste() {
        Optional<String> senha = pessoaDao.buscaSenha("foo@bar.com");

        assertThat(senha.isPresent(), is(false));
    }

    @Test
    public void editar() {
        Pessoa pessoa = pessoaDeTest().build();
        pessoaDao.criar(pessoa);

        PessoaTO esperado = PessoaTO.builder()
                .email(pessoa.getEmail())
                .nome(pessoa.getNome() + "1")
                .sobrenome(pessoa.getSobrenome() + "1")
                .celular(new Celular(55, 99, 999999999))
                .dataDeNascimento(LocalDate.of(2000, Month.APRIL, 20))
                .build();
        pessoaDao.editar(esperado);

        Optional<PessoaTO> editado = pessoaDao.buscaPorEmail(esperado.getEmail());
        assertThat(editado.isPresent(), is(true));
        assertThat(editado.get().getEmail(), equalTo(esperado.getEmail()));
        assertThat(editado.get().getNome(), equalTo(esperado.getNome()));
        assertThat(editado.get().getSobrenome(), equalTo(esperado.getSobrenome()));
        assertThat(editado.get().getCelular().getDdi(), equalTo(esperado.getCelular().getDdi()));
        assertThat(editado.get().getCelular().getDdd(), equalTo(esperado.getCelular().getDdd()));
        assertThat(editado.get().getCelular().getNumero(), equalTo(esperado.getCelular().getNumero()));
        assertThat(editado.get().getDataDeNascimento(), equalTo(esperado.getDataDeNascimento()));

        jdbcTemplate.execute("DELETE FROM pessoa;");
    }

    @Test
    public void listar() {
        Pessoa pessoa = pessoaDeTest().build();
        pessoaDao.criar(pessoa);
        Pessoa pessoa1 = pessoaDeTest().email("foo1@bar.com").build();
        pessoaDao.criar(pessoa1);
        Pessoa pessoa2 = pessoaDeTest().email("foo2@bar.com").build();
        pessoaDao.criar(pessoa2);

        List<PessoaTO> pessoas = pessoaDao.listar();
        assertThat(pessoas.size(), equalTo(3));
        assertPessoa(pessoa, pessoas.get(0));

        jdbcTemplate.execute("DELETE FROM pessoa;");
    }

    private void assertPessoa(Pessoa esperado, PessoaTO foo) {
        assertThat(foo.getEmail(), equalTo(esperado.getEmail()));
        assertThat(foo.getNome(), equalTo(esperado.getNome()));
        assertThat(foo.getSobrenome(), equalTo(esperado.getSobrenome()));
        assertThat(foo.getCelular().getDdi(), equalTo(esperado.getCelular().getDdi()));
        assertThat(foo.getCelular().getDdd(), equalTo(esperado.getCelular().getDdd()));
        assertThat(foo.getCelular().getNumero(), equalTo(esperado.getCelular().getNumero()));
        assertThat(foo.getDataDeNascimento(), equalTo(esperado.getDataDeNascimento()));
    }

    private PessoaBuilder pessoaDeTest() {
        return new PessoaBuilder()
                .email("foo@bar.com")
                .senha("loucura")
                .nome("Foo")
                .sobrenome("Bar")
                .celular(new Celular(55, 19, 992475689))
                .dataDeNascimento(LocalDate.now());
    }


}
