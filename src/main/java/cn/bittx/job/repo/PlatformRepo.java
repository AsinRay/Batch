package cn.bittx.job.repo;

import cn.bittx.job.bean.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepo extends JpaRepository<Platform,Integer> {

    @Query(value = "select p from Platform p where p.id=1")
    Platform getVersion();
}
