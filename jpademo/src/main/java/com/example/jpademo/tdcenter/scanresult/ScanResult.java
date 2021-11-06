package com.example.jpademo.tdcenter.scanresult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scanresult")
public class ScanResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fileid")
    private Integer fileId;

    @Column(name = "tdruleid")
    private Integer tDRuleId;

    @Column(name = "scanid")
    private Integer scanId;

    @Column(name = "occurancecount")
    private Integer occuranceCount;

    public Integer getOccuranceCount() {
        return occuranceCount;
    }

    public void setOccuranceCount(Integer occuranceCount) {
        this.occuranceCount = occuranceCount;
    }

    public Integer getScanId() {
        return scanId;
    }

    public void setScanId(Integer scanId) {
        this.scanId = scanId;
    }

    public Integer getTDRuleId() {
        return tDRuleId;
    }

    public void setTDRuleId(Integer tDRuleId) {
        this.tDRuleId = tDRuleId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
