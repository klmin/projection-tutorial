package com.projectiontutorial.team.repository;

import com.projectiontutorial.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    <T> T findByTeamId(Long id, Class<T> clazz);
    <T> List<T> findAllBy(Class<T> clazz);
}
