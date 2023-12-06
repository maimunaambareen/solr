package com.example.bean;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class SolrIndex {
private String id;
private String name;
private List<String> features;
private List<String> cat;
public String getId() {
	return id;
}
@Field
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
@Field
public void setName(String name) {
	this.name = name;
}
public List<String> getFeatures() {
	return features;
}
@Field
public void setFeatures(List<String> features) {
	this.features = features;
}
public List<String> getCat() {
	return cat;
}
@Field
public void setCat(List<String> cat) {
	this.cat = cat;
}

}
