------------------------ CUSTOMER SERVICE---------------------------------

1. Get customers - return all the customer details in the table
http://localhost:6070/customerservice/customer
2. Create a customer by sending the customer details
http://localhost:6070/customerservice/customer
a. when a create customer method is invoked. Insert the details in customer table 
and publish "CustomerCreated" event along with customer details.
b. sales order service has to subscribe to "CustomerCreated" event 

Table- Customer(id,email,first_name,last_name)