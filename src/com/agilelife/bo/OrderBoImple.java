package com.agilelife.bo;

import java.sql.SQLException;

import com.agilelife.bo.exceptions.BOException;
import com.agilelife.dao.IOrderDao;
import com.agilelife.dto.Order;

public class OrderBoImple implements IOrderBo {
	
	private IOrderDao dao;

	@Override
	public boolean realizarPedido(Order order) throws BOException {
		
		try{
			int result = dao.crearOrden(order);
			if(result==0){
				return false;
			}
		}
		catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	@Override
	public boolean cancelarOrden(int id) throws BOException {
		
		
		try{
			
			Order order = dao.obtenerOrden(id);
			order.setStatus("cancelada");
			int result = dao.actualizarOrden(order);
			if(result==0){
				return false;
			}
		}
		catch (SQLException e) {
			throw new BOException(e);
		}
		
		return true;
	}

	@Override
	public boolean eliminarOrden(int id) throws BOException {
		
	try{	int result = dao.eliminarOrden(id);
		if(result==0){
			return false;
		}
	}
	catch (SQLException e) {
		throw new BOException(e);
	}
		return false;
	}

}
