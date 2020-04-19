
package lab3_client.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "PersonServiceException", targetNamespace = "http://lab3_ws/")
public class PersonServiceException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private PersonServiceFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public PersonServiceException(String message, PersonServiceFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public PersonServiceException(String message, PersonServiceFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: lab3_client.generated.PersonServiceFault
     */
    public PersonServiceFault getFaultInfo() {
        return faultInfo;
    }

}
