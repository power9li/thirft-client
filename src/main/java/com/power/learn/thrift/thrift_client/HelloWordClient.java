package com.power.learn.thrift.thrift_client;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.power.learn.thrift.gen.HelloWordService;
import com.power.learn.thrift.gen.Request;
import com.power.learn.thrift.gen.RequestType;

public class HelloWordClient {
	public static void main(String[] args) {
		TTransport transport;
		try {
			transport = new TSocket("localhost", 9090);
			transport.open(); // 建⽴立连接
			
			TProtocol protocol = new TBinaryProtocol(transport); // 创建client
			HelloWordService.Client client = new HelloWordService.Client(protocol);

			// 第⼀一种请求类型
			Request request = new Request()
					.setType(RequestType.SAY_HELLO).setName("winwill2012").setAge(24);
			System.out.println(client.doAction(request));

			// 第⼆二种请求类型
			request.setType(RequestType.QUERY_TIME).setName("winwill2012");
			System.out.println(client.doAction(request));
			transport.close(); // 请求结束，断开连接
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
