package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArduinoRepositoryHibernate implements ArduinoRepository {

    @Override
    public <S extends ArduinoDao> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ArduinoDao> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ArduinoDao> findById(Integer integer) {
        return Optional.empty();
    }


    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<ArduinoDao> findAll() {
        return null;
    }

    @Override
    public Iterable<ArduinoDao> findAllById(Iterable<Integer> integers) {
        return null;
    }


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ArduinoDao entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ArduinoDao> entities) {

    }


    @Override
    public void deleteAll() {

    }
}
