
package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wendell Marcos
 */
public class PacienteDAOTest {
    
    private PacienteDAO pacienteDAO;
    
    public PacienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         pacienteDAO = new PacienteDAO();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testBuscarPaciente() throws SQLException{
        ArrayList<Paciente> lista = pacienteDAO.buscarPaciente();
        assertNotNull(lista);
    }
    
    @Test
    public void testCadastrarPaciente () throws SQLException, ParseException{
        
        // nome, cpf,  data de nascimento, endereço, telefone
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         Date dataExemplo = sdf.parse("2024/04/30");
         
        Paciente paciente = new Paciente(1, "Senac", "rua 7", dataExemplo, "0000000000", "9990999090", null, "teste@teste.com.br", 1);
        pacienteDAO.cadastrarPaciente(paciente);
        assertEquals(paciente.getNome(),"Senac");
    }
    
    // Teste para pesquisar nome João
        @Test
    public void testBuscarPacientesPorNome() throws SQLException {
     List<Paciente> resultados = pacienteDAO.buscarPacienteFiltro("João");
        
        assertEquals(resultados, "Pesquisa por nome João");
    }

    // Teste pesquisa telefone
    @Test
    public void testBuscarPacientesPorTelefone() throws SQLException {
        List<Paciente> resultados = pacienteDAO.buscarPacienteFiltro("19999999");
        
        assertEquals(resultados, "Nenhum paciente deve ser encontrado com este telefone");
    }
}
