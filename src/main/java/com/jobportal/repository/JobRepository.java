package com.jobportal.repository;


import com.jobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // You can add custom queries later like findByTitleContaining()
}