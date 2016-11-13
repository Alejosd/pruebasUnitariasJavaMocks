package com.agilelife.dao;

import java.sql.SQLException;

import com.agilelife.dto.Order;

public interface IOrderDao {
	
	int crearOrden(Order order) throws SQLException;
	
	Order obtenerOrden(Order order) throws SQLException;
	
	int actualizarOrden()throws SQLException;
	
	int eliminarOrden()throws SQLException;

}
