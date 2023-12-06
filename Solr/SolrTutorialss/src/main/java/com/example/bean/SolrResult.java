package com.example.bean;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class SolrResult {
private Long numDocs;
private List<SolrIndex> solrindex;
public Long getNumDocs() {
	return numDocs;
}
public void setNumDocs(Long numDocs) {
	this.numDocs = numDocs;
}
public List<SolrIndex> getSolrindex() {
	return solrindex;
}
public void setSolrindex(List<SolrIndex> solrindex) {
	this.solrindex = solrindex;
}
@Override
public String toString() {
	return "SolrResult [numDocs=" + numDocs + ", solrindex=" + solrindex + "]";
}

}
