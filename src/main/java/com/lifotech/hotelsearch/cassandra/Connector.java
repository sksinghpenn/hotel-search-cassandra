package com.lifotech.hotelsearch.cassandra;

import org.apache.cassandra.thrift.Cassandra.Client;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class Connector {

	private TTransport tr = new TSocket("localhost", 9160);

	public Client connect() throws InvalidRequestException, TException {
		TFramedTransport tf = new TFramedTransport(tr);

		TProtocol proto = new TBinaryProtocol(tf);

		Client client = new Client(proto);

		tr.open();

		client.set_keyspace(Constants.KEYSPACE);

		return client;

	}

	public void close() {
		tr.close();
	}

	public static void main(String[] args) {
		// test cassandra conenction
		try {
			Connector connector = new Connector();
			connector.connect();
			System.out.println("Got Connected");
			connector.close();
			System.out.println("Got disconnected..");

		} catch (InvalidRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
