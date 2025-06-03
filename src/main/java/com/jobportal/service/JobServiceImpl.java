package com.jobportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.BO.JobBO;
import com.jobportal.dto.JobDTO;
import com.jobportal.entity.JobEntity;
import com.jobportal.exception.custom.JobNotFoundException;
import com.jobportal.mapper.JobMapper;
import com.jobportal.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapper jobMapper;

    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        JobBO bo = jobMapper.toBO(jobDTO);
        JobEntity savedEntity = jobRepository.save(jobMapper.toEntity(bo));
        return jobMapper.toDTO(jobMapper.toBO(savedEntity));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(jobMapper::toBO)
                .map(jobMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobDTO getJobById(Long id) {
        JobEntity entity = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        return jobMapper.toDTO(jobMapper.toBO(entity));
    }

    @Override
    public JobDTO updateJob(Long id, JobDTO jobDTO) {
        JobEntity existing = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));

        JobBO bo = jobMapper.toBO(jobDTO);

        // Set updated fields
        existing.setTitle(bo.getTitle());
        existing.setDescription(bo.getDescription());
        existing.setLocation(bo.getLocation());
        existing.setStatus(bo.getStatus());
        existing.setCompany(bo.getCompany());
        existing.setSalary(bo.getSalary());

        JobEntity updated = jobRepository.save(existing);

        return jobMapper.toDTO(updated);  // ✅ now works after mapper update
    }


    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}