package camunda.application;

/**
 * Created by kraussju on 10.11.2016.
 */

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Camunda_Multi-Instance-1")
public class Application extends ServletProcessApplication {

}
