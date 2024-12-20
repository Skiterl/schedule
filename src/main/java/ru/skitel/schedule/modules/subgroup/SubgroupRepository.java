package ru.skitel.schedule.modules.subgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SubgroupRepository extends JpaRepository<Subgroup, Integer> {
    Optional<List<Subgroup>> findByGroupId(int groupId);
}
