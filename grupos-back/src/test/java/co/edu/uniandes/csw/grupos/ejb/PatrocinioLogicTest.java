/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.ejb;

import co.edu.uniandes.csw.grupos.entities.PatrocinioEntity;
import co.edu.uniandes.csw.grupos.entities.UsuarioEntity;
import co.edu.uniandes.csw.grupos.persistence.PatrocinioPersistence;
import co.edu.uniandes.csw.grupos.exceptions.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author tefa
 */
@RunWith(Arquillian.class)
public class PatrocinioLogicTest {
    /**
     * Logger de la lógica
     */
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogicTest.class.getName());

    /**
     * Deployment
     * @return Un JavaArchive
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PatrocinioEntity.class.getPackage())
                .addPackage(PatrocinioPersistence.class.getPackage())
                .addPackage(PatrocinioLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase PatrocinioLogic cuyos métodos
     * se van a probar.
     */
    @Inject
    private PatrocinioLogic logic;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Lista que guarda las entidades Patrocinio fuera de la base de datos
     */
    private List<PatrocinioEntity> data = new ArrayList<>();
    
    /**
     * Lista que guarda las entidades de Usuario fuera de la base de datos
     */
    private List<UsuarioEntity> dataU = new ArrayList<>();
    
    public PatrocinioLogicTest() {
    }
    
    /**
     * Se ejecuta antes de todo.
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * Se ejecuta después de todo.
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * setUp ejecutado antes de cada prueba.
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Limpia la base de datos.
     */
    private void clearData() {
        em.createQuery("delete from PatrocinioEntity").executeUpdate();
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    /**
     * Inserta los datos en estructuras (listas) y en la base de datos.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity usuario = factory.manufacturePojo(UsuarioEntity.class);
        em.persist(usuario);
        dataU.add(usuario);
        for (int i = 0; i < 3; i++) {
            PatrocinioEntity entity = factory.manufacturePojo(PatrocinioEntity.class);
            entity.setUsuario(usuario);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * tearDown ejecutado después de cada prueba.
     */
    @After
    public void tearDown() {
        
    }
    
    /**
     * Test que prueba la creación de las entidades.
     */
    @Test
    public void createEntityTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PatrocinioEntity newEntity = factory.manufacturePojo(PatrocinioEntity.class);
        newEntity.setUsuario(dataU.get(0));
        
        PatrocinioEntity result = logic.createPatrocinio(newEntity);
        Assert.assertNotNull(result);
        PatrocinioEntity entity = em.find(PatrocinioEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(entity.getId(), result.getId());
        Assert.assertEquals(entity.getPago(), result.getPago(), 0.0001);
        Assert.assertEquals(entity.getUsuario(), result.getUsuario());
    }
    
    /**
     * Test del método findAll en la persistencia.
     */
    @Test
    public void getPatrociniosTest() {
        List<PatrocinioEntity> list = logic.allPatrocinios();
        assertEquals(data.size(), list.size());
        for (PatrocinioEntity ent : list) {
            boolean found = false;
            for (PatrocinioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Test del método updateEntity de la persistencia.
     */
    @Test
    public void updatePatrocinioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PatrocinioEntity test =factory.manufacturePojo(PatrocinioEntity.class);
        while(data.indexOf(test)>=0)
        {
            test =factory.manufacturePojo(PatrocinioEntity.class);
        }
        boolean estaBien=true;
        try
        {
            logic.updatePatrocinio(test.getId(),test);
        }
        catch(BusinessException e)
        {
            estaBien=false;
            LOGGER.info(e.getMessage());
        }
        if(estaBien)
        {
            Assert.fail();
        } 
        estaBien=true;
        try
        {
            PatrocinioEntity entity = data.get(0);
            PatrocinioEntity newEntity = factory.manufacturePojo(PatrocinioEntity.class);

            newEntity.setId(entity.getId());
            newEntity.setUsuario(dataU.get(0));

            logic.updatePatrocinio(entity.getId(),newEntity);

            PatrocinioEntity resp = em.find(PatrocinioEntity.class, entity.getId());

            assertEquals(resp.getId(), newEntity.getId());
            Assert.assertEquals(resp.getPago(), newEntity.getPago(), 0.0001);
            Assert.assertEquals(resp.getUsuario(), dataU.get(0));
        }
        catch(BusinessException e)
        {
            estaBien=false;
            LOGGER.info(e.getMessage());
        }
        if(!estaBien)
        {
            Assert.fail();
        }
    }
}
