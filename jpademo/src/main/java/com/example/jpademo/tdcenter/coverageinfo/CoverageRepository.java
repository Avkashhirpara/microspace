package com.example.jpademo.tdcenter.coverageinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CoverageRepository extends JpaRepository<CoverageInfo,Integer>, JpaSpecificationExecutor<CoverageInfo>
{
    @Query("select coverage from CoverageInfo coverage left join CodeFileModel cfile on cfile.id = coverage.file.id where cfile.filename =:classname")
    List<CoverageInfo> getCoverageByClassName(@Param("classname") String className);
}
