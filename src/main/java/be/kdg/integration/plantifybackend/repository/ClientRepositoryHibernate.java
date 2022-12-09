package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.hibernate.ClientDao;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class ClientRepositoryHibernate implements ClientRepository{
    @Override
    public <S extends ClientDao> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ClientDao> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ClientDao> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<ClientDao> findAll() {
        return null;
    }

    @Override
    public Iterable<ClientDao> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ClientDao entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends ClientDao> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
