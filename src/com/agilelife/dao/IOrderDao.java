package com.agilelife.dao;

import java.sql.SQLException;

import com.agilelife.dto.Order;

public interface IOrderDao {
	
	int crearOrden(Order orden) throws SQLException;
	
	Order obtenerOrden(int id) throws SQLException;
	
	int actualizarOrden(Order orden)throws SQLException;
	
	int eliminarOrden(int id)throws SQLException;

}
