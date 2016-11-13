package com.agilelife.bo;

import com.agilelife.bo.exceptions.BOException;
import com.agilelife.dto.Order;

public interface IOrderBo {

	
	boolean realizarPedido(Order order) throws BOException;
	
	boolean cancelarOrden(int id)throws BOException;
	
	boolean eliminarOrden(int id)throws BOException;
}
