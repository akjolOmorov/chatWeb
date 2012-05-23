package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import javax.ejb.Handle;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/***
 * 
 * @author dolphin
 *
 */

public class ServiceLocator {
	
	private static ServiceLocator me;
	private InitialContext context = null;
	
	private ServiceLocator() throws ServiceLocatorException {
		try {
			context = new InitialContext();
		} catch(NamingException ne) {
			throw new ServiceLocatorException(ne.getLocalizedMessage());
		}
	}
	
	// Возвращает �?кземпл�?р кла�?�?а ServiceLocator
	public static ServiceLocator getInstance() throws ServiceLocatorException {
		if (me == null) {
			me = new ServiceLocator();
		}
		return me;
	}
	
	// Преобразует �?ериализованную �?троку в EJBHandle
	// затем в EJBObject.
	public EJBObject getService(String id) throws ServiceLocatorException {
		if (id == null) {
			throw new ServiceLocatorException("EJB identificator is null!");
		}
		try {
			byte[] bytes = new String(id).getBytes();
			InputStream io = new ByteArrayInputStream(bytes);
			ObjectInputStream os = new ObjectInputStream(io);
			Handle handle = (Handle)os.readObject();
			os.close();
			io.close();
			
			return handle.getEJBObject();
		} catch(Exception ex) {
			throw new ServiceLocatorException(ex.getLocalizedMessage());
		}
	}
	
	// Возвращает объект String, пред�?тавл�?ющий идентификатор
	// данного EJBObject в �?ериализованном формате.
	protected String getId(EJBObject session) throws ServiceLocatorException {
		try {
			Handle handle = session.getHandle();
			ByteArrayOutputStream fo = new ByteArrayOutputStream();
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(handle);
			so.flush();
			so.close();
			return new String(fo.toByteArray());
		} catch(RemoteException ex) {
			throw new ServiceLocatorException(ex.getLocalizedMessage());
		} catch(IOException ex) {
			throw new ServiceLocatorException(ex.getLocalizedMessage());
		}
	}
	
	// Возвращает объект EJBObject запрошенного имени
	// �?лужбы. Генерирует ServiceLocatorException при
	// возникновении любой ошибки при пои�?ке
	public Object getObject(@SuppressWarnings("rawtypes") Class clazz) throws ServiceLocatorException {
		try {
			System.out.println("get EJB called: java:module/" + clazz.getSimpleName());
			return (Object)context.lookup("java:module/" + clazz.getSimpleName());
		} catch(NamingException ex) {
			throw new ServiceLocatorException(ex.getLocalizedMessage());
		}
	}
}

