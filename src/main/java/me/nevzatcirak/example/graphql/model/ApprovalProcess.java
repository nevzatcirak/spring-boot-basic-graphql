package me.nevzatcirak.example.graphql.model;

import java.util.List;

public class ApprovalProcess {
    private String id;
    private String documentType;
    private String documentId;
    private String creator;
    private String status;
    private List<String> approverIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getApproverIds() {
        return approverIds;
    }

    public void setApproverIds(List<String> approverIds) {
        this.approverIds = approverIds;
    }
}
