/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         Date dataExemplo = sdf.parse("2024/04/30");
         
        Paciente paciente = new Paciente(1, "Senac", null, dataExemplo, null, null, null, null, 1);
        pacienteDAO.cadastrarPaciente(paciente);
        assertEquals(paciente.getNome(),"Senac");
    }
}
