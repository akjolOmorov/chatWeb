package util;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/****
 * 
 * @author dolphin
 *
 */

public class Resources {

   // Expose an entity manager using the resource producer pattern
   @SuppressWarnings("unused")
   @PersistenceContext(name="etender")
   @Produces
   private EntityManager datebase;

   @Produces
   Logger getLogger(InjectionPoint ip) {
      String category = ip.getMember().getDeclaringClass().getName();
      return Logger.getLogger(category);
   }

}
