package Simulados.p3BulletinSimulado.services;


import Simulados.p3BulletinSimulado.dao.BulletinDao;
import Simulados.p3BulletinSimulado.exception.EntityAlreadyExistsException;
import Simulados.p3BulletinSimulado.model.Bulletin;

public class RegisterBulletinService {
    private final BulletinDao<Bulletin> bulletinDao;

    public RegisterBulletinService(BulletinDao<Bulletin> bulletinDao) {
        this.bulletinDao = bulletinDao;
    }

    public void register(Bulletin bulletin) {
        if (bulletin == null) {throw new IllegalArgumentException("Bulletin não pode ser nulo!");}

        if (bulletinDao.existsById(bulletin.getId())) {throw new EntityAlreadyExistsException("O bulletin de id " + bulletin.getId() + " já existe no banco!");}

        bulletinDao.insert(bulletin);
    }

}
