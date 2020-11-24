package com.ibm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

@Configuration
public class RibbonLBConfiguration {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Bean
	public IRule loadBlancingRule() {
	    return new RoundRobinRule();
	}
	
	@Bean
	public IPing pingConfiguration(ServerList<Server> servers) {
	  String pingPath = "/currencyConversionFactor/get?countryCode=IN";
	  IPing ping = new PingUrl(false, pingPath);        
	  System.out.println("Configuring ping URI to [{}]");
	  return ping;    
	}
	
	@Bean
	public ServerList<Server> serverList() {
	  return new ServerList<Server>() {
	    @Override
	    public List<Server> getUpdatedListOfServers() {
	    	List<ServiceInstance> serverInstances = discoveryClient.getInstances("MS1");
	    	List<Server> severs = new ArrayList<Server>();
	    	serverInstances.stream().forEach(serviceInstance->{
	    		severs.add(new Server("http", "mnge-currency-conversion", serviceInstance.getPort()));
	    	});     
	      System.out.println("Returning updated list of servers [{"+ severs +"}]");
	      return severs;
	    }
	    @Override
	    public List<Server> getInitialListOfServers() {
	      return Arrays.asList(new Server("http", "mnge-currency-conversion", 8070));
	    }
	  };
	}
}
