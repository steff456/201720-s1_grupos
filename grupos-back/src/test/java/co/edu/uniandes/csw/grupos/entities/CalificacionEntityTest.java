/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.grupos.entities;


import java.util.Date;
import java.util.Objects;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;

import org.jboss.shrinkwrap.api.ShrinkWrap;

import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Prueba sobre la persistencia de calificación
 * @author s.guzmanm
 */
@RunWith(Arquillian.class)
public class CalificacionEntityTest {
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Calificacion, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    

    /**
     * Test of qualification methods, of class CalificacionEntity.
     */
    @Test
    public void testCalificacion()  {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        newEntity.setCalificacion(4.0);

        Assert.assertEquals(new Double(4.0), newEntity.getCalificacion());

    }
    
    /**
     * Test of blog methods, of class CalificacionEntity.
     */
    @Test
    public void testBlog()  {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        BlogEntity blog=factory.manufacturePojo(BlogEntity.class);
        newEntity.setBlog(blog);

        Assert.assertEquals(blog, newEntity.getBlog());

    }
    
    /**
     * Test of date  methods, of class CalificacionEntity.
     */
    @Test
    public void testFecha()  {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        Date expected=new Date();
        newEntity.setFecha(expected);

        
        Assert.assertEquals(expected, newEntity.getFecha());

    }
    
    /**
     * Test of qualifications method, of class LugarEntity.
     */
    @Test
    public void testCalificador()  {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        UsuarioEntity usuario = factory.manufacturePojo(UsuarioEntity.class);
        newEntity.setCalificador(usuario);

        Assert.assertEquals(usuario, newEntity.getCalificador());

    }
    
    /**
     * Test of createEntity method, of class LugarEntity.
     */
    @Test
    public void testId()  {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        newEntity.setId(4l);

        Assert.assertEquals(new Long(4l), newEntity.getId());

    }
    /**
     * Test del método equals
     */
    @Test
    public void testEquals()
    {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity e=factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity e2=factory.manufacturePojo(CalificacionEntity.class);
        e2.setId(e.getId());
        Assert.assertFalse(e.equals(new UsuarioEntity()));
        Assert.assertTrue(e.equals(e2));
    }
    /**
     *
     * Test of hashcode
     */
    @Test
    public void testHash()
    {
        PodamFactory factory= new PodamFactoryImpl();

        CalificacionEntity e=factory.manufacturePojo(CalificacionEntity.class);
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(e.getId());
        Assert.assertEquals(hash,e.hashCode());
    }

    
    
}
