package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.SolrIndex;
import com.example.bean.SolrResult;

@RestController
public class SolrController {
@Autowired
SolrResult solrResult;

@GetMapping(value="/solrsearch")
	public ResponseEntity<SolrResult> search(@RequestParam String field,@RequestParam String value,@RequestParam String start,@RequestParam String stop,
			@RequestParam String tag,@RequestParam String order) throws SolrServerException, IOException
{
	SolrClient client=new HttpSolrClient.Builder("http://localhost:8983/solr/techproducts").build();
	SolrQuery query=new SolrQuery();
	query.set("q", field+":"+value);
	query.set("start", start);
	query.set("rows", stop);
	
	SortClause sortClause=new SortClause(tag, order);
	query.setSort(sortClause);
	
	QueryResponse response=client.query(query);
	List<SolrIndex> docs=response.getBeans(SolrIndex.class);
	SolrDocumentList numdocs=response.getResults();
	response.getDebugMap();
	long numDocs=numdocs.getNumFound();
	solrResult.setNumDocs(numDocs);
	solrResult.setSolrindex(docs);
	return new ResponseEntity<SolrResult>(solrResult,HttpStatus.OK);
	
}
}
