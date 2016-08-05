
/**
 * CustomerSrvServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package mine.ws;

    /**
     *  CustomerSrvServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CustomerSrvServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CustomerSrvServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CustomerSrvServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for enquireCustomer method
            * override this method for handling normal response from enquireCustomer operation
            */
           public void receiveResultenquireCustomer(
                    mine.ws.CustomerSrvServiceStub.EnquireCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enquireCustomer operation
           */
            public void receiveErrorenquireCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createCustomer method
            * override this method for handling normal response from createCustomer operation
            */
           public void receiveResultcreateCustomer(
                    mine.ws.CustomerSrvServiceStub.CreateCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createCustomer operation
           */
            public void receiveErrorcreateCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findByAadhaarId method
            * override this method for handling normal response from findByAadhaarId operation
            */
           public void receiveResultfindByAadhaarId(
                    mine.ws.CustomerSrvServiceStub.FindByAadhaarIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findByAadhaarId operation
           */
            public void receiveErrorfindByAadhaarId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCustomer method
            * override this method for handling normal response from updateCustomer operation
            */
           public void receiveResultupdateCustomer(
                    mine.ws.CustomerSrvServiceStub.UpdateCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCustomer operation
           */
            public void receiveErrorupdateCustomer(java.lang.Exception e) {
            }
                


    }
    