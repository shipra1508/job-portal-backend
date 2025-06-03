package com.jobportal.mapper;

import org.mapstruct.Mapper;
import com.jobportal.dto.JobDTO;
import com.jobportal.BO.JobBO;
import com.jobportal.entity.JobEntity;

@Mapper(componentModel = "spring")
public interface JobMapper {

    JobBO toBO(JobDTO dto);                // DTO → BO
    JobDTO toDTO(JobBO bo);                // BO → DTO

    JobEntity toEntity(JobBO bo);          // BO → Entity
    JobBO toBO(JobEntity entity);          // Entity → BO

    JobDTO toDTO(JobEntity entity);        // for updateJob() response
}
