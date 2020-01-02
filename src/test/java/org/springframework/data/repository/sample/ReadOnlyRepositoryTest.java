package org.springframework.data.repository.sample;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ReadOnlyRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReadOnlyRepositoryTest {

    @Autowired ReadOnlyUserRepository readOnyUserRepository;


    interface ReadOnlyUserRepository extends ReadOnlyRepository<User, Long> {}


}
