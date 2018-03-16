package de.rboerner.springdemo.service;

import de.rboerner.springdemo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheType;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureCache(cacheProvider = CacheType.SIMPLE)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testFindAll() {
        Iterable<Person> persons = personRepository.findAll();
        int size = 0;
        for (Person p : persons)
            size++;
        assertEquals(size, personRepository.count());
    }

    @Test
    public void testFindById() {
        Person p = personRepository.findById(1).get();
        assertEquals("Roy", p.getFirstName());
        assertEquals("Boerner", p.getLastName());
    }

    @Test
    public void testFindByLastName() {
        Cache cache = cacheManager.getCache("persons");
        assertNotNull(cache);
        cache.clear();

        assertNull(cache.get("Boerner"));

        List<Person> persons = personRepository.findByLastName("Boerner");
        assertEquals(1, persons.size());
        assertEquals("Roy", persons.get(0).getFirstName());

        assertNotNull(cache.get("Boerner"));

        personRepository.findByLastName("Boerner");
        personRepository.findByLastName("Boerner");
        personRepository.findByLastName("Boerner");
    }

    @Test
    public void testFindByLastNameNull() {
        List<Person> persons = personRepository.findByLastName(null);
        assertEquals(1, persons.size());
        assertEquals(new Integer(3), persons.get(0).getId());
    }

    @Test
    public void testFindByLastNameNoResult() {
        List<Person> persons = personRepository.findByLastName(null);
        assertEquals(1, persons.size());
        assertEquals(new Integer(3), persons.get(0).getId());
    }

    @Test
    public void testSave() {
        Person p = new Person();
        p.setFirstName("unit");
        p.setLastName("test");
        assertNull(p.getId());
        Person p2 = personRepository.save(p);
        assertNotNull(p2.getId());
    }

}