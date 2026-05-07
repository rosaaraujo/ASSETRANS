package com.araujo.assetrans.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documentation")
public class Documentation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(name = "document_type")
  private String documentType;

  @Column(name = "file_path")
  private String filePath;

  @Column(name = "issue_date")
  private LocalDate issueDate;

  @ManyToOne
  @JoinColumn(name = "asset_id")
  private Asset asset;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDocumentType() { return documentType; }
  public void setDocumentType(String documentType) { this.documentType = documentType; }
  public String getFilePath() { return filePath; }
  public void setFilePath(String filePath) { this.filePath = filePath; }
  public LocalDate getIssueDate() { return issueDate; }
  public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
  public Asset getAsset() { return asset; }
  public void setAsset(Asset asset) { this.asset = asset; }
}