package com.example.jpademo.tdcenter.coverageinfo;

import com.example.jpademo.tdcenter.codefile.CodeFileModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "coverageinfo")
@Entity
public class CoverageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fileid", referencedColumnName = "id")
    private CodeFileModel file;

    @Column(name = "scanid")
    private Integer scanId;

    @Column(name = "percentage")
    private Integer percentage;

    @Column(name = "totallines")
    private Integer totallines;

    @Column(name = "missedlines")
    private Integer missedlines;

    @Column(name = "totalmethod")
    private Integer totalmethod;

    @Column(name = "totalcomplexity")
    private Integer totalcomplexity;

    public Integer getTotalcomplexity() {
        return totalcomplexity;
    }

    public void setTotalcomplexity(Integer totalcomplexity) {
        this.totalcomplexity = totalcomplexity;
    }

    public Integer getTotalmethod() {
        return totalmethod;
    }

    public void setTotalmethod(Integer totalmethod) {
        this.totalmethod = totalmethod;
    }

    public Integer getMissedlines() {
        return missedlines;
    }

    public void setMissedlines(Integer missedlines) {
        this.missedlines = missedlines;
    }

    public Integer getTotallines() {
        return totallines;
    }

    public void setTotallines(Integer totallines) {
        this.totallines = totallines;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getScanId() {
        return scanId;
    }

    public void setScanId(Integer scanId) {
        this.scanId = scanId;
    }

    public CodeFileModel getFile() {
        return file;
    }

    public void setFile(CodeFileModel file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
