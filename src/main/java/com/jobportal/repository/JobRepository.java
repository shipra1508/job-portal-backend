package com.jobportal.repository;


import com.jobportal.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {
    // You can add custom queries later like findByTitleContaining()
}