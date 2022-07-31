package com.example.demo

import com.example.demo.entity.Hello
import com.example.demo.entity.QHello
import com.querydsl.jpa.impl.JPAQueryFactory
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@SpringBootTest
@Transactional
class DemoApplicationTests {

    @Autowired
    lateinit var em: EntityManager

    @Test
    fun contextLoads() {
        var hello = Hello()
        em.persist(hello)

        var query = JPAQueryFactory(em)
        var qHello = QHello("h")

        var result: Hello? = query.selectFrom(qHello)
            .fetchOne()

        Assertions.assertThat(result).isEqualTo(hello)
        Assertions.assertThat(result?.id).isEqualTo(hello.id)
    }

}
