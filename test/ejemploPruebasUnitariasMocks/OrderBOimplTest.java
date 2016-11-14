package ejemploPruebasUnitariasMocks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.agilelife.bo.OrderBoImple;
import com.agilelife.bo.exceptions.BOException;
import com.agilelife.dao.IOrderDao;
import com.agilelife.dto.Order;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class OrderBOimplTest {
	
	
	@Mock
	IOrderDao dao;
	
	private OrderBoImple bo;
	
	private Order orden;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		 bo = new OrderBoImple();
	     bo.setDao(dao);
	     orden = new Order();
	}

	@Test
	public void realizarUnaOrdenDeberiaCrearUnaOrden() throws SQLException, BOException {
		when(dao.crearOrden(orden)).thenReturn(new Integer(1));
		boolean resultado = bo.realizarPedido(orden);
		assertTrue(resultado);
		verify(dao).crearOrden(orden);
	}

	@Test
	public void realizarUnaOrdenDeberiaNoCrearUnaOrden() throws SQLException, BOException {
		when(dao.crearOrden(orden)).thenReturn(new Integer(0));
		boolean resultado = bo.realizarPedido(orden);
		assertFalse(resultado);
		verify(dao).crearOrden(orden);
	}
	
	@Test(expected=BOException.class	)
	public void realizarUnaOrdenDeberiaLanzarUnaExcepcion() throws SQLException, BOException {
		when(dao.crearOrden(orden)).thenThrow(SQLException.class);
		boolean resultado = bo.realizarPedido(orden);
	}
	
	@Test
	public void cancelarUnaOrdenDeberiaCancelarLaOrden() throws SQLException, BOException {
		when(dao.obtenerOrden(123)).thenReturn(orden);
		when(dao.actualizarOrden(orden)).thenReturn(1);
		boolean resultado = bo.cancelarOrden(123);
		assertTrue(resultado);
		verify(dao).obtenerOrden(123);
		verify(dao).actualizarOrden(orden);
	}
	
	@Test
	public void cancelarUnaOrdenNoDeberiaCancelarLaOrden() throws SQLException, BOException {
		when(dao.obtenerOrden(123)).thenReturn(orden);
		when(dao.actualizarOrden(orden)).thenReturn(0);
		boolean resultado = bo.cancelarOrden(123);
		assertFalse(resultado);
		verify(dao).obtenerOrden(123);
		verify(dao).actualizarOrden(orden);
	}
	
	@Test(expected=BOException.class	)
	public void cancelarUnaOrdenDeberiaLanzarUnaExcepcion() throws SQLException, BOException {
		when(dao.obtenerOrden(123)).thenThrow(SQLException.class);
		boolean resultado = bo.cancelarOrden(123);
	}
	
	@Test(expected=BOException.class	)
	public void cancelarUnaOrdenDeberiaLanzarExcepcionSobreActualizarOrden() throws SQLException, BOException {
		when(dao.obtenerOrden(123)).thenReturn(orden);
		when(dao.actualizarOrden(orden)).thenThrow(SQLException.class);
		bo.cancelarOrden(123);
	}
	
	@Test
	public void eliminarUnaOrdenDeberiaEliminarUnaOrden() throws SQLException, BOException {
		when(dao.eliminarOrden(123)).thenReturn(new Integer(1));
		boolean resultado = bo.eliminarOrden(123);
		assertTrue(resultado);
		verify(dao).eliminarOrden(123);
	}

	@Test
	public void eliminarUnaOrdenDeberiaNoCrearUnaOrden() throws SQLException, BOException {
		when(dao.eliminarOrden(123)).thenReturn(new Integer(0));
		boolean resultado = bo.eliminarOrden(123);
		assertFalse(resultado);
		verify(dao).eliminarOrden(123);
	}
	
	@Test(expected=BOException.class	)
	public void eliminarUnaOrdenDeberiaLanzarUnaExcepcion() throws SQLException, BOException {
		when(dao.eliminarOrden(123)).thenThrow(SQLException.class);
		boolean resultado = bo.eliminarOrden(123);
	}

}
