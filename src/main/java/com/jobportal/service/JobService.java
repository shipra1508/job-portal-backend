package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.JobDTO;

public interface JobService {
    JobDTO createJob(JobDTO jobDTO);
    List<JobDTO> getAllJobs();
    JobDTO getJobById(Long id);
    JobDTO updateJob(Long id, JobDTO jobDTO);
    void deleteJob(Long id);
}
