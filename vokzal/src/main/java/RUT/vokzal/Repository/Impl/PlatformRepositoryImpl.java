package RUT.vokzal.Repository.Impl;

import RUT.vokzal.Entity.Platform;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.PlatformRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PlatformRepositoryImpl extends BaseRepository<Platform, Integer> implements PlatformRepository {

    public PlatformRepositoryImpl() {
        super(Platform.class);
    }

    @Override
    @Transactional
    public void create(Platform platform) {
        super.create(platform);
    }

    @Override
    public Platform findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Platform update(Platform platform) {
        return super.update(platform);
    }

    @Override
    public List<Platform> findAll() {
        return super.findAll();
    }
}