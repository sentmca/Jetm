import etm.core.configuration.BasicEtmConfigurator;
import etm.core.configuration.EtmManager;
import etm.core.monitor.EtmMonitor;
import etm.core.renderer.SimpleTextRenderer;

public class OneMinuteTest {

  private static EtmMonitor monitor;

  /**
 * @param args
 */
public static void main(String[] args) {
    // configure measurement framework
    setup();

    // instantiate business service
    BusinessService service = new BusinessService();

    // execute business logic

    service.someMethod();
    service.someMethod();
    service.someMethod();
    service.nestedMethod();

	// visualize results
    monitor.render(new SimpleTextRenderer());

    // shutdown measurement framework
    tearDown();
  }


  private static void setup() {
    BasicEtmConfigurator.configure();
    monitor = EtmManager.getEtmMonitor();
    monitor.start();
  }

  private static void tearDown() {
    monitor.stop();
  }

}