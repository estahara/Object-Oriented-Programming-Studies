package Simulados.p3BulletinSimulado.services;



import Simulados.p3BulletinSimulado.dao.BulletinDao;
import Simulados.p3BulletinSimulado.model.Bulletin;

import java.util.NoSuchElementException;

public class UpdateBulletinService {
    private final BulletinDao<Bulletin> bulletinDao;

    public UpdateBulletinService(BulletinDao<Bulletin> bulletinDao) {
        this.bulletinDao = bulletinDao;
    }

    public void update(Bulletin bulletin) {
        if (bulletin == null) {throw new IllegalArgumentException("Bulletin não pode ser nulo!"); }

        if (!bulletinDao.existsById(bulletin.getId())) {throw new NoSuchElementException("Bulletin de id " + bulletin.getId() + " não existe no banco!"); }

        bulletinDao.update(bulletin);
    }

}
