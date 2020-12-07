package com.example.servicenovigrad.data.Class;

import org.w3c.dom.Document;

import java.util.List;

public class NovService {

    public String serviceName = "";
    private List<Branch> branchList;
    private boolean isExpiration = false;
    private ServiceDoc ServiceDoc;
    private Document document;
    private String id;

    public NovService(String serviceName, List<Branch> branchList, boolean isExpiration, String id) {
        this.serviceName = serviceName;
        this.branchList = branchList;
        this.isExpiration = isExpiration;
        this.id = id;
    }

    public NovService(String serviceName, List<Branch> branchList, boolean isExpiration, ServiceDoc servicedoc, Document doc, String id) {
        this.serviceName = serviceName;
        this.branchList = branchList;
        this.isExpiration = isExpiration;
        ServiceDoc = servicedoc;
        this.document = doc;
        this.id = id;
    }
    public NovService(){
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public boolean isExpiration() {
        return isExpiration;
    }

    public void setExpiration(boolean expiration) {
        isExpiration = expiration;
    }

    public ServiceDoc getServicedoc() {
        return ServiceDoc;
    }

    public void setServicedoc(ServiceDoc servicedoc) {
        ServiceDoc = servicedoc;
    }

    public Document getDoc() {
        return document;
    }

    public void setDoc(Document doc) {
        this.document = doc;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
