package com.dtcc.Jobrunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.dtcc.Service.SalesOrderService;
import com.dtcc.Service.WorkOrderService;
import com.dtcc.model.OrderModel;

/**
 * 
 */
/**
 * @author sandeep
 *
 */

/**
 * The main method of SalesOrderApp
 *
 */
public class WorkOrderMainApp {
	
	final static Logger logger = Logger.getLogger(WorkOrderMainApp.class);

	public static void main(String[] args) {
		
		logger.info("##################################################################################");
		logger.info("The Sales Order App has been initiated");
		logger.info("##################################################################################");
		// The max size of this queue is 5
		BlockingQueue<OrderModel> OrderModels = new ArrayBlockingQueue<OrderModel>(5);

		
		WorkOrderService WorkerOrderService = new WorkOrderService(OrderModels);

		
		SalesOrderService salesOrderService = new SalesOrderService(OrderModels);

		// starting new thread for workorderservice		
		new Thread(WorkerOrderService).start();

		
		// starting new thread for salesorderservice
		new Thread(salesOrderService).start();

	}

}
