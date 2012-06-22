import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;

public class BusinessService {

  private static final EtmMonitor etmMonitor = EtmManager.getEtmMonitor();

  public void someMethod() {

    EtmPoint point = etmMonitor.createPoint("BusinessService:someMethod");

    try {

      //
      // some business code
      //

      nestedMethod();

    } finally {
      point.collect();
    }
  }

  public void nestedMethod() {

    EtmPoint point = etmMonitor.createPoint("BusinessService:nestedMethod");

    try {

      //
      // some business code
      //

    } finally {
      point.collect();
    }
  }
}