package com.dtcc.Service;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.dtcc.model.OrderModel;

/**
 * 
 */
/**
 * @author sandeep
 *
 */
public class SalesOrderService implements Runnable {

	final static Logger logger = Logger.getLogger(SalesOrderService.class);

	private BlockingQueue<OrderModel> OrderModels;

	public SalesOrderService(BlockingQueue<OrderModel> OrderModels) {
		this.OrderModels = OrderModels;
	}

	public void run() {
		
		
		for (int i = 1; i <= 10; i++) {
			try {

				// Pause for 3 seconds
				Thread.sleep(30);
								
				//setting up sales state field 
				OrderModels.take().setSales_state_field(" Sales Order Fullfilled");

				logger.info("##################################################################################");
				logger.info("The Sales Order Number " + i
						+ " is been Processed, And the order of the state is been Fullfilled");

				logger.info("##################################################################################");

				logger.info("Thread " + i + " ends here");

			} catch (Exception e) {
				logger.info("##################################################################################");
				System.out.println("Exception while Creating the Sales Order:- " + e);
				logger.info("##################################################################################");
			}
		}

	}
}