package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom,Integer>{
    @Query("SELECT rr FROM RecoveryRoom rr")
    List<RecoveryRoom> findAll();

    @Query("SELECT rrt FROM RecoveryRoomType rrt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();

    Optional<RecoveryRoom> findById(int id);

    RecoveryRoom save(RecoveryRoom p);

    @Query("SELECT rrt FROM RecoveryRoomType rrt WHERE rrt.name=:name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
    
    @Query("SELECT rr FROM RecoveryRoom rr WHERE rr.size >:size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size") Double size);

}
