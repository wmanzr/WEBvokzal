package RUT.vokzal.Repository;

import java.util.List;
import RUT.vokzal.Entity.Platform;

public interface PlatformRepository {
    public void create(Platform platform);
    public Platform findById(Integer id);
    public Platform update(Platform platform);
    public List<Platform> findAll();
}