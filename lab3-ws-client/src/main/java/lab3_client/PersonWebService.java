package lab3_client;

import lab3_client.generated.Person;
import lab3_client.generated.PersonService;
import lab3_client.generated.PersonServiceException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PersonWebService {


    public static void main(String[] args) throws MalformedURLException {

        Integer id;
        String name;
        String surname;
        Integer age;
        Integer phone;
        String gender;
        String status;

        System.out.println("1. Get all person\n2. Find person\n3. Add person\n4. Update person\n5. Delete person");

        Integer action = ConsoleInput.ReadIntValue("action");
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);

        try {
            switch (action) {
                case (1):
                    List<Person> persons = personService.getPersonWebServicePort().getAllPersons();
                    for (Person person : persons) {
                        System.out.println("name: " + person.getName() +
                                ", surname: " + person.getSurname() + ", age: " + person.getAge() + ", phone: " + person.getPhone() + ", gender: " + person.getGender());
                    }
                    break;
                case (2):
                    name = ConsoleInput.ReadStrValue("Name");
                    surname = ConsoleInput.ReadStrValue("Surname");
                    age = ConsoleInput.ReadIntValue("Age");
                    phone = ConsoleInput.ReadIntValue("Phone");
                    gender = ConsoleInput.ReadStrValue("Gender");
                    persons = personService.getPersonWebServicePort().getPersons(name, surname, age, phone, gender);
                    for (Person person : persons) {
                        System.out.println("name: " + person.getName() +
                                ", surname: " + person.getSurname() + ", age: " + person.getAge() + ", phone: " + person.getPhone() + ", gender: " + person.getGender());
                    }
                    break;
                case (3):
                    name = ConsoleInput.ReadStrValue("Name");
                    surname = ConsoleInput.ReadStrValue("Surname");
                    age = ConsoleInput.ReadIntValue("Age");
                    phone = ConsoleInput.ReadIntValue("Phone");
                    gender = ConsoleInput.ReadStrValue("Gender");
                    id = personService.getPersonWebServicePort().addPerson(name, surname, age, phone, gender);
                    System.out.println("New row id " + id);
                    break;
                case (4):
                    id = ConsoleInput.ReadIntValue("id");
                    name = ConsoleInput.ReadStrValue("Name");
                    surname = ConsoleInput.ReadStrValue("Surname");
                    age = ConsoleInput.ReadIntValue("Age");
                    phone = ConsoleInput.ReadIntValue("Phone");
                    gender = ConsoleInput.ReadStrValue("Gender");
                    status = personService.getPersonWebServicePort().updatePerson(id, name, surname, age, phone, gender);
                    System.out.println("Updated status: " + status);
                    break;
                case (5):
                    id = ConsoleInput.ReadIntValue("id");
                    status = personService.getPersonWebServicePort().deletePerson(id);
                    System.out.println("Deleted status: " + status);
                    break;
            }
        }catch (PersonServiceException e) {
            System.out.println(e);
        }


        //URL url = new URL("http://localhost:8080/lab1_ws_j2ee_war_exploded/PersonService?wsdl");

    }
}