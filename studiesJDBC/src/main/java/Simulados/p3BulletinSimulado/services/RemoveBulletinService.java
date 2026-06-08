package Simulados.p3BulletinSimulado.services;



import Simulados.p3BulletinSimulado.dao.BulletinDao;
import Simulados.p3BulletinSimulado.model.Bulletin;

import java.util.NoSuchElementException;

public class RemoveBulletinService {

    private final BulletinDao<Bulletin> bulletinDao;

    public RemoveBulletinService(BulletinDao<Bulletin> bulletinDao) {
        this.bulletinDao = bulletinDao;
    }

    public void remove(Integer id) {
        if (id == null) { throw new IllegalArgumentException("Id não pode ser nulo!"); }

        if (!bulletinDao.existsById(id)) { throw new NoSuchElementException("O bulletin de id " + id + "não existe no banco!"); }

        bulletinDao.delete(id);
    }

}
