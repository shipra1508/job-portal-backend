package com.jobportal.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.jobportal.dto.JobDTO;
import com.jobportal.service.JobService;

@RestController
@RequestMapping("/job-portal")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/create")
    public ResponseEntity<JobDTO> createJob(@Valid @RequestBody JobDTO jobDTO) {
        JobDTO createdJob = jobService.createJob(jobDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable("id") Long id) {
        JobDTO job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable("id") Long id, @Valid @RequestBody JobDTO jobDTO) {
        return ResponseEntity.ok(jobService.updateJob(id, jobDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobDTO>> getJobsByStatus(@PathVariable("status") String status) {
        List<JobDTO> jobs = jobService.getAllJobs();
        List<JobDTO> filtered = jobs.stream()
                .filter(job -> job.getStatus().equalsIgnoreCase(status))
                .toList();
        return ResponseEntity.ok(filtered);
    }
}
