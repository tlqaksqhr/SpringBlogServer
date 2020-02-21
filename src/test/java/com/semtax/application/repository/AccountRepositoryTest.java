package com.semtax.application.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate dataTemplate;


    @Test
    public void di() throws SQLException {
        /*
        try(Connection connection =  dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
         */

        //Account existingAccount = accountRepository.findByUsername("semtax");
        //assertThat(existingAccount).isNotNull();


        //Account nonExistingAccount = accountRepository.findByUsername("joker");
        //assertThat(nonExistingAccount).isNull();

        // Optional 객체는 isEmpty로 확인하기..
    }

}