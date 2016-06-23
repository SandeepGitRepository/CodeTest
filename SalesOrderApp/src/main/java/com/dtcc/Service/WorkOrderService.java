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
public class WorkOrderService implements Runnable {

	final static Logger logger = Logger.getLogger(WorkOrderService.class);

	private BlockingQueue<OrderModel> OrderModels;

	public WorkOrderService(BlockingQueue<OrderModel> OrderModels) {
		this.OrderModels = OrderModels;
	}

	public void run() {

		//An Order is simply a class with a state field and an order number (1-10)
		
		for (int i = 1; i <= 10; i++) {

			//The WorkerOderImpl class is holding  an instance of a queue of Order objects.
			OrderModel orderModels = new OrderModel("NEW Sales Order ", i);
			
			logger.info("Thread "+i+" Started");
			
			try {
				
				//Pause for 1 seconds
				Thread.sleep(10);
				OrderModels.put(orderModels);
				
				// printing standard output.
				logger.info("##################################################################################");
				
				//gets sales state field and sales order id's
				logger.info("Sales Order:- Staus Message - " + orderModels.getSales_state_field() + orderModels.getSales_order_id()
						+ " had been Processed.");
				logger.info("##################################################################################");
			} catch (Exception e) {
				logger.info("##################################################################################");
				logger.error("Exception while Creating the Order:- " + e);
				logger.info("##################################################################################");

			}
		}

	}

}
