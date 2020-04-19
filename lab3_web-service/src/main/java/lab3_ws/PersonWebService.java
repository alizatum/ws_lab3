package lab3_ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonService")
public class PersonWebService {


    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getAllPersons();
        return persons;
    }

    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "name") String name,
                                   @WebParam(name = "surname") String surname,
                                   @WebParam(name = "age") Integer age,
                                   @WebParam(name = "phone") Integer phone,
                                   @WebParam(name = "gender") String gender) throws PersonServiceException {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        checkParams(name, surname, age, phone, gender);
        List<Person> persons = dao.getPersons(name, surname, age, phone, gender);
        return persons;
    }

    @WebMethod(operationName = "addPerson")
    public Integer addPerson(@WebParam(name = "name") String name,
                                @WebParam(name = "surname") String surname,
                                @WebParam(name = "age") Integer age,
                                @WebParam(name = "phone") Integer phone,
                                @WebParam(name = "gender") String gender
    ) throws PersonServiceException {
        checkParams(name, surname, age, phone, gender);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        Integer id = dao.addPerson(name, surname, age, phone, gender);
        return id;
    }

    @WebMethod(operationName = "deletePerson")
    public String deletePerson(@WebParam(name = "id") Integer id) throws PersonServiceException {
        if (id == null)
            throw new PersonServiceException("Invalid id!", PersonServiceFault.defaultInstance());
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String status = dao.deletePerson(id);
        return status;
    }

    @WebMethod(operationName = "updatePerson")
    public String insertPerson(@WebParam(name = "id") Integer id,
                               @WebParam(name = "name") String name,
                               @WebParam(name = "surname") String surname,
                               @WebParam(name = "age") Integer age,
                               @WebParam(name = "phone") Integer phone,
                               @WebParam(name = "gender") String gender
    ) throws PersonServiceException {
        checkParams(name, surname, age, phone, gender);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String status = dao.updatePerson(id, name, surname, age, phone, gender);
        return status;
    }


    private static void checkParams(String name, String surname, Integer age,
                                    Integer phone, String gender) throws PersonServiceException {
        if (name == null || name.isEmpty())
            throw new PersonServiceException("Invalid name!", PersonServiceFault.defaultInstance());
        if (surname == null || surname.isEmpty())
            throw new PersonServiceException("Invalid surname!", PersonServiceFault.defaultInstance());
        if (age == null || age <= 0)
            throw new PersonServiceException("Invalid age!", PersonServiceFault.defaultInstance());
        if (phone == null || phone <= 100000)
            throw new PersonServiceException("Invalid phone!", PersonServiceFault.defaultInstance());
        if (gender == null || gender.isEmpty())
            throw new PersonServiceException("Invalid gender!", PersonServiceFault.defaultInstance());
    }
}