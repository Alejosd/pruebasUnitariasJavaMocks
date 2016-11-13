package ejemploPruebasUnitariasMocks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.agilelife.bo.OrderBoImple;
import com.agilelife.dao.IOrderDao;
import com.agilelife.dto.Order;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class OrderBOimplTest {
	
	
	@Mock
	IOrderDao dao;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void realizarUnaOrdenDeberiaCrearUnaOrden() throws SQLException {
		OrderBoImple bo = new OrderBoImple();
		bo.setDao(dao);
		Order orden = new Order();
		when(dao.crearOrden(orden)).thenReturn(new Integer(1));
	}

}
