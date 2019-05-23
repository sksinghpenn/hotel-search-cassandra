package com.lifotech.hotelsearch.cassandra;

import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.thrift.TException;


public class Prepopulate {
	
	private static final Log log = LogFactory.getLog(Prepopulate.class);
	
	private Cassandra.Client client;
	private Connector connector;
	
	// construct open connection so we don't have to open it always
	public Prepopulate() throws InvalidRequestException, TException {
		connector = new Connector();
		client = connector.connect();
	}
	
	public void prePopulate() {
		insertAllHotels();
	}

	private void insertAllHotels() {
		String columnFamily = "Hotel";
		
		
		
	}
}
